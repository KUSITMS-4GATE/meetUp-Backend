package meetUpBackend.groad.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

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


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private Member member;


    @Enumerated(EnumType.STRING)
    private ResumePass pass; // YES OR NO

    @Enumerated(EnumType.STRING)
    private ResumeDelete resumeDelete; // YES OR NO

    @CreationTimestamp
    private LocalDateTime regDate ;
    @UpdateTimestamp
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
