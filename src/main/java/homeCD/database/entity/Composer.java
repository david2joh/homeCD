package homeCD.database.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name="composers")
public class Composer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "composer_name", nullable = false, length = 45)
    private String composerName;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "composer", fetch = FetchType.EAGER)
    private Set<Performance> performances = new HashSet<>();

}
