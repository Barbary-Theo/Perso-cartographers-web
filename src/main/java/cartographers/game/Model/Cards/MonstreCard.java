package cartographers.game.Model.Cards;


import java.io.File;

public class MonstreCard extends GameCard {
    protected boolean type_rotation;
    /*
    Le num correspond au pictogramme en haut à droite de la carte :
        1 -> haut à gauche
        2 -> haut à droite
        3 -> bas gauche
        4 -> bas droite
     */
    protected int num;

    @Override
    public int getDuree() {
        return 0;
    }

    public MonstreCard(File image, boolean type_rotation, int num) {
        super(image);
        this.type_rotation = type_rotation;
        this.num = num;
    }

    public boolean isType_rotation() {
        return type_rotation;
    }

    public int getNum(){ return this.num; }
}