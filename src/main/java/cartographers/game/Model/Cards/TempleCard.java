package cartographers.game.Model.Cards;

import java.io.File;

public class TempleCard extends GameCard {
    public TempleCard(String image) {
        super(image);
        super.duree=0;
    }

    @Override
    public int getDuree() {
        return 0;
    }

}