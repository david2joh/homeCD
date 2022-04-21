package homeCD.database.DAO;
import homeCD.database.entity.Performance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public interface PerformanceDAO extends JpaRepository<Performance, Long> {

    public Performance findById(@Param("id") Integer id);


    //@Query(value = Select p from performances p Where p.cd_id=:cdId AND p.composer_id=:composerId")
    @Query(value = "Select * from performances p Where p.cd_id=:cdId AND p.composer_id=:composerId" ,nativeQuery = true)
    public List<Performance> findBycdIdAndcomposerId(@Param("cdId") Integer cdId, @Param("composerId") Integer composerId);

    @Modifying
    @Transactional
    @Query(value= "insert into performances (cd_id,composer_id,performance,artist) values (:cdId ,:composerId , :work, :artist)", nativeQuery = true)
    public void addPerformance(@Param("cdId") Integer cdId, @Param("composerId")  Integer composerId,
                               @Param("work") String work, @Param("artist") String artist);

    @Query(value="select cds.id as cdId, performances.performance as work, composers.composer_name as composer, "
            + " performances.artist as artist ,  location_name as locationName from cds"
            + " join performances on cds.id=performances.cd_id"
            + " join composers on performances.composer_id = composers.id"
            + " join locations on locations.id = cds.location_id"
            + " order by performances.performance , composers.composer_name", nativeQuery = true)
    public List<Map<String,Object>>  getPerformancelist();

}