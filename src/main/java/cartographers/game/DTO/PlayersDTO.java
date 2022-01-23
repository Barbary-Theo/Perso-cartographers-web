package cartographers.game.DTO;

import cartographers.game.Model.Player;

import java.util.List;

public class PlayersDTO {

    private List<Player> players;


    public PlayersDTO() {}

    public PlayersDTO(List<Player> players) {
        this.players = players;
    }


    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public String toString(){
        return ' ' + players.get(0).getName();
    }

}
