package meetUpBackend.groad.controller;

import meetUpBackend.groad.service.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
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
    public String showSearchResults(@RequestParam(value = "search_word", required = false, defaultValue = "") String searchWord,
                                    @PathVariable String category) {
        return mainService.search(category, searchWord);
    }


}
