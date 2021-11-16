package Draughts;

public class Piece extends Point {
    private int colour;
    private boolean isKing;
    private boolean isCaptured;

    public Piece(int x, int y, int colour, boolean isKing, boolean isCaptured) {
        super(x, y);
        this.colour = colour;
        this.isKing = isKing;
        this.isCaptured = isCaptured;
    }

    public String toString() {
        return "Piece: " +
                "Colour: " + getColour() +
                "Is a King: " + isKing +
                "Is Captured: " + isCaptured;
    }

    public int getColour() {
        return colour;
    }

    public void setColour(int colour) {
        this.colour = colour;
    }

    public boolean isKing() {
        return isKing;
    }

    public void setKing(boolean king) {
        isKing = king;
    }

    public boolean isCaptured() {
        return isCaptured;
    }

    public void setCaptured(boolean captured) {
        isCaptured = captured;
    }


}
