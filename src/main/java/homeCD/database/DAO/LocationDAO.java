package homeCD.database.DAO;

import homeCD.database.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


//
// Handle DB access for the location table
//
// The one extra query spans the DB end to end to give a complete listing
//

@Repository
public interface LocationDAO extends JpaRepository<Location, Long> {


    public Location findById(@Param("id") Integer id);

    // public List<Location> findAllOrderByIdAsc();
    public List<Location> findAll();

    public Location findByLocationName(@Param("locationName") String locationName);

    @Query(value = "Select l.location_name as locationName , count(c.id) as cnt from locations as l join cds as c on l.id = c.location_id group by l.id order by l.id", nativeQuery = true)
    public List<Map<String, Object>> getLocationCount();

    @Query(nativeQuery = true,
            value = "select location_name as locationName, composers.composer_name as composerName, "
                    + "performances.performance as performance, performances.artist as artist from cds "
                    + " join performances on cds.id=performances.cd_id "
                    + " join composers on performances.composer_id = composers.id "
                    + " join locations on locations.id = cds.location_id "
                    + " where locations.id=:locId")
    public List<Map<String, Object>> getCDdetailsBylocationId(@Param("locId") Integer locationId);


}


//
// Some educational notes left here for when I come back in a couple months
//
//there are thre ways to execut a query
// 1.) via @Query with JPA /JQl? HQL
// 2.) via @Query with a native query
// 3.) by using a function for spring to do the query with no query (with reflection ...
//     see about findByFirstNameAndLastName .. Spring parses function name and pulls it apart

//this is a JPA query is a hibernate JLQ or HQL query
//  @Query(select u from Location u where u.email = :email")
//Native query example
//        @Query(value = "select u from Location u where u.password = :password", nativeQuery = true)
//        public List<Location> getByPassword(@Param("password") String password);
//
//
//        List<Location> findByFirstNameIgnoreCaseContaining(@Param("firstName") String str);
