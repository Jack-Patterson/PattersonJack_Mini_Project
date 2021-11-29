package Draughts;

import javax.swing.*;
import java.io.Serializable;

public class Player implements Serializable {
    private String playerName;
    private String playerColour;
    private boolean isTheirTurn;
    private static int playerNumber;
    private int playerNo;

    public Player(String playerName, String playerColour, boolean isTheirTurn) {
        setPlayerName(playerName);
        setPlayerColour(playerColour);
        setTheirTurn(isTheirTurn);
        incrementPlayerNo();
        setPlayerNo(playerNumber);
    }

    public Player(){
        setPlayerName(JOptionPane.showInputDialog("Please enter a player name."));
        setPlayerColour(JOptionPane.showInputDialog("Please enter a colour."));
        setTheirTurn(false);
        incrementPlayerNo();
        setPlayerNo(playerNumber);
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

    public boolean isTheirTurn() {
        return isTheirTurn;
    }

    public void setTheirTurn(boolean theirTurn) {
        isTheirTurn = theirTurn;
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

    public String toString() {
        return "Player: " + getPlayerNo() + ":" +
                "\nName: " + getPlayerName() +
                "\nPiece Colour: " + getPlayerColour() +
                "\nIs their turn? " + isTheirTurn() + "\n\n";
    }

    public static void isPlayerTurn (Player pl1, Player pl2, int turnCounter){
        if (turnCounter == 0){
            turnCounter++;
            pl1.setTheirTurn(true);
        }
        else if (turnCounter % 2 == 0){
            pl1.setTheirTurn(false);
            pl2.setTheirTurn(true);
        }
        else if (turnCounter % 2 == 1){
            pl2.setTheirTurn(false);
            pl1.setTheirTurn(true);
        }
    }
}
