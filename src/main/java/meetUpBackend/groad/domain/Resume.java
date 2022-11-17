package meetUpBackend.groad.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "Resume")
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resumeId")
    private Long resumeId;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private MyPage userId;


    @Enumerated(EnumType.STRING)
    private ResumePass pass; // YES OR NO

    @Enumerated(EnumType.STRING)
    private ResumeDelete resumeDelete; // YES OR NO


    private LocalDateTime regDate ;
    private LocalDateTime updDate ;


    @Column(name = "resumeTitle")
    private String title;
    @Column(name = "resumeContent")
    private String content;
    @Column(name = "resumeCategory")
    private String category;
    @Column(name = "resumeGrade")
    private Integer type;
    @Column(name = "resumeStrDate")
    private Date resumeStrDate;
    @Column(name = "resumeEndDate")
    private Date resumeEndDate;
}
