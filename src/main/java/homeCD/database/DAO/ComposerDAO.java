package homeCD.database.DAO;

import homeCD.database.entity.Composer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ComposerDAO extends JpaRepository<Composer, Long> {



    public Composer findById(@Param("id") Integer id);

    public List<Composer> findAll();

    public Composer findByComposerName(@Param("composerName") String composerName);

    @Query(value= "select c from Composer c order by c.composerName")
    public List<Composer> findAllOrderByComposerName();

    public List<Composer> findComposerByComposerNameContainingIgnoreCase
         (@Param("composerName") String composerName);

    @Query(nativeQuery = true,
            value= "select cds.id as cdId, performances.performance as performance,   "
                    + " performances.artist as artist, location_name as locationName from cds "
                    + " join performances on cds.id=performances.cd_id "
                    + " join composers on performances.composer_id = composers.id "
                    + " join locations on locations.id = cds.location_id "
                    + " where composers.id=:composerId"
                    + " order by performances.performance")
    public List<Map<String,Object>> getCDdetailsByComposerId(@Param("composerId") Integer composerId);

}
