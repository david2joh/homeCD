package homeCD.database.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name="performances")
public class Performance {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

//    @Column(name = "cd_id",  nullable = false ,insertable = false, updatable = false)
//    private Integer cdId;
//
//    @Column(name = "composer_id",  nullable = false , insertable = false, updatable = false)
//    private Integer composerId;

    @Column(name = "performance", nullable = false, length = 45)
    private String performance;

    @Column(name = "artist", nullable = false, length = 45)
    private String artist;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "cd_id" , nullable = false)
    private Cd cd;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "composer_id" ,nullable = false)
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
