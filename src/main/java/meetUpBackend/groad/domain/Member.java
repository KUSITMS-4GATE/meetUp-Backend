package meetUpBackend.groad.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue
    @JoinColumn(name = "userId")
    private String userId;

    @Column(name = "member_id")
    private Long id;

    private String pwd;

    private LocalDateTime regDate;
    private LocalDateTime updDate;

    private String name;
    private String email;
}
