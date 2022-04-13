package homeCD.database.entity;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "user_roles")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class UserRole {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;


    //Not bothering with the fact that user could have many roles
    @Column(name = "user_role")
    private String userRole;

}
