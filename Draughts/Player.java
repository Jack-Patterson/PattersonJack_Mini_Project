package Draughts;

import javax.swing.*;

public class Player {
    private String playerName;
    private String playerColour;
    private boolean isTheirTurn;

    public Player(String playerName, String playerColour, boolean isTheirTurn) {
        setPlayerName(playerName);
        setPlayerColour(playerColour);
        setTheirTurn(isTheirTurn);
    }

    public Player(){
        setPlayerName(JOptionPane.showInputDialog("Please enter a player name."));
        setPlayerColour(JOptionPane.showInputDialog("Please enter a colour."));
        setTheirTurn(false);
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

    public String toString() {
        return "Player: " +
                "Player Name: " + getPlayerName() +
                " Player Colour: " + getPlayerColour() +
                " Is Their Turn: " + isTheirTurn();
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
