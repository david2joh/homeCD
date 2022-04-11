package homeCD.database.DAO;


import homeCD.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {

    public User findById(@Param("id") Integer id);

    public List<User> findAllByOrderByIdAsc();

    public User findByUserName(@Param("userName") String userName);

    List<User> findByFirstNameIgnoreCaseContaining(String userName);

    // collate utf8mb4_general_ci
    @Query(value = "select * from Users u where lower(u.user_name) LIKE CONCAT('%',lower(:username),'%') ", nativeQuery = true)
    List<User> findByUserNameContainingIgnoreCase(@Param("username") String username);
}

