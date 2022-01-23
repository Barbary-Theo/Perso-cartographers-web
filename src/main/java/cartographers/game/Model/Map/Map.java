package cartographers.game.Model.Map;

import java.util.ArrayList;
import java.util.Collections;

public class Map {

    private int nbRow;
    private int nbColumn;
    private Case[][] map;

    public Map(int li, int co ){
        this.nbRow = li;
        this.nbColumn = co;

        this.map = new Case[li][co];
        for(int i=0 ; i<nbRow ; i++) {
            for (int j=0 ; j<nbColumn ; j++) {
                map[i][j] = new Case(i,j);
            }
        }
    }

    public static Map initMap(){

        Map map = new Map(11,11);

        map.changerCase(1,3,"mountain");
        map.changerCase(3,8,"mountain");
        map.changerCase(8,2,"mountain");
        map.changerCase(5,5,"mountain");
        map.changerCase(9,7,"mountain");

        map.changerCase(1,5,"temple");
        map.changerCase(2,1,"temple");
        map.changerCase(2,9,"temple");
        map.changerCase(8,9,"temple");
        map.changerCase(8,1,"temple");
        map.changerCase(9,5,"temple");

        return map;

    }


    public void changerCase(int x, int y, String newType) {
        map[x][y].setType(newType);
    }


    public void rotateCarte() {

        Case[][] matt = new Case[this.getNbColumn()][this.getNbRow()];
        Case[] row;

        var lignee = new ArrayList<Case>();
        var column = new ArrayList<ArrayList<Case>>();

        for (int k=0 ; k< this.getNbColumn() ;k++){
            lignee = new ArrayList<>();
            for (int i=0 ; i< this.getNbRow() ; i++){
                lignee.add(this.getMap()[i][k]);
            }
            column.add(lignee);
        }

        for(ArrayList<Case> ligneee : column){
            Collections.reverse(ligneee);
        }

        for(int i=0 ; i<column.size() ; i++){
            row = new Case[this.getNbRow()];
            for(int j=0 ; j<column.get(i).size() ; j++){
                row[j] = column.get(i).get(j);
            }
            matt[i] = row;

        }

        this.nbRow = matt.length;
        this.nbColumn = matt[0].length ;
        map = matt;

    }

    public void reverseCarte(){
        var M = this;

        Map nouveau = new Map(M.getNbRow(),M.getNbColumn());

        for(int i=0 ; i<M.getNbRow() ; i++){
            for(int j=0 ; j<M.getNbColumn() ; j++){

                nouveau.changerCase(i, M.getNbColumn()-1-j,M.getMap()[i][j].getType());

            }
        }

        this.map = nouveau.getMap();
    }
    
    public int getNbRow() {
        return nbRow;
    }

    public void setNbRow(int nbRow) {
        this.nbRow = nbRow;
    }

    public int getNbColumn() {
        return nbColumn;
    }

    public void setNbColumn(int nbColumn) {
        this.nbColumn = nbColumn;
    }

    public Case[][] getMap() {
        return map;
    }

    public void setMap(Case[][] map) {
        this.map = map;
    }
}
