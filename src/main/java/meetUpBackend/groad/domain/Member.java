package meetUpBackend.groad.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue
    @JoinColumn(name = "userId")
    private String userId;

    @Column(name = "memberId")
    private Long id;

    private String pwd;

    private LocalDateTime regDate;
    private LocalDateTime updDate;

    private String name;
    private String email;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "mypageId")
//    private MyPage mypageId;
}
