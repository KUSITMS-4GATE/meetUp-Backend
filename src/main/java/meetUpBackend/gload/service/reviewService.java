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
        reviewRepository.update(review, reviewId);
    }

    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Transactional
    public int deleteOne(Long reviewId){

        return reviewRepository.deleteOne(reviewId);
    }

}
