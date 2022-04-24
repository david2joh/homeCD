package homeCD.controller;


import homeCD.database.DAO.PerformanceDAO;
import homeCD.formbean.PerformanceDetailBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//
// Small controller to list all the performances
//

@Slf4j
@Controller
@PreAuthorize("hasAnyAuthority('USER','ADMIN')")
public class PerformanceController {

    @Autowired
    private PerformanceDAO performanceDao;

    @RequestMapping(value = "/performance/performanceList", method = RequestMethod.GET)
    public ModelAndView performanceList() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("performance/performanceList");

        log.trace("Entering performance/performanceList");
        Map<String, Object> result = new HashMap<>();
        List<PerformanceDetailBean> pDetails = new LinkedList<>();
        List<Map<String, Object>> results = performanceDao.getPerformancelist();
        if (result != null) {
            for (int i = 0; i < results.size(); i++) {
                PerformanceDetailBean pDetail = new PerformanceDetailBean();
                result = results.get(i);
                pDetail.setCdId((Integer) result.get("cdId"));
                pDetail.setPerformance((String) result.get("work"));
                pDetail.setComposer((String) result.get("composer"));
                pDetail.setArtist((String) result.get("artist"));
                pDetail.setLocationName((String) result.get("locationName"));
                pDetails.add(pDetail);
            }
            response.addObject("pDetails", pDetails);
        }

        return response;
    }
}
