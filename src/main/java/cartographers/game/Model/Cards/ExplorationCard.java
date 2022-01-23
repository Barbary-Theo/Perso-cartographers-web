package cartographers.game.Model.Cards;
import cartographers.game.Model.Map.Map;

import java.io.File;

public abstract class ExplorationCard extends GameCard {

    protected Map m;

    public ExplorationCard(String image, int duree) {
        super(image);
        this.duree = duree;
    }

    public int getDuree() {
        return duree;
    }

    @Override
    public void setM(Map m) {
        this.m = m;
    }

    public Map getM() {
        return m;
    }
}