package cartographers.game.Controller;


import cartographers.game.DTO.PlayersDTO;
import cartographers.game.Model.Game;
import cartographers.game.Model.Player;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String getMappingPage(Model model){
        return "index";
    }

    @PostMapping( "/initMultiMode")
    public ResponseEntity initMultiMode(@RequestBody PlayersDTO playersdto){
        Game.getInstance(playersdto.getPlayers());
        return ResponseEntity.ok(playersdto);
    }

}
