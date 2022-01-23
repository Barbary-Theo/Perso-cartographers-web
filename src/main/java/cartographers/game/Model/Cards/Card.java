package cartographers.game.Model.Cards;

import java.io.File;
import java.io.Serializable;

public abstract class Card implements Serializable {
    protected File image;

    public Card(File image) {
        this.image = image;
    }

    public File getImage(){
        return this.image;
    }
}