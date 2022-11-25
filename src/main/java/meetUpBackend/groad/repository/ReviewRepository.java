package meetUpBackend.groad.repository;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import lombok.RequiredArgsConstructor;
import meetUpBackend.groad.domain.Event;
import meetUpBackend.groad.domain.Review;
import meetUpBackend.groad.domain.ReviewDelete;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReviewRepository {
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



    public List<Review> findHottestReview() {
        return em.createQuery("select r from Review r", Review.class)
                .setMaxResults(5)
                .getResultList();

//        select * from review
//        inner join event
//        on review.reviewId = event.reviewId
//        where portfolioId = null
//        order by event_like desc limit 3;
    }

    //portfolio 레포없어서 여기서 작성
    public List<Event> findHottestPortfolio() {
        List<Event> resultList = em.createQuery("select e from Event e where e.reviewId is null order by e.like desc", Event.class)
                .setMaxResults(5)
                .getResultList();
        return resultList;
    }

    public int deleteOne(Long id) {
        return em.createQuery("update Review r set r.mapDelete = 'YES' where r.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    public int recommendOne(Long reviewId) {
        return em.createQuery("update Event e set e.like = e.like + 1 where e.reviewId = :reviewId")
                .setParameter("reviewId", reviewId)
                .executeUpdate();
    }

    public int reportOne(Long reviewId) {
        return em.createQuery("update Report r set r.count = r.count + 1 where r.reviewId = :reviewId")
                .setParameter("reviewId", reviewId)
                .executeUpdate();
    }

    public int scrapOne(Long reviewId) {
        return em.createQuery("update Event e set e.scrap = e.scrap + 1 where e.reviewId = :reviewId")
                .setParameter("reviewId", reviewId)
                .executeUpdate();
    }


    public void update(Review review, Long id) {
        Query query = em.createQuery(
                "update Review r set r.category = :category, r.content = :content , r.title = :title, r.mapDelete = :mapDelete, r.updDate = :updDate " +
                        "where r.id = :id");
        query.setParameter("category", review.getCategory());
        query.setParameter("content", review.getContent());
        query.setParameter("title", review.getTitle());
        query.setParameter("mapDelete", ReviewDelete.valueOf("NO"));
        query.setParameter("updDate", LocalDateTime.now());
        query.setParameter("id", id);
        int rowUpdated = query.executeUpdate();
        System.out.println("rowUpdated" + rowUpdated);
    }
}