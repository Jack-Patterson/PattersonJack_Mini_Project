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

    public static void moveChooser(ArrayList<Piece> allPieces, Piece p, Point move1, Point move2, Point move3, Point move4){
            //System.out.println("Choose your move!");
            // Move1 - Forward Left
            if (p.getX() != 1 && p.getY() != 8 && p.getColour().equals("black")) {
                move1.setX(p.getX() - 1);
                move1.setY(p.getY() + 1);
                //System.out.println("Move 1: Move from " + p.getX() + "," + p.getY() + " to " + move1.toString());
            }
            else if (p.getX() != 8 && p.getY() != 1 && p.getColour().equals("brown")){
                move1.setX(p.getX() + 1);
                move1.setY(p.getY() - 1);
                //System.out.println("Move 1: Move from " + p.getX() + "," + p.getY() + " to " + move1.toString());
            }
            else {
                move1.setX(0);
                move1.setY(0);
            }

            // Move2 - Forward Right
            if (p.getX() != 8 && p.getY() != 8 && p.getColour().equals("black")) {
                move2.setX(p.getX() + 1);
                move2.setY(p.getY() + 1);
                //System.out.println("Move 2: Move from " + p.getX() + "," + p.getY() + " to " + move2.toString());
            }
            else if (p.getX() != 1 && p.getY() != 1 && p.getColour().equals("brown")) {
                move2.setX(p.getX() - 1);
                move2.setY(p.getY() - 1);
                //System.out.println("Move 2: Move from " + p.getX() + "," + p.getY() + " to " + move2.toString());
            }
            else {
                move2.setX(0);
                move2.setY(0);
            }

            if (p.isKing() == true) {
                //System.out.println("\nBecause you are a king you also have the following moves:");
                // Move3 - Backwards Left
                if (p.getX() != 1 && p.getY() != 1 && p.getColour().equals("black")) {
                    move3.setX(p.getX() - 1);
                    move3.setY(p.getY() - 1);
                    //System.out.println("Move 3: Move from " + p.getX() + "," + p.getY() + " to " + move3.toString());
                }
                else if (p.getX() != 8 && p.getY() != 8 && p.getColour().equals("brown")) {
                    move3.setX(p.getX() + 1);
                    move3.setY(p.getY() + 1);
                    //System.out.println("Move 3: Move from " + p.getX() + "," + p.getY() + " to " + move3.toString());
                }
                else {
                    move3.setX(0);
                    move4.setY(0);
                }

                // Move4 - Backwards Right
                if (p.getX() != 8 && p.getY() != 1 && p.getColour().equals("black")) {
                    move4.setX(p.getX() + 1);
                    move4.setY(p.getY() - 1);
                    //System.out.println("Move 4: Move from " + p.getX() + "," + p.getY() + " to " + move4.toString());
                }
                else if (p.getX() != 1 && p.getY() != 8 && p.getColour().equals("brown")) {
                    move4.setX(p.getX() - 1);
                    move4.setY(p.getY() + 1);
                    //System.out.println("Move 4: Move from " + p.getX() + "," + p.getY() + " to " + move4.toString());
                }
                else {
                    move1.setX(5);
                    move1.setY(5);
                }
            }
        }

    public static void pieceChooser(ArrayList<Piece> allPieces, ArrayList<Piece> allBlackPieces, ArrayList<Piece> allBrownPieces, Player pl1, Player pl2, Point move1, Point move2, Point move3, Point move4){
        int test = 0;
        if (pl1.isTheirTurn() == true){
            for (Piece pbl:allBlackPieces) {
                Piece.moveChooser(allPieces, pbl, move1, move2, move3, move4);

                if (Validator.isNumber(move1) == true || Validator.isNumber(move2) == true) {
                    System.out.println("\n" + pbl.getX() + "," + pbl.getY());
                    System.out.println("Move1: " + move1.toString());
                    System.out.println("Move2: " + move2.toString());
                    if (pbl.isKing() == true) {
                        if (Validator.isNumber(move3) == true || Validator.isNumber(move4) == true) {
                            System.out.println("Move3: " + move3.toString());
                            System.out.println("Move4: " + move4.toString());
                        }
                    }
                    test++;
                    System.out.println(test);

                    for (Piece p1:allPieces) {
                        if (Validator.isNumber(move1) == true) {
                            if (p1.getX() == move1.getX()) {
                                if (p1.getY() == move1.getY()) {
                                    System.out.println("M1 invalid");
                                }
                            }
                        }
                        if (Validator.isNumber(move2) == true) {
                            if (p1.getX() == move2.getX() || move2.getX() > 8) {
                                if (p1.getY() == move2.getY() || move2.getY() > 8) {
                                    System.out.println("M2 invalid");
                                }
                            }
                        }
                        if (pbl.isKing() == true){
                            if (Validator.isNumber(move3) == true || Validator.isNumber(move4) == true) {
                                if (Validator.isNumber(move3) == true) {
                                    if (p1.getX() == move3.getX()) {
                                        if (p1.getY() == move3.getY()) {
                                            System.out.println("M3 invalid");
                                        }
                                    }
                                }
                                if (Validator.isNumber(move4) == true) {
                                    if (p1.getX() == move4.getX()) {
                                        if (p1.getY() == move4.getY()) {
                                            System.out.println("M4 invalid");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }
        else if (pl2.isTheirTurn() == true){
            for (Piece pbr:allBrownPieces) {
                Piece.moveChooser(allPieces, pbr, move1, move2, move3, move4);

                if (Validator.isNumber(move1) == true || Validator.isNumber(move2) == true || Validator.isNumber(move3) == true || Validator.isNumber(move4) == true) {
                    System.out.println("\n" + pbr.getX() + "," + pbr.getY());
                    System.out.println("Move1: " + move1.toString());
                    System.out.println("Move2: " + move2.toString());
                    if (pbr.isKing() == true) {
                        System.out.println("Move3: " + move3.toString());
                        System.out.println("Move4: " + move4.toString());
                    }
                    test++;
                    System.out.println(test);

                    for (Piece p1:allPieces) {
                        if (p1.getX() == move1.getX()) {
                            if (p1.getY() == move1.getY()) {
                                System.out.println("M1 invalid");
                            }
                        }
                        if (p1.getX() == move2.getX()) {
                            if (p1.getY() == move2.getY() || move2.getY() < 1 || move2.getX() > 8) {
                                System.out.println("M2 invalid");
                            }
                        }
                        if (pbr.isKing() == true){
                            if (Validator.isNumber(move3) == true || Validator.isNumber(move4) == true) {
                                if (Validator.isNumber(move3) == true) {
                                    if (p1.getX() == move3.getX()) {
                                        if (p1.getY() == move3.getY()) {
                                            System.out.println("M3 invalid");
                                        }
                                    }
                                }
                                if (Validator.isNumber(move4) == true) {
                                    if (p1.getX() == move4.getX()) {
                                        if (p1.getY() == move4.getY()) {
                                            System.out.println("M4 invalid");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }
    }

}
