package cartographers.game.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/game")
public class MainController {

    @GetMapping
    public String getMappingPage(Model model){
        return "main";
    }

}
