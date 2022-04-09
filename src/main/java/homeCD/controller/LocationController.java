package homeCD.controller;

import homeCD.formbean.LocationFormBean;
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

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class LocationController {

    @Autowired
    LocationDAO locationDAO;

    // List  Locations for the intro location page
    @RequestMapping(value = "/location/list", method = RequestMethod.GET)
    public ModelAndView list() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("location/list");

        List<Location> locations = new ArrayList<>();

            locations = locationDAO.findAll();

        response.addObject("locations", locations);
        /*
        Seeding the model with an empty form so that the JSP substitutions will not error out
        in this case spring is being nice enough to not thow errors but these 2 lines are safety
         */
        LocationFormBean form = new LocationFormBean();
        response.addObject("form", form);

        return response;
    }

    @RequestMapping(value = "/user/locationChange/{action}", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView locationChange(@Valid LocationFormBean form, BindingResult bindingResult,
                                       @PathVariable("action") String action) throws Exception {
        ModelAndView response = new ModelAndView();

        //ask binding result if it has errors
        if (bindingResult.hasErrors()) {
            List<String> errorMessages = new ArrayList<>();

            for (ObjectError error : bindingResult.getAllErrors()) {
                errorMessages.add(error.getDefaultMessage());
                log.info(((FieldError) error).getField() + " " + error.getDefaultMessage());
            }
            //Add the information that was in the form back to the form when erroring
            //so the user does not have to re-enter the information
            response.addObject("form", form);
            //add the errror list to the model
            response.addObject("errorMessages", errorMessages);
            response.addObject("bindingResult", bindingResult);

            //because this is an error we do not want to processs to create/update/delete a location in the DB
            // We want to show the same model that we are already on location/list
            response.setViewName("redirect:/location/list");
            //response.setViewName("redirect:/user/register");
            return response;
        }


        Location location = locationDAO.findByLocationName(form.getLocationName());
        if (location == null) {
            if (action.equalsIgnoreCase("add")) {
                location = new Location();
                location.setLocationName(form.getLocationName());
                locationDAO.save(location);
                log.debug("Location creation = " + form.toString());
            }
            else {  //wow someone spoofed us just go back reseting the form
                log.debug("Location creation with bad inputs = " + form.toString());
                response.setViewName("redirect:/location/list");
            }
        }
        else {
            //We have a delete or update
            //if the action = delete then this is a delete else a update
            //for deletes make sure that the location is really empty first.
            //the front end doesn't allow it so the only way to get there is
            //by spoofing the request
            if (action.equalsIgnoreCase("update")) {
                if (location.getCds().size() == 0) {
                    locationDAO.delete(location);
                    log.debug("Location deleted  : " + location.getLocationName());
                } else {
                    log.warn("Location delete attempted on Non Empty Location :" + location.getLocationName());
                }
            }
            else if (action.equalsIgnoreCase("delete")) {
                    //Already know that location name is valid so just update
                    log.debug("Location name changed from : " + location.getLocationName() +
                            " to " + form.getLocationName());
                    location.setLocationName(form.getLocationName());
                    locationDAO.delete(location);
                }
            }
        response.setViewName("redirect:/location/list");
        return response;
    }




    @RequestMapping(value = "/location/details", method = RequestMethod.GET)
    public ModelAndView lDetails(@RequestParam("locationId")  Integer locationId) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("location/details");

        Location location = locationDAO.findById(locationId);

        response.addObject("location", location);

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
