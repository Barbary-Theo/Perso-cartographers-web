package cartographers.game.Model;

import cartographers.game.Model.Cards.*;
import cartographers.game.Model.Map.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Game {

    private static Game singleton;
    
    private List<Player> players;
    public ArrayList<GameCard> gameCards = new ArrayList<>();
    protected ArrayList<MonstreCard> monstreCards = new ArrayList<>();
    protected ArrayList<Season> seasons = new ArrayList<>();

    protected GameCard impossibleCard;
    protected GameCard current_card;
    protected Player current_player;
    protected Season current_season;


    private static final String pathImg = "src/main/resources/public/";

    public Game() {}

    public Game(List<Player> players) {

        start(); // get all cards game
        addMonstre(); // add monstre

        /* init players */
        this.players = players;
        current_player = players.get(0);

        Random r=new Random();
        int indice = r.nextInt(gameCards.size()-1);

        current_card = gameCards.get(indice);
        gameCards.remove(indice);

        /* init decret */
        var List_decret = Decret();
        indice = r.nextInt(List_decret.size()-1);
        Decret a = (Decret) List_decret.get(indice);
        List_decret.remove(indice);
        indice = r.nextInt(List_decret.size()-1);
        Decret b = (Decret) List_decret.get(indice);
        List_decret.remove(indice);
        indice = r.nextInt(List_decret.size()-1);
        Decret c = (Decret) List_decret.get(indice);
        List_decret.remove(indice);
        indice = r.nextInt(List_decret.size()-1);
        Decret d = (Decret) List_decret.get(indice);
        List_decret.remove(indice);

        /* init seasons */
        seasons.get(0).getDecrets().add(a);
        seasons.get(0).getDecrets().add(b);
        seasons.get(1).getDecrets().add(b);
        seasons.get(1).getDecrets().add(c);
        seasons.get(2).getDecrets().add(c);
        seasons.get(2).getDecrets().add(d);
        seasons.get(3).getDecrets().add(d);
        seasons.get(3).getDecrets().add(a);
        current_season = seasons.get(0);

    }


    /* Singleton instance */
    public static Game getInstance() {
        if(singleton == null) {
            singleton = new Game();
        }
        return singleton;
    }

    public static Game getInstance(List<Player> players) {
        if(singleton == null) {
            singleton = new Game(players);
        }
        return singleton;
    }

    /* init game methods */
    public void start(){
        this.gameCards.addAll(Explo_unique());
        this.gameCards.addAll(Explo_Choix());
        this.monstreCards.addAll(Monstre());
        this.gameCards.addAll(Ruine());
        this.seasons = Saisons();
    }

    public void addMonstre(){
        Collections.shuffle(this.monstreCards);
        this.gameCards.add(this.monstreCards.get(0));
        this.monstreCards.remove(0);
        mix();
    }

    public void mix(){
        Collections.shuffle(gameCards);
        Collections.shuffle(gameCards);
        Collections.shuffle(gameCards);
    }

    public ArrayList<GameCard> Explo_unique(){
        String path = "Cards/Exploration/Uniques";
        File p =new File(pathImg + path);
        File[] dossier=p.listFiles(); //Liste contenant tous les dossiers du fichier dans le chemin de la variable chemin
        ArrayList<File> ls=new ArrayList<>();
        ArrayList<GameCard> lc=new ArrayList<>();

        assert dossier != null;
        Collections.addAll(ls, dossier);

        ExplorationCardUnique c;
        for(File i : ls) {
            if (i.getName().charAt(2) == 'E'){ //On teste si la premiere lettre est un E
                c=new ExplorationCardUnique(path + i.getName(), 1, "Eau");
                Map m1=new Map(3,1);
                m1.changerCase(0,0,"Eau");
                m1.changerCase(1,0,"Eau");
                m1.changerCase(2,0,"Eau");
                Map m2=new Map(3,3);
                m2.changerCase(2,0,"Eau");
                m2.changerCase(1,1,"Eau");
                m2.changerCase(2,1,"Eau");
                m2.changerCase(0,2,"Eau");
                m2.changerCase(1,2,"Eau");
                c.setListMap(m1,m2);
                lc.add(c);
            } else if (i.getName().charAt(2) == 'B') {
                c=new ExplorationCardUnique(path + i.getName(), 1, "Bois");
                Map m1=new Map(2,2);
                m1.changerCase(0,0,"Bois");
                m1.changerCase(1,1,"Bois");
                Map m2=new Map(3,2);
                m2.changerCase(0,0,"Bois");
                m2.changerCase(1,0,"Bois");
                m2.changerCase(1,1,"Bois");
                m2.changerCase(2,1,"Bois");
                c.setListMap(m1,m2);
                lc.add(c);
            } else if (i.getName().charAt(2) == 'F') {
                c=new ExplorationCardUnique(path + i.getName(), 1, "Ferme");
                Map m1=new Map(2,1);
                m1.changerCase(0,0,"Ferme");
                m1.changerCase(1,0,"Ferme");
                Map m2=new Map(3,3);
                m2.changerCase(0,1,"Ferme");
                m2.changerCase(1,0,"Ferme");
                m2.changerCase(1,1,"Ferme");
                m2.changerCase(1,2,"Ferme");
                m2.changerCase(2,1,"Ferme");
                c.setListMap(m1,m2);
                lc.add(c);
            } else if (i.getName().charAt(2) == 'M') {
                c=new ExplorationCardUnique(path + i.getName(), 1, "Maison");
                Map m1=new Map(2,2);
                m1.changerCase(0,0,"Maison");
                m1.changerCase(1,0,"Maison");
                m1.changerCase(1,1,"Maison");
                Map m2=new Map(2,3);
                m2.changerCase(0,0,"Maison");
                m2.changerCase(0,1,"Maison");
                m2.changerCase(0,2,"Maison");
                m2.changerCase(1,0,"Maison");
                m2.changerCase(1,1,"Maison");
                c.setListMap(m1,m2);
                lc.add(c);
            }
        }
        return lc;
    }

    public ArrayList<GameCard> Explo_Choix(){
        String path = "Cards/Exploration/Choix";
        File p=new File(pathImg + path);
        File[] dossier=p.listFiles();
        ArrayList<File> ls=new ArrayList<>();
        ArrayList<GameCard> lc=new ArrayList<>();

        assert dossier != null;
        Collections.addAll(ls, dossier);

        for(File i : ls) {

            if (i.getName().equals("C.jpg")) {
                ExplorationCardChoice c = new ExplorationCardChoice(path + i.getName(),0);
                c.getListChoix().add("Eau");
                c.getListChoix().add("Bois");
                c.getListChoix().add("Ferme");
                c.getListChoix().add("Maison");
                c.getListChoix().add("Monstre");
                Map m= new Map(1,1);
                m.changerCase(0,0,"Bois");
                c.setM(m);
                this.impossibleCard = c;
                lc.add(c);
            } else if (i.getName().equals("B_E.jpg") ) {
                ExplorationCardChoice c = new ExplorationCardChoice(path + i.getName(),2);
                c.getListChoix().add("Eau");
                c.getListChoix().add("Bois");
                Map m= new Map(3,3);
                m.changerCase(0,0,"Bois");
                m.changerCase(1,0,"Bois");
                m.changerCase(2,0,"Bois");
                m.changerCase(1,1,"Bois");
                m.changerCase(1,2,"Bois");
                c.setM(m);
                lc.add(c);
            } else if (i.getName().equals("B_F.jpg")) {
                ExplorationCardChoice c = new ExplorationCardChoice(path + i.getName(),2);
                c.getListChoix().add("Ferme");
                c.getListChoix().add("Bois");
                Map m= new Map(2,3);
                m.changerCase(0,0,"Bois");
                m.changerCase(0,1,"Bois");
                m.changerCase(0,2,"Bois");
                m.changerCase(1,2,"Bois");
                c.setM(m);
                lc.add(c);
            } else if (i.getName().equals("B_M.jpg")) {
                ExplorationCardChoice c = new ExplorationCardChoice(path + i.getName(),2);
                c.getListChoix().add("Maison");
                c.getListChoix().add("Bois");
                Map m= new Map(2,4);
                m.changerCase(0,2,"Bois");
                m.changerCase(0,3,"Bois");
                m.changerCase(1,0,"Bois");
                m.changerCase(1,1,"Bois");
                m.changerCase(1,2,"Bois");
                c.setM(m);
                lc.add(c);
            }
            else if (i.getName().equals("F_E.jpg")) {
                ExplorationCardChoice c = new ExplorationCardChoice(path + i.getName(), 2);
                c.getListChoix().add("Ferme");
                c.getListChoix().add("Eau");
                Map m= new Map(3,3);
                m.changerCase(0,0,"Eau");
                m.changerCase(1,0,"Eau");
                m.changerCase(2,0,"Eau");
                m.changerCase(0,1,"Eau");
                m.changerCase(0,2,"Eau");
                c.setM(m);
                lc.add(c);
            }
            else if (i.getName().equals("M_E.jpg")) {
                ExplorationCardChoice c = new ExplorationCardChoice(path + i.getName(), 2);
                c.getListChoix().add("Maison");
                c.getListChoix().add("Eau");
                Map m= new Map(1,4);
                m.changerCase(0,0,"Eau");
                m.changerCase(0,1,"Eau");
                m.changerCase(0,2,"Eau");
                m.changerCase(0,3,"Eau");
                c.setM(m);
                lc.add(c);
            }
            else if (i.getName().equals("M_F.jpg")) {
                ExplorationCardChoice c = new ExplorationCardChoice(path + i.getName(), 2);
                c.getListChoix().add("Maison");
                c.getListChoix().add("Ferme");
                Map m= new Map(3,2);
                m.changerCase(0,0,"Maison");
                m.changerCase(1,0,"Maison");
                m.changerCase(2,0,"Maison");
                m.changerCase(1,1,"Maison");
                c.setM(m);
                lc.add(c);
            }
        }
        return lc;
    }

    public ArrayList<MonstreCard> Monstre(){
        String path = "Cards/Monstres";
        File p=new File(pathImg + path);
        File[] dossier=p.listFiles();
        ArrayList<File> ls=new ArrayList<>();
        ArrayList<MonstreCard> lc=new ArrayList<>();

        assert dossier != null;
        Collections.addAll(ls, dossier);

        for(File i : ls) {
            if(i.getName().equals("01.jpg")){
                MonstreCard c =new MonstreCard(path + i.getName(),true,4);
                Map m = new Map(3,3);
                m.changerCase(0,0,"Monstre");
                m.changerCase(1,1,"Monstre");
                m.changerCase(2,2,"Monstre");
                c.setM(m);
                lc.add(c);
            }

            else if(i.getName().equals("02.jpg")){
                MonstreCard c =new MonstreCard(path + i.getName(),false,2);
                Map m = new Map(2,3);
                m.changerCase(0,0,"Monstre");
                m.changerCase(1,0,"Monstre");
                m.changerCase(0,2,"Monstre");
                m.changerCase(1,2,"Monstre");
                c.setM(m);
                lc.add(c);
            }
            else if(i.getName().equals("03.jpg")){
                MonstreCard c =new MonstreCard(path + i.getName(),false,3);
                Map m = new Map(3,2);
                m.changerCase(0,0,"Monstre");
                m.changerCase(1,0,"Monstre");
                m.changerCase(1,1,"Monstre");
                m.changerCase(2,0,"Monstre");
                c.setM(m);
                lc.add(c);
            }
            else if(i.getName().equals("04.jpg")){
                MonstreCard c =new MonstreCard(path + i.getName(),true,1);
                Map m = new Map(3,2);
                m.changerCase(0,0,"Monstre");
                m.changerCase(1,0,"Monstre");
                m.changerCase(2,0,"Monstre");
                m.changerCase(0,1,"Monstre");
                m.changerCase(2,1,"Monstre");
                c.setM(m);
                lc.add(c);
            }
        }
        return lc;
    }

    public ArrayList<GameCard> Ruine(){
        String path = "Cards/Ruines";
        File p=new File(pathImg + path);
        File[] dossier=p.listFiles();
        ArrayList<File> ls=new ArrayList<>();
        ArrayList<GameCard> lc=new ArrayList<>();

        assert dossier != null;
        Collections.addAll(ls, dossier);

        for(File i : ls) {
            lc.add(new TempleCard(path + i.getName()));
        }
        return lc;
    }

    public ArrayList<Card> Decret(){
        String path = "Cards/Decret";
        File p=new File(pathImg + path);
        File[] dossier=p.listFiles();
        ArrayList<File> ls=new ArrayList<>();
        ArrayList<Card> lc=new ArrayList<>();

        assert dossier != null;
        Collections.addAll(ls, dossier);

        Decret c;
        for(File f : ls){
            if (f.getName().equals("26.jpg")) {
                c = new Decret(path + f.getName(),"<HTML> <p style='text-align:center;'> Gagnez un point de réputation <br>pour chaque espace de forêt adjacent <br>à un bord de map. </p> </HTML>");
                Map m1 = new Map(4, 4);
                m1.changerCase(0, 0, "Bois");
                m1.changerCase(0, 2, "Bois");
                m1.changerCase(0, 3, "Montagne");
                m1.changerCase(1, 0, "Bois");
                m1.changerCase(1, 1, "Bois");
                m1.changerCase(1, 2, "Bois");
                m1.changerCase(1, 3, "Montagne");
                m1.changerCase(2, 0, "Montagne");
                m1.changerCase(2, 1, "Montagne");
                m1.changerCase(2, 2, "Montagne");
                m1.changerCase(3, 2, "Montagne");
                m1.changerCase(3, 3, "Montagne");
                c.setMap(m1);
                lc.add(c);
            }
            if (f.getName().equals("27.jpg")) {
                c = new Decret(path + f.getName(),"<HTML> <p style='text-align:center;'> Gagnez un point de réputation <br>pour chaque ligne et colonne avec <br>un moins un espace de forêt. <br>Un même espace de forêt peut être <br>comptabilisé dans une ligne<br> et une colonne.</p> </HTML>");
                Map m1 = new Map(3, 4);
                m1.changerCase(0, 0, "Bois");
                m1.changerCase(0, 2, "Bois");
                m1.changerCase(0, 3, "Montagne");
                m1.changerCase(1, 0, "Bois");
                m1.changerCase(1, 1, "Bois");
                m1.changerCase(1, 2, "Bois");
                m1.changerCase(1, 3, "Montagne");
                m1.changerCase(2, 0, "Montagne");
                m1.changerCase(2, 1, "Montagne");
                m1.changerCase(2, 2, "Montagne");
                c.setMap(m1);
                lc.add(c);
            }
            if (f.getName().equals("28.jpg")) {
                c = new Decret(path + f.getName(),"<HTML> <p style='text-align:center;'> Gagnez un point de réputation <br>pour chaque espace de forêt <br>entouré sur ses quatres côtés <br>par un espace typé <br>ou par un bord de map.</p> </HTML>");
                Map m1 = new Map(4, 4);
                m1.changerCase(0, 0, "Bois");
                m1.changerCase(0, 2, "Bois");
                m1.changerCase(0, 3, "Montagne");
                m1.changerCase(1, 0, "Bois");
                m1.changerCase(1, 1, "Bois");
                m1.changerCase(1, 2, "Bois");
                m1.changerCase(1, 3, "Montagne");
                m1.changerCase(2, 0, "Montagne");
                m1.changerCase(2, 1, "Montagne");
                m1.changerCase(2, 2, "Montagne");
                m1.changerCase(3, 2, "Montagne");
                m1.changerCase(3, 3, "Montagne");
                c.setMap(m1);
                lc.add(c);
            }
            if (f.getName().equals("30.jpg")){
                c = new Decret(path + f.getName(),"<HTML> <p style='text-align:center;'> Gagnez un point de réputation <br>pour chaque espace d'eau <br>adjacent par au moins <br>un espace de ferme et inversement.</p> </HTML>");
                Map m1 = new Map(2, 2);
                m1.changerCase(0, 0, "Ferme");
                m1.changerCase(0, 1, "Eau");
                m1.changerCase(1, 0, "Eau");
                m1.changerCase(1, 1, "Montagne");
                c.setMap(m1);
                lc.add(c);
            }
            if (f.getName().equals("31.jpg")) {
                c = new Decret(path + f.getName(),"<HTML> <p style='text-align:center;'> Gagnez deux points de réputation <br>pour chaque espace d'eau <br>adjacent à un espace de montagne <br>et gagnez un point de <br>réputation pour chaque espace <br>de ferme adjacent à un <br>espace de montagne.</p> </HTML>");
                Map m1 = new Map(3, 3);
                m1.changerCase(0, 0, "Ferme");
                m1.changerCase(0, 1, "Eau");
                m1.changerCase(0, 2, "Montagne");
                m1.changerCase(1, 0, "Eau");
                m1.changerCase(1, 1, "Montagne");
                m1.changerCase(1, 2, "Ferme");
                m1.changerCase(2, 0, "Eau");
                m1.changerCase(2, 1, "Ferme");
                m1.changerCase(2, 2, "Montagne");
                c.setMap(m1);
                lc.add(c);
            }
            if (f.getName().equals("32.jpg")) {
                c = new Decret(path + f.getName(),"<HTML> <p style='text-align:center;'> Gagnez un point de réputation <br>pour chaque espace d'eau adjacent <br>à un espace de ruine et <br>gagner trois points de <br>réputation pour chaque espace <br>de ferme sur un espace <br>de ruine.</p> </HTML>");
                Map m1 = new Map(3, 3);
                m1.changerCase(0, 0, "Ferme");
                m1.changerCase(0, 1, "Eau");
                m1.changerCase(0, 2, "Eau");
                m1.changerCase(1, 0, "Ferme");
                m1.changerCase(1, 1, "Temple");
                m1.changerCase(1, 2, "Montagne");
                m1.changerCase(2, 0, "Montagne");
                m1.changerCase(2, 1, "Temple");
                m1.changerCase(2, 2, "Eau");
                c.setMap(m1);
                lc.add(c);
            }
            if (f.getName().equals("33.jpg")) {
                c = new Decret(path + f.getName(),"<HTML> <p style='text-align:center;'> Gagnez trois points de réputation <br>pour chaque groupe d'espace <br>de ferme qui n'est <br>pas adjacent à un espace <br>d'eau ou au bord de <br>map, et de même pour un <br>espace d'eau.</p> </HTML>");
                Map m1 = new Map(5, 5);
                m1.changerCase(0, 0, "Ferme");
                m1.changerCase(0, 1, "Ferme");
                m1.changerCase(1, 2, "Eau");
                m1.changerCase(1, 3, "Ferme");
                m1.changerCase(2, 0, "Montagne");
                m1.changerCase(2, 1, "Eau");
                m1.changerCase(2, 2, "Eau");
                m1.changerCase(2, 4, "Eau");
                m1.changerCase(3, 4, "Eau");
                m1.changerCase(4, 1, "Ferme");
                m1.changerCase(4, 2, "Ferme");
                c.setMap(m1);
                lc.add(c);
            }
            if (f.getName().equals("34.jpg")) {
                c = new Decret(path + f.getName(),"<HTML> <p style='text-align:center;'> Gagnez huit points de réputation <br>pour chaque groupe de six <br>espaces de maison ou plus.</p> </HTML>");
                Map m1 = new Map(3, 2);
                m1.changerCase(0, 0, "Maison");
                m1.changerCase(0, 1, "Maison");
                m1.changerCase(1, 0, "Maison");
                m1.changerCase(1, 1, "Maison");
                m1.changerCase(2, 0, "Maison");
                m1.changerCase(2, 1, "Maison");
                c.setMap(m1);
                lc.add(c);
            }
            if (f.getName().equals("35.jpg")) {
                c = new Decret(path + f.getName(),"<HTML> <p style='text-align:center;'> Gagnez un point de réputation <br>pour chaque espace de maison <br>du plus grand groupe d'espace <br>de maison qui n'est pas <br>adjacent à un espace de montagne.</p> </HTML>");
                Map m1 = new Map(2, 4);
                m1.changerCase(0, 0, "Maison");
                m1.changerCase(0, 1, "Maison");
                m1.changerCase(1, 1, "Maison");
                m1.changerCase(1, 2, "Maison");
                m1.changerCase(1, 3, "Maison");
                c.setMap(m1);
                lc.add(c);
            }
            if (f.getName().equals("36.jpg")) {
                Map m1 = new Map(3, 3);
                c = new Decret(path + f.getName(),"<HTML> <p style='text-align:center;'> Gagnez trois points de réputation <br>pour chaque groupe d'espace <br>de maison qui est adjacent <br>à trois espaces typés <br>différent ou plus.</p> </HTML>");
                m1.changerCase(0, 2, "Montagne");
                m1.changerCase(1, 0, "Maison");
                m1.changerCase(1, 1, "Maison");
                m1.changerCase(1, 2, "Maison");
                m1.changerCase(2, 0, "Eau");
                m1.changerCase(2, 1, "Maison");
                m1.changerCase(2, 2, "Bois");
                c.setMap(m1);
                lc.add(c);
            }
            if (f.getName().equals("37.jpg")) {
                c = new Decret(path + f.getName(),"<HTML> <p style='text-align:center;'> Gagnez deux points de réputation <br>pour chaque espace de maison <br>du deuxième groupe d'espace <br>de maison le plus grand.</p> </HTML>");
                Map m1 = new Map(2, 4);
                m1.changerCase(0, 0, "Maison");
                m1.changerCase(0, 1, "Maison");
                m1.changerCase(1, 1, "Maison");
                m1.changerCase(1, 2, "Maison");
                m1.changerCase(1, 3, "Maison");
                c.setMap(m1);
                lc.add(c);
            }
            if (f.getName().equals("38.jpg")) {
                c = new Decret(path + f.getName(),"<HTML> <p style='text-align:center;'> Gagnez six points de réputation <br>pour chaque ligne ou <br>colonne complètement remplie <br>d'espaces typés.</p> </HTML>");
                Map m1 = new Map(3, 3);
                m1.changerCase(0, 0, "Montagne");
                m1.changerCase(0, 1, "Montagne");
                m1.changerCase(0, 2, "Montagne");
                m1.changerCase(1, 0, "Montagne");
                m1.changerCase(2, 0, "Montagne");
                c.setMap(m1);
                lc.add(c);
            }
            if (f.getName().equals("39.jpg")) {
                c = new Decret(path + f.getName(),"<HTML> <p style='text-align:center;'> Gagnez trois points de réputation <br>pour chaque espace le long <br>du côté du plus grand <br>carré d'espaces typés.</p> </HTML>");
                Map m1 = new Map(3, 3);
                m1.changerCase(0, 0, "Montagne");
                m1.changerCase(0, 1, "Montagne");
                m1.changerCase(1, 0, "Montagne");
                m1.changerCase(1, 1, "Montagne");
                c.setMap(m1);
                lc.add(c);
            }
            if (f.getName().equals("40.jpg")) {
                c = new Decret(path + f.getName(),"<HTML> <p style='text-align:center;'> Gagnez trois points de réputation <br>pour chaque diagonale complétement <br>remplies d'espaces typés touchant <br>le bord gauche et le <br>bas de la map.</p> </HTML>");
                Map m1 = new Map(3, 3);
                m1.changerCase(0, 0, "Montagne");
                m1.changerCase(0, 2, "Montagne");
                m1.changerCase(1, 1, "Montagne");
                m1.changerCase(2, 0, "Montagne");
                c.setMap(m1);
                lc.add(c);
            }
            if (f.getName().equals("41.jpg")) {
                c = new Decret(path + f.getName(),"<HTML> <p style='text-align:center;'> Gagnez un point de réputation <br>pour chaque espace vide entouré <br>d'espaces typés ou du bord <br>de la map sur chacun <br>de ses quatres côtés.</p> </HTML>");
                Map m1 = new Map(3, 3);
                m1.changerCase(0, 1, "Montagne");
                m1.changerCase(1, 0, "Montagne");
                m1.changerCase(1, 2, "Montagne");
                m1.changerCase(2, 1, "Montagne");
                c.setMap(m1);
                lc.add(c);
            }

        }

        Collections.shuffle(lc);
        return lc;
    }

    public ArrayList<Season> Saisons(){
        String path = "Cards/Season";  //Chemin du dossier des cartes
        File p=new File(pathImg + path);
        File[] dossier=p.listFiles(); //Liste contenant tous les dossiers du fichier dans le chemin de la variable chemin
        ArrayList<File> ls=new ArrayList<>();
        ArrayList<Season> lc=new ArrayList<>();

        assert dossier != null;
        Collections.addAll(ls, dossier);

        for (File i :ls){
            if (i.getName().equals("0Spring.png")){
                Season s = new Season(path + i.getName(),8,0);
                lc.add(s);
            }
            if (i.getName().equals("1Summer.png")){
                Season s = new Season(path + i.getName(),8,1);
                lc.add(s);
            }
            if (i.getName().equals("2Fall.png")){
                Season s = new Season(path + i.getName(),7,2);
                lc.add(s);
            }
            if (i.getName().equals("3Winter.png")){
                Season s = new Season(path + i.getName(),6,3);
                lc.add(s);
            }
        }

        return lc;
    }


    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public ArrayList<GameCard> getGameCards() {
        return gameCards;
    }

    public void setGameCards(ArrayList<GameCard> gameCards) {
        this.gameCards = gameCards;
    }

    public ArrayList<MonstreCard> getMonstreCards() {
        return monstreCards;
    }

    public void setMonstreCards(ArrayList<MonstreCard> monstreCards) {
        this.monstreCards = monstreCards;
    }

    public ArrayList<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(ArrayList<Season> seasons) {
        this.seasons = seasons;
    }

    public GameCard getImpossibleCard() {
        return impossibleCard;
    }

    public void setImpossibleCard(GameCard impossibleCard) {
        this.impossibleCard = impossibleCard;
    }


    public GameCard getCurrent_card() {
        return current_card;
    }

    public void setCurrent_card(GameCard current_card) {
        this.current_card = current_card;
    }

    public Player getCurrent_player() {
        return current_player;
    }

    public void setCurrent_player(Player current_player) {
        this.current_player = current_player;
    }

    public Season getCurrent_season() {
        return current_season;
    }

    public void setCurrent_season(Season current_season) {
        this.current_season = current_season;
    }
}
