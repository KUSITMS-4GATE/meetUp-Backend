package meetUpBackend.gload.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import meetUpBackend.gload.domain.Review;
import meetUpBackend.gload.domain.Roadmap;
import meetUpBackend.gload.service.roadMapService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class roadMapController {

    private final roadMapService roadMapService;

    @GetMapping("/roadMap")
    public String selectRoadMap(Roadmap roadmap) {
        List<Roadmap> roadmapAll = roadMapService.findAll();

        return roadmapAll.toString();
    }

    @GetMapping("/roadMap/{post_id}")
    public String selectSettingRoadMap(@PathVariable("post_id") Long actSemesterId) {
        Roadmap roadMapSetting = roadMapService.selectOne(actSemesterId);

        return roadMapSetting.toString();
    }

}
