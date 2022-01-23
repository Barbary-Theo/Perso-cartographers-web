package cartographers.game.Controller;


import cartographers.game.Model.Game;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/game")
public class MainController {

    @GetMapping
    public String getMappingPage(Model model){
        model.addAttribute("game", Game.getInstance());
        return "main";
    }

}
