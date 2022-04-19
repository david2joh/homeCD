package homeCD.database.DAO;


import homeCD.database.entity.Composer;
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
public class TestComposerDAO {

    @Autowired
    private ComposerDAO composerDao;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void createComposerTest() {


        Composer testComposer = new Composer();
        testComposer.setComposerName("Bach");
        Composer result = composerDao.save(testComposer);
        Assertions.assertEquals("Bach", result.getComposerName());
//       Assertions.assertTrue(result.getId() > 0);
    }

    @Test
    @Order(2)
    @Rollback(value = false)
    public void readComposerTest() {
        Composer result = composerDao.findByComposerName("Bach");
        Assertions.assertEquals("Bach", result.getComposerName());
    }

    @Test
    @Order(3)
    @Rollback(value = false)
    public void updateComposerTest() {
        Composer result = composerDao.findByComposerName("Bach");
        result.setComposerName("Copland");
        result = composerDao.save(result);
        Assertions.assertEquals("Copland", result.getComposerName());
    }

    @Test
    @Order(4)
    public void deleteComposerTest() {
        composerDao.delete(composerDao.findByComposerName("Copland"));
        Composer result = composerDao.findByComposerName("Copland");
        Assertions.assertNull(result);
    }
}