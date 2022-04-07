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

@Slf4j
@Controller
public class LocationController {

    // List and Group Cds by location for the intro menu page
    public ModelAndView search(@RequestParam(required = false) String searchFirstName) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("location/locationcount");

        List<String> locations = new ArrayList<>();

        //if(StringUtils.isEmpty(searchFirstName)) {   //apache string utils to do the same check
        if (searchFirstName != null && !searchFirstName.isBlank()) {
            //query
            users = userDao.findByFirstNameIgnoreCaseContaining(searchFirstName);
        }
        response.addObject("searchFirstName", searchFirstName);
        response.addObject("users", users);

        return response;
    }






}
