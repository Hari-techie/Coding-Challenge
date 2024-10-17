package LLD.TicTacToe;

public class TicTacToe {
    public static void main(String[] args) {
        Player player1 = new Player("Hari", 'O');
        Player player2 = new Player("Thara", 'X');
        Game game = new Game(player1, player2);
        game.startGame();
    }
}
// PS C:\Users\Harir\OneDrive\Documents\My Interview Prep\Coding-Challenge>
// javac LLD/TicTacToe/*.java
// java LLD.TicTacToe.TicTacToe
