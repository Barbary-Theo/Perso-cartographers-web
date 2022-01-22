package cartographers.game.Model;

public class Player {

    private String name;
    private String title;
    private Map map = Map.initMap();


    public Player(String name, String title) {
        this.name = name;
        this.title = title;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
}
