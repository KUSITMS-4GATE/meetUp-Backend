package meetUpBackend.groad.service;

import meetUpBackend.groad.domain.Event;
import meetUpBackend.groad.domain.Resume;
import meetUpBackend.groad.domain.Review;
import meetUpBackend.groad.repository.MyResumeRepositoryInterface;
import meetUpBackend.groad.repository.ReviewServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {

    private final ReviewServiceInterface reviewServiceInterface;

    private final MyResumeRepositoryInterface myResumeRepositoryInterface;

    private final ReviewService reviewService;

    public MainService(ReviewServiceInterface reviewServiceInterface, MyResumeRepositoryInterface myResumeRepositoryInterface, ReviewService reviewService) {
        this.reviewServiceInterface = reviewServiceInterface;
        this.myResumeRepositoryInterface = myResumeRepositoryInterface;
        this.reviewService = reviewService;
    }


    public String findHotList() {
        List<Review> hotReviewList = reviewService.findHottestReview();
        List<Event> hotEventList = reviewService.findHottestPortfolio();


        return String.format(hotEventList.toString(), hotReviewList.toString());
    }

    public String search(String category, String searchWord) {
        switch (category) {
            case "resume": {
                return searchResume(searchWord);
            }
            case "review": {
                return searchReview(searchWord);
            }
            default:
//                throw new RuntimeException("category err");
                return null;
        }
    }

    public String searchReview(String searchWord) {
        List<Review> reviewResult1 = reviewServiceInterface.findByContentContaining(searchWord);
        List<Review> reviewResult2 = reviewServiceInterface.findByTitleContaining(searchWord);

        return String.format(reviewResult1.toString(), reviewResult2.toString());
    }

    public String searchResume(String searchWord) {
        List<Resume> resumeResult1 = myResumeRepositoryInterface.findByContentContaining(searchWord);
        List<Resume> resumeResult2 = myResumeRepositoryInterface.findByTitleContaining(searchWord);

        return String.format(resumeResult2.toString(), resumeResult1.toString());
    }
}
