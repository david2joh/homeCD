package homeCD.Service;


import homeCD.database.DAO.CdDAO;
import homeCD.database.DAO.ComposerDAO;
import homeCD.database.DAO.LocationDAO;
import homeCD.database.DAO.PerformanceDAO;
import homeCD.database.entity.Cd;
import homeCD.database.entity.Composer;
import homeCD.database.entity.Location;
import homeCD.database.entity.Performance;
import homeCD.formbean.CdAddFormBean;
import homeCD.formbean.CdDetailsBean;
import homeCD.formbean.PerformanceEntryFormBean;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//The CD service provides cross entity support for the individual controllers as CD operations span all the DB
@Service
@Data
@Slf4j
public class CdService {

    @Autowired
    private CdDAO cdDao;

    @Autowired
    private PerformanceDAO performanceDao;

    @Autowired
    private ComposerDAO composerDao;

    @Autowired
    private LocationDAO locationDao;

    //Add a cd into the DB if not there
    public Cd cdAddDisk(CdAddFormBean form, List<String> errorMsgs) {
        Cd cd = null;
        Composer composer = null;
        cd = cdDao.findCdByLabelAndAndCatalogNumber(form.getLabel(), form.getCatalogNumber());
        if (cd == null) {  // new entry
            cd = new Cd();
            cd.setLabel(form.getLabel());
            cd.setCatalogNumber(form.getCatalogNumber());
            //get the locationId from the name -- already validated to exist
            Location location = locationDao.findByLocationName(form.getLocationName());
            cd.setLocationId(location.getId());
            //write cd info to the db
            cd = cdDao.save(cd);
            log.info("CD added : " + cd.toString());
        } else {  //Tried to enter a cd that exists
            errorMsgs.add("Attempt to enter an existing CD : Not added");
        }
        return cd;
    }

    //Add a performance to a CD
    //Assumption CD entry is good
    //


    //Add a performance to a CD
    @Transactional
    public Performance cdAddPerformance(PerformanceEntryFormBean form, List<String> errorMsgs) {
        //Flow

        //
        //  At this point the CD object has been verified.
        //  Check the form composer entry in the composer DB for existance
        //     if not exist create it and retrieve the pk
        //  Foreach entry in the CD performances list cross check the form values of performance/artist to  label/catalog
        //   if the performace already exists in the performances list error back
        //
        //  Set up the individual performance object with the cdPK, composerPK, composer name, performance name, artist name
        //  Save new objects to the DB ( CD, Composer, Performace )
        //
        //  Return successStatus and errorMsg back to the CdController
        //
        Cd cd = cdDao.findById(form.getId());
        //Reset this in the event of an add
        form.setId(cd.getId());
        Integer cdPK = cd.getId();
        Integer composerPK;
        Composer composer = null;
        Performance performance = null;
//        cd = cdDao.findCdByLabelAndAndCatalogNumber(form.getLabel(),form.getCatalogNumber());

        //check on the composer table for the ID
        composer = composerDao.findByComposerName(form.getComposer());

        // Check to see if a record for this CD exists in the join table if so
        // check the performance and artist to see if a duplicate
        if (cd != null && composer != null) {

            //Get the PKs of  Composer
            composerPK = composer.getId();
//            List<Performance> performances = performanceDao.findBycdIdAndcomposerId(cdPK, composerPK);
            Set<Performance> performances = cd.getPerformances();
            if ((performances != null) && (performances.size() > 0)) { //iterate through the performances
                for (Performance p : performances) {
                    if (p.getPerformance().equalsIgnoreCase(form.getPerformance())
                            && p.getArtist().equalsIgnoreCase(form.getArtist())) { //have a duplicate unwind
                        errorMsgs.add("Duplicate performance found on this CD  Not added");
                        form.setId(cdPK);
                        return performance;
                    }
                }
            }
        }

        if (composer == null) {  //new composer
            composer = new Composer();
            composer.setComposerName(form.getComposer());
            composer = composerDao.save(composer);
        }

        //Add a performance into the DB
        performance = new Performance();
        //        performance.setCdId(cdPK);
        //        performance.setComposerId(composerPK);
        performance.setPerformance(form.getPerformance());
        performance.setArtist(form.getArtist());
        performance.setCd(cd);
        performance.setComposer(composer);
        performance = performanceDao.saveAndFlush(performance);


        //Add the performances onto the form lists , retrieve the changed cd entity
        cd = cdDao.findById(form.getId());
        Set<Performance> performances = cd.getPerformances();
        if ((performances != null) && (performances.size() > 0)) {
            performances.forEach(p -> {
                form.getPerformancePK().add((p.getId()));
                form.getComposers().add(p.getComposer().getComposerName());
                form.getWorks().add(p.getPerformance());
                form.getArtists().add(p.getArtist());
                form.getPerformances().add(p);
            });
        }

        //Hack around the most recent performance not being in the set -- Hibernate weirdness
        form.getPerformancePK().add((performance.getId()));
        form.getComposers().add(performance.getComposer().getComposerName());
        form.getWorks().add(performance.getPerformance());
        form.getArtists().add(performance.getArtist());
        form.getPerformances().add(performance);
        //        performanceDao.addPerformance(cdPK,composerPK,form.getWork(),form.getArtist());
        return performance;
    }

    public void cdAddPerformanceDelete(PerformanceEntryFormBean form, Integer PerformancePK, List<String> errorMsgs) {
        //Delete a performance during the cdAdd process - slightly different than deleting one from the Performance List
        Performance perf = new Performance();
        perf.setId(PerformancePK);
        //While the documentation "says" delete returns the number of rows deleted the compiler and deep in JPA says void
        //To work around this in the DAO one could add @Modifying/@Query(value = ""Delete From <table_name> where ...")/int myDeleteById;
        //Really a style question
        performanceDao.delete(perf);
        //Remove the performance from the form
        Cd cd = cdDao.findById(form.getId());
        Set<Performance> performances = cd.getPerformances();
        if ((performances != null) && (performances.size() > 0)) {
            for (Performance p : performances) {
                //Test for hibernate weirdness
                if (p.getId() == PerformancePK) break;
                form.getPerformancePK().add((p.getId()));
                form.getComposers().add(p.getComposer().getComposerName());
                form.getWorks().add(p.getPerformance());
                form.getArtists().add(p.getArtist());
                form.getPerformances().add(p);
            }
        }
        form.setPerformance("");
        form.setArtist("");
        form.setComposer("");
        return;
    }

    public void getCdDetails(CdDetailsBean form, Integer id) {
        //Fill in all the CD information from the cdPK given by "id"
        Cd cd = cdDao.findById(id);
        form.setId(cd.getId());
        form.setLabel(cd.getLabel());
        form.setCatalogNumber(cd.getCatalogNumber());
        form.setLocationName(locationDao.findById(cd.getLocationId()).getLocationName());
        List<Performance> performances =
                new ArrayList(cd.getPerformances().stream().sorted(Comparator.comparingInt(p -> p.hashCode())).collect(Collectors.toList()));
        for (Performance p : performances) {
            form.getComposers().add(p.getComposer().getComposerName());
            form.getWorks().add(p.getPerformance());
            form.getArtists().add(p.getArtist());
        }

    }
} //class

