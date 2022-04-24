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
@Table(name = "cds")
public class Cd {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "label", nullable = false, length = 45)
    private String label;

    @Column(name = "catalog_number", nullable = false, length = 45)
    private String catalogNumber;

    @Column(name = "location_id", nullable = false)
    private Integer locationId;


    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "location_id", nullable = false, updatable = false, insertable = false)
    private Location location;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "cd", fetch = FetchType.EAGER)
    private Set<Performance> performances = new HashSet<>();

}
