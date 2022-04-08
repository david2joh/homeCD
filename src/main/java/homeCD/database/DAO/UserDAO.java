package homeCD.database.DAO;


import homeCD.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO {

    public User findById(@Param("id") Integer id);

    public List<User> findAllByOrderByIdAsc();

    public List<User> findByUserName(
            @Param("UserName") String UserName);
}
