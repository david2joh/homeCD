package homeCD.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import homeCD.database.DAO.LocationDAO;
import homeCD.database.DAO.ComposerDAO;
import homeCD.database.entity.Composer;

// import homeCD.formbean.LocationFormBean;
//import javax.validation.Valid;

import java.util.*;

@Slf4j
@Controller
public class MenuController {

    @Autowired
    LocationDAO locationDao;

    @Autowired
    ComposerDAO composerDao;

    //Method to set the view for the main menu and populate the location list for the card
    @RequestMapping(value = "/menu/menu", method = RequestMethod.GET)
    public ModelAndView menu() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("menu/menu");

        // List<Location> locations = new ArrayList<Location>();

        List<Composer> composers = composerDao.findAllOrderByComposerName();
        response.addObject("composers", composers);
        // locations = locationDAO.findAll();
        List<Map<String,Object>> locations = locationDao.getLocationCount();

        response.addObject("locations", locations);

        return response;
    }

}
