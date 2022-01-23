package cartographers.game.Model.Cards;


import java.io.File;
import java.util.ArrayList;

public class ExplorationCardChoice extends ExplorationCard {
    private ArrayList<String> ListChoix;

    public ExplorationCardChoice(String image, int duree){
        super(image,duree);
        this.ListChoix = new ArrayList<>();
    }

    public ArrayList<String> getListChoix() {
        return ListChoix;
    }

}