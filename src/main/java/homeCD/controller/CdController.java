package homeCD.controller;

import homeCD.Service.CdService;
import homeCD.database.DAO.CdDAO;
import homeCD.database.DAO.ComposerDAO;
import homeCD.database.DAO.PerformanceDAO;
import homeCD.database.entity.Cd;
import homeCD.database.entity.Composer;
import homeCD.database.entity.Location;
import homeCD.database.entity.Performance;
import homeCD.formbean.CdAddFormBean;
import homeCD.formbean.CdEntryFormBean;
import homeCD.formbean.CdMultiEntryFormBean;
import homeCD.formbean.PerformanceEntryFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
@Controller
public class CdController {

    @Autowired
    private CdDAO cdDao;

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

//    @RequestMapping(value = "/cd/cdAddSubmit", method = RequestMethod.POST)
//    public ModelAndView cdAddSubmit(@Valid CdEntryFormBean form, BindingResult bindingResult , @RequestParam(value = "id" , required = false) Integer id)
//            throws Exception {
//        ModelAndView response = new ModelAndView();
//
//        //ask binding result if it has errors
//        if (bindingResult.hasErrors()) {
//            List<String> errorMessages = new ArrayList<>();
//
//            for (ObjectError error : bindingResult.getAllErrors()) {
//                errorMessages.add(error.getDefaultMessage());
//                log.info(((FieldError) error).getField() + " " + error.getDefaultMessage());
//            }
//            //Add the information that was in the form back to the form when error
//            //so the user does not have to re-enter the information
//            response.addObject("form", form);
//            //add the error list to the model
//            response.addObject("errorMessages", errorMessages);
//            response.addObject("bindingResult", bindingResult);
//
//            //Send the form info back to the view
//            response.setViewName("cd/cdAdd");
//            return response;
//        }
//        //send the form information to the service to deal with
//        List<String> errors = new ArrayList<>();
//        Performance performance = cdService.cdAddPerformance(form,errors);
//
//        if (errors.size() > 0) {
//            //Service layer returned errors something went wrong try to alert the user
//            response.addObject("form", form);
//            form.setId(-1);
//            response.addObject("errors", errors);
//        }
//        else {  //Good to go add the new form info to the array lists
//            form.getComposers().add(form.getComposer());
//            form.getWorks().add(form.getWork());
//            form.getArtists().add(form.getArtist());
//            form.getPerformancePK().add(performancePK);
//            form.setId(form.getId());
//            response.addObject("performancePK",performancePK);
//            response.addObject("errors", errors);
//        }
//        response.addObject("form", form);
//        response.setViewName("cd/cdAdd");
//        return response;
//    }

    @RequestMapping(value = "/cd/cdAddDisk", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView cdAddDisk(@Valid CdAddFormBean form, BindingResult bindingResult , @RequestParam(value = "id" , required = false) Integer id)
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
        Cd cd = cdService.cdAddDisk(form,errors);

        if (errors.size() > 0) {
            //Service layer returned errors something went wrong try to alert the user
            response.addObject("form", form);
            response.addObject("errors", errors);
            response.setViewName("cd/cdAdd");
            return response;
        }
        else {  //Good to go add the info to the new form
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
    public ModelAndView cdModifyPerformance(PerformanceEntryFormBean form, BindingResult bindingResult ,
                                            @RequestParam(value = "id" , required = false) Integer id)
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
        Performance performance = cdService.cdAddPerformance(form,errors);

        if (errors.size() > 0) {
            //Service layer returned errors something went wrong try to alert the user
            response.addObject("form", form);
            response.addObject("errors", errors);
            response.setViewName("cd/cdAddPerformance");
            return response;
        }
        else {  //Good to go add the info to the new form
//            PerformanceEntryFormBean pform = new PerformanceEntryFormBean();
            log.debug(form.toString());
//            Stream<String> stream = Arrays.stream(new String[]{form.getPerformances().toString()});
//            log.trace(stream.foreach.(Arrays.stream(new String[]{form.getPerformances()->toString());
            // CD cd = cdDao.findById(form.getId());
//            form.setId(form.getCd().getId());
            form.setLabel(form.getLabel());
            form.setCatalogNumber(form.getCatalogNumber());
            form.setLocationName(form.getLocationName());
//            form.setCd(form.getCd());
            form.getPerformances().add(performance);
            response.addObject("errors", errors);
            response.addObject("form", form);
            // response.addObject("cd",cd);
        }

        response.setViewName("cd/cdAddPerformance");
        return response;
    }


    //Modify a performance entry while adding a cd --  gold plating extra
    @RequestMapping(value = "/cd/cdModifyPerformance", method = RequestMethod.POST)
    public ModelAndView cdModifyPerformance(CdEntryFormBean form, BindingResult bindingResult ,
                                            @RequestParam(value = "id" , required = false) Integer id)
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





        response.addObject("form", form);
        //add the errror list to the model
        response.addObject("bindingResult", bindingResult);
        List<String> errorMessages = new ArrayList<>();
        response.addObject("errorMessages", errorMessages);


        //Send the form info back to the view
        response.setViewName("redirect:/cd/cdAdd");
        return response;
    }


    }
