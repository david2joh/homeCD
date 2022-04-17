package homeCD.controller;

import homeCD.Service.CdService;
import homeCD.database.DAO.CdDAO;
import homeCD.database.DAO.ComposerDAO;
import homeCD.database.DAO.PerformanceDAO;
import homeCD.database.entity.Cd;
import homeCD.database.entity.Composer;
import homeCD.database.entity.Location;
import homeCD.database.entity.Performance;
import homeCD.formbean.CdEntryFormBean;
import homeCD.formbean.CdMultiEntryFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

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

    // Initial blank form
    @RequestMapping(value = "/cd/cdAddSubmit/{id}", method = RequestMethod.POST)
    public ModelAndView cdAddSubmit(CdEntryFormBean form, BindingResult bindingResult , @PathVariable("id") Integer id) throws Exception {
        ModelAndView response = new ModelAndView();

        //ask binding result if it has errors
        if (bindingResult.hasErrors()) {
            List<String> errorMessages = new ArrayList<>();

            for (ObjectError error : bindingResult.getAllErrors()) {
                errorMessages.add(error.getDefaultMessage());
                log.info(((FieldError) error).getField() + " " + error.getDefaultMessage());
            }
            //Add the information that was in the form back to the form when erroring
            //so the user does not have to re-enter the information
            response.addObject("form", form);
            //add the errror list to the model
            response.addObject("errorMessages", errorMessages);
            response.addObject("bindingResult", bindingResult);

            //Send the form info back to the view
            response.setViewName("cd/cdAdd");
            return response;
        }
        //send the form information to the service to deal with
        List<String> errors = new ArrayList();
        Integer performancePK = cdService.cdAddPerformance(form,errors);

        //Service layer returned errors something went wrong try to alert the user
        if (performancePK <= 0) {
            response.addObject("form", form);
            form.setId(-1);
            response.addObject("errors", errors);
        }
        else {  //Good to go add the form info to the array lists
            form.getComposers().add(form.getComposer());
            form.getWorks().add(form.getWork());
            form.getArtists().add(form.getArtist());
            form.getPerformancePK().add(performancePK);
            form.setId(form.getId());
            response.addObject("performancePK",performancePK);
        }
        response.addObject("form", form);
        response.setViewName("cd/cdAdd");
        return response;
    }


}
