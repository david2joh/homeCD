package homeCD.database.DAO;

import homeCD.database.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleDAO extends JpaRepository<UserRole, Long> {

//    default List<UserRole> findByUserID() {
//        return findByUserID();
//    }

    List<UserRole> findByUserId(@Param("userId") Integer userId);

}
