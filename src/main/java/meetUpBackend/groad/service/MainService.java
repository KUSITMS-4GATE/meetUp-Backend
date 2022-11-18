package meetUpBackend.groad.service;

import meetUpBackend.groad.domain.Event;
import meetUpBackend.groad.domain.Review;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class MainService {

    private final reviewService reviewService;

    public MainService(meetUpBackend.groad.service.reviewService reviewService) {
        this.reviewService = reviewService;
    }

    public String findHotList() {
        List<Review> reviewList = reviewService.findHottestReview();
        List<Event> eventList = reviewService.findHottestPortfolio();

        Stream<Review> hotReviewList = reviewList.stream().limit(4L);
        Stream<Event> hotEventList = eventList.stream().limit(3L);

        return String.format(hotEventList.toString(), hotEventList.toString());
    }
}
