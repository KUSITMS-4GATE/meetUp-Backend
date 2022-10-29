package meetUpBackend.gload.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import meetUpBackend.gload.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public class reviewRepository {
    EntityManager em = null;
    EntityTransaction tx = em.getTransaction();
    public Review save(Review review) {
        try {
            tx.begin();

            em.persist(review.getId());

            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }finally {
            em.close();
        }
        return review;
    }

    public interface reviewRepo extends JpaRepository<Review, Long> {
        //select m from Member m where m.name = ?
        List<Review> findByName(String name); //메서드 이름을 보고 ?를 채워 넣는다.(findByName)
    }
}
