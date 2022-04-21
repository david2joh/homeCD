package homeCD.controller;

import homeCD.formbean.CdDetailBean;
import homeCD.formbean.ComposerFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import homeCD.database.DAO.ComposerDAO;
import homeCD.database.entity.Composer;

// import homeCD.formbean.ComposerFormBean;
//import javax.validation.Valid;

import javax.validation.Valid;
import java.util.*;

//
//The Composer Controller to handle composer requests
//Composers are limited to add and search.
//Business logic limits the amount of operations required
//Do not want to delete a composer from the UI interface
//

@Slf4j
@Controller
@PreAuthorize("hasAnyAuthority('USER','ADMIN')")
public class ComposerController {

    @Autowired
    private ComposerDAO composerDao;

    // List  Composers for the intro Composer page
    @RequestMapping(value = "/composer/list", method = RequestMethod.GET)
    public ModelAndView list() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("composer/list");

        List<Composer> composers = new ArrayList<>();

        composers = composerDao.findAllOrderByComposerName();

        response.addObject("composers", composers);
        /*
        Seeding the model with an empty form so that the JSP substitutions will not error out
        in this case spring is being nice enough to not thow errors but these 2 lines are safety
         */
        ComposerFormBean form = new ComposerFormBean();
        response.addObject("form", form);

        return response;
    }

    @RequestMapping(value = "/composer/composerChange/{action}", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView composerChange(@Valid ComposerFormBean form, BindingResult bindingResult,
                                       @PathVariable("action") String action) throws Exception {
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

            //because this is an error we do not want to processs to create/update/delete a composer in the DB
            // We want to show the same model that we are already on  list
            response.setViewName("redirect:/composer/list");
            return response;
        }

        Composer composer = composerDao.findByComposerName(form.getComposerName());
        if (action.equalsIgnoreCase("update") && (form.getId() != 0)) {
            composer = composerDao.findById(form.getId());
        }
        if (composer == null) {
            if (action.equalsIgnoreCase("add")) {
                composer = new Composer();
                composer.setComposerName(form.getComposerName());
                composerDao.save(composer);
                log.debug("Composer creation = " + form.toString());
            } else if (action.equalsIgnoreCase("update")) {
                //Already know that composer name is valid so just update
                log.debug("Composer name changed from : " + composer.getComposerName() +
                        " to " + form.getComposerName());
                composer.setComposerName(form.getComposerName());
                composerDao.save(composer);
                response.setViewName("redirect:/composer/list");
                return response;
            } else {  //wow someone spoofed us just go back reseting the form
                log.debug("Composer creation with bad inputs = " + form.toString());
                response.setViewName("redirect:/composer/list");
            }
        } else {
            //We have a delete or update
            //if the action = delete then this is a delete else a update
            //for deletes make sure that the composer is really empty first.
            //the front end doesn't allow it so the only way to get there is
            //by spoofing the request
            if (action.equalsIgnoreCase("delete")) {
                if (composer.getPerformances().size() == 0) {
                    composerDao.delete(composer);
                    log.debug("Composer deleted  : " + composer.getComposerName());
                } else {
                    log.warn("Composer delete attempted on Non Empty Composer :" + composer.getComposerName());
                }
            } else {
                if (action.equalsIgnoreCase("update")) {
                    //Already know that composer name is valid so just update
                    log.debug("Composer name changed from : " + composer.getComposerName() +
                            " to " + form.getComposerName());
                    composer.setComposerName(form.getComposerName());
                    composerDao.save(composer);
                }
            }
        }
        response.setViewName("redirect:/composer/list");
        return response;
    }


//    @RequestMapping(value = "/composer/composerDetails/{composerId}", method = RequestMethod.GET)
//    public ModelAndView cDetails(@PathVariable("composerId") Integer composerId) throws Exception {
        @RequestMapping(value = "/composer/composerDetails", method = RequestMethod.GET)
        public ModelAndView cDetails(@RequestParam("composerId") Integer composerId) throws Exception {
            ModelAndView response = new ModelAndView();
        response.setViewName("composer/composerDetails");

        Map<String,Object> result = new HashMap<>();
        List<CdDetailBean> cdDetails = new LinkedList<>();
        Composer composer = composerDao.findById(composerId);
        List<Map<String,Object>> results =  composerDao.getCDdetailsByComposerId((composerId));
        if (result != null ) {
            for (int i = 0; i < results.size(); i++) {
                CdDetailBean cdDetail = new CdDetailBean();
                result = results.get(i);
                cdDetail.setId((Integer) result.get("cdId"));
                cdDetail.setLocationName((String) result.get("locationName"));
                cdDetail.setComposer((String) result.get("composerName"));
                cdDetail.setArtist((String) result.get("artist"));
                cdDetail.setPerformance((String) result.get("performance"));
                cdDetails.add(cdDetail);
            }
            response.addObject("cdDetails", cdDetails);
        }

      /*
        Seeding the model with a form id in this case spring is thorwing errors
         */
       ComposerFormBean form = new ComposerFormBean();
        form.setId(composerId);
        form.setComposerName(composer.getComposerName());

        response.addObject("form", form);

        return response;
    }

} //class