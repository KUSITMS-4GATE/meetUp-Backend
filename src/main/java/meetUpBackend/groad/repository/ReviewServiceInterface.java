package meetUpBackend.groad.repository;

import meetUpBackend.groad.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewServiceInterface extends JpaRepository<Review, Long> {
    List<Review> findByTitleContaining(String searchWord);
    List<Review> findByContentContaining(String searchWord);
}
