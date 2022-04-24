package homeCD.database.DAO;


import homeCD.database.entity.Cd;
import homeCD.database.entity.Location;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;


@ActiveProfiles("test")
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestCdDAO {

    @Autowired
    private CdDAO cdDao;

    @Autowired
    LocationDAO locationDao;

    Location l1;
    Location l2;

    @BeforeEach
    void setup() {
        l1 = new Location();
        l1.setLocationName("office");
        l2 = new Location();
        l2.setLocationName("car");

    }

    @ParameterizedTest
    @Order(1)
    @Rollback(value = false)
    @CsvSource({"home, 1 , 1", "home, 2, 1", "Telarc, TDC-0401, 2"})
    public void createCdTest(String label, String catalogNumber, Integer locationId) {
        locationDao.save(l1);
        locationDao.save(l2);
        Cd testCd = new Cd();
        testCd.setLabel(label);
        testCd.setCatalogNumber(catalogNumber);
        testCd.setLocationId(locationId);

        Cd result = cdDao.save(testCd);
        Assertions.assertEquals(label, result.getLabel());
        Assertions.assertEquals(catalogNumber, result.getCatalogNumber());
        Assertions.assertEquals(locationId, result.getLocationId());

    }

    @Test
    @Order(2)
    @Rollback(value = false)
    public void readCdTest() {
        Cd result = cdDao.findCdByLabelAndAndCatalogNumber("Telarc", "TDC-0401");
        Assertions.assertEquals("Telarc", result.getLabel());
        Assertions.assertEquals("TDC-0401", result.getCatalogNumber());
    }

    @Test
    @Order(3)
    @Rollback(value = false)
    public void updateCdTest() {
        Cd result = cdDao.findById(1);
        result.setLabel("BiS");
        result = cdDao.save(result);
        result = cdDao.findById(1);
        Assertions.assertEquals("BiS", result.getLabel());
    }

    @Test
    @Order(4)
    public void deleteCdTest() {
        cdDao.delete(cdDao.findById(2));
        Cd result = cdDao.findById(2);
        Assertions.assertNull(result);
    }
}