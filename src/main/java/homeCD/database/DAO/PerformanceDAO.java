package homeCD.database.DAO;
import homeCD.database.entity.Performance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface PerformanceDAO extends JpaRepository<Performance, Long> {

    public Performance findById(@Param("id") Integer id);

    @Query(value = "Select p from Performance p Where p.cdId=:cdId AND p.composerId=:composerId")
    List<Performance> findBycdIdAndcomposerId(@Param("cdId") Integer cdId, @Param("composerId") Integer composerId);

}