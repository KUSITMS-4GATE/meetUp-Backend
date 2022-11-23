package meetUpBackend.groad.service;

import meetUpBackend.groad.domain.Event;
import meetUpBackend.groad.domain.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {

    private final reviewService reviewService;
    private final myResumeService myResumeService;

    public MainService(reviewService reviewService, myResumeService myResumeService) {
        this.reviewService = reviewService;
        this.myResumeService = myResumeService;
    }

    public String findHotList() {
        List<Review> hotReviewList = reviewService.findHottestReview();
        List<Event> hotEventList = reviewService.findHottestPortfolio();


        return String.format(hotEventList.toString(), hotEventList.toString());
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
                throw new RuntimeException("category err");
        }
    }

    public String searchReview(String searchWord) {
        return reviewService.findReview(searchWord).toString();
    }

    public String searchResume(String searchWord) {
        return myResumeService.findResume(searchWord).toString();
    }

}
