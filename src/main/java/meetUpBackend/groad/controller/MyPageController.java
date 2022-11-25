package meetUpBackend.groad.controller;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import meetUpBackend.groad.domain.Member;
import meetUpBackend.groad.domain.MyPage;
import meetUpBackend.groad.service.MyPageService;
import meetUpBackend.groad.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class MyPageController {

    private final MyPageService myPageService;

    private final UserService userService;

    @GetMapping("/{user_id}/mypage")
    public MyPage selectMyPageInfo(@PathVariable("user_id") String id) {
        Member userId = userService.getUserId(id);
        // List<Roadmap> myPageAll = (List<Roadmap>) myPageService.getMyPage(userId);
        MyPage myPageAll = myPageService.getMyPage(userId);

        return myPageAll;
   }

    @PostMapping("/{user_id}/mypage/saveinfo")
    public void saveMyPageInfo(@RequestBody userResumeIdReq userResumeIdReq, @PathVariable("user_id") String id){
        MyPage myPage = new MyPage();
        Member userId = userService.getUserId(id);
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

    @PutMapping("/{user_id}/mypage/updateinfo")
    public void updateMyPageInfo(@RequestBody userResumeIdReq userResumeIdReq, @PathVariable("user_id") String id) {
        MyPage myPage = new MyPage();
        myPage.setCollege(userResumeIdReq.getCollege());
        myPage.setMajor(userResumeIdReq.getMajor());
        myPage.setEnterYear(userResumeIdReq.getEnterYear());
        myPage.setUpdDate(LocalDateTime.now());
        myPage.setGrade(userResumeIdReq.getGrade());
        myPage.setCareer(userResumeIdReq.getCareer());
        myPage.setCompany(userResumeIdReq.getCompany());
        myPage.setSelfIntroduce(userResumeIdReq.getSelfIntroduce());
        myPageService.updateMyPageInfo(myPage,id);

//        System.out.println(myPage.getMajor());
//        System.out.println(myPage.getCareer());
//        System.out.println(myPage.getCollege());
//        System.out.println(myPage.getCompany());
//        System.out.println(myPage.getSelfIntroduce());
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
