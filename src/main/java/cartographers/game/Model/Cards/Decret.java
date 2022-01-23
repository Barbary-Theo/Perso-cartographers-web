package cartographers.game.Model.Cards;

import cartographers.game.Model.Map.Map;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class Decret extends Card {
    protected Map m;
    protected String description;

    public Decret(String image, String description) {super(image);this.description = description;}

    public Map getMap(){return this.m;}

    public String getDescription(){return this.description;}

    public void setMap(Map m1){this.m = m1;}

    /*
    A partir de là ca sera la vérification des points pour chacun des cartes Decrets
     */
    public int Verif_Point(Map map){

        int score = 0;
        if (super.image.equals("26Use.jpg")) {

            for (int i = 0; i < map.getNbRow(); i++) {
                for (int j = 0; j < map.getNbColumn(); j++) {
                    if (i == 0) {
                        if (map.getMap()[0][j].getType().equals("Bois")) score++;
                    } else if (i == map.getNbRow() - 1) {
                        if (map.getMap()[map.getNbRow() - 1][j].getType().equals("Bois")) score++;
                    } else if (j == 0) {
                        if (map.getMap()[i][0].getType().equals("Bois")) score++;
                    } else if (j == map.getNbColumn() - 1) {
                        if (map.getMap()[i][map.getNbColumn() - 1].getType().equals("Bois")) score++;
                    }
                }
            }
        }

        else if (super.image .equals("27Use.jpg")) {

            for (int i = 0; i < map.getNbRow(); i++) {
                for (int j = 0; j < map.getNbColumn(); j++) {

                    if(map.getMap()[i][j].getType().equals("Bois")){
                        score ++;
                    }
                }
            }

        }

        else if (super.image .equals("28Use.jpg")) {
            for (int i = 0; i < map.getNbRow(); i++) {
                for (int j = 0; j < map.getNbColumn(); j++) {

                    if( i!=0 && i!=map.getNbRow()-1 && j!=0 && j!=map.getNbColumn()-1) {
                        if (map.getMap()[i][j].getType().equals("Bois") && !map.getMap()[i - 1][j].getType().equals("Vide")
                                && !map.getMap()[i + 1][j].getType().equals("Vide") && !map.getMap()[i][j - 1].getType().equals("Vide")
                                && !map.getMap()[i][j + 1].getType().equals("Vide")) score++;
                    }
                    else if (i==0 && j==0){
                        if (map.getMap()[i][j].getType().equals("Bois") && !map.getMap()[i + 1][j].getType().equals("Vide")
                                && !map.getMap()[i][j + 1].getType().equals("Vide")) score++;
                    }
                    else if (i== map.getNbRow()-1 && j== map.getNbColumn()-1){
                        if (map.getMap()[i][j].getType().equals("Bois") && !map.getMap()[i - 1][j].getType().equals("Vide")
                                && !map.getMap()[i][j - 1].getType().equals("Vide")) score++;
                    }
                    else if (i==0 && j== map.getNbColumn()-1){
                        if (map.getMap()[i][j].getType().equals("Bois") && !map.getMap()[i + 1][j].getType().equals("Vide")
                                && !map.getMap()[i][j - 1].getType().equals("Vide")) score++;
                    }
                    else if (j==0 && i== map.getNbRow()-1){
                        if (map.getMap()[i][j].getType().equals("Bois") && !map.getMap()[i - 1][j].getType().equals("Vide")
                                && !map.getMap()[i][j + 1].getType().equals("Vide")) score++;
                    }
                    else if (j==0){
                        if (map.getMap()[i][j].getType().equals("Bois") && !map.getMap()[i - 1][j].getType().equals("Vide")
                                && !map.getMap()[i + 1][j].getType().equals("Vide") && !map.getMap()[i][j + 1].getType().equals("Vide")) score++;
                    }
                    else if (i==0){
                        if (map.getMap()[i][j].getType().equals("Bois") && !map.getMap()[i + 1][j].getType().equals("Vide")
                                && !map.getMap()[i][j - 1].getType().equals("Vide") && !map.getMap()[i][j + 1].getType().equals("Vide")) score++;
                    }
                    else if(j==map.getNbColumn()-1) {
                        if (map.getMap()[i][j].getType().equals("Bois") && !map.getMap()[i - 1][j].getType().equals("Vide")
                                && !map.getMap()[i + 1][j].getType().equals("Vide") && !map.getMap()[i][j - 1].getType().equals("Vide")) score++;
                    }
                    else if(i==map.getNbRow()-1) {
                        if (map.getMap()[i][j].getType().equals("Bois") && !map.getMap()[i - 1][j].getType().equals("Vide")
                                && !map.getMap()[i][j - 1].getType().equals("Vide") && !map.getMap()[i][j + 1].getType().equals("Vide")) score++;
                    }
                }
            }

        }

        else if (super.image .equals("30Use.jpg")){

            for (int i = 0; i < map.getNbRow(); i++) {
                for (int j = 0; j < map.getNbColumn(); j++) {

                    if(map.getMap()[i][j].getType().equals("Eau")){
                        if( i!=0 && i!=map.getNbRow()-1 && j!=0 && j!=map.getNbColumn()-1) {
                            if (map.getMap()[i - 1][j].getType().equals("Ferme") || map.getMap()[i + 1][j].getType().equals("Ferme")
                                    || map.getMap()[i][j - 1].getType().equals("Ferme") || map.getMap()[i][j + 1].getType().equals("Ferme")) score++;
                        }
                        else if (i==0 && j==0){
                            if (map.getMap()[i + 1][j].getType().equals("Ferme") || map.getMap()[i][j + 1].getType().equals("Ferme")) score++;
                        }
                        else if (i== map.getNbRow()-1 && j== map.getNbColumn()-1){
                            if (map.getMap()[i - 1][j].getType().equals("Ferme")
                                    || map.getMap()[i][j - 1].getType().equals("Ferme")) score++;
                        }
                        else if (i==0 && j==map.getNbColumn()-1){
                            if (map.getMap()[i + 1][j].getType().equals("Ferme")
                                    || map.getMap()[i][j - 1].getType().equals("Ferme")) score++;
                        }
                        else if (j==0 && i==map.getNbRow()-1){
                            if (map.getMap()[i - 1][j].getType().equals("Ferme")
                                    || map.getMap()[i][j + 1].getType().equals("Ferme")) score++;
                        }
                        else if (i==0){
                            if (map.getMap()[i + 1][j].getType().equals("Ferme")
                                    || map.getMap()[i][j - 1].getType().equals("Ferme") || map.getMap()[i][j + 1].getType().equals("Ferme")) score++;
                        }
                        else if (j==0){
                            if (map.getMap()[i - 1][j].getType().equals("Ferme")
                                    || map.getMap()[i + 1][j].getType().equals("Ferme") || map.getMap()[i][j + 1].getType().equals("Ferme")) score++;
                        }
                        else if(j==map.getNbColumn()-1) {
                            if (map.getMap()[i - 1][j].getType().equals("Ferme")
                                    || map.getMap()[i + 1][j].getType().equals("Ferme") || map.getMap()[i][j - 1].getType().equals("Ferme")) score++;
                        }
                        else if(i==map.getNbRow()-1) {
                            if (map.getMap()[i - 1][j].getType().equals("Ferme")
                                    || map.getMap()[i][j - 1].getType().equals("Ferme") || map.getMap()[i][j + 1].getType().equals("Ferme")) score++;
                        }
                    }
                    else if (map.getMap()[i][j].getType().equals("Ferme")){
                        if( i!=0 && i!=map.getNbRow()-1 && j!=0 && j!=map.getNbColumn()-1) {
                            if (map.getMap()[i - 1][j].getType().equals("Eau") || map.getMap()[i + 1][j].getType().equals("Eau")
                                    || map.getMap()[i][j - 1].getType().equals("Eau") || map.getMap()[i][j + 1].getType().equals("Eau")) score++;
                        }

                        else if (i==0 && j==0){
                            if (map.getMap()[i + 1][j].getType().equals("Eau")
                                    || map.getMap()[i][j + 1].getType().equals("Eau")) score++;
                        }
                        else if (i== map.getNbRow()-1 && j== map.getNbColumn()-1){
                            if (map.getMap()[i - 1][j].getType().equals("Eau")
                                    || map.getMap()[i][j - 1].getType().equals("Eau")) score++;
                        }
                        else if (i==0 && j==map.getNbColumn()-1){
                            if (map.getMap()[i + 1][j].getType().equals("Eau")
                                    || map.getMap()[i][j - 1].getType().equals("Eau")) score++;
                        }
                        else if (j==0 && i==map.getNbRow()-1){
                            if (map.getMap()[i - 1][j].getType().equals("Eau")
                                    || map.getMap()[i][j + 1].getType().equals("Eau")) score++;
                        }
                        else if (j==0){
                            if (map.getMap()[i - 1][j].getType().equals("Eau")
                                    || map.getMap()[i + 1][j].getType().equals("Eau") || map.getMap()[i][j + 1].getType().equals("Eau")) score++;
                        }
                        else if (i==0){
                            if (map.getMap()[i + 1][j].getType().equals("Eau")
                                    || map.getMap()[i][j - 1].getType().equals("Eau") || map.getMap()[i][j + 1].getType().equals("Eau")) score++;
                        }
                        else if(j==map.getNbColumn()-1) {
                            if (map.getMap()[i - 1][j].getType().equals("Eau")
                                    || map.getMap()[i + 1][j].getType().equals("Eau") || map.getMap()[i][j - 1].getType().equals("Eau")) score++;
                        }
                        else if(i==map.getNbRow()-1) {
                            if (map.getMap()[i - 1][j].getType().equals("Eau")
                                    || map.getMap()[i][j - 1].getType().equals("Eau") || map.getMap()[i][j + 1].getType().equals("Eau")) score++;
                        }
                    }
                }
            }
        }

        else if (super.image .equals("31Use.jpg")){
            for (int i = 0; i < map.getNbRow(); i++) {
                for (int j = 0; j < map.getNbColumn(); j++) {

                    if(map.getMap()[i][j].getType().equals("Eau")){
                        if( i!=0 && i!=map.getNbRow()-1 && j!=0 && j!=map.getNbColumn()-1) {
                            if (map.getMap()[i - 1][j].getType().equals("Montagne") || map.getMap()[i + 1][j].getType().equals("Montagne")
                                    || map.getMap()[i][j - 1].getType().equals("Montagne") || map.getMap()[i][j + 1].getType().equals("Montagne")) score =score + 2;
                        }
                        else if (i==0 && j==0){
                            if (map.getMap()[i + 1][j].getType().equals("Montagne")
                                    || map.getMap()[i][j + 1].getType().equals("Montagne")) score =score + 2;
                        }
                        else if (i== map.getNbRow()-1 && j== map.getNbColumn()-1){
                            if (map.getMap()[i - 1][j].getType().equals("Montagne")
                                    || map.getMap()[i][j - 1].getType().equals("Montagne")) score =score + 2;
                        }
                        else if (i==0 && j==map.getNbColumn()-1){
                            if (map.getMap()[i + 1][j].getType().equals("Montagne")
                                    || map.getMap()[i][j - 1].getType().equals("Montagne")) score =score + 2;
                        }
                        else if (j==0 && i==map.getNbRow()-1){
                            if (map.getMap()[i - 1][j].getType().equals("Montagne")
                                    || map.getMap()[i][j + 1].getType().equals("Montagne")) score =score + 2;
                        }
                        else if (i==0){
                            if (map.getMap()[i + 1][j].getType().equals("Montagne")
                                    || map.getMap()[i][j - 1].getType().equals("Montagne") || map.getMap()[i][j + 1].getType().equals("Montagne")) score =score + 2;
                        }
                        else if (j==0){
                            if (map.getMap()[i - 1][j].getType().equals("Montagne")
                                    || map.getMap()[i + 1][j].getType().equals("Montagne") || map.getMap()[i][j + 1].getType().equals("Montagne")) score =score + 2;
                        }
                        else if(j==map.getNbColumn()-1) {
                            if (map.getMap()[i - 1][j].getType().equals("Montagne")
                                    || map.getMap()[i + 1][j].getType().equals("Montagne") || map.getMap()[i][j - 1].getType().equals("Montagne")) score =score + 2;
                        }
                        else if(i==map.getNbRow()-1) {
                            if (map.getMap()[i - 1][j].getType().equals("Montagne")
                                    || map.getMap()[i][j - 1].getType().equals("Montagne") || map.getMap()[i][j + 1].getType().equals("Montagne")) score =score + 2;
                        }
                    }
                    else if (map.getMap()[i][j].getType().equals("Ferme")){
                        if( i!=0 && i!=map.getNbRow()-1 && j!=0 && j!=map.getNbColumn()-1) {
                            if (map.getMap()[i - 1][j].getType().equals("Montagne") || map.getMap()[i + 1][j].getType().equals("Montagne")
                                    || map.getMap()[i][j - 1].getType().equals("Montagne") || map.getMap()[i][j + 1].getType().equals("Montagne")) score++;
                        }

                        else if (i==0 && j==0){
                            if (map.getMap()[i + 1][j].getType().equals("Montagne")
                                    || map.getMap()[i][j + 1].getType().equals("Montagne")) score++;
                        }
                        else if (i== map.getNbRow()-1 && j== map.getNbColumn()-1){
                            if (map.getMap()[i - 1][j].getType().equals("Montagne")
                                    || map.getMap()[i][j - 1].getType().equals("Montagne")) score++;
                        }
                        else if (i==0 && j==map.getNbColumn()-1){
                            if (map.getMap()[i + 1][j].getType().equals("Montagne")
                                    || map.getMap()[i][j - 1].getType().equals("Montagne")) score++;
                        }
                        else if (j==0 && i==map.getNbRow()-1){
                            if (map.getMap()[i - 1][j].getType().equals("Montagne")
                                    || map.getMap()[i][j + 1].getType().equals("Montagne")) score++;
                        }
                        else if (j==0){
                            if (map.getMap()[i - 1][j].getType().equals("Montagne")
                                    || map.getMap()[i + 1][j].getType().equals("Montagne") || map.getMap()[i][j + 1].getType().equals("Montagne")) score++;
                        }
                        else if (i==0){
                            if (map.getMap()[i + 1][j].getType().equals("Montagne")
                                    || map.getMap()[i][j - 1].getType().equals("Montagne") || map.getMap()[i][j + 1].getType().equals("Montagne")) score++;
                        }
                        else if(j==map.getNbColumn()-1) {
                            if (map.getMap()[i - 1][j].getType().equals("Montagne")
                                    || map.getMap()[i + 1][j].getType().equals("Montagne") || map.getMap()[i][j - 1].getType().equals("Montagne")) score++;
                        }
                        else if(i==map.getNbRow()-1) {
                            if (map.getMap()[i - 1][j].getType().equals("Montagne")
                                    || map.getMap()[i][j - 1].getType().equals("Montagne") || map.getMap()[i][j + 1].getType().equals("Montagne")) score++;
                        }
                    }
                }
            }
        }

        else if (super.image .equals("32Use.jpg")){
            for (int i = 0; i < map.getNbRow(); i++) {
                for (int j = 0; j < map.getNbColumn(); j++) {

                    if(map.getMap()[i][j].getType().equals("Eau")){
                        if( i!=0 && i!=map.getNbRow()-1 && j!=0 && j!=map.getNbColumn()-1) {
                            if (map.getMap()[i - 1][j].getType().equals("Temple") || map.getMap()[i + 1][j].getType().equals("Temple")
                                    || map.getMap()[i][j - 1].getType().equals("Temple") || map.getMap()[i][j + 1].getType().equals("Temple")) score =score + 2;
                            else if((i-1==1 && j==5) || (i-1==2 && j==1) || (i-1==2 && j==9) || (i-1==8 && j==9) || (i-1==8 && j==1) || (i-1==9 && j==5)){
                                score++;
                            }
                            else if((i==1 && j+1==5) || (i==2 && j+1==1) || (i==2 && j+1==9) || (i==8 && j+1==9) || (i==8 && j+1==1) || (i==9 && j+1==5)){
                                score++;
                            }
                            else if((i+1==1 && j==5) || (i+1==2 && j==1) || (i+1==2 && j==9) || (i+1==8 && j==9) || (i+1==8 && j==1) || (i+1==9 && j==5)){
                                score++;
                            }
                            else if((i==1 && j-1==5) || (i==2 && j-1==1) || (i==2 && j-1==9) || (i==8 && j-1==9) || (i==8 && j-1==1) || (i==9 && j-1==5)){
                                score++;
                            }
                        }
                        else if (i==0 && j==0){
                            if (map.getMap()[i + 1][j].getType().equals("Temple")
                                    || map.getMap()[i][j + 1].getType().equals("Temple")) score++;
                            else if((i+1==1 && j==5) || (i+1==2 && j==1) || (i+1==2 && j==9) || (i+1==8 && j==9) || (i+1==8 && j==1) || (i+1==9 && j==5)){
                                score++;
                            }
                            else if((i==1 && j+1==5) || (i==2 && j+1==1) || (i==2 && j+1==9) || (i==8 && j+1==9) || (i==8 && j+1==1) || (i==9 && j+1==5)){
                                score++;
                            }
                        }
                        else if (i== map.getNbRow()-1 && j== map.getNbColumn()-1){
                            if (map.getMap()[i - 1][j].getType().equals("Temple")
                                    || map.getMap()[i][j - 1].getType().equals("Temple")) score++;
                            else if((i-1==1 && j==5) || (i-1==2 && j==1) || (i-1==2 && j==9) || (i-1==8 && j==9) || (i-1==8 && j==1) || (i-1==9 && j==5)){
                                score++;
                            }
                            else if((i==1 && j-1==5) || (i==2 && j-1==1) || (i==2 && j-1==9) || (i==8 && j-1==9) || (i==8 && j-1==1) || (i==9 && j-1==5)){
                                score++;
                            }
                        }
                        else if (i==0 && j==map.getNbColumn()-1){
                            if (map.getMap()[i + 1][j].getType().equals("Temple")
                                    || map.getMap()[i][j - 1].getType().equals("Temple")) score++;
                            else if((i+1==1 && j==5) || (i+1==2 && j==1) || (i+1==2 && j==9) || (i+1==8 && j==9) || (i+1==8 && j==1) || (i+1==9 && j==5)){
                                score++;
                            }
                            else if((i==1 && j-1==5) || (i==2 && j-1==1) || (i==2 && j-1==9) || (i==8 && j-1==9) || (i==8 && j-1==1) || (i==9 && j-1==5)){
                                score++;
                            }
                        }
                        else if (j==0 && i==map.getNbRow()-1){
                            if (map.getMap()[i - 1][j].getType().equals("Temple")
                                    || map.getMap()[i][j + 1].getType().equals("Temple")) score++;
                            else if((i-1==1 && j==5) || (i-1==2 && j==1) || (i-1==2 && j==9) || (i-1==8 && j==9) || (i-1==8 && j==1) || (i-1==9 && j==5)){
                                score++;
                            }
                            else if((i==1 && j+1==5) || (i==2 && j+1==1) || (i==2 && j+1==9) || (i==8 && j+1==9) || (i==8 && j+1==1) || (i==9 && j+1==5)){
                                score++;
                            }
                        }
                        else if (i==0){
                            if (map.getMap()[i + 1][j].getType().equals("Temple")
                                    || map.getMap()[i][j - 1].getType().equals("Temple") || map.getMap()[i][j + 1].getType().equals("Temple")) score++;
                            else if((i+1==1 && j==5) || (i+1==2 && j==1) || (i+1==2 && j==9) || (i+1==8 && j==9) || (i+1==8 && j==1) || (i+1==9 && j==5)){
                                score++;
                            }
                            else if((i==1 && j-1==5) || (i==2 && j-1==1) || (i==2 && j-1==9) || (i==8 && j-1==9) || (i==8 && j-1==1) || (i==9 && j-1==5)){
                                score++;
                            }
                            else if((i==1 && j+1==5) || (i==2 && j+1==1) || (i==2 && j+1==9) || (i==8 && j+1==9) || (i==8 && j+1==1) || (i==9 && j+1==5)){
                                score++;
                            }
                        }
                        else if (j==0){
                            if (map.getMap()[i - 1][j].getType().equals("Temple")
                                    || map.getMap()[i + 1][j].getType().equals("Temple") || map.getMap()[i][j + 1].getType().equals("Temple")) score++;
                            else if((i-1==1 && j==5) || (i-1==2 && j==1) || (i-1==2 && j==9) || (i-1==8 && j==9) || (i-1==8 && j==1) || (i-1==9 && j==5)){
                                score++;
                            }
                            else if((i+1==1 && j==5) || (i+1==2 && j==1) || (i+1==2 && j==9) || (i+1==8 && j==9) || (i+1==8 && j==1) || (i+1==9 && j==5)){
                                score++;
                            }
                            else if((i==1 && j+1==5) || (i==2 && j+1==1) || (i==2 && j+1==9) || (i==8 && j+1==9) || (i==8 && j+1==1) || (i==9 && j+1==5)){
                                score++;
                            }
                        }
                        else if(j==map.getNbColumn()-1) {
                            if (map.getMap()[i - 1][j].getType().equals("Temple")
                                    || map.getMap()[i + 1][j].getType().equals("Temple") || map.getMap()[i][j - 1].getType().equals("Temple")) score++;
                            else if((i-1==1 && j==5) || (i-1==2 && j==1) || (i-1==2 && j==9) || (i-1==8 && j==9) || (i-1==8 && j==1) || (i-1==9 && j==5)){
                                score++;
                            }
                            else if((i+1==1 && j==5) || (i+1==2 && j==1) || (i+1==2 && j==9) || (i+1==8 && j==9) || (i+1==8 && j==1) || (i+1==9 && j==5)){
                                score++;
                            }
                            else if((i==1 && j-1==5) || (i==2 && j-1==1) || (i==2 && j-1==9) || (i==8 && j-1==9) || (i==8 && j-1==1) || (i==9 && j-1==5)){
                                score++;
                            }
                        }
                        else if(i==map.getNbRow()-1) {
                            if (map.getMap()[i - 1][j].getType().equals("Temple")
                                    || map.getMap()[i][j - 1].getType().equals("Temple") || map.getMap()[i][j + 1].getType().equals("Temple")) score++;
                            else if((i-1==1 && j==5) || (i-1==2 && j==1) || (i-1==2 && j==9) || (i-1==8 && j==9) || (i-1==8 && j==1) || (i-1==9 && j==5)){
                                score++;
                            }
                            else if((i==1 && j-1==5) || (i==2 && j-1==1) || (i==2 && j-1==9) || (i==8 && j-1==9) || (i==8 && j-1==1) || (i==9 && j-1==5)){
                                score++;
                            }
                            else if((i==1 && j+1==5) || (i==2 && j+1==1) || (i==2 && j+1==9) || (i==8 && j+1==9) || (i==8 && j+1==1) || (i==9 && j+1==5)){
                                score++;
                            }
                        }
                    }
                    else if (map.getMap()[i][j].getType().equals("Ferme")){
                        if( (i==1 && j==5) || (i==2 && j==1) || (i==2 && j==9) || (i==8 && j==9) || (i==8 && j==1) || (i==9 && j==5) ){
                            score = score + 3;
                        }
                    }
                }
            }
        }

        /*
        else if (super.image =="33.png"){
            for (int i = 0; i < map.getNbRow(); i++) {
                for (int j = 0; j < map.getNbColumn(); j++) {

                    if(map.getMap()[i][j].getType()=="Eau"){
                        if( i!=0 && i!=map.getNbRow()-1 && j!=0 && j!=map.getNbColumn()-1) {
                            if (map.getMap()[i + 1][j].getType() == "Eau" || map.getMap()[i][j + 1].getType() == "Eau") score = score + 3;
                        }
                        else if (i==0 && j==0){
                            if (map.getMap()[i + 1][j].getType() == "Eau" || map.getMap()[i][j + 1].getType() == "Eau") score = score + 3;
                        }
                        else if (i== map.getNbRow()-1 && j== map.getNbColumn()-1){
                            //Rien faire
                        }
                        else if (i==0 && j==map.getNbColumn()-1){
                            if ( map.getMap()[i + 1][j].getType() == "Eau" ) score = score + 3;
                        }
                        else if (j==0 && i==map.getNbRow()-1){
                            if ( map.getMap()[i][j + 1].getType() == "Eau") score = score + 3;
                        }
                        else if (i==0){
                            if ( map.getMap()[i + 1][j].getType() == "Eau" || map.getMap()[i][j + 1].getType() == "Eau") score = score + 3;
                        }
                        else if (j==0){
                            if (  map.getMap()[i + 1][j].getType() == "Eau" || map.getMap()[i][j + 1].getType() == "Eau") score = score + 3;
                        }
                        else if(j==map.getNbColumn()-1) {
                            if ( map.getMap()[i + 1][j].getType() == "Eau" ) score = score + 3;
                        }
                        else if(i==map.getNbRow()-1) {
                            if ( map.getMap()[i][j + 1].getType() == "Eau") score = score + 3;
                        }
                    }
                    else if (map.getMap()[i][j].getType()=="Ferme"){
                        if( i!=0 && i!=map.getNbRow()-1 && j!=0 && j!=map.getNbColumn()-1) {
                            if ( map.getMap()[i + 1][j].getType() == "Ferme" || map.getMap()[i][j + 1].getType() == "Ferme") score = score + 3;
                        }

                        else if (i==0 && j==0){
                            if (map.getMap()[i + 1][j].getType() == "Ferme" || map.getMap()[i][j + 1].getType() == "Ferme") score = score + 3;
                        }
                        else if (i== map.getNbRow()-1 && j== map.getNbColumn()-1){
                            //Rien faire
                        }
                        else if (i==0 && j==map.getNbColumn()-1){
                            if ( map.getMap()[i + 1][j].getType() == "Ferme" ) score = score + 3;
                        }
                        else if (j==0 && i==map.getNbRow()-1){
                            if ( map.getMap()[i][j + 1].getType() == "Ferme") score = score + 3;
                        }
                        else if (j==0){
                            if ( map.getMap()[i + 1][j].getType() == "Ferme" || map.getMap()[i][j + 1].getType() == "Ferme") score = score + 3;
                        }
                        else if (i==0){
                            if ( map.getMap()[i + 1][j].getType() == "Ferme" || map.getMap()[i][j + 1].getType() == "Ferme") score = score + 3;
                        }
                        else if(j==map.getNbColumn()-1) {
                            if (map.getMap()[i + 1][j].getType() == "Ferme" ) score = score + 3;
                        }
                        else if(i==map.getNbRow()-1) {
                            if ( map.getMap()[i][j + 1].getType() == "Ferme") score = score + 3;
                        }
                    }
                }
            }
        }
        Pas terminé, il manque le check que ça ne soit pas sur un bord de map
        (prendre inspiration sur le premier decret),
        et vérifier que c'est bien vide autour du duo -> la 33
         */

        else if (super.image .equals("34Use.jpg")){
            ArrayList<Integer> liste = new ArrayList<>();
            int res = 0;
            for (int i=0 ; i< map.getNbRow() ; i++){
                for (int j=0 ; j< map.getNbColumn() ; j++){

                    if(map.getMap()[i][j].getType().equals("Maison") && !map.getMap()[i][j].isCheck()){
                        res = 0;
                        map.getMap()[i][j].setCheck(true);
                        res = maison(res, map, i , j)+1;
                        liste.add(res);
                    }

                }
            }
            for (int i = 0; i < map.getNbRow(); i++) {
                for (int j = 0; j < map.getNbColumn(); j++) {
                    if(!map.getMap()[i][j].getType().equals("Montagne")) map.getMap()[i][j].setCheck(false);
                }
            }
            for (Integer val : liste ){
                if(val>=6) score += 8;
            }
        }

        else if (super.image .equals("35Use.jpg")){

            ArrayList<Integer> quartier = new ArrayList<>();

            for (int i = 0; i < map.getNbRow(); i++) {
                for (int j = 0; j < map.getNbColumn(); j++) {

                    if (map.getMap()[i][j].getType().equals("Maison") && !map.getMap()[i][j].isCheck()){
                        map.getMap()[i][j].setCheck(true);
                        quartier.add(maison_35(0, map, i, j)+1);
                    }

                }
            }

            for (int i = 0; i < map.getNbRow(); i++) {
                for (int j = 0; j < map.getNbColumn(); j++) {
                    if(!map.getMap()[i][j].getType().equals("Montagne")) map.getMap()[i][j].setCheck(false);
                }
            }
            for (Integer val : quartier){
                if(score<val) score = val;
            }
        }

        else if (super.image .equals("36Use.jpg")){
            ArrayList<ArrayList<String>> liste = new ArrayList<>();

            for (int i = 0; i < map.getNbRow(); i++) {
                for (int j = 0; j < map.getNbColumn(); j++) {

                    if (map.getMap()[i][j].getType().equals("Maison") && !map.getMap()[i][j].isCheck()){
                        ArrayList<String> casee = new ArrayList<>();
                        map.getMap()[i][j].setCheck(true);
                        casee = maison_36(new ArrayList<>(),map,i,j);
                        liste.add(casee);
                    }

                }
            }
            for (int i = 0; i < map.getNbRow(); i++) {
                for (int j = 0; j < map.getNbColumn(); j++) {
                    if(!map.getMap()[i][j].getType().equals("Montagne")) map.getMap()[i][j].setCheck(false);
                }
            }

            for(ArrayList<String> s : liste){
                if(s.size()>=3) score += s.size();
            }
        }

        else if (super.image .equals("37Use.jpg")){
            ArrayList<Integer> quartier = new ArrayList<>();

            for (int i = 0; i < map.getNbRow(); i++) {
                for (int j = 0; j < map.getNbColumn(); j++) {

                    if (map.getMap()[i][j].getType().equals("Maison") && !map.getMap()[i][j].isCheck()){
                        map.getMap()[i][j].setCheck(true);
                        quartier.add(maison(0, map, i, j)+1);
                    }

                }
            }

            for (int i = 0; i < map.getNbRow(); i++) {
                for (int j = 0; j < map.getNbColumn(); j++) {
                    if(!map.getMap()[i][j].getType().equals("Montagne")) map.getMap()[i][j].setCheck(false);
                }
            }

            Collections.sort(quartier);

            if(quartier.size()>1) score = quartier.get(quartier.size()-2)*2;
        }

        else if (super.image .equals("38Use.jpg")){
            for (int i = 0; i < map.getNbRow(); i++) {
                int t = 0;
                for (int j = 0; j < map.getNbColumn(); j++) {
                    if(!map.getMap()[i][j].getType().equals("Vide")) {
                        t++;
                    }
                }
                if(t==map.getNbColumn()) {
                    score=score+6;
                }
            }
            for (int i = 0; i < map.getNbColumn(); i++) {
                int t = 0;
                for (int j = 0; j < map.getNbRow(); j++) {
                    if(!map.getMap()[i][j].getType().equals("Vide")) {
                        t++;
                    }
                }
                if(t==map.getNbRow()) {
                    score=score+6;
                }
            }
        }

        /* Pas fini, traîte pas les cas certains cas où il y a des trucs autour.
        else if (super.image =="39.png"){
            ArrayList<Integer> liste = new ArrayList<>();
            int score2 = 0;
            int m = 0;
            int k = 0;
            for(int i =0 ; i< map.getNbRow() ; i++){
                for (int j=0 ; j<map.getNbColumn() ; j++){

                    if(map.getMap()[i][j].getType()!="Vide" && map.getMap()[i][j].getType()!="Temple" && map.getMap()[i][j].getType()!="Montagne" && !map.getMap()[i][j].isCheck()){
                        score = 0;
                        map.getMap()[i][j].setCheck(true);
                        score = decret_39(score, map, i, j) +1;

                        while (k<score) {
                            if (map.getMap()[i + 1][j + k].getType() != "Vide" && map.getMap()[i + 1][j + k].getType() != "Temple" && map.getMap()[i + 1][j + k].getType() != "Montagne" && !map.getMap()[i + 1][j + k].isCheck()) {
                                map.getMap()[i+1][j+k].setCheck(true);
                                score2 = decret_39Bis(score2, map, i + 1, j + k) + 1;
                            }
                            k++;
                        }
                        if(score==score2/(score-1)){
                            liste.add(score);
                        }
                    }

                }
            }

            for(int i =0 ; i< map.getNbRow() ; i++) {
                for (int j = 0; j < map.getNbColumn(); j++) {
                    map.getMap()[i][j].setCheck(false);
                }
            }
            score=0;
            map.affichageMapType();
            Collections.sort(liste);
            for (Integer val : liste){
                if(score < val) score = val;
            }
            score *= 3;
            System.out.println("Score : "+ score);

        }
        */

        else if (super.image .equals("40Use.jpg")){
            for (int i = 0; i < map.getNbRow(); i++) {
                int j=0;
                int t=0;
                for(int k=0;k<map.getNbRow()-i;k++) {
                    if(!map.getMap()[i + k][j + k].getType().equals("Vide")) {
                        t++;
                    }
                }
                if(t==map.getNbRow()-i) {
                    score=score+3;
                }


            }
        }

        else if (super.image .equals("41Use.jpg")){
            for (int i = 0; i < map.getNbRow(); i++) {
                for (int j = 0; j < map.getNbColumn(); j++) {
                    if (map.getMap()[i][j].getType().equals("Vide")) {
                        if((i!=0)&&(j!=0)&&(j!=map.getNbColumn()-1)&&(i!=map.getNbRow()-1)) {
                            if((!map.getMap()[i + 1][j].getType().equals("Vide"))&&(!map.getMap()[i][j + 1].getType().equals("Vide"))&&(!map.getMap()[i - 1][j].getType().equals("Vide"))&&(!map.getMap()[i][j - 1].getType().equals("Vide"))) {
                                score++;
                            }
                        }
                        else if((i==0)&&(j==0)) {
                            if ((!map.getMap()[i + 1][j].getType().equals("Vide"))&&(!map.getMap()[i][j + 1].getType().equals("Vide"))) {
                                score++;
                            }
                        }
                        else if((i==map.getNbRow()-1)&&(j==map.getNbColumn()-1)) {
                            if ((!map.getMap()[i - 1][j].getType().equals("Vide"))&&(!map.getMap()[i][j - 1].getType().equals("Vide"))) {
                                score++;
                            }
                        }
                        else if((i==0) &&(j!=map.getNbColumn()-1)) {
                            if((!map.getMap()[i + 1][j].getType().equals("Vide"))&&(!map.getMap()[i][j - 1].getType().equals("Vide"))&&(!map.getMap()[i][j + 1].getType().equals("Vide"))) {
                                score++;
                            }
                        }
                        else if((i==0)&&(j==map.getNbColumn()-1)) {
                            if((!map.getMap()[i + 1][j].getType().equals("Vide"))&&(!map.getMap()[i][j - 1].getType().equals("Vide"))) {
                                score++;
                            }
                        }
                        else if((j==0)&&(i!=map.getNbRow()-1)) {
                            if((!map.getMap()[i + 1][j].getType().equals("Vide"))&&(!map.getMap()[i][j + 1].getType().equals("Vide"))&&(!map.getMap()[i - 1][j].getType().equals("Vide"))) {
                                score++;
                            }
                        }
                        else if((j==0)&&(i==map.getNbRow()-1)) {
                            if((!map.getMap()[i][j + 1].getType().equals("Vide"))&&(!map.getMap()[i - 1][j].getType().equals("Vide"))) {
                                score++;
                            }
                        }
                    }
                }
            }

        }

        return score;
    }

    /*
    Fonction pour le score du decret 37
     */
    public int maison(int res, Map map, int x, int y){


        if (x != 0 && x != map.getNbRow() - 1 && y != 0 && y != map.getNbColumn() - 1) {
            if(map.getMap()[x + 1][y].getType().equals("Maison") && !map.getMap()[x+1][y].isCheck()) {map.getMap()[x+1][y].setCheck(true);res = maison(res,map,x+1,y) +1 ; }
            if(map.getMap()[x][y + 1].getType().equals("Maison") && !map.getMap()[x][y+1].isCheck()) {map.getMap()[x][y+1].setCheck(true);res = maison(res,map,x,y+1) +1; }
            if(map.getMap()[x - 1][y].getType().equals("Maison") && !map.getMap()[x-1][y].isCheck()) {map.getMap()[x-1][y].setCheck(true);res = maison(res,map,x-1,y) +1 ; }
            if(map.getMap()[x][y - 1].getType().equals("Maison") && !map.getMap()[x][y-1].isCheck()) {map.getMap()[x][y-1].setCheck(true);res = maison(res,map,x,y-1) +1; }
        }
        else if (x == 0 && y == 0) {
            if(map.getMap()[x + 1][y].getType().equals("Maison") && !map.getMap()[x+1][y].isCheck()) {map.getMap()[x+1][y].setCheck(true);res = maison(res,map,x+1,y) +1 ; }
            if(map.getMap()[x][y + 1].getType().equals("Maison") && !map.getMap()[x][y+1].isCheck()) {map.getMap()[x][y+1].setCheck(true);res = maison(res,map,x,y+1) +1 ; }
        }
        else if (x == map.getNbRow() - 1 && y == map.getNbColumn() - 1) {
            if(map.getMap()[x - 1][y].getType().equals("Maison") && !map.getMap()[x-1][y].isCheck()) {map.getMap()[x-1][y].setCheck(true);res = maison(res,map,x-1,y) +1 ; }
            if(map.getMap()[x][y - 1].getType().equals("Maison") && !map.getMap()[x][y-1].isCheck()) {map.getMap()[x][y-1].setCheck(true);res = maison(res,map,x,y-1) +1; }
        }
        else if (x == 0 && y == map.getNbColumn() - 1) {
            if(map.getMap()[x + 1][y].getType().equals("Maison") && !map.getMap()[x+1][y].isCheck() ){ map.getMap()[x+1][y].setCheck(true);res = maison(res,map,x+1,y) +1 ; }
            if(map.getMap()[x][y - 1].getType().equals("Maison") && !map.getMap()[x][y-1].isCheck()) {map.getMap()[x][y-1].setCheck(true);res = maison(res,map,x,y-1) +1; }
        }
        else if (y == 0 && x == map.getNbRow() - 1) {
            if(map.getMap()[x][y + 1].getType().equals("Maison") && !map.getMap()[x][y+1].isCheck()){ map.getMap()[x][y+1].setCheck(true);res = maison(res,map,x,y+1) +1 ; }
            if(map.getMap()[x - 1][y].getType().equals("Maison") && !map.getMap()[x-1][y].isCheck()) {map.getMap()[x-1][y].setCheck(true);res = maison(res,map,x-1,y) +1 ; }
        }
        else if (x == 0) {
            if(map.getMap()[x + 1][y].getType().equals("Maison") && !map.getMap()[x+1][y].isCheck()) {map.getMap()[x+1][y].setCheck(true);res = maison(res,map,x+1,y) +1 ; }
            if(map.getMap()[x][y + 1].getType().equals("Maison") && !map.getMap()[x][y+1].isCheck()) {map.getMap()[x][y+1].setCheck(true);res = maison(res,map,x,y+1) +1 ; }
            if(map.getMap()[x][y - 1].getType().equals("Maison") && !map.getMap()[x][y-1].isCheck()) {map.getMap()[x][y-1].setCheck(true);res = maison(res,map,x,y-1) +1; }
        }
        else if (y == 0) {
            if(map.getMap()[x + 1][y].getType().equals("Maison") && !map.getMap()[x+1][y].isCheck()) {map.getMap()[x+1][y].setCheck(true);res = maison(res,map,x+1,y) +1 ; }
            if (map.getMap()[x][y + 1].getType().equals("Maison") && !map.getMap()[x][y+1].isCheck()){ map.getMap()[x][y+1].setCheck(true);res = maison(res,map,x,y+1) +1 ; }
            if(map.getMap()[x - 1][y].getType().equals("Maison") && !map.getMap()[x-1][y].isCheck()) {map.getMap()[x-1][y].setCheck(true);res = maison(res,map,x-1,y) +1 ; }
        }
        else if (y == map.getNbColumn() - 1) {
            if(map.getMap()[x + 1][y].getType().equals("Maison") && !map.getMap()[x+1][y].isCheck()){ map.getMap()[x+1][y].setCheck(true);res = maison(res,map,x+1,y) +1 ; }
            if(map.getMap()[x - 1][y].getType().equals("Maison") && !map.getMap()[x-1][y].isCheck()) { map.getMap()[x-1][y].setCheck(true);res = maison(res,map,x-1,y) +1 ;}
            if(map.getMap()[x][y - 1].getType().equals("Maison") && !map.getMap()[x][y-1].isCheck()) {map.getMap()[x][y-1].setCheck(true);res = maison(res,map,x,y-1) +1; }
        }
        else if (x == map.getNbRow() - 1) {
            if(map.getMap()[x][y + 1].getType().equals("Maison") && !map.getMap()[x][y+1].isCheck()) { map.getMap()[x][y+1].setCheck(true);res = maison(res,map,x,y+1) +1 ; }
            if(map.getMap()[x - 1][y].getType().equals("Maison") && !map.getMap()[x-1][y].isCheck()) { map.getMap()[x-1][y].setCheck(true);res = maison(res,map,x-1,y) +1 ;}
            if(map.getMap()[x][y - 1].getType().equals("Maison") && !map.getMap()[x][y-1].isCheck()) {map.getMap()[x][y-1].setCheck(true);res = maison(res,map,x,y-1) +1; }
        }
        return res;
    }

    /*
    Fonction pour le score du decret 35
     */
    public static int maison_35(int res, Map map, int x, int y){
        if (x != 0 && x != map.getNbRow() - 1 && y != 0 && y != map.getNbColumn() - 1) {
            if(!map.getMap()[x + 1][y].getType().equals("Montagne") && !map.getMap()[x][y + 1].getType().equals("Montagne") &&
                    !map.getMap()[x - 1][y].getType().equals("Montagne") && !map.getMap()[x][y - 1].getType().equals("Montagne")){
                if(map.getMap()[x + 1][y].getType().equals("Maison") && !map.getMap()[x+1][y].isCheck()) {map.getMap()[x+1][y].setCheck(true);res = maison_35(res,map,x+1,y) +1 ; }
                if(map.getMap()[x][y + 1].getType().equals("Maison") && !map.getMap()[x][y+1].isCheck()) {map.getMap()[x][y+1].setCheck(true);res = maison_35(res,map,x,y+1) +1; }
                if(map.getMap()[x - 1][y].getType().equals("Maison") && !map.getMap()[x-1][y].isCheck()) {map.getMap()[x-1][y].setCheck(true);res = maison_35(res,map,x-1,y) +1 ; }
                if(map.getMap()[x][y - 1].getType().equals("Maison") && !map.getMap()[x][y-1].isCheck()) {map.getMap()[x][y-1].setCheck(true);res = maison_35(res,map,x,y-1) +1; }
            }
            else res -=1;
        }
        else if (x == 0 && y == 0) {
            if(!map.getMap()[x + 1][y].getType().equals("Montagne") && !map.getMap()[x][y + 1].getType().equals("Montagne")){
                if(map.getMap()[x + 1][y].getType().equals("Maison") && !map.getMap()[x+1][y].isCheck()) {map.getMap()[x+1][y].setCheck(true);res = maison_35(res,map,x+1,y) +1 ; }
                if(map.getMap()[x][y + 1].getType().equals("Maison") && !map.getMap()[x][y+1].isCheck()) {map.getMap()[x][y+1].setCheck(true);res = maison_35(res,map,x,y+1) +1 ; }
            }
            else res -=1;
        }
        else if (x == map.getNbRow() - 1 && y == map.getNbColumn() - 1) {
            if(!map.getMap()[x - 1][y].getType().equals("Montagne") && !map.getMap()[x][y - 1].getType().equals("Montagne")){
                if(map.getMap()[x - 1][y].getType().equals("Maison") && !map.getMap()[x-1][y].isCheck()) {map.getMap()[x-1][y].setCheck(true);res = maison_35(res,map,x-1,y) +1 ; }
                if(map.getMap()[x][y - 1].getType().equals("Maison") && !map.getMap()[x][y-1].isCheck()) {map.getMap()[x][y-1].setCheck(true);res = maison_35(res,map,x,y-1) +1; }
            }else res -=1;
        }
        else if (x == 0 && y == map.getNbColumn() - 1) {
            if(!map.getMap()[x + 1][y].getType().equals("Montagne") && !map.getMap()[x][y - 1].getType().equals("Montagne")){
                if(map.getMap()[x + 1][y].getType().equals("Maison") && !map.getMap()[x+1][y].isCheck() ){ map.getMap()[x+1][y].setCheck(true);res = maison_35(res,map,x+1,y) +1 ; }
                if(map.getMap()[x][y - 1].getType().equals("Maison") && !map.getMap()[x][y-1].isCheck()) {map.getMap()[x][y-1].setCheck(true);res = maison_35(res,map,x,y-1) +1; }
            }else res -=1;
        }
        else if (y == 0 && x == map.getNbRow() - 1) {
            if(!map.getMap()[x - 1][y].getType().equals("Montagne") && !map.getMap()[x][y + 1].getType().equals("Montagne")){
                if(map.getMap()[x][y + 1].getType().equals("Maison") && !map.getMap()[x][y+1].isCheck()){ map.getMap()[x][y+1].setCheck(true);res = maison_35(res,map,x,y+1) +1 ; }
                if(map.getMap()[x - 1][y].getType().equals("Maison") && !map.getMap()[x-1][y].isCheck()) {map.getMap()[x-1][y].setCheck(true);res = maison_35(res,map,x-1,y) +1 ; }
            }else res -=1;
        }
        else if (x == 0) {
            if(!map.getMap()[x + 1][y].getType().equals("Montagne") && !map.getMap()[x][y + 1].getType().equals("Montagne") && !map.getMap()[x][y - 1].getType().equals("Montagne")){
                if(map.getMap()[x + 1][y].getType().equals("Maison") && !map.getMap()[x+1][y].isCheck()) {map.getMap()[x+1][y].setCheck(true);res = maison_35(res,map,x+1,y) +1 ; }
                if(map.getMap()[x][y + 1].getType().equals("Maison") && !map.getMap()[x][y+1].isCheck()) {map.getMap()[x][y+1].setCheck(true);res = maison_35(res,map,x,y+1) +1 ; }
                if(map.getMap()[x][y - 1].getType().equals("Maison") && !map.getMap()[x][y-1].isCheck()) {map.getMap()[x][y-1].setCheck(true);res = maison_35(res,map,x,y-1) +1; }
            }else res -=1;
        }
        else if (y == 0) {
            if(!map.getMap()[x + 1][y].getType().equals("Montagne") && !map.getMap()[x][y + 1].getType().equals("Montagne") && !map.getMap()[x - 1][y].getType().equals("Montagne")){
                if(map.getMap()[x + 1][y].getType().equals("Maison") && !map.getMap()[x+1][y].isCheck()) {map.getMap()[x+1][y].setCheck(true);res = maison_35(res,map,x+1,y) +1 ; }
                if (map.getMap()[x][y + 1].getType().equals("Maison") && !map.getMap()[x][y+1].isCheck()){ map.getMap()[x][y+1].setCheck(true);res = maison_35(res,map,x,y+1) +1 ; }
                if(map.getMap()[x - 1][y].getType().equals("Maison") && !map.getMap()[x-1][y].isCheck()) {map.getMap()[x-1][y].setCheck(true);res = maison_35(res,map,x-1,y) +1 ; }
            }else res -=1;
        }
        else if (y == map.getNbColumn() - 1) {
            if(!map.getMap()[x + 1][y].getType().equals("Montagne") && !map.getMap()[x - 1][y].getType().equals("Montagne") && !map.getMap()[x][y - 1].getType().equals("Montagne")){
                if(map.getMap()[x + 1][y].getType().equals("Maison") && !map.getMap()[x+1][y].isCheck()){ map.getMap()[x+1][y].setCheck(true);res = maison_35(res,map,x+1,y) +1 ; }
                if(map.getMap()[x - 1][y].getType().equals("Maison") && !map.getMap()[x-1][y].isCheck()) { map.getMap()[x-1][y].setCheck(true);res = maison_35(res,map,x-1,y) +1 ;}
                if(map.getMap()[x][y - 1].getType().equals("Maison") && !map.getMap()[x][y-1].isCheck()) {map.getMap()[x][y-1].setCheck(true);res = maison_35(res,map,x,y-1) +1; }
            }else res -=1;
        }
        else if (x == map.getNbRow() - 1) {
            if(!map.getMap()[x - 1][y].getType().equals("Montagne") && !map.getMap()[x][y + 1].getType().equals("Montagne") && !map.getMap()[x][y - 1].getType().equals("Montagne")){
                if(map.getMap()[x][y + 1].getType().equals("Maison") && !map.getMap()[x][y+1].isCheck()) { map.getMap()[x][y+1].setCheck(true);res = maison_35(res,map,x,y+1) +1 ; }
                if(map.getMap()[x - 1][y].getType().equals("Maison") && !map.getMap()[x-1][y].isCheck()) { map.getMap()[x-1][y].setCheck(true);res = maison_35(res,map,x-1,y) +1 ;}
                if(map.getMap()[x][y - 1].getType().equals("Maison") && !map.getMap()[x][y-1].isCheck()) {map.getMap()[x][y-1].setCheck(true);res = maison_35(res,map,x,y-1) +1; }
            }else res -=1;
        }
        return res;
    }

    /*
    Fonction pour le score du decret 36
     */
    public ArrayList<String> maison_36(ArrayList<String> res, Map map, int x, int y){

        if (x != 0 && x != map.getNbRow() - 1 && y != 0 && y != map.getNbColumn() - 1) {

            if (!map.getMap()[x + 1][y].getType().equals("Maison") && !map.getMap()[x + 1][y].getType().equals("Vide") && !map.getMap()[x + 1][y].getType().equals("Temple")){
                if(!res.contains(map.getMap()[x+1][y].getType())) res.add(map.getMap()[x+1][y].getType());
            }
            if (!map.getMap()[x - 1][y].getType().equals("Maison") && !map.getMap()[x - 1][y].getType().equals("Vide") && !map.getMap()[x - 1][y].getType().equals("Temple")){
                if(!res.contains(map.getMap()[x-1][y].getType())) res.add(map.getMap()[x-1][y].getType());
            }
            if (!map.getMap()[x][y + 1].getType().equals("Maison") && !map.getMap()[x][y + 1].getType().equals("Vide") && !map.getMap()[x][y + 1].getType().equals("Temple")){
                if(!res.contains(map.getMap()[x][y+1].getType())) res.add(map.getMap()[x][y+1].getType());
            }
            if (!map.getMap()[x][y - 1].getType().equals("Maison") && !map.getMap()[x][y - 1].getType().equals("Vide") && !map.getMap()[x][y - 1].getType().equals("Temple")){
                if(!res.contains(map.getMap()[x][y-1].getType())) res.add(map.getMap()[x][y-1].getType());
            }

            if(map.getMap()[x + 1][y].getType().equals("Maison") && !map.getMap()[x+1][y].isCheck()) {map.getMap()[x+1][y].setCheck(true);res = maison_36(res,map,x+1,y); }
            if(map.getMap()[x][y + 1].getType().equals("Maison") && !map.getMap()[x][y+1].isCheck()) {map.getMap()[x][y+1].setCheck(true);res = maison_36(res,map,x,y+1); }
            if(map.getMap()[x - 1][y].getType().equals("Maison") && !map.getMap()[x-1][y].isCheck()) {map.getMap()[x-1][y].setCheck(true);res = maison_36(res,map,x-1,y); }
            if(map.getMap()[x][y - 1].getType().equals("Maison") && !map.getMap()[x][y-1].isCheck()) {map.getMap()[x][y-1].setCheck(true);res = maison_36(res,map,x,y-1); }
        }
        else if (x == 0 && y == 0) {
            if (!map.getMap()[x + 1][y].getType().equals("Maison") && !map.getMap()[x + 1][y].getType().equals("Vide") && !map.getMap()[x + 1][y].getType().equals("Temple")){
                if(!res.contains(map.getMap()[x+1][y].getType())) res.add(map.getMap()[x+1][y].getType());
            }
            if (!map.getMap()[x][y + 1].getType().equals("Maison") && !map.getMap()[x][y + 1].getType().equals("Vide") && !map.getMap()[x][y + 1].getType().equals("Temple")){
                if(!res.contains(map.getMap()[x][y+1].getType())) res.add(map.getMap()[x][y+1].getType());
            }

            if(map.getMap()[x + 1][y].getType().equals("Maison") && !map.getMap()[x+1][y].isCheck()) {map.getMap()[x+1][y].setCheck(true);res = maison_36(res,map,x+1,y); }
            if(map.getMap()[x][y + 1].getType().equals("Maison") && !map.getMap()[x][y+1].isCheck()) {map.getMap()[x][y+1].setCheck(true);res = maison_36(res,map,x,y+1); }
        }
        else if (x == map.getNbRow() - 1 && y == map.getNbColumn() - 1) {
            if (!map.getMap()[x - 1][y].getType().equals("Maison") && !map.getMap()[x - 1][y].getType().equals("Vide") && !map.getMap()[x - 1][y].getType().equals("Temple")){
                if(!res.contains(map.getMap()[x-1][y].getType())) res.add(map.getMap()[x-1][y].getType());
            }
            if (!map.getMap()[x][y - 1].getType().equals("Maison") && !map.getMap()[x][y - 1].getType().equals("Vide") && !map.getMap()[x][y - 1].getType().equals("Temple")){
                if(!res.contains(map.getMap()[x][y-1].getType())) res.add(map.getMap()[x][y-1].getType());
            }

            if(map.getMap()[x - 1][y].getType().equals("Maison") && !map.getMap()[x-1][y].isCheck()) {map.getMap()[x-1][y].setCheck(true);res = maison_36(res,map,x-1,y); }
            if(map.getMap()[x][y - 1].getType().equals("Maison") && !map.getMap()[x][y-1].isCheck()) {map.getMap()[x][y-1].setCheck(true);res = maison_36(res,map,x,y-1); }
        }
        else if (x == 0 && y == map.getNbColumn() - 1) {
            if (!map.getMap()[x + 1][y].getType().equals("Maison") && !map.getMap()[x + 1][y].getType().equals("Vide") && !map.getMap()[x + 1][y].getType().equals("Temple")){
                if(!res.contains(map.getMap()[x+1][y].getType())) res.add(map.getMap()[x+1][y].getType());
            }
            if (!map.getMap()[x][y - 1].getType().equals("Maison") && !map.getMap()[x][y - 1].getType().equals("Vide") && !map.getMap()[x][y - 1].getType().equals("Temple")){
                if(!res.contains(map.getMap()[x][y-1].getType())) res.add(map.getMap()[x][y-1].getType());
            }

            if(map.getMap()[x + 1][y].getType().equals("Maison") && !map.getMap()[x+1][y].isCheck() ){ map.getMap()[x+1][y].setCheck(true);res = maison_36(res,map,x+1,y); }
            if(map.getMap()[x][y - 1].getType().equals("Maison") && !map.getMap()[x][y-1].isCheck()) {map.getMap()[x][y-1].setCheck(true);res = maison_36(res,map,x,y-1); }
        }
        else if (y == 0 && x == map.getNbRow() - 1) {
            if (!map.getMap()[x - 1][y].getType().equals("Maison") && !map.getMap()[x - 1][y].getType().equals("Vide") && !map.getMap()[x - 1][y].getType().equals("Temple")){
                if(!res.contains(map.getMap()[x-1][y].getType())) res.add(map.getMap()[x-1][y].getType());
            }
            if (!map.getMap()[x][y + 1].getType().equals("Maison") && !map.getMap()[x][y + 1].getType().equals("Vide") && !map.getMap()[x][y + 1].getType().equals("Temple")){
                if(!res.contains(map.getMap()[x][y+1].getType())) res.add(map.getMap()[x][y+1].getType());
            }

            if(map.getMap()[x][y + 1].getType().equals("Maison") && !map.getMap()[x][y+1].isCheck()){ map.getMap()[x][y+1].setCheck(true);res = maison_36(res,map,x,y+1); }
            if(map.getMap()[x - 1][y].getType().equals("Maison") && !map.getMap()[x-1][y].isCheck()) {map.getMap()[x-1][y].setCheck(true);res = maison_36(res,map,x-1,y); }
        }
        else if (x == 0) {
            if (!map.getMap()[x + 1][y].getType().equals("Maison") && !map.getMap()[x + 1][y].getType().equals("Vide") && !map.getMap()[x + 1][y].getType().equals("Temple")){
                if(!res.contains(map.getMap()[x+1][y].getType())) res.add(map.getMap()[x+1][y].getType());
            }
            if (!map.getMap()[x][y + 1].getType().equals("Maison") && !map.getMap()[x][y + 1].getType().equals("Vide") && !map.getMap()[x][y + 1].getType().equals("Temple")){
                if(!res.contains(map.getMap()[x][y+1].getType())) res.add(map.getMap()[x][y+1].getType());
            }
            if (!map.getMap()[x][y - 1].getType().equals("Maison") && !map.getMap()[x][y - 1].getType().equals("Vide") && !map.getMap()[x][y - 1].getType().equals("Temple")){
                if(!res.contains(map.getMap()[x][y-1].getType())) res.add(map.getMap()[x][y-1].getType());
            }

            if(map.getMap()[x + 1][y].getType().equals("Maison") && !map.getMap()[x+1][y].isCheck()) {map.getMap()[x+1][y].setCheck(true);res = maison_36(res,map,x+1,y); }
            if(map.getMap()[x][y + 1].getType().equals("Maison") && !map.getMap()[x][y+1].isCheck()) {map.getMap()[x][y+1].setCheck(true);res = maison_36(res,map,x,y+1); }
            if(map.getMap()[x][y - 1].getType().equals("Maison") && !map.getMap()[x][y-1].isCheck()) {map.getMap()[x][y-1].setCheck(true);res = maison_36(res,map,x,y-1); }
        }
        else if (y == 0) {
            if (!map.getMap()[x + 1][y].getType().equals("Maison") && !map.getMap()[x + 1][y].getType().equals("Vide") && !map.getMap()[x + 1][y].getType().equals("Temple")){
                if(!res.contains(map.getMap()[x+1][y].getType())) res.add(map.getMap()[x+1][y].getType());
            }
            if (!map.getMap()[x - 1][y].getType().equals("Maison") && !map.getMap()[x - 1][y].getType().equals("Vide") && !map.getMap()[x - 1][y].getType().equals("Temple")){
                if(!res.contains(map.getMap()[x-1][y].getType())) res.add(map.getMap()[x-1][y].getType());
            }
            if (!map.getMap()[x][y + 1].getType().equals("Maison") && !map.getMap()[x][y + 1].getType().equals("Vide") && !map.getMap()[x][y + 1].getType().equals("Temple")){
                if(!res.contains(map.getMap()[x][y+1].getType())) res.add(map.getMap()[x][y+1].getType());
            }

            if(map.getMap()[x + 1][y].getType().equals("Maison") && !map.getMap()[x+1][y].isCheck()) {map.getMap()[x+1][y].setCheck(true);res = maison_36(res,map,x+1,y); }
            if (map.getMap()[x][y + 1].getType().equals("Maison") && !map.getMap()[x][y+1].isCheck()){ map.getMap()[x][y+1].setCheck(true);res = maison_36(res,map,x,y+1); }
            if(map.getMap()[x - 1][y].getType().equals("Maison") && !map.getMap()[x-1][y].isCheck()) {map.getMap()[x-1][y].setCheck(true);res = maison_36(res,map,x-1,y); }
        }
        else if (y == map.getNbColumn() - 1) {
            if (!map.getMap()[x + 1][y].getType().equals("Maison") && !map.getMap()[x + 1][y].getType().equals("Vide") && !map.getMap()[x + 1][y].getType().equals("Temple")){
                if(!res.contains(map.getMap()[x+1][y].getType())) res.add(map.getMap()[x+1][y].getType());
            }
            if (!map.getMap()[x - 1][y].getType().equals("Maison") && !map.getMap()[x - 1][y].getType().equals("Vide") && !map.getMap()[x - 1][y].getType().equals("Temple")){
                if(!res.contains(map.getMap()[x-1][y].getType())) res.add(map.getMap()[x-1][y].getType());
            }
            if (!map.getMap()[x][y - 1].getType().equals("Maison") && !map.getMap()[x][y - 1].getType().equals("Vide") && !map.getMap()[x][y - 1].getType().equals("Temple")){
                if(!res.contains(map.getMap()[x][y-1].getType())) res.add(map.getMap()[x][y-1].getType());
            }

            if(map.getMap()[x + 1][y].getType().equals("Maison") && !map.getMap()[x+1][y].isCheck()){ map.getMap()[x+1][y].setCheck(true);res = maison_36(res,map,x+1,y); }
            if(map.getMap()[x - 1][y].getType().equals("Maison") && !map.getMap()[x-1][y].isCheck()) { map.getMap()[x-1][y].setCheck(true);res = maison_36(res,map,x-1,y);}
            if(map.getMap()[x][y - 1].getType().equals("Maison") && !map.getMap()[x][y-1].isCheck()) {map.getMap()[x][y-1].setCheck(true);res = maison_36(res,map,x,y-1); }
        }
        else if (x == map.getNbRow() - 1) {
            if (!map.getMap()[x - 1][y].getType().equals("Maison") && !map.getMap()[x - 1][y].getType().equals("Vide") && !map.getMap()[x - 1][y].getType().equals("Temple")){
                if(!res.contains(map.getMap()[x-1][y].getType())) res.add(map.getMap()[x-1][y].getType());
            }
            if (!map.getMap()[x][y + 1].getType().equals("Maison") && !map.getMap()[x][y + 1].getType().equals("Vide") && !map.getMap()[x][y + 1].getType().equals("Temple")){
                if(!res.contains(map.getMap()[x][y+1].getType())) res.add(map.getMap()[x][y+1].getType());
            }
            if (!map.getMap()[x][y - 1].getType().equals("Maison") && !map.getMap()[x][y - 1].getType().equals("Vide") && !map.getMap()[x][y - 1].getType().equals("Temple")){
                if(!res.contains(map.getMap()[x][y-1].getType())) res.add(map.getMap()[x][y-1].getType());
            }

            if(map.getMap()[x][y + 1].getType().equals("Maison") && !map.getMap()[x][y+1].isCheck()) { map.getMap()[x][y+1].setCheck(true);res = maison_36(res,map,x,y+1); }
            if(map.getMap()[x - 1][y].getType().equals("Maison") && !map.getMap()[x-1][y].isCheck()) { map.getMap()[x-1][y].setCheck(true);res = maison_36(res,map,x-1,y);}
            if(map.getMap()[x][y - 1].getType().equals("Maison") && !map.getMap()[x][y-1].isCheck()) {map.getMap()[x][y-1].setCheck(true);res = maison_36(res,map,x,y-1); }
        }
        return res;

    }

    /*
    Deux prochaines fonctions pour le decret 39 (qui est a terminé plus tard)
    */
    public static int decret_39(int res, Map map, int x, int y){

        if(!map.getMap()[x][y + 1].getType().equals("Vide") && !map.getMap()[x][y + 1].getType().equals("Montagne") && !map.getMap()[x][y + 1].getType().equals("Temple") && !map.getMap()[x][y+1].isCheck() ){
            map.getMap()[x][y+1].setCheck(true);
            res = decret_39(res, map, x, y+1)+1;
        }

        return res;
    }

    public static int decret_39Bis(int res, Map map, int x, int y){

        if(!map.getMap()[x + 1][y].getType().equals("Vide") && !map.getMap()[x + 1][y].getType().equals("Montagne") && !map.getMap()[x + 1][y].getType().equals("Temple") && !map.getMap()[x+1][y].isCheck() ){
            map.getMap()[x+1][y].setCheck(true);
            res = decret_39Bis(res, map, x+1, y)+1;
        }

        return res;
    }
}
