package meetUpBackend.groad.domain;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import org.hibernate.annotations.Type;
import meetUpBackend.groad.domain.Member;

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
    @JsonIgnore
    @JoinColumn(name = "userId")
    private Member userId;

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
