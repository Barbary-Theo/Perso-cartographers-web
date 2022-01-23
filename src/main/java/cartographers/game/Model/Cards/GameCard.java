package cartographers.game.Model.Cards;

import cartographers.game.Model.Map.Map;

import java.io.File;

public abstract class GameCard extends Card {
    protected Map m;
    protected int duree;

    public GameCard(File image) {
        super(image);
        this.m = null;
    }

    public void setM(Map m) {
        this.m = m;
    }

    public Map getM(){
        return this.m;
    }

    public int getDuree(){
        return this.duree;
    }

}