package homeCD.controller;

import homeCD.Service.CdService;
import homeCD.database.DAO.CdDAO;
import homeCD.database.DAO.ComposerDAO;
import homeCD.database.DAO.LocationDAO;
import homeCD.database.DAO.PerformanceDAO;
import homeCD.database.entity.Cd;
import homeCD.database.entity.Location;
import homeCD.database.entity.Performance;
import homeCD.formbean.CdAddFormBean;
import homeCD.formbean.CdDetailsBean;
import homeCD.formbean.CdEntryFormBean;
import homeCD.formbean.PerformanceEntryFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//
//The controller for all CD functions (add, move, delete)
// Due to the span of CD operations this controller has its own Service
//
@Slf4j
@Controller
@PreAuthorize("hasAnyAuthority('USER','ADMIN')")
public class CdController {

    @Autowired
    private CdDAO cdDao;

    @Autowired
    private LocationDAO locationDao;

    @Autowired
    private PerformanceDAO performanceDao;

    @Autowired
    private ComposerDAO composerDao;

    @Autowired
    private CdService cdService;

    // Initial blank form
    @RequestMapping(value = "/cd/cdAdd", method = RequestMethod.GET)
    public ModelAndView list(CdEntryFormBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("cd/cdAdd");

        /*
        Seeding the model with an empty form if necessary
         */
        if (form == null || form.getId() == 0) {
            form = new CdEntryFormBean();
        }
        response.addObject("form", form);

        response.setViewName("cd/cdAdd");
        return response;
    }

