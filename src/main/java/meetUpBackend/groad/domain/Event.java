package meetUpBackend.groad.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Event {

    @Id
    @GeneratedValue
    @JsonProperty("eventId")
    @Column(name = "eventId")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolioId")
    private Review portfolioId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reviewId")
    private Review reviewId;

    @Column(name = "eventLike")
    private Integer like;
    @Column(name = "eventScrap")
    private Integer scrap;

}
