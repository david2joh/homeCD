package homeCD.database.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "username", nullable = false, length = 16)
    private String username;
    @Basic
    @Column(name = "password", nullable = false, length = 32)
    private String password;
    @Basic
    @Column(name = "user_type", nullable = false)
    private Integer userType;
    @Basic
    @Column(name = "create_time", nullable = false)
    private Timestamp createTime;

}
