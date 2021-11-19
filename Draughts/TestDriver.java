package Draughts;

import java.util.ArrayList;
import java.util.Scanner;

public class TestDriver {
    public static void main(String[] args) {
        int turnCounter = 0;

        Player pl1 = new Player("Test Name 1", "black", false);
        Player pl2 = new Player("Test Name 2", "brown", false);

        Piece pbl1 = new Piece(2, 2, "brown", false, false);
        Piece pbl2 = new Piece(2, 2, "brown", false, false);
        Piece pbl3 = new Piece(2, 2, "brown", false, false);
        Piece pbl4 = new Piece(2, 2, "brown", false, false);
        Piece pbl5 = new Piece(2, 2, "brown", false, false);
        Piece pbl6 = new Piece(2, 2, "brown", false, false);
        Piece pbl7 = new Piece(2, 2, "brown", false, false);
        Piece pbl8 = new Piece(2, 2, "brown", false, false);
        Piece pbl9 = new Piece(2, 2, "brown", false, false);
        Piece pbl10 = new Piece(2, 2, "brown", false, false);
        Piece pbl11 = new Piece(2, 2, "brown", false, false);
        Piece pbl12 = new Piece(2, 2, "brown", false, false);
        Piece pbr1 = new Piece(2, 2, "brown", false, false);
        Piece pbr2 = new Piece(2, 2, "brown", false, false);
        Piece pbr3 = new Piece(2, 2, "brown", false, false);
        Piece pbr4 = new Piece(2, 2, "brown", false, false);
        Piece pbr5 = new Piece(2, 2, "brown", false, false);
        Piece pbr6 = new Piece(2, 2, "brown", false, false);
        Piece pbr7 = new Piece(2, 2, "brown", false, false);
        Piece pbr8 = new Piece(2, 2, "brown", false, false);
        Piece pbr9 = new Piece(2, 2, "brown", false, false);
        Piece pbr10 = new Piece(2, 2, "brown", false, false);
        Piece pbr11 = new Piece(2, 2, "brown", false, false);
        Piece pbr12 = new Piece(2, 2, "brown", false, false);

        ArrayList<Piece> allPieces = new ArrayList<Piece>();
        ArrayList<Piece> allBlackPieces = new ArrayList<Piece>();
        ArrayList<Piece> allBrownPieces = new ArrayList<Piece>();

        ArrayList<Point> allPoints = new ArrayList<Point>();
        Point po1 = new Point(1,1);
        Point po3 = new Point(1,3);
        Point po2 = new Point(1,5);
        Point po4 = new Point(1,7);
        Point po5 = new Point(2,2);
        Point po6 = new Point(2,4);
        Point po7 = new Point(2,6);
        Point po8 = new Point(2,8);
        Point po9 = new Point(3,1);
        Point po10 = new Point(3,3);
        Point po11 = new Point(3,5);
        Point po12 = new Point(3,7);
        Point po13 = new Point(4,2);
        Point po14 = new Point(4,4);
        Point po15 = new Point(4,6);
        Point po16 = new Point(4,8);
        Point po17 = new Point(5,1);
        Point po18 = new Point(5,3);
        Point po19 = new Point(5,5);
        Point po20 = new Point(5,7);
        Point po21 = new Point(6,2);
        Point po22 = new Point(6,4);
        Point po23 = new Point(6,6);
        Point po24 = new Point(6,8);
        Point po25 = new Point(7,1);
        Point po26 = new Point(7,3);
        Point po27 = new Point(7,5);
        Point po28 = new Point(7,7);
        Point po29 = new Point(8,2);
        Point po30 = new Point(8,4);
        Point po31 = new Point(8,6);
        Point po32 = new Point(8,8);

        Point move1 = new Point();
        Point move2 = new Point();
        Point move3 = new Point();
        Point move4 = new Point();

        AllPoints(allPoints, po1, po3, po2, po4, po5, po6, po7, po8, po9, po10, po11, po12, po13, po14, po15, po16, po17, po19, po18, po20, po21, po22, po23, po24, po25, po26, po27, po28, po29, po30, po31, po32);
        AllPieces(allPieces, pbl1, pbl2, pbl3, pbl4, pbl5, pbl6, pbl7, pbl8, pbl9, pbl10, pbl11, pbl12, pbr1, pbr2, pbr3, pbr4, pbr5, pbr6, pbr7, pbr8, pbr9, pbr10, pbr11, pbr12);
        AllBlackPieces(allBlackPieces, pbl1, pbl2, pbl3, pbl4, pbl5, pbl6, pbl7, pbl8, pbl9, pbl10, pbl11, pbl12);
        AllBrownPieces(allBrownPieces, pbr1, pbr2, pbr3, pbr4, pbr5, pbr6, pbr7, pbr8, pbr9, pbr10, pbr11, pbr12);
        Validator.isValidPointArray(allPoints, allPieces);

        boolean gameOver = false;
        while (gameOver){
            Player.isPlayerTurn(pl1, pl2, turnCounter);






        }

        Piece.moveChooser(allPieces,move1,move2,move3,move4);
        String chooseMove = "";
        Scanner input = new Scanner(System.in);
        System.out.println("Please choose a move:");
            chooseMove = input.nextLine();
            int moveChosen = Integer.parseInt(chooseMove);
        switch (moveChosen){
            case 1:
                System.out.println(move1.toString());
                break;
            case 2:
                System.out.println(move2.toString());
                break;
            case 3:
                System.out.println(move3.toString());
                break;
            case 4:
                System.out.println(move4.toString());
                break;
        }

    }



