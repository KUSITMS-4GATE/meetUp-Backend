package meetUpBackend.gload.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "ActSemster")
public class ActSemester {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actSemesterId")
    private Long actSemesterId;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "roadmapId")
    private List<Roadmap> roadmapId;

    @Column(name = "actSemesterSemester")
    private String semester;
    @Column(name = "actSemesterYear")
    private String year;

}
