package homeCD.database.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="performances")
public class Performance {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "cd_id", insertable = false, nullable = false)
    private Integer cdId;
    @Basic
    @Column(name = "composer_id", insertable = false, nullable = false)
    private Integer composerId;
    @Basic
    @Column(name = "performance", nullable = false, length = 45)
    private String performance;
    @Basic
    @Column(name = "artist", nullable = false, length = 45)
    private String artist;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "cd_id", nullable = false, updatable = false, insertable = false)
    private Cd cd;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "composer_id", nullable = false, updatable = false, insertable = false)
    private Composer composer;

    public Composer getComposer() {
        return composer;
    }

    public void setComposer(Composer composer) {
        this.composer = composer;
    }

    public Cd getCd() {
        return cd;
    }

    public void setCd(Cd cd) {
        this.cd = cd;
    }

}
