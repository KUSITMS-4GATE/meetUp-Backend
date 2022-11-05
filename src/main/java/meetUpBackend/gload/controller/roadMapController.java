package meetUpBackend.gload.controller;

import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import meetUpBackend.gload.domain.ActSemester;
import meetUpBackend.gload.domain.ActivityUse;
import meetUpBackend.gload.domain.Roadmap;
import meetUpBackend.gload.domain.RoadmapUse;
import meetUpBackend.gload.domain.roadmapState;
import meetUpBackend.gload.service.roadMapService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class roadMapController {

    private final roadMapService roadMapService;

    @GetMapping("/roadMap")
    public String selectRoadMap(Roadmap roadmap) {
        List<Roadmap> roadmapAll = roadMapService.findAll();

        return roadmapAll.toString();
    }

    @PostMapping("/roadMap/actSemester")
    public void saveActSemester(@RequestBody @Validated ActSemesterReq actSemesterReq){
        ActSemester actSemester = new ActSemester();
        actSemester.setSemester(actSemesterReq.getSemester());
        actSemester.setYear(actSemesterReq.getYear());
        roadMapService.saveActSemester(actSemester);
    }

    @PostMapping("/roadMap/{post_id}/save")
    public void saveRoadMap(@PathVariable("post_id") ActSemester actSemesterId, @RequestBody @Validated MapRequest request) {
        Roadmap roadmap = new Roadmap();

        roadmap.setActSemesterId(actSemesterId);
        roadmap.setTitle(request.getTitle());
        roadmap.setCategory(request.getCategory());
        roadmap.setContent(request.getContent());
        roadmap.setState(request.getState());
        roadmap.setGrade(request.getGrade());
        roadmap.setRoadmapStrDate(request.getRoadmapStrDate());
        roadmap.setRoadmapEndDate(request.getRoadmapStrDate());
        roadmap.setActDelete(ActivityUse.NO);
        roadmap.setMapDelete(RoadmapUse.NO);
        roadMapService.saveRoadMap(roadmap);
    }

    @GetMapping("/roadMap/{post_id}")
    public String selectSettingRoadMap(@PathVariable("post_id") Long actSemesterId) {
        Roadmap roadMapSetting = roadMapService.selectOne(actSemesterId);

        return roadMapSetting.toString();
    }

    @Data
    static class ActSemesterReq{
        private Integer semester;
        private Integer year;
    }

    @Data
    static class MapRequest {
        private ActSemester actSemesterId;
        private String title;
        private String category;
        private String content;
        private roadmapState state;
        private Integer grade;
        private Date roadmapStrDate;
        private Date roadmapEndDate;
        private ActivityUse actDelete;
        private RoadmapUse mapDelete;
    }

}
