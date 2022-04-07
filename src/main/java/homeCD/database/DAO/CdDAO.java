package homeCD.database.DAO;

import homeCD.database.entity.Cd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CdDAO {


    public Cd findById(@Param("id") Integer id);

    public List<Cd> findAllByOrderByIdAsc();

    // Not terribly useful here
//    public List<Cd> findByCdName(
//            @Param("Cd") String Cd );

    public List<Cd> findAllByLocationIdAsc();



}
