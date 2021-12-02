package Draughts;

import javax.swing.*;
import java.util.ArrayList;

public class Validator {

    // Method checks if the point is on a black square.
    public static boolean isValidMove (Piece selectedPiece){
        boolean validPoint = false;

        // To fit with changes made for GUI the code used to draw the squared has been repurposed here.
        boolean white=true;
        for(int y1= 0;y1<8;y1++){
            for(int x1= 0;x1<8;x1++){
                if ((selectedPiece.getX()+64)/64 == x1 && (selectedPiece.getY()+64)/64 == y1){
                    validPoint =true;
                }
                white=!white;
            }
            white=!white;
        }
        if (validPoint == true){
            return true;
        }
        else {
            JOptionPane.showMessageDialog(null,"Invalid Move", "Invalid Move", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /*public static boolean moveIsValid (ArrayList<Piece> allPieces, Piece piece){
        int counter = 0;
        for (Piece p:allPieces){
            if (piece.getX() == p.getX() && piece.getY() == p.getY()){
                counter++;
            }
        }
        if (counter == 23){
            return false;
        }
        else {
            return true;
        }
    }

    public static boolean moveValidate(String chooseMove){
        int counter = 0;
        for (int i = 0; i < chooseMove.length(); i++){
            if (chooseMove.charAt(i) >= 0 && chooseMove.charAt(i) <= 9){
                counter++;
            }
        }
        if (counter == chooseMove.length() - 1){
            return true;
        }
        else {
            return false;
        }
    }*/

    // Checks if a point is within the valid number range.
    /*public static boolean isNumber(Point move){
        if ((move.getX() >= 1 && move.getX() <= 8) && (move.getY() >= 1 && move.getY() <= 8)){
            return true;
        }
        else {
            return false;
        }
    }*/

    // Checks if a square is free to jump onto.
    /*public static void pieceVerifier (ArrayList<Piece> allPieces, ArrayList<Piece> allBlackPieces, ArrayList<Piece> allBrownPieces, Player pl1, Player pl2, Point move1, Point move2, Point move3, Point move4, Point p) {
        int testt = 0;
        boolean m1Valid = false, m2Valid = false, m3Valid = false, m4Valid = false;
        //if (pl1.isTheirTurn() == true) {
            for (Piece pbl : allBlackPieces) {

                Piece.moveChooser(pbl, move1, move2, move3, move4);

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
                    testt++;
                    System.out.println(testt);

                    for (Piece p1 : allPieces) {
                        if (Validator.isNumber(move1) == true) {
                            if (p1.getX() == move1.getX() && p1.getY() == move1.getY()) {
                                System.out.println("M1 invalid");
                            }
                            //else {
                                m1Valid = true;
                            //}
                        }

                        if (Validator.isNumber(move2) == true) {
                            if (p1.getX() == move2.getX() && p1.getY() == move2.getY()) {
                                System.out.println("M2 invalid");
                            }
                            else {
                                m2Valid = true;
                            }
                        }

                        if (pbl.isKing() == true) {
                            if (Validator.isNumber(move3) == true || Validator.isNumber(move4) == true) {
                                if (Validator.isNumber(move3) == true) {
                                    if (p1.getX() == move3.getX()) {
                                        if (p1.getY() == move3.getY()) {
                                            System.out.println("M3 invalid");
                                            m3Valid = false;
                                        }
                                    }
                                    else {
                                        //m3Valid = true;
                                    }
                                }

                                if (Validator.isNumber(move4) == true) {
                                    if (p1.getX() == move4.getX()) {
                                        if (p1.getY() == move4.getY()) {
                                            System.out.println("M4 invalid");
                                            m4Valid = false;
                                        }
                                    }
                                    else {
                                        //m4Valid = true;
                                    }
                                }

                            }
                        }
                    }
                }
                if (pbl.getX() == p.getX() && pbl.getY() == p.getY()){
                    System.out.println("\nfinished.");
                    if (m1Valid == true || m2Valid == true || m3Valid == true || m4Valid == true){
                        pbl.setHasValidMove(true);
                        System.out.println("true");
                    }
                    break;
                }
            }
        //} else if (pl2.isTheirTurn() == true) {
            for (Piece pbr : allBrownPieces) {

                Piece.moveChooser(pbr, move1, move2, move3, move4);

                if (Validator.isNumber(move1) == true || Validator.isNumber(move2) == true || Validator.isNumber(move3) == true || Validator.isNumber(move4) == true) {
                    System.out.println("\n" + pbr.getX() + "," + pbr.getY());
                    System.out.println("Move1: " + move1.toString());
                    System.out.println("Move2: " + move2.toString());
                    if (pbr.isKing() == true) {
                        System.out.println("Move3: " + move3.toString());
                        System.out.println("Move4: " + move4.toString());
                    }
                    testt++;
                    System.out.println(testt);

                    for (Piece p1 : allPieces) {
                        if (p1.getX() == move1.getX()) {
                            if (p1.getY() == move1.getY()) {
                                System.out.println("M1 invalid");
                                m1Valid = false;
                            }
                        }
                        if (p1.getX() == move2.getX()) {
                            if (p1.getY() == move2.getY() || move2.getY() < 1 || move2.getX() > 8) {
                                System.out.println("M2 invalid");
                                m2Valid = false;
                            }
                        }
                        if (pbr.isKing() == true) {
                            if (Validator.isNumber(move3) == true || Validator.isNumber(move4) == true) {
                                if (Validator.isNumber(move3) == true) {
                                    if (p1.getX() == move3.getX()) {
                                        if (p1.getY() == move3.getY()) {
                                            System.out.println("M3 invalid");
                                            m3Valid = false;
                                        }
                                    }
                                }
                                if (Validator.isNumber(move4) == true) {
                                    if (p1.getX() == move4.getX()) {
                                        if (p1.getY() == move4.getY()) {
                                            System.out.println("M4 invalid");
                                            m4Valid = false;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (pbr.getX() == p.getX() && pbr.getY() == p.getY()){
                    System.out.println("\nfinished.");
                    if (m1Valid == true || m2Valid == true){
                        pbr.setHasValidMove(true);
                    }
                    break;
                }
            }
       // }
    }*/

    public static boolean isValidName(String name){
        boolean valid = false;
        for (int i = 0; i < name.length(); i++){
            name = name.toUpperCase();
            if ((name.charAt(i) >= 'A' && name.charAt(i) <= 'Z') || (name.charAt(i) >= 0 && name.charAt(i) <= 9)){
                valid = true;
            }
        }
        if (valid == true){
            return true;
        }
        else {
            return false;
        }
    }
}
