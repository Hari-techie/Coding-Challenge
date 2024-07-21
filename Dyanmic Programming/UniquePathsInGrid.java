/*
 * Problem Statement: Given a matrix m X n, count paths from left-top to the right bottom of a matrix with 
 * the constraints that from each cell you can either only move to the rightward direction or the downward direction.

Example 1:

Input Format: m = 2, n= 2
Output: 2

Example 2:

Input Format: m = 2, n= 3 
Ouput: 3
 */

public class UniquePathsInGrid {

    public static int findUsingRecursion(int m, int n) {
        if(m == 0 && n == 0) {
            return 1;
        }
        if(m < 0 || n < 0) {
            return 0;
        }
        int up = findUsingRecursion(m - 1, n);
        int down = findUsingRecursion(m, n - 1);
        return up + down;
    }

    public static void findUsingDP(int m, int n) {
        int dp[][] = new int[m][n];

        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = 1;
                }
                else {
                    int up = 0;
                    int left = 0;
                    if(i > 0) up = dp[i - 1][j] ;
                    if(j > 0) left = dp[i][j - 1];
                    dp[i][j] = up + left;
                }
            }
        }

        System.out.println(dp[m-1][n-1]);
    }

    public static void findUsingCombinatrincs(int m, int n) {
        // R R D - R D R - D R R - (3 + 2 - 2) = 3
        // 3C2 - 3C1 = 3
        int N = m + n - 2;
        int r = m - 1;
        int res = 1;
        for(int i = 0; i < r; i ++) {
            res = res * (N - i);
            res = res / (i + 1);
            // res = res * ( N - r + i) / i;
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        int m = 2, n = 3;
        // int c = findUsingRecursion(m - 1, n - 1);
        // System.out.println(c);
        // findUsingCombinatrincs(m, n);
        findUsingDP(m, n);
    }
}
