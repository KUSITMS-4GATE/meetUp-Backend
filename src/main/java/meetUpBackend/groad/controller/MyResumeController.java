package meetUpBackend.groad.controller;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import meetUpBackend.groad.domain.Member;
import meetUpBackend.groad.domain.Resume;
import meetUpBackend.groad.domain.ResumeDelete;
import meetUpBackend.groad.domain.ResumePass;
import meetUpBackend.groad.service.MyResumeService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api")
public class MyResumeController {

    private final MyResumeService myResumeService;

    @GetMapping("/{user_id}/myresume")
    public List<Resume> GetMyResume(@PathVariable("user_id") String userId) {
        List<Resume> resumeAll = myResumeService.findAll(userId);

        return resumeAll;
    }

    @PostMapping("/{user_id}/myresume/write") // 무결성 에러 + event table에 row 만들어야 함 -> 해결
    public Resume saveResume(@PathVariable("user_id") String userId, @RequestBody @Validated resumeRequest request) {
        Resume resume = new Resume();
        Member member = myResumeService.getMember(userId);

        resume.setMember(member);
        resume.setTitle(request.getTitle());
        resume.setType(request.getType());
        resume.setContent(request.getContent());
        resume.setCategory(request.getCategory());
        resume.setResumeStrDate(request.getResumeStrDate());
        resume.setResumeEndDate(request.getResumeEndDate());
        resume.setPass(request.getPass());
        resume.setResumeDelete(ResumeDelete.NO);

        //System.out.println(resume);

        myResumeService.join(resume);

        return resume;
    }

    @GetMapping("/{user_id}/myresume/update/{resume_id}")
    public Resume updateResumePage(@PathVariable("user_id") String userId, @PathVariable("resume_id") Long resumeId){
        Resume getResumeId = myResumeService.selectOne(userId, resumeId);

        return getResumeId;
    }

    @PutMapping("/{user_id}/myresume/update/{resume_id}") // resumeId, member, regDate, updDate : NULL로 처리되고 있음 -> 다른 거 return 중이였음
    public Resume updateResume(@PathVariable("user_id") String userId, @RequestBody resumeRequest request, @PathVariable("resume_id") Long resumeId) {
        Resume resume = new Resume();

        resume.setTitle(request.getTitle());
        resume.setType(request.getType());
        resume.setContent(request.getContent());
        resume.setCategory(request.getCategory());
        resume.setResumeStrDate(request.getResumeStrDate());
        resume.setResumeEndDate(request.getResumeEndDate());
        resume.setPass(request.getPass());
        resume.setResumeDelete(ResumeDelete.NO);


        myResumeService.updateById(resume, userId, resumeId);

        return resume;
    }

    @PutMapping("/{user_id}/myresume/delete/{resume_id}")
    public int deleteResume(@PathVariable("user_id") String userId, @PathVariable("resume_id") Long resumeId){

        int deleteResume = myResumeService.deleteOne(userId, resumeId);

        return deleteResume;
    }

    @PutMapping("/{user_id}/myresume/recommend") //my page 완성 후 한 번 더 check 필요
    public int recommendResume(@PathVariable("user_id") String userId){

        int recommendResume = myResumeService.recommendOne(userId);

        return recommendResume;
    }

    @PutMapping("/{user_id}/myresume/report") //my page 완성 후 한 번 더 check 필요
    public int reportResume(@PathVariable("user_id") String userId){

        int reportResume = myResumeService.reportOne(userId);

        return reportResume;
    }

    @PutMapping("/{user_id}/myresume/scrap") //my page 완성 후 한 번 더 check 필요
    public int scrapResume(@PathVariable("user_id") String userId){

        int scrapResume = myResumeService.scrapOne(userId);

        return scrapResume;
    }

    @Data
    static class resumeRequest {
        private String title;
        private Integer type;
        private String content;
        private String category;
        private Date resumeStrDate;
        private Date resumeEndDate;
        private ResumePass pass;
        private ResumeDelete mapDelete;
    }

    @Data
    static class userIdResumeIdReq {
        private String userId;
        private Long resumeId;
    }
}