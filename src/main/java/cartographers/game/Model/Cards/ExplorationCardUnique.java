package cartographers.game.Model.Cards;

import cartographers.game.Model.Map.Map;

import java.io.File;
import java.util.ArrayList;

public class ExplorationCardUnique extends ExplorationCard {
    protected ArrayList<Map> ListMap;
    protected String type;


    public ExplorationCardUnique(File image, int duree, String t) {
        super(image,duree);
        type=t;
        this.ListMap = new ArrayList<>();
    }

    public ArrayList<Map> getListMap(){
        return ListMap;
    }


    public void setListMap(Map m1, Map m2) {
         this.ListMap.add(m1);this.ListMap.add(m2);

    }

    public String getType(){ return this.type; }
}
