package meetUpBackend.gload.repository;

import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import meetUpBackend.gload.domain.Review;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public List<Review> findAll() {
        return em.createQuery("select r from Review r", Review.class)
                .getResultList();
    }

    public int deleteOne(Long id) {
        return em.createQuery("update Review r set r.mapdelete = 'NO' where r.id = :id", Review.class)
                .setParameter("id", id)
                .executeUpdate();
    }


}
