import java.util.Arrays;

/*
 * You are given an infinite supply of coins of each of denominations D = {D0, D1, D2, D3, ...... Dn-1}. 
 * You need to figure out the total number of ways W, in which you can make a change for value V using coins of
 *  denominations from D. Print 0, if a change isn't possible.

Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
3
1 2 3
4
Sample Output 1:
4
Explanation for Sample Output 1:
We can make a change for the value V = 4 in four ways.
1. (1,1,1,1), 
2. (1,1, 2), [One thing to note here is, (1, 1, 2) is same as that of (2, 1, 1) and (1, 2, 1)]
3. (1, 3), and 
4. (2, 2)
Sample Input 2 :
3
5 3 2
1
Sample Output 2:
0
 */

public class CoinChange2 {

    public static int recFun(int ind, int target, int coins[]) {
        if (ind == 0) {
            return target % coins[ind] == 0 ? 1 : 0;
        }

        int notTake = recFun(ind - 1, target, coins);
        int take = 0;
        if (coins[ind] <= target) {
            take = recFun(ind, target - coins[ind], coins);
        }

        return take + notTake;
    }

    public static int memFun(int ind, int target, int coins[], int dp[][]) {
        if (ind == 0) {
            return target % coins[ind] == 0 ? 1 : 0;
        }
        if (dp[ind][target] != -1)
            return dp[ind][target];

        int notTake = memFun(ind - 1, target, coins, dp);
        int take = 0;
        if (coins[ind] <= target) {
            take = memFun(ind, target - coins[ind], coins, dp);
        }

        return dp[ind][target] = take + notTake;
    }

    public static int tabFun(int n, int val, int coins[]) {
        int dp[][] = new int[n][val + 1];
        for (int t = 0; t <= val; t++) {
            if (t % coins[0] == 0)
                dp[0][t] = 1;
        }

        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= val; target++) {
                int notTake = dp[ind - 1][target];
                int take = 0;
                if (coins[ind] <= target) {
                    take = dp[ind][target - coins[ind]];
                }
                dp[ind][target] = take + notTake;
            }
        }

        return dp[n - 1][val];
    }

    public static void main(String[] args) {
        int n = 3;
        int coins[] = { 1, 2, 3 };
        int target = 4;
        // System.out.println(recFun(n - 1, target, coins));
        int dp[][] = new int[n][target + 1];
        for (int a[] : dp) {
            Arrays.fill(a, -1);
        }
        // System.out.println(memFun(n - 1, target, coins, dp));
        System.out.println(tabFun(n , target, coins));
    }
}
