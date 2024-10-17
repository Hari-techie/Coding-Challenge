import java.util.Arrays;

/*
 * For a given array with N elements, you need to find the length of the longest subsequence 
 * from the array such that all the elements of the subsequence are sorted in strictly increasing order.

Strictly Increasing Sequence is when each term in the sequence is larger than the preceding term.

For example:
[1, 2, 3, 4] is a strictly increasing array, while [2, 1, 4, 3] is not.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input :
6
5 4 11 1 16 8
Sample Output 1 :
3
Explanation of Sample Input 1:
Length of longest subsequence is 3 i.e. [5, 11, 16] or [4, 11, 16].
Sample Input 2:
3
1 2 2
Sample Output 2 :
2
 */

public class LongestIncreasingSubsequence {

    public static int recFun(int ind, int prevInd, int a[]) {
        if(ind == a.length) return 0;

        int notTake = recFun(ind + 1, prevInd, a);
        int take = 0;
        if(prevInd == -1 || a[ind] > a[prevInd]) {
            take = 1 + recFun(ind + 1, ind, a);
        }

        return Math.max(notTake, take);
    } 

    public static int memFun(int ind, int prevInd, int a[], int dp[][]) {
        if(ind == a.length) return 0;
        if(dp[ind][prevInd + 1] != -1) return dp[ind][prevInd + 1];

        int notTake = memFun(ind + 1, prevInd, a, dp);
        int take = 0;
        if(prevInd == -1 || a[ind] > a[prevInd]) {
            take = 1 + memFun(ind + 1, ind, a, dp);
        }

        return dp[ind][prevInd + 1] = Math.max(notTake, take);
    } 

    public static void main(String[] args) {
        int a[] = {5, 4, 11, 1, 16, 8};
        // System.out.println(recFun(0, -1, a));
        int n = a.length;
        int dp[][] = new int[n][n+1];
        for(int arr[]: dp) Arrays.fill(arr, -1);
        System.out.println(memFun(0, -1, a, dp));
    }
}
