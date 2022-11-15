package meetUpBackend.groad.controller;

import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import meetUpBackend.groad.domain.ActSemester;
import meetUpBackend.groad.domain.ActivityUse;
import meetUpBackend.groad.domain.Roadmap;
import meetUpBackend.groad.domain.RoadmapUse;
import meetUpBackend.groad.domain.User;
import meetUpBackend.groad.domain.roadmapState;
import meetUpBackend.groad.service.roadMapService;
import meetUpBackend.groad.service.userService;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class roadMapController {

    private final roadMapService roadMapService;
    private final userService userService;

    @GetMapping("/roadMap")
    public String selectRoadMap(Roadmap roadmap, Model model) {
        List<Roadmap> roadmapAll = roadMapService.findAll();

        model.addAttribute("roadmapAll", roadmapAll);
        return roadmapAll.toString();
    }

    @PostMapping("/roadMap/actSemester")
    public void saveActSemester(@RequestBody @Validated ActSemesterReq actSemesterReq){
        ActSemester actSemester = new ActSemester();
        User userId = userService.getUserId(actSemesterReq.getUserId());
        actSemester.setMyPageId(userId);
        actSemester.setSemester(actSemesterReq.getSemester());
        actSemester.setYear(actSemesterReq.getYear());
        roadMapService.saveActSemester(actSemester);
    }

    @PutMapping("/roadMap/actSemester/update{post_id}")
    public void updateActSemester(@RequestBody @Validated ActSemesterReq actSemesterReq, @PathVariable("post_id") Long actSemesterId){
        ActSemester actSemester = new ActSemester();
        actSemester.setSemester(actSemesterReq.getSemester());
        actSemester.setYear(actSemesterReq.getYear());
        roadMapService.updateActSemester(actSemester, actSemesterId);
    }

//    @PutMapping("/roadMap/delete/{post_id}")
//    public int deleteRoadMap(@PathVariable("post_id") Long actSemesterId){
//        int deleteActSemester = roadMapService.deleteActSemester(actSemesterId);
//
//        return deleteActSemester;
//    }

    @PostMapping("/roadMap/{post_id}/save")
    public void saveRoadMap(@PathVariable("post_id") Long actSemesterId, @RequestBody @Validated MapRequest request) {
        Roadmap roadmap = new Roadmap();

        ActSemester keyId = roadMapService.getActSemester(actSemesterId);
        roadmap.setActSemesterId(keyId);
        roadmap.setTitle(request.getTitle());
        roadmap.setCategory(request.getCategory());
        roadmap.setContent(request.getContent());
        roadmap.setState(request.getState());
        roadmap.setGrade(request.getGrade());
        roadmap.setRoadmapStrDate(request.getRoadmapStrDate());
        roadmap.setRoadmapEndDate(request.getRoadmapEndDate());
        roadmap.setActDelete(ActivityUse.NO);
        roadmap.setMapDelete(RoadmapUse.NO);
        roadMapService.saveRoadMap(roadmap);
    }

    @PutMapping("/roadMap/update/{keyId}")
    public void updateRoadMap(@PathVariable("keyId") Long roadMapId, @RequestBody @Validated MapRequest request){
        Roadmap roadmap = new Roadmap();

        Long mapId = roadMapService.getRoadMap(roadMapId).getRoadmapId();

        roadmap.setTitle(request.getTitle());
        roadmap.setCategory(request.getCategory());
        roadmap.setContent(request.getContent());
        roadmap.setState(request.getState());
        roadmap.setGrade(request.getGrade());
        roadmap.setRoadmapStrDate(request.getRoadmapStrDate());
        roadmap.setRoadmapEndDate(request.getRoadmapEndDate());
        roadmap.setActDelete(ActivityUse.NO);
        roadmap.setMapDelete(RoadmapUse.NO);
        roadMapService.updateRoadMap(roadmap, mapId);
    }

    @PutMapping("/roadMap/delete/{keyId}")
    public int deleteRoadMap(@PathVariable("keyId") Long roadMapId){
        int deleteRoadMap = roadMapService.deleteRoadMap(roadMapId);

        return deleteRoadMap;
    }

    @GetMapping("/roadMap/actSemester/{post_id}")
    public String selectSettingRoadMap(@PathVariable("post_id") Long actSemesterId) {
        ActSemester roadMapSetting = roadMapService.getActSemester(actSemesterId);

        return roadMapSetting.toString();
    }

    @GetMapping(value = {"/roadMap/detail/{keyId}"})
    public String selectRoadMapDetail(@PathVariable("keyId") Long roadMapId, Model model){
        Roadmap mapId = roadMapService.getRoadMap(roadMapId);

        model.addAttribute("mapId", mapId);
        return mapId.toString();

    }
    @Data
    static class ActSemesterReq{
        private String userId;
        private Integer semester;
        private Integer year;
    }

    @Data
    static class MapRequest {
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
