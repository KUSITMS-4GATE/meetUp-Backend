package meetUpBackend.gload.repository;

import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import meetUpBackend.gload.domain.Review;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class reviewRepository {

    private final EntityManager em;

    public void save(Review review) {
        em.persist(review);
    }

    public Review findOne(Long id) {
        return em.find(Review.class, id);
    }

}
