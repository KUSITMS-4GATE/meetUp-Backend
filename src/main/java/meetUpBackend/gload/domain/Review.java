package meetUpBackend.gload.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Review {

    @Id
    @GeneratedValue
    @Column(name = "reviewId")
    private Long id;


    @Enumerated(EnumType.STRING)
    @Column(name = "roadmapDelete")
    private reviewDelete mapdelete; // YES OR NO


    private LocalDateTime regDate ;
    private LocalDateTime updDate ;


    @Column(name = "reviewTitle")
    private String title;
    @Column(name = "reviewContent")
    private String content;
    @Column(name = "reviewCategory")
    private String category;

}
