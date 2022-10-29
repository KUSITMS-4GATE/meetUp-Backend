package meetUpBackend.gload.service;

import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import meetUpBackend.gload.domain.Review;
import meetUpBackend.gload.repository.reviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }
}
