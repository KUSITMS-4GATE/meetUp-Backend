package meetUpBackend.groad.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class MyPage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mypageId")
    private Long mypageId;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resumeId")
    private Resume resumeId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User userId;


    private LocalDateTime regDate ;
    private LocalDateTime updDate ;


    @Column(name = "mypageProfile")
    private String profile;
    @Column(name = "mypageCollege")
    private String college;
    @Column(name = "mypageMajor")
    private String major;
    @Column(name = "mypageGrade")
    private Integer grade;
    @Column(name = "mypageNo")
    private Integer no;
    @Column(name = "mypageScore")
    private Integer score;
    @Column(name = "mypageCareer")
    private String career;
    @Column(name = "mypageCompany")
    private String company;
    

}
