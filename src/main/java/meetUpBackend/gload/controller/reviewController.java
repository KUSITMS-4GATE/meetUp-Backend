package meetUpBackend.gload.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import meetUpBackend.gload.domain.Review;
import meetUpBackend.gload.service.reviewService;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api")
public class reviewController {

    private final reviewService reviewService;

    @PostMapping("/activity/write")
    public Review saveReview(@RequestBody @Validated reviewRequest request) {
        log.debug("123");
        Review review = new Review();
        review.setTitle(request.getTitle());
        review.setContent(request.getContent());
        review.setCategory(request.getCategory());
        reviewService.join(review);
        return review;
    }

    @GetMapping("/activity/update/{post_id}")
    public Review updateReviewPage(@PathVariable("post_id") long reviewId, Model model){
        Review review = new Review();

        return review;
    }

    @GetMapping("/activity/{post_id}")
    public Review selectReview(@PathVariable("post_id") long reviewId, Review review){
        Review reviewIdSelect = reviewService.selectOne(reviewId);

        return reviewIdSelect;
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
    }
}