package LLD.TicTacToe;

import java.util.Scanner;

public class Game {
    Player player1;
    Player player2;
    Board board;
    Player currentPlayer;

    Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        board = new Board();
        board.initializeBoard(3, 3);
    }

    public void startGame() {
        System.out.println("Game started");
       
        while(true) {
            board.getBoard();

            if(board.isFull()) {
                System.out.println("Game over");
                break;
            }

            System.out.println(currentPlayer.getName() + "'s Turn");
            System.out.print("Make your move : ");
            Scanner sc = new Scanner(System.in);
            
            int row = sc.nextInt();
            int col = sc.nextInt();

            boolean canMakeMove = board.makeMove(row, col, currentPlayer.getCharacter());
            if(!canMakeMove) {
                System.out.println("Invalid move. Please enter valid position");
                continue;
            }

            if(board.isWin(row, col, currentPlayer.getCharacter())) {
                System.out.println(currentPlayer.getName() + " Won the match !!!");
                board.getBoard();
                break;
            }
            
            switchPlayer();
        }
    }

    public void switchPlayer() {
        this.currentPlayer = this.currentPlayer == player1 ? player2 : player1;
    }
}
