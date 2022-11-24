package meetUpBackend.groad.controller;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import meetUpBackend.groad.domain.Review;
import meetUpBackend.groad.domain.ReviewDelete;
import meetUpBackend.groad.service.ReviewService;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/activity/write")
    public Review saveReview(@RequestBody @Validated reviewRequest request) {
        Review review = new Review();
        review.setTitle(request.getTitle());
        review.setContent(request.getContent());
        review.setCategory(request.getCategory());
        review.setRegDate(LocalDateTime.now());
        review.setUpdDate(LocalDateTime.now());
        review.setMapDelete(ReviewDelete.NO);
        log.debug("review =" + review);
        reviewService.join(review);
        return review;
    }

    @GetMapping("/activity/update/{post_id}")
    public Review updateReviewPage(@PathVariable("post_id") Long reviewId, Model model){
        Review getReviewId = reviewService.selectOne(reviewId);

        model.addAttribute("getReviewId", getReviewId);

        return getReviewId;
    }


        @PutMapping("/activity/update/{post_id}")
    public Review updateReview(@RequestBody reviewRequest request, @PathVariable("post_id") Long reviewId){
        Review review = new Review();
        review.setTitle(request.getTitle());
        review.setContent(request.getContent());
        review.setCategory(request.getCategory());
        review.setMapDelete(request.getMapDelete());
        reviewService.updateById(review, reviewId);
        return review;
    }

    @GetMapping("/activity/{post_id}")
    public Review selectReview(@PathVariable("post_id") Long reviewId){

        Review reviewIdSelect = reviewService.selectOne(reviewId);

        return reviewIdSelect;
    }

    @GetMapping("/activity")
    public String list(Review review) {
        List<Review> reviewAll = reviewService.findAll();

        return reviewAll.toString();
    }

    @PutMapping("/activity/delete/{post_id}")
    public int deleteReview(@PathVariable("post_id") Long reviewId){

        int deleteReview = reviewService.deleteOne(reviewId);

        return deleteReview;
    }

    @PutMapping("/activity/recommend/{post_id}")
    public int recommendReview(@PathVariable("post_id") Long reviewId){

        int recommendReview = reviewService.recommendOne(reviewId);

        return recommendReview;
    }

    @PutMapping("/activity/report/{post_id}")
    public int reportReview(@PathVariable("post_id") Long reviewId){

        int reportReview = reviewService.reportOne(reviewId);

        return reportReview;
    }

    @PutMapping("/activity/scrap/{post_id}")
    public int scrapReview(@PathVariable("post_id") Long reviewId){

        int scrapReview = reviewService.scrapOne(reviewId);

        return scrapReview;
    }

    @Data
    static class CreateReview {
        private Long id;
    }

    @Data
    static class reviewRequest {
        private String title ;
        private String content ;
        private String category;
        private ReviewDelete mapDelete;
    }
}