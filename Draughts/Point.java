package Draughts;

public class Point {
    protected int x;
    protected int y;

    public Point(int x, int y) {
        setX(x);
        setY(y);
    }

    public String toString() {
        return "Point :" +
                "X: " + getX() +
                "Y: " + getY();
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
