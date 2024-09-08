
/*
 * Problem statement
Given a ‘N’ * ’M’ maze with obstacles, count and return the number of unique paths to reach the right-bottom cell 
from the top-left cell. A cell in the given maze has a value '-1' if it is a blockage or dead-end, else 0. 
From a given cell, we are allowed to move to cells (i+1, j) and (i, j+1) only. Since the answer can be large, 
print it modulo 10^9 + 7.

For Example :
Consider the maze below :
0 0 0 
0 -1 0 
0 0 0

There are two ways to reach the bottom left corner - 

(1, 1) -> (1, 2) -> (1, 3) -> (2, 3) -> (3, 3)
(1, 1) -> (2, 1) -> (3, 1) -> (3, 2) -> (3, 3)

Hence the answer for the above test case is 2.
 */
import java.util.*;

public class MazeObstacles {

    public static int recFun(int a[][], int i, int j) {
        if (i == 0 && j == 0)
            return 1;
        if (i < 0 || j < 0 || a[i][j] == -1)
            return 0;

        return recFun(a, i - 1, j) + recFun(a, i, j - 1);
    }

    public static int dpFun(int a[][], int i, int j, int dp[][]) {
        if (i == 0 && j == 0)
            return 1;
        if (i < 0 || j < 0 || a[i][j] == -1)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];

        return dp[i][j] = recFun(a, i - 1, j) + recFun(a, i, j - 1);
    }

    public static int tabFun(int a[][], int m, int n) {
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Skip blocked cells
                if (i > 0 && j > 0 && a[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }

                if (i == 0 && j == 0) {
                    dp[i][j] = 1; // There's one valid path to the start cell.
                    continue;
                }

                int up = 0;
                int down = 0;
                // If not the first row, add the value from the top
                if (i > 0) {
                    up = dp[i - 1][j];
                }

                // If not the first column, add the value from the left
                if (j > 0) {
                    down= dp[i][j - 1];
                }
                dp[i][j] = up + down;
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int a[][] = {
                { 0, 0, 0 },
                { 0, -1, 0 },
                { 0, 0, 0 }
        };
        // int a[][] = {
        // {0, -1},
        // {-1, 0}
        // };
        // System.out.println(recFun(a, 2 , 2));
        // int b[][] = new int[3][3];
        // for (int i = 0; i < b.length; i++) {
        // Arrays.fill(b[i], -1);
        // }
        // System.out.println(dpFun(a, 2, 2, b));
        System.out.println(tabFun(a, 3, 3));
    }
}
