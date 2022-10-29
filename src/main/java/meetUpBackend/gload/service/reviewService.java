package meetUpBackend.gload.service;

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
    public Long join(Review review){
        reviewRepository.save(review);
        return review.getId();
    }
}

