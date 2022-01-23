package cartographers.game.Model.Cards;

import java.io.File;

public class TempleCard extends GameCard {
    public TempleCard(File image) {
        super(image);
        super.duree=0;
    }

    @Override
    public int getDuree() {
        return 0;
    }

}