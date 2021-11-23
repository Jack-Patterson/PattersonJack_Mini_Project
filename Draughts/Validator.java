package Draughts;

import java.util.ArrayList;

public class Validator {

    // Method checks if the point is a valid black square on the board.
    public static void isValidPointArray (ArrayList<Point> allPoints, ArrayList<Piece> allPieces){
        boolean validPoint = false;
        for (Point po:allPoints){
            for (Piece p: allPieces) {
                if (po.getX() == p.getX() && po.getY() == p.getY()) {
                    validPoint = true;
                    break;
                }
            }
        }
        if (validPoint == true){
            System.out.println("Valid");
        }
        else {
            System.out.println("Invalid");
        }
    }

    public static void isValidPoint (ArrayList<Point> allPoints, Point move){
        boolean validPoint = false;
        for (Point po:allPoints){
            if (po.getX() == move.getX() && po.getY() == move.getY()) {
                validPoint = true;
                break;
            }
        }
        if (validPoint == true){
            System.out.println("Valid");
        }
        else {
            System.out.println("Invalid");
        }
    }

    public static boolean moveIsValid (ArrayList<Piece> allPieces, Piece piece){
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

    public static boolean chooseMoveValidate(String chooseMove){
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
    }

    public static boolean isNumber(Point move){
        if ((move.getX() >= 1 && move.getX() <= 8) && (move.getY() >= 1 && move.getY() <= 8)){
            return true;
        }
        else {
            return false;
        }
    }


}
