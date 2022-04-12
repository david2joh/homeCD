package homeCD.database.DAO;


import homeCD.database.entity.Location;
import homeCD.database.entity.Performance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerformanceDAO extends JpaRepository<Location, Long> {

    public Location findById(@Param("id") Integer id);

}
