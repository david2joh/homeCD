package homeCD.database.DAO;

import homeCD.database.entity.Cd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Map;

//Mark the repository as transactional since there are update/delete methods
//Mark individual methods with @Modifying to limit the scope
@Repository
@Transactional
public interface CdDAO extends JpaRepository<Cd, Long> {



    public Cd findById(@Param("id") Integer id);

   // public List<Cd> findAllOrderById();

    public List<Cd> findAll();


    @Query(value = "SELECT cd FROM Cd cd WHERE cd.label = :label AND cd.catalogNumber = :catalogNumber")
    public Cd findCdByLabelAndAndCatalogNumber(@Param("label") String label, @Param("catalogNumber") String catalogNumber);

    @Modifying
    @Query(value ="DELETE FROM Cd c where c.id = :id")
    public void deleteCd(@Param("id") Integer id);
}
