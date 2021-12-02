package Draughts;

import javax.swing.*;
import java.io.Serializable;

public class Player implements Serializable {
    private String playerName;
    private String playerColour;
    private boolean isPlayerTurn;
    private static int playerNumber;
    private int playerNo;

    public Player(String playerName, String playerColour) {
        setPlayerName(playerName);
        setPlayerColour(playerColour);
        incrementPlayerNo();
        setPlayerNo(playerNumber);
        setPlayerTurn(isPlayerTurn);
    }

    public Player(){
        setPlayerName(playerName);
        setPlayerColour(playerColour);
        incrementPlayerNo();
        setPlayerNo(playerNumber);
        setPlayerTurn(isPlayerTurn);
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerColour() {
        return playerColour;
    }

    public void setPlayerColour(String playerColour) {
        this.playerColour = playerColour;
    }

    public static int getPlayerNumber() {
        return playerNumber;
    }

    public static void setPlayerNumber(int playerNumber) {
        Player.playerNumber = playerNumber;
    }

    public int getPlayerNo() {
        return playerNo;
    }

    public void setPlayerNo(int playerNo) {
        this.playerNo = playerNo;
    }

    public static void incrementPlayerNo(){
        playerNumber++;
    }

    public boolean isPlayerTurn() {
        return isPlayerTurn;
    }

    public void setPlayerTurn(boolean playerTurn) {
        isPlayerTurn = playerTurn;
    }

    public String toString() {
        return "Player: " + getPlayerNo() + ":" +
                "\nName: " + getPlayerName().toUpperCase() +
                "\nPiece Colour: " + getPlayerColour().toUpperCase() + "\n";
    }

    public static void setPlayer (Piece piece, Player pl1, Player pl2){
        if (piece.getColour().equalsIgnoreCase("Black")){
            if (pl1.getPlayerColour().equalsIgnoreCase("black")){
                pl1.setPlayerTurn(true);
                pl2.setPlayerTurn(false);
            }
            else {
                pl1.setPlayerTurn(false);
                pl2.setPlayerTurn(true);
            }
        }
        else if (piece.getColour().equalsIgnoreCase("Brown")){
            if (pl1.getPlayerColour().equalsIgnoreCase("black")){
                pl1.setPlayerTurn(false);
                pl2.setPlayerTurn(true);
            }
            else {
                pl1.setPlayerTurn(true);
                pl2.setPlayerTurn(false);
            }
        }
    }
}
