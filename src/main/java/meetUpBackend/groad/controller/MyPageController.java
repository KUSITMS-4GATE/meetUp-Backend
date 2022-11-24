package meetUpBackend.groad.controller;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import meetUpBackend.groad.domain.MyPage;
import meetUpBackend.groad.domain.Roadmap;
import meetUpBackend.groad.domain.User;
import meetUpBackend.groad.service.MyPageService;
import meetUpBackend.groad.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class MyPageController {

    private final MyPageService myPageService;

    private final UserService userService;

    @GetMapping("/{user_id}/mypage")
    public String selectMyPageInfo(@PathVariable("user_id") String id) {
        User userId = userService.getUserId(id);
        List<Roadmap> myPageAll = (List<Roadmap>) myPageService.getMyPage(userId);

        return myPageAll.toString();
   }

    @PostMapping("/{user_id}/mypage/saveinfo")
    public void saveMyPageInfo(userResumeIdReq userResumeIdReq, @PathVariable("user_id") String id){
        MyPage myPage = new MyPage();
        User userId = userService.getUserId(id);
        myPage.setMyPageId(myPage.getMyPageId());
        myPage.setUserId(userId);
        myPage.setRegDate(LocalDateTime.now());
        myPage.setUpdDate(LocalDateTime.now());
        myPage.setCollege(userResumeIdReq.getCollege());
        myPage.setMajor(userResumeIdReq.getMajor());
        myPage.setEnterYear(userResumeIdReq.getEnterYear());
        myPage.setGrade(userResumeIdReq.getGrade());
        myPage.setCareer(userResumeIdReq.getCareer());
        myPage.setCompany(userResumeIdReq.getCompany());
        myPage.setSelfIntroduce(userResumeIdReq.getSelfIntroduce());
        myPageService.saveMyPageInfo(myPage);
    }

    @PutMapping("/{user_id}/mypage/updateinfo/{myPage_id}")
    public void updateMyPageInfo(MyPageController.userResumeIdReq userResumeIdReq, @PathVariable("user_id") String id
            , @PathVariable("myPage_id") MyPage myPageId){
        MyPage myPage = new MyPage();
        myPage.setMyPageId(myPageId.getMyPageId());
        myPage.setCollege(userResumeIdReq.getCollege());
        myPage.setMajor(userResumeIdReq.getMajor());
        myPage.setEnterYear(userResumeIdReq.getEnterYear());
        myPage.setGrade(userResumeIdReq.getGrade());
        myPage.setCareer(userResumeIdReq.getCareer());
        myPage.setCompany(userResumeIdReq.getCompany());
        myPage.setSelfIntroduce(userResumeIdReq.getSelfIntroduce());
        myPageService.updateMyPageInfo(myPage,id);
    }

    @Data
    static class userResumeIdReq{
        private Date regDate;
        private Date updDate;
        private String college;
        private String major;
        private Integer enterYear;
        private Integer grade;
        private String career;
        private String company;
        private String selfIntroduce;
    }

}
