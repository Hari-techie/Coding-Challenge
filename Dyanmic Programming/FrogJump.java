/*
 * Problem Statement:

Given a number of stairs and a frog, the frog wants to climb from the 0th stair to the (N-1)th stair.
At a time the frog can climb either one or two steps. A height[N] array is also given. 
Whenever the frog jumps from a stair i to stair j, the energy consumed in the jump is 
abs(height[i]- height[j]), where abs() means the absolute difference. 
We need to return the minimum energy that can be used by the frog to jump from stair 0 to stair N-1.

Example:
n = 4
[10, 20, 30, 10]
output -> 20
 */
import java.util.*;
public class FrogJump {

    public static int solveByRecursion(int a[], int n) {
        if(n == 0) return 0;

        int jumpOne = solveByRecursion(a, n - 1) +  Math.abs(a[n] - a[n - 1]);
        int jumpTwo = Integer.MAX_VALUE;
        if(n > 1) {
            jumpTwo = solveByRecursion(a, n - 2) +  Math.abs(a[n] - a[n - 2]);
        }
        
        return Math.min(jumpOne, jumpTwo);
    }

    public static int solveByMemoization(int a[], int n, int dp[]) {
        dp[0] = 0;
        if(dp[n] != -1) return dp[n];
        int jumpOne = solveByRecursion(a, n - 1) +  Math.abs(a[n] - a[n - 1]);
        int jumpTwo = Integer.MAX_VALUE;
        if(n > 1) {
            jumpTwo = solveByRecursion(a, n - 2) +  Math.abs(a[n] - a[n - 2]);
        }
        
        return dp[n] = Math.min(jumpOne, jumpTwo);
    }

    public static int solveByTabulation(int a[], int n) {
        int dp[] = new int[n];
        dp[0] = 0;
        dp[1] = Math.abs(a[0] - a[1]);
        for(int i = 2; i < n; i++) {
            int left = dp[i - 1] + Math.abs(a[i] - a[i - 1]);
            int right = dp[i - 2] + Math.abs(a[i] - a[i - 2]);
            dp[i] = Math.min(left, right);
        }
        return dp[n - 1];
    }

    public static int solveBySpaceOptimization(int a[], int n) {
        int prev = 0;
        int prev1 = Math.abs(a[0] - a[1]);
        int current = 0;
        for(int i = 2; i < n; i++) {
            int left = prev + Math.abs(a[i] - a[i - 1]);
            int right = prev1 + Math.abs(a[i] - a[i - 2]);
            current = Math.min(left, right);
            prev = current;
            prev1 = prev;
        }
        return current;
    }

    public static void main(String [] args) {
        int n = 4;
        int a[] = {10, 20, 30, 10};
        // System.out.println(solveByRecursion(a, n - 1));
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        System.out.println(solveByMemoization(a, n - 1, dp));
        // System.out.println(solveByTabulation(a, n));
        // System.out.println(solveBySpaceOptimization(a, n));
    }
}