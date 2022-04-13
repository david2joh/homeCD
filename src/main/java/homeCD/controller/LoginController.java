package homeCD.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.UsesSunHttpServer;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import homeCD.database.DAO.UserDAO;
import homeCD.database.entity.User;
import homeCD.formbean.RegisterFormBean;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Controller
public class LoginController {


    @RequestMapping(value = "/login/login", method = RequestMethod.GET)
    public ModelAndView login() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("login/loginForm");
        return response;


    }
}
//
//    Any controller can access the user after login with these lines
//
//    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//    String currentPrincipalName = authentication.getName();
//
