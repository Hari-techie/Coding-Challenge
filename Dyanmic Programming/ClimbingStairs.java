import java.util.*;

/*
 * Steps to follow for Dp
 * 1. Approach it as index 
 * 2. Count all -> Sum
 *    Min of all -> Min
 *    Max of all -> Max
 * 3. 
 */

public class ClimbingStairs {

    public static int solveByRecursion(int ind) {
        if(ind == 0) return 1;
        if(ind == 1) return 1;

        return solveByRecursion(ind - 1) + solveByRecursion(ind - 2);
    }

    public static int solveByTabulation(int ind) {
        int dp[] = new int[ind + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= ind; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[ind];
    }

    public static int solveBySpaceOptimization(int ind) {
        int prev = 1;
        int prev1 = 1;
        int cur = 0;
        for(int i = 2; i <= ind; i++) {
            cur = prev + prev1;
            prev1 = prev;
            prev = cur;
        }
        return cur;
    }

    public static void main(String [] args) {
        int n = 3;
        System.out.println(solveByRecursion(n));
        System.out.println(solveByTabulation(n));
        System.out.println(solveBySpaceOptimization(n));
    }
}