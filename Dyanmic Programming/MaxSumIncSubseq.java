/*
 * Given an array of n positive integers. Find the sum of the maximum sum subsequence of 
 * the given array such that the integers in the subsequence are sorted in strictly increasing 
 * order 
 * i.e. a strictly increasing subsequence. 

Example 1:

Input: 
N = 5, arr[] = {1, 101, 2, 3, 100} 
Output: 
106
Explanation:
The maximum sum of a increasing sequence is obtained from {1, 2, 3, 100},
Example 2:

Input: 
N = 4, arr[] = {4, 1, 2, 3}
Output: 
6
Explanation:
The maximum sum of a increasing sequence is obtained from {1, 2, 3}.
 */

import java.util.*;

public class MaxSumIncSubseq {

    public static int recFun(int ind, int prevInd, int a[]) {
        if(ind == a.length) {
            return 0;
        }

        int notTake = recFun(ind + 1, prevInd, a);
        int take = 0;
        if(prevInd == -1 || a[ind] > a[prevInd]) {
            take = a[ind] + recFun(ind + 1, ind, a);
        }
        return Math.max(take, notTake);
    }

    public static int memFun(int ind, int prevInd, int a[], int dp[][]) {
        if(ind == a.length) {
            return 0;
        }
        if(dp[ind][prevInd + 1] != -1) return dp[ind][prevInd + 1];

        int notTake = memFun(ind + 1, prevInd, a, dp);
        int take = 0;
        if(prevInd == -1 || a[ind] > a[prevInd]) {
            take = a[ind] + memFun(ind + 1, ind, a, dp);
        }
        return dp[ind][prevInd + 1] = Math.max(take, notTake);
    }

    public static void main(String [] args) {
        int a[] = {1, 101, 2, 3, 100};
        // int a[] = {4, 1, 2, 3};
        // System.out.println(recFun(0, -1, a));
        int n = a.length;
        int dp[][] = new int[n][n+1];
        for(int b[]: dp) Arrays.fill(b, -1);
        System.out.println(memFun(0, -1, a, dp));
    }
}