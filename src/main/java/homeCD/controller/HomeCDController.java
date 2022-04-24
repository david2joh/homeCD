package homeCD.controller;


import homeCD.database.DAO.UserDAO;
import homeCD.database.entity.User;
import homeCD.formbean.RegisterFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


//
// A controller to just handle the login screen
// Usually at login/login but try and use other URLs
@Slf4j
@Controller
public class HomeCDController {

    @Autowired
    private UserDAO userDao;

    @RequestMapping(value = {"/login/homeCD", "/homeCD"}, method = {RequestMethod.POST, RequestMethod.GET})
    /* this method is the entry point for login*/
//    @PostMapping("/homeCD")
    public ModelAndView loginCD(@RequestParam(required = false) String userName, @RequestParam(required = false) String password) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("login/homeCD");
        if (userName != null && !userName.isEmpty() && password != null && !password.isEmpty()) {
            //attempting to login
            User user = new User();
            user = userDao.findByUserName(userName);
            if (user != null && password.equals(user.getPassword())) {
                response.setViewName("redirect:/menu/menu");
                return response;
            }
        }

        RegisterFormBean form = new RegisterFormBean();
        response.addObject("form", form);

        return response;
    }
}
