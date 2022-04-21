package homeCD.controller;

import homeCD.formbean.CdDetailBean;
import homeCD.formbean.LocationFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
import java.util.*;

//
// Location Controller -- this is two leveled the overview of all locations
// and details expressing what CDs exist in a particular location
//

@Slf4j
@Controller
@PreAuthorize("hasAnyAuthority('USER','ADMIN')")
public class LocationController {

    @Autowired
    LocationDAO locationDao;

    // List  Locations for the intro location page
    @RequestMapping(value = "/location/list", method = RequestMethod.GET)
    public ModelAndView list() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("location/list");

        List<Location> locations = new ArrayList<>();

        locations = locationDao.findAll();

        response.addObject("locations", locations);
        /*
        Seeding the model with an empty form so that the JSP substitutions will not error out
        in this case spring is being nice enough to not thow errors but these 2 lines are safety
         */
        LocationFormBean form = new LocationFormBean();
        response.addObject("form", form);

        return response;
    }

    //Method to handle the add/update/delete of locations the action to occur is passed in as a path variable
    @RequestMapping(value = "/location/locationChange/{action}", method = {RequestMethod.POST, RequestMethod.GET})
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

        Location dbLocation = new Location();
        Location location = locationDao.findByLocationName(form.getLocationName());
        if (action.equalsIgnoreCase("update") && (form.getId() != 0)) {
            location = locationDao.findById(form.getId());
        }
        if (location == null) {
            if (action.equalsIgnoreCase("add")) {
                location = new Location();
                location.setLocationName(form.getLocationName());
                locationDao.save(location);
                log.debug("Location creation = " + form.toString());
            }
            else if (action.equalsIgnoreCase("update")) {
                //Already know that location name is valid so just update
                log.debug("Location name changed from : " + location.getLocationName() +
                        " to " + form.getLocationName());
                location.setLocationName(form.getLocationName());
                locationDao.save(location);
                response.setViewName("redirect:/location/list");
                return response;
            }
            else {  //wow someone spoofed us just go back reseting the form
                log.debug("Location creation with bad inputs = " + form.toString());
                response.setViewName("redirect:/location/list");
            }
        } else {
            //We have a delete or update
            //if the action = delete then this is a delete else a update
            //for deletes make sure that the location is really empty first.
            //the front end doesn't allow it so the only way to get there is
            //by spoofing the request
            if (action.equalsIgnoreCase("delete")) {
                if (location.getCds().size() == 0) {
                    locationDao.delete(location);
                    log.debug("Location deleted  : " + location.getLocationName());
                }
                else {
                    log.warn("Location delete attempted on Non Empty Location :" + location.getLocationName());
                }
            }
            else {
                if (action.equalsIgnoreCase("update")) {
                    //Already know that location name is valid so just update
                    log.debug("Location name changed from : " + location.getLocationName() +
                            " to " + form.getLocationName());
                    location.setLocationName(form.getLocationName());
                    locationDao.save(location);
                    lDetails(location.getId());
                }
            }
        }
            response.setViewName("redirect:/location/list");
            return response;
        }



    @RequestMapping(value = "/location/details", method = RequestMethod.GET)
    public ModelAndView lDetails(@RequestParam("locationId")  Integer locationId) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("location/details");

        Location location = locationDao.findById(locationId);

        response.addObject("location", location);

        Map<String,Object> result = new HashMap<>();
        List<CdDetailBean> cdDetails = new LinkedList<>();
        List<Map<String,Object>> results =  locationDao.getCDdetailsBylocationId((locationId));
        if (result != null ) {
            for (int i = 0; i < results.size(); i++) {
                CdDetailBean cdDetail = new CdDetailBean();
                cdDetail.setId(i+1);
                result = results.get(i);
                cdDetail.setLocationName((String) result.get("locationName"));
                cdDetail.setComposer((String) result.get("composerName"));
                cdDetail.setArtist((String) result.get("artist"));
                cdDetail.setPerformance((String) result.get("performance"));
                cdDetails.add(cdDetail);
            }
            response.addObject("cdDetails", cdDetails);
        }

      /*
        Seeding the model with a form id in this case spring is thorwing errors
         */
        LocationFormBean form = new LocationFormBean();
        form.setId(locationId);
        form.setLocationName(location.getLocationName());
        response.addObject("form", form);

        return response;
    }

}
