package Draughts;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Locale;

public class TestDriver {
    public static void main(String[] args) {


        Piece p1 = new Piece(3, 7, "black", true, true);

        ArrayList<Piece> allPieces = new ArrayList<Piece>();
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


        AllPoints(allPoints, po1, po3, po2, po4, po5, po6, po7, po8, po9, po10, po11, po12, po13, po14, po15, po16, po17, po19, po18, po20, po21, po22, po23, po24, po25, po26, po27, po28, po29, po30, po31, po32);
        AllPieces(allPieces, p1);
        Validator.isValidPoint(allPoints, allPieces);

        Point move1 = new Point(0,0);
        Point move2 = new Point(0,0);
        Point move3 = new Point(0,0);
        Point move4 = new Point(0,0);

        for (Piece p:allPieces) {
            if (p.getColour().equals("black")) {
                System.out.println("Choose your move!");
                if (p.getX() != 1 && p.getY() != 8) {
                    move1.setX(p.getX() - 1);
                    move1.setY(p.getY() + 1);
                    System.out.println("Move 1: Move from " + p.getX() + "," + p.getY() + " to " + move1.toString());
                }
                else {
                    System.out.println("Move 1: Invalid Move");
                }

                if (p.getX() != 8 && p.getY() != 8) {
                    move2.setX(p.getX() + 1);
                    move2.setY(p.getY() + 1);
                    System.out.println("Move 2: Move from " + p.getX() + "," + p.getY() + " to " + move2.toString());
                }
                else {
                    System.out.println("Move 2: Invalid Move");
                }
                }
                if(p.isKing() == true){
                    System.out.println("\nBecause you are a king you also have the following moves:");
                    if (p.getX() != 1 && p.getY() != 1) {
                        move3.setX(p.getX() - 1);
                        move3.setY(p.getY() - 1);
                        System.out.println("Move 3: Move from " + p.getX() + "," + p.getY() + " to " + move3.toString());
                    }
                    else {
                        System.out.println("Move 3: Invalid Move");
                    }

                    if (p.getX() != 8 && p.getY() != 1) {
                        move4.setX(p.getX() + 1);
                        move4.setY(p.getY() - 1);
                        System.out.println("Move 4: Move from " + p.getX() + "," + p.getY() + " to " + move4.toString());
                    }
                    else {
                        System.out.println("Move 4: Invalid Move");
                    }
                }
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

    private static void AllPieces (ArrayList<Piece> allPieces, Piece p1){
        allPieces.add(p1);
    }
}