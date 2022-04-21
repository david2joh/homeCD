package homeCD.controller;

import homeCD.database.DAO.UserRoleDAO;
import homeCD.database.entity.UserRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
import java.util.List;

@Slf4j
@Controller
public class UserController {

    @Autowired
    UserDAO userDao;

    @Autowired
    UserRoleDAO userRoleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;


    //create a form on the user search page that submits to this route using a get method
    //make an input box
    //can change over to request mapping as well
    //@RequestMapping(value="/user/search", method={RequestMethod.POST, RequestMethod.GET})
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/user/search")
    // Try using @requestparam  with value="serchUserName"
    public ModelAndView search(@RequestParam(required = false) String searchUserName) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/search");

      List<User> users = new ArrayList<>();

        //if(StringUtils.isEmpty(searchFirstName)) {   //apache string utils to do the same check
        if (searchUserName != null && !searchUserName.isBlank()) {
            //query
            users = userDao.findByUserNameContainingIgnoreCase(searchUserName);
        }
        response.addObject("searchUserName", searchUserName);
        response.addObject("users", users);

        return response;
    }
    //Instead of showing a view we want to redirect to the edit page
    //the edit page will then be responsible for loading the user from the DB
    //and dynamically creating the page
    //when you use redirect:  as part of the view name it triggers spring to tell
    //the browser to do a redirect to the URL after the :   The big piece here is to
    //recognize that redirect: uses a
    //  response.setViewName("redirect:/user/edit/" + user.getId());

    @GetMapping("user/edit/{userId}")
//    @RequestMapping(value = "/user/edit/{userId}", method = RequestMethod.GET)
    public ModelAndView editUser(@PathVariable("userId") Integer userId) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/register");

        User user = userDao.findById(userId);

        RegisterFormBean form = new RegisterFormBean();

        form.setId(user.getId());
        form.setUserName(user.getUserName());
        form.setFirstName(user.getFirstName());
        form.setLastName(user.getLastName());
        form.setPassword(user.getPassword());
        form.setConfirmPassword(user.getPassword());

        response.addObject("form", form);

        return response;
    }




}
