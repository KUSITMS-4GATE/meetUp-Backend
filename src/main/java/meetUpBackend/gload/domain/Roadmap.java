package meetUpBackend.gload.domain;

import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "Roadmap")
public class Roadmap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roadmapId")
    private Long roadmapId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "actSemesterId")
    private ActSemester actSemesterId;

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
    @Column(name = "roadmapCategory")
    private String category;
    @Column(name = "roadmapGrade")
    private Integer grade;
    @Column(name = "roadmapStrDate")
    private Date roadmapStrDate;
    @Column(name = "roadmapEndDate")
    private Date roadmapEndDate;
}
