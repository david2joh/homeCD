package homeCD.database.DAO;


import homeCD.database.entity.Location;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Assertions;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;


@ActiveProfiles("test")
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class TestLocationDAO {

    @Autowired
    private LocationDAO locationDao;

   @Test
   @Order(1)
   @Rollback(value=false)
   public void createLocationTest() {


       Location testLocation = new Location();
       testLocation.setLocationName("Paris");
       Location result = locationDao.save(testLocation);
       Assertions.assertEquals("Paris",result.getLocationName());
//       Assertions.assertTrue(result.getId() > 0);
   }

    @Test
    @Order(2)
    @Rollback(value=false)
    public void readLocationTest() {
        Location result = locationDao.findByLocationName("Paris");
        Assertions.assertEquals("Paris", result.getLocationName());
    }

    @Test
    @Order(3)
    @Rollback(value=false)
    public void updateLocationTest() {
        Location result = locationDao.findByLocationName("Paris");
        result.setLocationName("London");
        result = locationDao.save(result);
        Assertions.assertEquals("London",result.getLocationName());
    }

    @Test
    @Order(4)
    public void deleteLocationTest() {
        locationDao.delete(locationDao.findByLocationName("London"));
        Location result = locationDao.findByLocationName("London");
        Assertions.assertNull(result);
    }



 }
