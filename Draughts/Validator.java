package Draughts;

import java.util.ArrayList;

public class Validator {

    // Method checks if the point is a valid black square on the board.
    public static void isValidPoint (ArrayList<Point> allPoints, ArrayList<Piece> allPieces){
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

    public static void moveChooser(ArrayList<Point> allPoints, ArrayList<Piece> allPieces, Point move1, Point move2, Point move3, Point move4){

    }


}
