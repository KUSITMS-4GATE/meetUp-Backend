package meetUpBackend.groad.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import meetUpBackend.groad.domain.ActSemester;
import meetUpBackend.groad.domain.MyPage;
import meetUpBackend.groad.domain.Roadmap;
import meetUpBackend.groad.domain.User;
import meetUpBackend.groad.service.myPageService;
import meetUpBackend.groad.service.userService;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class myPageController {

    private final myPageService myPageService;

    private final userService userService;

//    @GetMapping("/{user_id}/myPage")
//    public String selectMyPageInfo(@RequestBody @Validated myPageController.userResumeIdReq userResumeIdReq) {
//        User userId = userService.getUserId(userResumeIdReq.getUserId());
//        List<Roadmap> myPageAll = myPageService.getMyPage();
//
//        return myPageAll.toString();
//    }

//    @PostMapping("/{user_id}/myPage/saveInfo")
//    public void saveMyPageInfo(@RequestBody @Validated myPageController.userResumeIdReq userResumeIdReq){
//        MyPage myPage = new MyPage();
//        User userId = userService.saveMyPageInfo(userResumeIdReq.getUserId());
//        myPage.setMyPageId(userId);
//        myPage.setSemester(userResumeIdReq.getMyPageId());
//        myPageService.saveActSemester(actSemester);
//    }
//
//    @PutMapping("/{user_id}/myPage/updateInfo/{resume_id}")
//    public void updateMyPageInfo(@RequestBody @Validated myPageController.userResumeIdReq userResumeIdReq, @PathVariable("post_id") Long actSemesterId){
//        ActSemester actSemester = new ActSemester();
//        actSemester.setSemester(userResumeIdReq.getSemester());
//        actSemester.setYear(userResumeIdReq.getYear());
//        myPageService.updateMyPageInfo(actSemester, actSemesterId);
//    }

    @Data
    static class userResumeIdReq{
        private String userId;
        private String myPageId;
    }

}
