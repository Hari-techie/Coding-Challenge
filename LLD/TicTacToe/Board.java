package LLD.TicTacToe;

import java.util.Arrays;

public class Board {
    private char [][] ticTacBoard;
    int rows;
    int columns;

    public void initializeBoard(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.ticTacBoard = new char[rows][columns];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                ticTacBoard[i][j] = '-';
            }
        }
    }

    public void getBoard() {
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                System.out.print(ticTacBoard[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public boolean makeMove(int row, int col, char symbol) {
        boolean exists = Arrays.stream(Symbol.values()).anyMatch(s -> s.name().equals(symbol));
        
        if(row >= rows || col >= columns || exists || ticTacBoard[row][col] != '-') {
            return false;
        }

        ticTacBoard[row][col] = symbol;
        return true;
    }

    public boolean isFull() {
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                if(ticTacBoard[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isWin(int row, int col, char symbol) {
        boolean rowCheck = true, colCheck = true, diagCheck = true, revDiagCheck = true;
        for(int i = 0; i < rows; i++) {
            if(ticTacBoard[i][col] != symbol) {
                rowCheck = false;
            }
            if(ticTacBoard[i][i] != symbol) {
                diagCheck = false;
            }
            if(ticTacBoard[i][columns - i - 1] != symbol) {
                revDiagCheck = false;
            }
        }
        for(int i = 0; i < columns; i++) {
            if(ticTacBoard[row][i] != symbol) {
                colCheck = false;
            }
        }

        return rowCheck || colCheck || diagCheck || revDiagCheck;
    }


}

enum Symbol {
    O, 
    X
} 
