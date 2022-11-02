package meetUpBackend.gload.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import lombok.RequiredArgsConstructor;
import meetUpBackend.gload.domain.Review;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class reviewRepository {
    EntityManager em = null;
    EntityTransaction tx = em.getTransaction();

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


    public void update(Review review, long reviewId) {
        tx.begin();
        Query query = em.createQuery(
                "update Review r set r.category = :category, r.content = :content , r.title = :title " +
                        "where r.id = :id"
                , Review.class);
        query.setParameter("category", review.getCategory());
        query.setParameter("content", review.getContent());
        query.setParameter("title", review.getTitle());
        query.setParameter("id", reviewId);
        int rowUpdated = query.executeUpdate();
        System.out.println("rowUpdated" + rowUpdated);
        tx.commit();
        em.close();
    }
}
