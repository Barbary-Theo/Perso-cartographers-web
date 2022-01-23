package cartographers.game.Model.Cards;

import java.io.File;
import java.io.Serializable;

public abstract class Card implements Serializable {
    protected String image;

    public Card(String image) {
        this.image = image;
    }

    public String getImage(){
        return this.image;
    }
}