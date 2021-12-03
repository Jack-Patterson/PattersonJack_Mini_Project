package Draughts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class identifies pieces on a draughts board.
 * There are 12 pieces per player.
 * It inherits its x and y value from the "Point" class.
 * It implements serializable so that it can be written to a file.
 *
 * @author Jack Patterson
 */
public class Piece extends Point implements Serializable {
    /**
     * It defines the colour of a piece
     */
    private String colour;
    /**
    It determines whether a piece is a king.
     */
    private boolean isKing;
    /**
     * It determines if a piece is captured.
     */
    private boolean isCaptured;
    /**
     * It determines whether there is a valid move for a piece.
     */
    private boolean hasValidMove;

    /**
     *Creates a piece with the given variables.
     * It should contain information for all variables.
     * @param x is the x value of the piece.
     * @param y is the y value of the piece.
     * @param colour is the colour of the piece. Is only black or brown.
     * @param isKing determines whether a piece is a king.
     * @param isCaptured determines whether a piece is captured.
     * @param hasValidMove determines whether a piece has a valid move.
     */
    public Piece(int x, int y, String colour, boolean isKing, boolean isCaptured, boolean hasValidMove) {
        super(x, y);
        setColour(colour);
        setKing(isKing);
        setCaptured(isCaptured,null);
        setHasValidMove(hasValidMove);
    }

    /**
     * It displays the information of a piece as a String value.
     * @return a string specifying the state of a piece.
     */
    public String toString() {
        return "Piece: " +
                "Co-ordinate: \"" + super.getX() + "," + super.getY() +
                "\" Colour: " + getColour() +
                " Is a King: " + isKing() +
                " Is Captured: " + isCaptured();
    }

    /**
     * Returns the colour of a piece.
     * Can only be brown or black.
     * @return the colour of a piece.
     */
    public String getColour() {
        return colour;
    }

    /**
     * Sets the colour of a piece.
     * Is only black or brown.
     * @param colour is defined.
     */
    public void setColour(String colour) {
        this.colour = colour;
    }

    /**
     * Returns whether a piece is a king.
     * @return true or false for if a piece is a king.
     */
    public boolean isKing() {
        return isKing;
    }

    /**
     * Sets the value of a piece whether it is or isn't a king.
     * @param king is made either true or false.
     */
    public void setKing(boolean king) {
        isKing = king;
    }

    /**
     * Returns a boolean whether a piece is captured or not.
     * @return true or false whether a piece is captured.
     */
    public boolean isCaptured() {
        return isCaptured;
    }

    /**
     * Sets whether a piece is captured.
     * If a piece is captured it's removed from the "allPieces" ArrayList.
     * @param isCaptured is set either true or false.
     * @param allPieces is used to remove the piece from the ArrayList.
     */
    //modified by JB to ensure setCaptured() knows about the array-list of pieces and can therefore pass
    //on this information to removePiece()
    public void setCaptured(boolean isCaptured, ArrayList<Piece> allPieces) {
        this.isCaptured= isCaptured;
        if (isCaptured == true){
            removePiece(this, allPieces); //modified by JB
        }
    }

    /**
     * Returns whether a piece has a valid move.
     * @return if piece has a valid move.
     */
    public boolean isHasValidMove() {
        return hasValidMove;
    }

    /**
     * Sets whether a piece has a valid move o not.
     * @param hasValidMove is made true or false.
     */
    public void setHasValidMove(boolean hasValidMove) {
        this.hasValidMove = hasValidMove;
    }

    /**
     * Is used to get a piece from the ArrayList allPieces to get the x and y value of the piece from where the player clicks.
     * @param x is the x value of where the player clicked.
     * @param y is the y value of where the player clicked.
     * @param allPieces is the ArrayList which contains all pieces and is searched.
     * @return the piece whos x and y values match the selected area. It is then moved to where the mouse is dragged.
     */
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

    /**
     * Is a method to move the piece once the mouse is released.
     * It also verifies whether a piece has reached a valid place to be kinged and if it is calls a method to do so.
     * @param x is the x value of the place the mouse is released.
     * @param y is the y value of the place the mouse is released.
     * @param allPieces is the ArrayList which contains all pieces and is searched.
     * @param allPlayers is the ArrayList which contains all players and is searched.
     */
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

    /**
     * Removes the piece if it is taken.
     * @param p is the piece which is being removed.
     * @param allPieces is the ArrayList which contains all pieces and is searched.
     */
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

    /**
     * Used to get an ArrayList of all black pieces.
     * @param allBlackPieces is the ArrayList being filled.
     * @return all the black Pieces into this array.
     */
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

    /**
     * Used to get an ArrayList of all browm pieces.
     * @param allBrownPieces is the ArrayList being filled.
     * @return all the brown Pieces into this array.
     */
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

    /**
     * Paints the king piece onto the board.
     * @param p is the piece being kinged.
     * @return the method being true.
     */
    public static boolean paintKing (Piece p){
        if (p.isKing == true){
            return true;
        }
        else {
            return false;
        }
    }

}
