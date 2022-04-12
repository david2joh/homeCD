package homeCD.database.DAO;

import homeCD.database.entity.Cd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CdDAO extends JpaRepository<Cd, Long> {



    public Cd findById(@Param("id") Integer id);

   // public List<Cd> findAllOrderById();

    public List<Cd> findAll();

}
