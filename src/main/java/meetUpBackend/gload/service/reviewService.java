package meetUpBackend.gload.service;

import java.util.List;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import meetUpBackend.gload.domain.Review;
import meetUpBackend.gload.repository.reviewRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class reviewService {
    private final reviewRepository reviewRepository;

    @Transactional
    public void join(Review review){
        reviewRepository.save(review);
    }

    @Transactional
    public Review selectOne(Long reviewId){

        return reviewRepository.findOne(reviewId);
    }

    @Transactional
    public void updateById(Review review, long reviewId) {
        Review up_review = reviewRepository.findOne(reviewId);

        if (up_review != null) {
            up_review.setCategory(up_review.getCategory());
            up_review.setTitle(up_review.getTitle());
            up_review.setContent(up_review.getContent());
        }
    }

    public List<Review> findAll() {
        return reviewRepository.findAll();
    }
}
