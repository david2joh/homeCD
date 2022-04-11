package homeCD.database.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

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
    @Column(name = "first_name", nullable = false, length = 16)
    private String firstName;

    @Basic
    @Column(name = "user_name", nullable = false, length = 16)
    private String userName;

    @Basic
    @Column(name = "last_name", nullable = false, length = 16)
    private String lastName;

    @Basic
    @Column(name = "password", nullable = false, length = 32)
    private String password;

    @Basic
    @Column(name = "user_type", nullable = false)
    private Integer userType;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", nullable = false)
    private Date createDate = new Date();;

}
