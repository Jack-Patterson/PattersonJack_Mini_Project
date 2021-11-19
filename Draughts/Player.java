package Draughts;

public class Player extends Piece {
    private String playerName;
    private String playerColour;
    private boolean isTheirTurn;

    public Player(int x, int y, String colour, boolean isKing, boolean isCaptured, String playerName, String playerColour, boolean isTheirTurn) {
        super(x, y, colour, isKing, isCaptured);
        setPlayerName(playerName);
        setPlayerColour(playerColour);
        setTheirTurn(isTheirTurn);
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
}
