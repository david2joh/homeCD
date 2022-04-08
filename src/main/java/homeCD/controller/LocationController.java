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
import homeCD.database.DAO.LocationDAO;
import homeCD.database.entity.Location;

// import homeCD.formbean.LocationFormBean;
//import javax.validation.Valid;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class LocationController {

    @Autowired
    LocationDAO locationDAO;

    // List and Group Cds by location for the intro menu page
    @RequestMapping(value = "/location/list", method = RequestMethod.GET)
    public ModelAndView list() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("location/list");

        List<Location> locations = new ArrayList<Location>();

            locations = locationDAO.findAll();


        response.addObject("locations", locations);

        return response;
    }

    @RequestMapping(value = "/menu/menu", method = RequestMethod.GET)
    public ModelAndView menu() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("menu/menu");

       // List<Location> locations = new ArrayList<Location>();

       // locations = locationDAO.findAll();
        List<Map<String,Object>> locations = locationDAO.getLocationCount();




        response.addObject("locations", locations);

        return response;
    }




}
