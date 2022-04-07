package homeCD.database.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name="locations")
public class Location {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "location_name", nullable = false, length = 45)
    private String locationName;

    @OneToMany(mappedBy = "location", fetch = FetchType.LAZY)
    private Set<Cd> cds =new HashSet<>();
}
