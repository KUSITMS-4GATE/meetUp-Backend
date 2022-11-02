package meetUpBackend.gload.repository;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import lombok.RequiredArgsConstructor;
import meetUpBackend.gload.domain.Review;
import meetUpBackend.gload.domain.reviewDelete;
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

    public List<Review> findAll() {
        return em.createQuery("select r from Review r", Review.class)
                .getResultList();
    }

    public int deleteOne(Long id) {
        return em.createQuery("update Review r set r.mapdelete = 'YES' where r.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }


    public void update(Review review, Long id) {
        Query query = em.createQuery(
                "update Review r set r.category = :category, r.content = :content , r.title = :title, r.mapdelete = :mapdelete, r.updDate = :updDate " +
                        "where r.id = :id");
        query.setParameter("category", review.getCategory());
        query.setParameter("content", review.getContent());
        query.setParameter("title", review.getTitle());
        query.setParameter("mapdelete", reviewDelete.valueOf("NO"));
        query.setParameter("updDate", LocalDateTime.now());
        query.setParameter("id", id);
        int rowUpdated = query.executeUpdate();
        System.out.println("rowUpdated" + rowUpdated);
    }
}