    @RequestMapping(value = "/cd/cdAddDisk", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView cdAddDisk(@Valid CdAddFormBean form, BindingResult bindingResult, @RequestParam(value = "id", required = false) Integer id)
            throws Exception {
        ModelAndView response = new ModelAndView();

        //ask binding result if it has errors
        if (bindingResult.hasErrors()) {
            List<String> errorMessages = new ArrayList<>();

            for (ObjectError error : bindingResult.getAllErrors()) {
                errorMessages.add(error.getDefaultMessage());
                log.info(((FieldError) error).getField() + " " + error.getDefaultMessage());
            }
            //Add the information that was in the form back to the form when error
            //so the user does not have to re-enter the information
            response.addObject("form", form);
            //add the error list to the model
            response.addObject("errorMessages", errorMessages);
            response.addObject("bindingResult", bindingResult);

            //Send the form info back to the view
            response.setViewName("cd/cdAdd");
            return response;
        }
        //send the form information to the service to deal with
        List<String> errors = new ArrayList<>();
        Cd cd = cdService.cdAddDisk(form, errors);

        if (errors.size() > 0) {
            //Service layer returned errors something went wrong try to alert the user
            response.addObject("form", form);
            response.addObject("errors", errors);
            response.setViewName("cd/cdAdd");
            return response;
        } else {  //Good to go add the info to the new form
            PerformanceEntryFormBean pform = new PerformanceEntryFormBean();
            form.setId(cd.getId());
            pform.setId(cd.getId());
            pform.setLabel(form.getLabel());
            pform.setCatalogNumber(form.getCatalogNumber());
            pform.setLocationName(form.getLocationName());
//            pform.setCd(cd);
            response.addObject("errors", errors);
            response.addObject("form", pform);
        }

        response.setViewName("cd/cdAddPerformance");
        return response;
    }


    @RequestMapping(value = "/cd/cdAddPerformance", method = RequestMethod.POST)
    public ModelAndView cdAddPerformance(PerformanceEntryFormBean form, BindingResult bindingResult,
                                         @RequestParam(value = "id", required = false) Integer id)
            throws Exception {
        ModelAndView response = new ModelAndView();

        //ask binding result if it has errors
        if (bindingResult.hasErrors()) {
            List<String> errorMessages = new ArrayList<>();

            for (ObjectError error : bindingResult.getAllErrors()) {
                errorMessages.add(error.getDefaultMessage());
                log.info(((FieldError) error).getField() + " " + error.getDefaultMessage());
            }
            //Add the information that was in the form back to the form when error
            //so the user does not have to re-enter the information
            response.addObject("form", form);
            //add the error list to the model
            response.addObject("errorMessages", errorMessages);
            response.addObject("bindingResult", bindingResult);

            //Send the form info back to the view
            response.setViewName("cd/cdAdd");
            return response;
        }
        //send the form information to the service to deal with
        List<String> errors = new ArrayList<>();
        Performance performance = cdService.cdAddPerformance(form, errors);

        if (errors.size() > 0) {
            //Service layer returned errors something went wrong try to alert the user
            response.addObject("form", form);
            response.addObject("errors", errors);
            response.setViewName("cd/cdAddPerformance");
            return response;
        } else {  //Good to go add the info to the new form
            log.debug(form.toString());
            form.setLabel(form.getLabel());
            form.setCatalogNumber(form.getCatalogNumber());
            form.setLocationName(form.getLocationName());
            form.getPerformances().add(performance);
            response.addObject("errors", errors);
            response.addObject("form", form);
        }

        response.setViewName("cd/cdAddPerformance");
        return response;
    }


    //Modify a performance entry while adding a cd --  gold plating extra
    @RequestMapping(value = "/cd/cdModifyPerformance", method = RequestMethod.POST)
    public ModelAndView cdModifyPerformance(PerformanceEntryFormBean form, BindingResult bindingResult,
                                            @RequestParam(value = "id", required = false) Integer id)
            throws Exception {

        ModelAndView response = new ModelAndView();
        //ask binding result if it has errors
        if (bindingResult.hasErrors()) {
            List<String> errorMessages = new ArrayList<>();

            for (ObjectError error : bindingResult.getAllErrors()) {
                errorMessages.add(error.getDefaultMessage());
                log.info(((FieldError) error).getField() + " " + error.getDefaultMessage());
            }
            //Add the information that was in the form back to the form when error
            //so the user does not have to re-enter the information
            response.addObject("form", form);
            //add the error list to the model
            response.addObject("errorMessages", errorMessages);
            response.addObject("bindingResult", bindingResult);

            //Send the form info back to the view
            response.setViewName("cd/cdAddPerformance");
            return response;
        }

        response.addObject("form", form);
        //add the errror list to the model
        response.addObject("bindingResult", bindingResult);
        List<String> errorMessages = new ArrayList<>();
        response.addObject("errorMessages", errorMessages);


        //Send the form info back to the view
        response.setViewName("redirect:cd/cdAddPerformance");
        return response;
    }


    //Delete a performance entry while adding a cd
    @RequestMapping(value = "/cd/cdAddPerformanceDelete", method = RequestMethod.POST)
    public ModelAndView cdDeletePerformance(PerformanceEntryFormBean form, BindingResult bindingResult,
                                            @RequestParam(value = "id", required = true) Integer id,
                                            @RequestParam(value = "pId", required = true) Integer pId)

            throws Exception {

        ModelAndView response = new ModelAndView();
        //ask binding result if it has errors
        if (bindingResult.hasErrors()) {
            List<String> errorMessages = new ArrayList<>();

            for (ObjectError error : bindingResult.getAllErrors()) {
                errorMessages.add(error.getDefaultMessage());
                log.info(((FieldError) error).getField() + " " + error.getDefaultMessage());
            }
            //Add the information that was in the form back to the form when error
            //so the user does not have to re-enter the information
            response.addObject("form", form);
            //add the error list to the model
            response.addObject("errorMessages", errorMessages);
            response.addObject("bindingResult", bindingResult);

            //Send the form info back to the view
            response.setViewName("cd/cdAdd");
            return response;
        }
        //send the form information to the service to deal with
        List<String> errors = new ArrayList<>();
        cdService.cdAddPerformanceDelete(form, pId, errors);

        response.addObject("form", form);
        //add the errror list to the model
        response.addObject("bindingResult", bindingResult);
        List<String> errorMessages = new ArrayList<>();
        response.addObject("errorMessages", errorMessages);


        //Send the form info back to the view
        response.setViewName("cd/cdAddPerformance");
        return response;
    }

    //List all our cds
    @RequestMapping(value = "/cd/cdList", method = RequestMethod.GET)
    public ModelAndView cdList(PerformanceEntryFormBean form, BindingResult bindingResult)
            throws Exception {
        ModelAndView response = new ModelAndView();
        List<Cd> cds = cdDao.findAll();
        List<Cd> sortedCds = cds.stream().sorted(Comparator.comparingInt(p -> p.getLocationId())).collect(Collectors.toList());

        //and lets get really stupid and make the code self modify!!!Streams, lambdas Unmaintainable Village here we go !
        List<String> locationNames = sortedCds.stream().map(Cd::getLocationId).collect(Collectors.toList())
                .stream().map(lId -> locationDao.findById(lId).getLocationName()).collect(Collectors.toList());
        response.addObject("locationNames", locationNames);
        response.addObject("cds", sortedCds);
        //            response.setViewName("cd/cdList");
        return response;
    }


    //Get the details of this cd -- this is an internal method call only
    @RequestMapping(value = "/cd/cdDetails", method = RequestMethod.GET)
    public ModelAndView cdDetail(@RequestParam(value = "id", required = true) Integer id)
            throws Exception {
        ModelAndView response = new ModelAndView();

        CdDetailsBean form = new CdDetailsBean();

        cdService.getCdDetails(form, id);
        List<Location> locations = locationDao.findAll();
        response.addObject("locations", locations);
        response.addObject("form", form);
        response.setViewName("cd/cdDetails");
        return response;
    }

    //Delete a cd from the DB
    @DeleteMapping
    @RequestMapping(value = "/cd/cdDelete", method = RequestMethod.POST)
    public ModelAndView cdDelete(@RequestParam(value = "id", required = true) Integer id)
            throws Exception {
        ModelAndView response = new ModelAndView();
        Cd cd = cdDao.findById(id);
        if (cd != null) {
            log.info("Delete CD : " + cd.toString());
            cdDao.deleteCd(cd.getId());
        }
        response.setViewName("redirect:/cd/cdList");
        return response;
    }

    @RequestMapping(value = "/cd/cdMove", method = RequestMethod.POST)
    public ModelAndView cdMove(CdDetailsBean form, @RequestParam(value = "id", required = true) Integer id)
            throws Exception {
        ModelAndView response = new ModelAndView();
        Cd cd = cdDao.findById(id);
        if (cd != null) {
            String newLocationName = form.getLocationName();
            Integer newLocationId = locationDao.findByLocationName(newLocationName).getId();
            if (cd.getLocationId() != newLocationId) {
                cd.setLocationId(newLocationId);
                cdDao.saveAndFlush(cd);
            }
        }
        response.setViewName("redirect:/cd/cdDetails?id=" + id);
        return response;
    }

//    @RequestMapping(value = "/cd/cdDetails", method = RequestMethod.GET)
//    public ModelAndView cdDetails(CdDetailsBean form)
//            throws Exception {
//        ModelAndView response = new ModelAndView();
//        response.addObject("form", form);
//        response.setViewName("cd/cdDetails");
//        return response;
//    }

}  //class


