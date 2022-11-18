package meetUpBackend.groad.service;

import java.util.List;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import meetUpBackend.groad.domain.Event;
import meetUpBackend.groad.domain.Review;
import meetUpBackend.groad.repository.reviewRepository;
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
    public void updateById(Review review, Long reviewId) {
        reviewRepository.update(review, reviewId);
    }

    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Transactional
    public int deleteOne(Long reviewId){

        return reviewRepository.deleteOne(reviewId);
    }

    @Transactional
    public int recommendOne(Long reviewId){

        return reviewRepository.recommendOne(reviewId);
    }

    @Transactional
    public int reportOne(Long reviewId){

        return reviewRepository.reportOne(reviewId);
    }

    @Transactional
    public int scrapOne(Long reviewId){

        return reviewRepository.scrapOne(reviewId);
    }

    @Transactional
    public List<Review> findHottestReview() {
        return reviewRepository.findHottestReview();
    }

    //portfolio 없어서 여기다 작성
    @Transactional
    public List<Event> findHottestPortfolio() {
        return reviewRepository.findHottestPortfolio();
    }

}