package LLD.TicTacToe;

public class Player {
    private String playerId;
    private String name;
    private char character;
    private static int noOfPlayers = 0;

    public Player(String name, char character) {
        noOfPlayers++;
        this.playerId = "PLAYER_" + noOfPlayers;
        this.name = name;
        this.character = character;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    @Override
    public String toString() {
        return "Player [playerId=" + playerId + ", name=" + name + ", character=" + character + "]";
    }

}
