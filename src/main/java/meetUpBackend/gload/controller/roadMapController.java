package meetUpBackend.gload.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import meetUpBackend.gload.domain.Roadmap;
import meetUpBackend.gload.service.roadMapService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class roadMapController {

    private final roadMapService roadMapService;

    @PostMapping("/roadMap/save")
    public void saveRoadMap(@RequestBody @Validated MapRequest request) {

        Roadmap roadmap = new Roadmap();
        roadmap.setTitle(request.getTitle());
        roadmap.setContent(request.getContent());
        roadMapService.join(roadmap);
    }

    @Data
    static class CreateRoadMap {
        private Long id;
    }

    @Data
    static class MapRequest {
        private String title ;
        private String content ;
    }

}
