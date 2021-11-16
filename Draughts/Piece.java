package Draughts;

public class Piece extends Point {
    private String colour;
    private boolean isKing;
    private boolean isCaptured;

    public Piece(int x, int y, String colour, boolean isKing, boolean isCaptured) {
        super(x, y);
        setColour(colour);
        setKing(isKing);
        setCaptured(isCaptured);
    }

    public String toString() {
        return "Piece: " +
                "Co-ordinate: \"" + x + "," + y +
                "\" Colour: " + getColour() +
                " Is a King: " + isKing() +
                " Is Captured: " + isCaptured();
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
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
