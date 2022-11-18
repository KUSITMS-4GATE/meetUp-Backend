package meetUpBackend.groad.controller;

import meetUpBackend.groad.service.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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


}
