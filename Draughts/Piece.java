package Draughts;

import java.util.ArrayList;

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
                "Co-ordinate: \"" + super.getX() + "," + super.getY() +
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

    public static void moveChooser(ArrayList<Piece> allPieces, Point move1, Point move2, Point move3, Point move4){
        for (Piece p:allPieces) {
            System.out.println("Choose your move!");
            // Move1 - Forward Left
            if (p.getX() != 1 && p.getY() != 8 && p.getColour().equals("black")) {
                move1.setX(p.getX() - 1);
                move1.setY(p.getY() + 1);
                System.out.println("Move 1: Move from " + p.getX() + "," + p.getY() + " to " + move1.toString());
            }
            else if (p.getX() != 8 && p.getY() != 1 && p.getColour().equals("brown")){
                move1.setX(p.getX() + 1);
                move1.setY(p.getY() - 1);
                System.out.println("Move 1: Move from " + p.getX() + "," + p.getY() + " to " + move1.toString());
            }
            else {
                System.out.println("Move 1: Invalid Move");
            }

            // Move2 - Forward Right
            if (p.getX() != 8 && p.getY() != 8 && p.getColour().equals("black")) {
                move2.setX(p.getX() + 1);
                move2.setY(p.getY() + 1);
                System.out.println("Move 2: Move from " + p.getX() + "," + p.getY() + " to " + move2.toString());
            }
            else if (p.getX() != 8 && p.getY() != 8 && p.getColour().equals("brown")) {
                move2.setX(p.getX() - 1);
                move2.setY(p.getY() - 1);
                System.out.println("Move 2: Move from " + p.getX() + "," + p.getY() + " to " + move2.toString());
            }
            else {
                System.out.println("Move 2: Invalid Move");
            }

            if (p.isKing() == true) {
                System.out.println("\nBecause you are a king you also have the following moves:");
                // Move3 - Backwards Left
                if (p.getX() != 1 && p.getY() != 1 && p.getColour().equals("black")) {
                    move3.setX(p.getX() - 1);
                    move3.setY(p.getY() - 1);
                    System.out.println("Move 3: Move from " + p.getX() + "," + p.getY() + " to " + move3.toString());
                }
                else if (p.getX() != 8 && p.getY() != 8 && p.getColour().equals("brown")) {
                    move3.setX(p.getX() + 1);
                    move3.setY(p.getY() + 1);
                    System.out.println("Move 3: Move from " + p.getX() + "," + p.getY() + " to " + move3.toString());
                }
                else {
                    System.out.println("Move 3: Invalid Move");
                }

                // Move4 - Backwards Right
                if (p.getX() != 8 && p.getY() != 1 && p.getColour().equals("black")) {
                    move4.setX(p.getX() + 1);
                    move4.setY(p.getY() - 1);
                    System.out.println("Move 4: Move from " + p.getX() + "," + p.getY() + " to " + move4.toString());
                }
                else if (p.getX() != 1 && p.getY() != 8 && p.getColour().equals("brown")) {
                    move4.setX(p.getX() - 1);
                    move4.setY(p.getY() + 1);
                    System.out.println("Move 4: Move from " + p.getX() + "," + p.getY() + " to " + move4.toString());
                }
                else {
                    System.out.println("Move 4: Invalid Move");
                }
            }
        }
    }

    public static void pieceChooser(ArrayList<Piece> allPieces){

    }

}
