package meetUpBackend.gload.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter @Setter
public class Roadmap {

    @Id @GeneratedValue
    @Column(name = "roadmapId")
    private Long id;

//    @OneToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
//    private List

    @Enumerated(EnumType.STRING)
    private roadmapState state; // ENROLL OR OFF

    @Enumerated(EnumType.STRING)
    private ActivityUse actDelete; // YES OR NO

    @Enumerated(EnumType.STRING)
    private RoadmapUse mapDelete; // YES OR NO

    private LocalDateTime regDate ;
    private LocalDateTime updDate ;

    @Column(name = "roadmapTitle")
    private String title;
    @Column(name = "roadmapContent")
    private String content;
    @Column(name = "roadmapSemester")
    private String semester;
    @Column(name = "roadmapCategory")
    private String category;
}
