package Draughts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.ArrayList;

public class Piece extends Point implements Serializable {
    private String colour;
    private boolean isKing;
    private boolean isCaptured, hasValidMove;

    public Piece(int x, int y, String colour, boolean isKing, boolean isCaptured, boolean hasValidMove) {
        super(x, y);
        setColour(colour);
        setKing(isKing);
        setCaptured(isCaptured,null);
        setHasValidMove(hasValidMove);
    }

    public Piece() {
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

    //modified by JB to ensure setCaptured() knows about the array-list of pieces and can therefore pass
    //on this information to removePiece()
    public void setCaptured(boolean isCaptured, ArrayList<Piece> allPieces) {
        this.isCaptured= isCaptured;
        if (isCaptured == true){
            removePiece(this, allPieces); //modified by JB
        }
    }

    public boolean isHasValidMove() {
        return hasValidMove;
    }

    public void setHasValidMove(boolean hasValidMove) {
        this.hasValidMove = hasValidMove;
    }

    public static Piece getPiece(int x, int y, ArrayList<Piece> allPieces){
        int x2 = (x+64)/64;
        int y2 = (y+10)/64;
        for (Piece p: allPieces){
            if (p.getX() == x2 && p.getY() == y2){
                return p;

            }
        }
        return null;
    }

    public void move(int x, int y, ArrayList<Piece> allPieces, ArrayList<Player> allPlayers){
        for (Piece p: allPieces){
            if (p.getX() == x && p.getY() == y){
                if (p == this){

                }
                else {
                    p.setCaptured(true, allPieces); //modified by JB so that setCaptured() knows about the array-list
                    break; //JB added a break here to prevent a concurrent modification exception
                }
            }
        }
        for (Player pl: allPlayers) {
            int increment = 1;
            int isBlack = 0;

            if (this.getColour().equalsIgnoreCase("Black")) {
                if (this.getY() == 1) {
                    for (Piece p : allPieces) {
                        if (p == this) {
                            p.setKing(true);
                            this.setKing(true);
                            paintKing(this);
                        }
                    }
                }
            }
            else if (this.getColour().equalsIgnoreCase("Brown")) {
                if (this.getY() == 8) {
                    for (Piece p : allPieces) {
                        if (p == this) {
                            p.setKing(true);
                            this.setKing(true);
                            paintKing(this);
                        }
                    }
                }
            }
            Player pl1 = new Player();
            Player pl2 = new Player();
            Player player = new Player();

            Player.setPlayer(this,pl1,pl2);
            if (pl1.isPlayerTurn() == true){
                player = pl1;
            }
            else {
                player = pl2;
            }
            JOptionPane.showMessageDialog(null, "Congratulations on being kinged" + player, "King me", JOptionPane.INFORMATION_MESSAGE);
        }

        this.setX(x);
        this.setY(y);
    }

    //JB modified the method so that it can take the array-list of pieces as an argument
    public static void removePiece (Piece p, ArrayList<Piece> allPieces){
        //ArrayList<Piece> allPieces = new ArrayList<Piece>(); //commented out by JB as no longer required
        //allPieces = getAllPieces(allPieces); //commented out by JB as no longer required
        ArrayList<Piece> allBlackPieces = new ArrayList<Piece>();
        allBlackPieces = getAllBlackPieces(allBlackPieces);
        ArrayList<Piece> allBrownPieces = new ArrayList<Piece>();
        allBrownPieces = getAllBrownPieces(allBrownPieces);

        allPieces.remove(p);

        if (p.getColour().equalsIgnoreCase("black")){
            allBlackPieces.remove(p);
        }
        else if (p.getColour().equalsIgnoreCase("brown")){
            allBrownPieces.remove(p);
        }
    }

    // Gets the valid moves that an be done by a piece in each direction.
    public static void moveChooser(Piece p, Point move1, Point move2, Point move3, Point move4){
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

    //JB - don't need this method at all now as you are able to access the array-list of pieces by passing it
    //from the GUI class itself (as you had been doing anyway)

    /*public static ArrayList<Piece> getAllPieces (ArrayList<Piece> allPieces){
        Piece pbr1 = new Piece(2, 1, "brown", false, false, true);
        Piece pbr2 = new Piece(2, 3, "brown", false, false, true);
        Piece pbr3 = new Piece(1, 2, "brown", false, false, true);
        Piece pbr4 = new Piece(4, 1, "brown", false, false, true);
        Piece pbr5 = new Piece(4, 3, "brown", false, false, true);
        Piece pbr6 = new Piece(3, 2, "brown", false, false, true);
        Piece pbr7 = new Piece(6, 1, "brown", true, false, true);
        Piece pbr8 = new Piece(6, 3, "brown", false, false, true);
        Piece pbr9 = new Piece(5, 2, "brown", false, false, true);
        Piece pbr10 = new Piece(8, 1, "brown", false, false, true);
        Piece pbr11 = new Piece(8, 3, "brown", false, false, true);
        Piece pbr12 = new Piece(7, 2, "brown", false, false, true);
        Piece pbl1 = new Piece(2, 7,  "black", false, false, true);
        Piece pbl2 = new Piece(1, 8,  "black", false, false, true);
        Piece pbl3 = new Piece(1, 6,  "black", false, false, true);
        Piece pbl4 = new Piece(4, 7,  "black", false, false, true);
        Piece pbl5 = new Piece(3, 8,  "black", false, false, true);
        Piece pbl6 = new Piece(3, 6,  "black", false, false, true);
        Piece pbl7 = new Piece(6, 7,  "black", false, false, true);
        Piece pbl8 = new Piece(5, 6,  "black", false, false, true);
        Piece pbl9 = new Piece(5, 8,  "black", false, false, true);
        Piece pbl10 = new Piece(8, 7, "black", false, false, true);
        Piece pbl11 = new Piece(7, 6, "black", false, false, true);
        Piece pbl12 = new Piece(7, 8, "black", false, false, true);
        allPieces.add(pbl1);
        allPieces.add(pbl2);
        allPieces.add(pbl3);
        allPieces.add(pbl4);
        allPieces.add(pbl5);
        allPieces.add(pbl6);
        allPieces.add(pbl7);
        allPieces.add(pbl8);
        allPieces.add(pbl9);
        allPieces.add(pbl10);
        allPieces.add(pbl11);
        allPieces.add(pbl12);
        allPieces.add(pbr1);
        allPieces.add(pbr2);
        allPieces.add(pbr3);
        allPieces.add(pbr4);
        allPieces.add(pbr5);
        allPieces.add(pbr6);
        allPieces.add(pbr7);
        allPieces.add(pbr8);
        allPieces.add(pbr9);
        allPieces.add(pbr10);
        allPieces.add(pbr11);
        allPieces.add(pbr12);
        return allPieces;
    }*/

    public static ArrayList<Piece> getAllBlackPieces (ArrayList<Piece> allBlackPieces){
        Piece pbl1 = new Piece(2, 7,  "black", false, false, true);
        Piece pbl2 = new Piece(1, 8,  "black", false, false, true);
        Piece pbl3 = new Piece(1, 6,  "black", false, false, true);
        Piece pbl4 = new Piece(4, 7,  "black", false, false, true);
        Piece pbl5 = new Piece(3, 8,  "black", false, false, true);
        Piece pbl6 = new Piece(3, 6,  "black", false, false, true);
        Piece pbl7 = new Piece(6, 7,  "black", false, false, true);
        Piece pbl8 = new Piece(5, 6,  "black", false, false, true);
        Piece pbl9 = new Piece(5, 8,  "black", false, false, true);
        Piece pbl10 = new Piece(8, 7, "black", false, false, true);
        Piece pbl11 = new Piece(7, 6, "black", false, false, true);
        Piece pbl12 = new Piece(7, 8, "black", false, false, true);
        allBlackPieces.add(pbl1);
        allBlackPieces.add(pbl2);
        allBlackPieces.add(pbl3);
        allBlackPieces.add(pbl4);
        allBlackPieces.add(pbl5);
        allBlackPieces.add(pbl6);
        allBlackPieces.add(pbl7);
        allBlackPieces.add(pbl8);
        allBlackPieces.add(pbl9);
        allBlackPieces.add(pbl10);
        allBlackPieces.add(pbl11);
        allBlackPieces.add(pbl12);
        return allBlackPieces;
    }

    public static ArrayList<Piece> getAllBrownPieces (ArrayList<Piece> allBrownPieces){
        Piece pbr1 = new Piece(2, 1, "brown", false, false, true);
        Piece pbr2 = new Piece(2, 3, "brown", false, false, true);
        Piece pbr3 = new Piece(1, 2, "brown", false, false, true);
        Piece pbr4 = new Piece(4, 1, "brown", false, false, true);
        Piece pbr5 = new Piece(4, 3, "brown", false, false, true);
        Piece pbr6 = new Piece(3, 2, "brown", false, false, true);
        Piece pbr7 = new Piece(6, 1, "brown", true, false, true);
        Piece pbr8 = new Piece(6, 3, "brown", false, false, true);
        Piece pbr9 = new Piece(5, 2, "brown", false, false, true);
        Piece pbr10 = new Piece(8, 1, "brown", false, false, true);
        Piece pbr11 = new Piece(8, 3, "brown", false, false, true);
        Piece pbr12 = new Piece(7, 2, "brown", false, false, true);
        allBrownPieces.add(pbr1);
        allBrownPieces.add(pbr2);
        allBrownPieces.add(pbr3);
        allBrownPieces.add(pbr4);
        allBrownPieces.add(pbr5);
        allBrownPieces.add(pbr6);
        allBrownPieces.add(pbr7);
        allBrownPieces.add(pbr8);
        allBrownPieces.add(pbr9);
        allBrownPieces.add(pbr10);
        allBrownPieces.add(pbr11);
        allBrownPieces.add(pbr12);
        return allBrownPieces;
    }

    public static boolean paintKing (Piece p){
        if (p.isKing == true){
            return true;
        }
        else {
            return false;
        }
    }

}
