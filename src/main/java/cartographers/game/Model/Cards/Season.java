package cartographers.game.Model.Cards;

import java.io.File;
import java.util.ArrayList;

public class Season extends Card {
    protected int numSaison;
    protected ArrayList<Decret> decrets;
    protected int dureeSaison;

    public Season(File image, int dureeSaison, int numSaison) {
        super(image);
        this.numSaison = numSaison;
        this.decrets = new ArrayList<>();
        this.dureeSaison = dureeSaison;
    }

    public ArrayList<Decret> getDecrets() {
        return decrets;
    }

    public int getDureeSaison() {
        return dureeSaison;
    }

    public int getNumSaison() {
        return numSaison;
    }

}
