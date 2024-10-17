/*
 * Given the dimension of a sequence of matrices in an array arr[], 
 * where the dimension of the ith matrix is (arr[i-1] * arr[i]), 
 * the task is to find the most efficient way to multiply these matrices together such that the 
 * total number of element multiplications is minimum. When two matrices of size m*n and n*p when 
 * multiplied, they generate a matrix of size m*p and the number of multiplications performed are m*n*p.

Examples:

Input: arr[] = {2, 1, 3, 4}
Output: 20
Explanation: There are 3 matrices of dimensions 2×1, 1×3, and 3×4, 
Let the input 3 matrices be M1, M2, and M3. There are two ways to multiply ((M1 x M2) x M3) and (M1 x (M2 x M3)), 
Please note that the result of M1 x M2 is a 2 x 3 matrix and result of (M2 x M3) is a 1 x 4 matrix.
((M1 x M2) x M3)  requires (2 x 1 x 3)  + (0) +  (2 x 3 x 4) = 30 
(M1 x (M2 x M3))  requires (0)  + (1 x 3 x 4) +  (2 x 1 x 4) = 20 
The minimum of these two is 20.


Input: arr[] = {1, 2, 3, 4, 3}
Output: 30
Explanation: There are 4 matrices of dimensions 1×2, 2×3, 3×4, 4×3. Let the input 4 matrices be M1, M2, M3 and M4. The minimum number of multiplications are obtained by ((M1M2)M3)M4. The minimum number is 1*2*3 + 1*3*4 + 1*4*3 = 30


Input: arr[] = {3, 4}
Output: 0
Explanation: As there is only one matrix so, there is no cost of multiplication.
 */
import java.util.*;

public class MatrixChainMultiplication {

    public static int recFun(int i, int j, int a[]) {
        if(i == j) return 0;

        int min = Integer.MAX_VALUE;
        for(int k = i; k <= j - 1; k++) {
            int steps = (a[i - 1] * a[j] * a[k]) + recFun(i, k, a) + recFun(k + 1, j, a);
            min = Math.min(steps, min);
        }

        return min;
    }

    public static int memFun(int i, int j, int a[], int dp[][]) {
        if(i == j) return dp[i][j] = 0;
        if(dp[i][j] != -1) return dp[i][j];

        int min = Integer.MAX_VALUE;
        for(int k = i; k <= j - 1; k++) {
            int steps = (a[i - 1] * a[j] * a[k]) + recFun(i, k, a) + recFun(k + 1, j, a);
            min = Math.min(steps, min);
        }

        return dp[i][j] = min;
    }

    public static void main(String [] args) {
        // int a[] = {10, 20, 30, 40, 50};
        int a[] = {2, 1, 3, 4};
        int n = a.length;
        // System.out.println(recFun(1, n - 1, a));
        int dp[][] = new int[n][n];
        for(int b[]: dp) Arrays.fill(b, -1);
        System.out.println(memFun(1, n - 1, a, dp));
    }
}