package homeCD.Service;


import homeCD.database.DAO.CdDAO;
import homeCD.database.DAO.ComposerDAO;
import homeCD.database.DAO.LocationDAO;
import homeCD.database.DAO.PerformanceDAO;
import homeCD.database.entity.Cd;
import homeCD.database.entity.Composer;
import homeCD.database.entity.Location;
import homeCD.database.entity.Performance;
import homeCD.formbean.CdEntryFormBean;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@Slf4j
public class CdService {
//The CD service provides cross entity support for the individual controllers as CD operations span all the DB
    @Autowired
    private CdDAO cdDao;

    @Autowired
    private PerformanceDAO performanceDao;

    @Autowired
    private ComposerDAO composerDao;

    @Autowired
    private LocationDAO locationDao;

    //This is the main function of the Service as this function crosses all the entity tables
    public boolean cdAdd(CdEntryFormBean form, List<String> errorMsgs) {
        //Flow

        //
        //  check the CD does it reasonably exist already ?  cross check to label/catalog
        //     if the CD is new to us add it in to a new CD object
        //         get a location Id by name to complete the CD object entry
        //  Foreach entry in the CD performances list
        //    check the composer , does it exist in the db , if it does then grab the pk
        //    if not add the composer to the DB table and retrieve the pk
        //  Set up the individual performace object with the cdPK, composerPK, work name, performance name
        //  Save new objects to the DB ( CD, Composer, Performace )
        //
        //  Return successStatus and errorMsg back to the CdController
        //

        Cd cd = null;
        Composer composer = null;
        cd = cdDao.findCdByLabelAndAndCatalogNumber(form.getLabel(),form.getCatalogNumber());
        if (cd == null) {  // new entry
            cd = new Cd();
            cd.setLabel(form.getLabel());
            cd.setCatalogNumber(form.getCatalogNumber());
            //get the locationId from the name -- already validated to exist
            Location location = locationDao.findByLocationName(form.getLocationName());
            cd.setLocationId(location.getId());
            //write cd info to the db
            cd = cdDao.save(cd);
        }

        // cd already exists check on the composer table for the ID
        composer = composerDao.findByComposerName(form.getComposer());
        if ( composer == null) {  //new composer
            composer = new Composer();
            composer.setComposerName(form.getComposer());
            composer = composerDao.save(composer);
        }

        //Get the PKs of the CD and Composer
        Integer cdPK = cd.getId();
        Integer composerPK = composer.getId();

        // Check to see if a record for this CD exists in the join table if so
        // check the performance a/ artist to see if a duplicate
        List<Performance> performances = performanceDao.findBycdIdAndcomposerId(cdPK,composerPK);
        if (performances != null) { //iterate through the performances
            for (Performance performance : performances) {
                if (performance.getPerformance().equalsIgnoreCase(form.getWork())
                        && performance.getArtist().equalsIgnoreCase(form.getArtist())) { //have a duplicate unwind
                    cdDao.delete(cd);
                    composerDao.delete(composer);
                    errorMsgs.add("Duplicate performance found on this CD  Not added");
                    form.setId(cdPK);
                    return false;
                }
            }
        }
        //Add a performance into the DB
        Performance performance = new Performance();
        performance.setCdId(cdPK);
        performance.setComposerId(composerPK);
        performance.setPerformance(form.getWork());
        performance.setArtist(form.getArtist());
        performanceDao.save(performance);
        return true;
        }



} //class
