package Draughts;

public class Point {
    protected int x;
    protected int y;

    public Point(int x, int y) {
        setX(x);
        setY(y);
    }

    public Point(){
        setX(0);
        setY(0);
    }

    public String toString() {
        return getX() + "," + getY();
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
}
