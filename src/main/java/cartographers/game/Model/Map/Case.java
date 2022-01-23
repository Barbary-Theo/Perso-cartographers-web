package cartographers.game.Model.Map;

public class Case {

    private int x;
    private int y;
    private String type = "empty";
    private boolean check;


    public Case(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Case(int x, int y, String type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
