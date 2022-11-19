package meetUpBackend.groad.domain;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import org.hibernate.annotations.Type;

@Entity
@Getter @Setter
public class MyPage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "myPageId")
    @Type(type = "uuid-char")
    private UUID myPageId = UUID.randomUUID();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resumeId")
    private Resume resumeId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User userId;


    private LocalDateTime regDate ;
    private LocalDateTime updDate ;

    @Column(name = "mypageCollege")
    private String college;
    @Column(name = "mypageMajor")
    private String major;
    @Column(name = "enterYear")
    private Integer enterYear;
    @Column(name = "mypageGrade")
    private Integer grade;
    @Column(name = "mypageCareer")
    private String career;
    @Column(name = "mypageCompany")
    private String company;
    @Column(name = "selfIntroduce")
    private String selfIntroduce;



}
