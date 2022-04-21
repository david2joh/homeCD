package homeCD.controller;


import homeCD.database.DAO.UserRoleDAO;
import homeCD.database.entity.UserRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.UsesSunHttpServer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
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

//
// Deal with user login and registration
//  This method is unsecured as we don't want to prevent
//  logins or new user registration
//
@Slf4j
@Controller
public class LoginController {


    @RequestMapping(value = "/login/login", method = RequestMethod.GET)
    public ModelAndView login() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("login/loginForm");
        return response;


    }


    @Autowired
    UserDAO userDao;

    @Autowired
    UserRoleDAO userRoleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /* this method is th entry point for create user */
    @RequestMapping(value = "/user/register", method = RequestMethod.GET)
    public ModelAndView register() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/register");


        /*
        Seeding the model with an empty form so that the JSP substitutions will not error out
        in this case spring is being nice enough to not throw errors but these 2 lines are safety
         */
        RegisterFormBean form = new RegisterFormBean();
        response.addObject("form", form);

        return response;
    }

    /* */
    @RequestMapping(value = "/user/registerSubmit", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView registerSubmit(@Valid RegisterFormBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();

        //First assume we are doing an edit by loading the user from the DB using the incoming id
        User user = userDao.findById(form.getId());
        //ask binding result if it has errors -or- if we have a non-null user AND more than one error (which is the duplicate user on an edit)
        if ((bindingResult.hasErrors()) && !((user != null) && (bindingResult.getErrorCount() > 1)) ) {
            List<String> errorMessages = new ArrayList<>();

            for (ObjectError error : bindingResult.getAllErrors()) {
                errorMessages.add(error.getDefaultMessage());
                log.info(((FieldError) error).getField() + " " + error.getDefaultMessage());
            }
            //Add the information that was in the form back to the form when erroring
            //so the user does not have to re-enter the information
            response.addObject("form", form);
            //add the error list to the model
            response.addObject("errorMessages", errorMessages);
            response.addObject("bindingResult", bindingResult);

            //because this is an error we do not want to processs to create a user in the DB
            // We want to show the same model that we are alreay on register.jsp
            response.setViewName("user/register");
            //response.setViewName("redirect:/user/register");
            return response;
        }

        //First assume we are doing an edit by loading the user from the DB using the incoming id
        //      User user = userDao.findById(form.getId());
        //if the user from the DB is null then it means this is a Create , else an edit
        //       UserRole user_role = new UserRole();
        if (user == null) {
            user = new User();
            helperRegistersubmit(form, user);
            // If user is NOT known send them back to the login screen
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentPrincipalName = authentication.getName();

            if(currentPrincipalName.equals("anonymousUser")) {
                response.setViewName("redirect:/login/login");
            } else {
                response.setViewName("user/search");
            }
            return response;
        }
        //This is an edit, retrieve the old user_role info
        helperRegistersubmit(form, user);

        response.setViewName("user/search");


        return response;
    }

    public void helperRegistersubmit(RegisterFormBean form, User user) {

        user.setUserName(form.getUserName());
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        //       user.setPassword(form.getPassword());  //pre-encrypt
        String password = passwordEncoder.encode(form.getPassword());
        user.setPassword(password);

        userDao.save(user);

        List<UserRole> userRoles = userRoleDao.findByUserId(user.getId());
        boolean foundUserRole = false;
        //check for null if null thiss user is not yet in the table
        if (userRoles != null) {
            //iterate the list, does this user have this role
            for (UserRole userRole : userRoles)
            {
                if (userRole.getUserRole().equals(form.getUserType())) {foundUserRole = true; break;}
            }
        }
        if (!foundUserRole) {
            //did not find this user with this role
            //add this user into the user_role table
            UserRole userRole = new UserRole();
            userRole.setUserId(user.getId());
            userRole.setUserRole(form.getUserType());
            userRoleDao.save(userRole);
        }

        log.info("Registration form submission = " + form.toString());

    }







}





//
//    Any controller can access the user after login with these lines
//
//    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//    String currentPrincipalName = authentication.getName();
//
