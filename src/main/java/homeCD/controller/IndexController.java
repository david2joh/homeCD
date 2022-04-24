package homeCD.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//
//The Index controller -- this is an old artifact pre-security
//that is left in here for when things go very bad
//

@Slf4j
@Controller
public class IndexController {


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() throws Exception {
        ModelAndView response = new ModelAndView();

        response.setViewName("index");

        return response;
    }
}