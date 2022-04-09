package homeCD.controller;



import homeCD.database.DAO.UserDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Slf4j
@Controller
public class HomeCDController {

//    @Autowired
//    private UserDAO userDao;

    @RequestMapping(value = "/homeCD", method = RequestMethod.GET)
    public ModelAndView index() throws Exception {
        ModelAndView response = new ModelAndView();


//        User user = userDao.findByEmail("a@b.com");
//        List<User> users = userDao.findByFirstNameIgnoreCaseContaining("A");
//        log.info("findBYEmail " + user.toString());
//
//
//        for (User u : users) {
//            log.info(u.toString());
//        }
//
//        users = userDao.findByFirstNameAndLastName("A","C");
//        for (User u : users) {
//            log.info("findBYF_L_name " + u.toString());
//        }
//    List<User> users = userDao.findAll();
        response.setViewName("homeCD");
//        response.addObject("users",users);

        return response;
    }


}
