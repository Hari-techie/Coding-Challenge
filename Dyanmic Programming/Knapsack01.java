import java.util.Arrays;

/*
 * A thief is robbing a store and can carry a maximal weight of W into his knapsack. 
 * There are N items and the ith item weighs wi and is of value vi. Considering the constraints of the maximum weight
 *  that a knapsack can carry, you have to find and return the maximum value that a thief can generate by stealing items.
 * 
 * Constraints:
1 <= T <= 10
1 <= N <= 10^2
1<= wi <= 50
1 <= vi <= 10^2
1 <= W <= 10^3

Time Limit: 1 second
Sample Input:
1 
4
1 2 4 5
5 4 8 6
5
Sample Output:
13
 */
public class Knapsack01 {

    public static int recFun(int ind,int w, int profit[], int weight[]) {
        if(ind == 0) {
            if(weight[0] <= w) return profit[0];

            return 0;
        }

        int notTake = recFun(ind - 1, w, profit, weight);
        int take = Integer.MIN_VALUE;
        if(weight[ind] <= w) {
            take = profit[ind] + recFun(ind - 1, w - weight[ind], profit, weight);
        }
        return Math.max(notTake, take);
    }

    public static int memFun(int ind,int w, int profit[], int weight[], int dp[][]) {
        if(ind == 0) {
            if(weight[0] <= w) return profit[0];

            return 0;
        }
        if(dp[ind][w] != - 1) return dp[ind][w];

        int notTake = memFun(ind - 1, w, profit, weight, dp);
        int take = Integer.MIN_VALUE;
        if(weight[ind] <= w) {
            take = profit[ind] + memFun(ind - 1, w - weight[ind], profit, weight, dp);
        }
        return dp[ind][w] = Math.max(notTake, take);
    }

    public static void main(String[] args) {
        int n = 4, w = 5;
        int weight [] = {1, 2, 4, 5};
        int profit [] = {5, 4, 8, 6};
        // System.out.println(recFun(n - 1, w, profit, weight));
        int dp[][] = new int[4][6];
        for(int a[]: dp)
            Arrays.fill(a, -1);
        System.out.println(memFun(n - 1, w, profit, weight, dp));
    }
}
