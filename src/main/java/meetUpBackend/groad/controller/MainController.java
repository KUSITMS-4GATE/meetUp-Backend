package meetUpBackend.groad.controller;

import meetUpBackend.groad.service.MainService;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {
    private final MainService mainService;

    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/")
    public String showMainPage() {
        return mainService.findHotList();
    }

    @GetMapping("/search/{category}")
    public String showSearchResults(@RequestParam(value = "searchword", required = false, defaultValue = "") String searchWord,
                                    @PathVariable("category") String category) {
        return mainService.search(category, searchWord);
    }


}