    private static void AllPoints(ArrayList<Point> allPoints, Point po1, Point po3, Point po2, Point po4, Point po5, Point po6, Point po7, Point po8, Point po9, Point po10, Point po11, Point po12, Point po13, Point po14, Point po15, Point po16, Point po17, Point po18, Point po19, Point po20, Point po21, Point po22, Point po23, Point po24, Point po25, Point po26, Point po27, Point po28, Point po29, Point po30, Point po31, Point po32) {
        allPoints.add(po1);
        allPoints.add(po2);
        allPoints.add(po3);
        allPoints.add(po4);
        allPoints.add(po5);
        allPoints.add(po6);
        allPoints.add(po7);
        allPoints.add(po8);
        allPoints.add(po9);
        allPoints.add(po10);
        allPoints.add(po11);
        allPoints.add(po12);
        allPoints.add(po13);
        allPoints.add(po14);
        allPoints.add(po15);
        allPoints.add(po16);
        allPoints.add(po17);
        allPoints.add(po18);
        allPoints.add(po19);
        allPoints.add(po20);
        allPoints.add(po21);
        allPoints.add(po22);
        allPoints.add(po23);
        allPoints.add(po24);
        allPoints.add(po25);
        allPoints.add(po26);
        allPoints.add(po27);
        allPoints.add(po28);
        allPoints.add(po29);
        allPoints.add(po30);
        allPoints.add(po31);
        allPoints.add(po32);
    }

    private static void AllPieces (ArrayList<Piece> allPieces, Piece pbl1, Piece pbl2, Piece pbl3, Piece pbl4, Piece pbl5, Piece pbl6, Piece pbl7, Piece pbl8, Piece pbl9, Piece pbl10, Piece pbl11, Piece pbl12, Piece pbr1, Piece pbr2, Piece pbr3, Piece pbr4, Piece pbr5, Piece pbr6, Piece pbr7, Piece pbr8, Piece pbr9, Piece pbr10, Piece pbr11, Piece pbr12){
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
    }

    private static void AllBlackPieces (ArrayList<Piece> allBlackPieces, Piece pbl1, Piece pbl2, Piece pbl3, Piece pbl4, Piece pbl5, Piece pbl6, Piece pbl7, Piece pbl8, Piece pbl9, Piece pbl10, Piece pbl11, Piece pbl12){
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
    }

    private static void AllBrownPieces (ArrayList<Piece> allBrownPieces, Piece pbr1, Piece pbr2, Piece pbr3, Piece pbr4, Piece pbr5, Piece pbr6, Piece pbr7, Piece pbr8, Piece pbr9, Piece pbr10, Piece pbr11, Piece pbr12){
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
    }

}