package cartographers.game.Model;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private static Game singleton;
    private List<Player> players;


    public Game() {}

    public Game(List<Player> players) {
        this.players = players;
    }


    /*
    Singleton instance
     */
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


    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
