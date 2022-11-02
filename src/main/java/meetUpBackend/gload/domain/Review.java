package meetUpBackend.gload.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Getter @Setter
public class Review {

    @Id
    @GeneratedValue
    @JsonProperty("reviewId")
    @Column(name = "reviewId")
    private Long id;


    @Enumerated(EnumType.STRING)
    @JsonProperty("mapDelete")
    @Column(name = "roadmapDelete")
    private reviewDelete mapdelete; // YES OR NO


    @JsonProperty("regDate")
    @CreationTimestamp
    private LocalDateTime regDate ;

    @JsonProperty("updDate")
    @UpdateTimestamp
    private LocalDateTime updDate ;

    @JsonProperty("reviewTitle")
    @Column(name = "reviewTitle")
    private String title;

    @JsonProperty("reviewContent")
    @Column(name = "reviewContent")
    private String content;

    @JsonProperty("reviewCategory")
    @Column(name = "reviewCategory")
    private String category;

}
