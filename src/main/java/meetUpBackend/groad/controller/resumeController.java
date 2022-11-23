package meetUpBackend.groad.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import meetUpBackend.groad.domain.User;
import meetUpBackend.groad.domain.MyPage;
import meetUpBackend.groad.service.resumeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api")
public class resumeController {

    private final resumeService resumeService;

    @GetMapping("/resume")
    public String resumeList() {
        List<MyPage> userResumeAll = resumeService.findAll();

        return userResumeAll.toString();
    }

    @GetMapping("/{user_id}/getuserresume")
    public MyPage linkUserResume(@PathVariable("user_id") String userId) {
        MyPage getUserId = resumeService.selectOne(userId);

        return getUserId;
    }

    @GetMapping("/resume/school/{school_name}")
    public String resumeFilterSchool(@PathVariable("school_name") String schoolName) {
        // System.out.println(schoolName);

        List<MyPage> userResumeAll = resumeService.findSchool(schoolName);

        return userResumeAll.toString();
    }

    @GetMapping("/resume/major/{major_type}")
    public String resumeFilterMajor(@PathVariable("major_type") String majorType) {
        List<MyPage> userResumeAll = resumeService.findMajor(majorType);

        return userResumeAll.toString();
    }

    @GetMapping("/resume/grade/{grade_num}")
    public String resumeFilterGrade(@PathVariable("grade_num") Integer gradeNum) {
        List<MyPage> userResumeAll = resumeService.findGrade(gradeNum);

        return userResumeAll.toString();
    }

    @GetMapping("/resume/career/{career_type}")
    public String resumeFilterCareer(@PathVariable("career_type") String careerType) {
        List<MyPage> userResumeAll = resumeService.findCareer(careerType);

        return userResumeAll.toString();
    }

    @Data
    static class userResumeData {
        private User user;
        private MyPage myPage;
    }
//    @Data
//    static class resumeRequest {
//        private String title;
//        private Integer type;
//        private String content;
//        private String category;
//        private Date resumeStrDate;
//        private Date resumeEndDate;
//        private ResumePass pass;
//        private ResumeDelete mapDelete;
//    }
}