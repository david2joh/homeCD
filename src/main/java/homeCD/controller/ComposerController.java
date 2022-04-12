package homeCD.controller;

import homeCD.formbean.CdDetailsBean;
import homeCD.formbean.ComposerFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.UsesSunHttpServer;
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

@Slf4j
@Controller
public class ComposerController {

    @Autowired
    ComposerDAO ComposerDAO;

    // List  Composers for the intro Composer page
    @RequestMapping(value = "/composer/list", method = RequestMethod.GET)
    public ModelAndView list() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("composer/list");

        List<Composer> composers = new ArrayList<>();

        composers = ComposerDAO.findAll();

        response.addObject("composers", composers);
        /*
        Seeding the model with an empty form so that the JSP substitutions will not error out
        in this case spring is being nice enough to not thow errors but these 2 lines are safety
         */
        ComposerFormBean form = new ComposerFormBean();
        response.addObject("form", form);

        return response;
    }
}