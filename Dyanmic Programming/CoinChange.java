import java.util.Arrays;

/*
 * target = 7
 * coins =  {1, 2, 3};
 * o/p : 3 
 * exp : 3 3 1
 */

public class CoinChange {

    public static int recFun(int ind, int target, int coins[]) {
        if(target == 0) return 0;

        int notTake = 0;
        int take = 0;
        if(coins[ind] <= target) {
            take = target/coins[ind] + recFun(ind - 1, target%coins[ind], coins);
        }
        else {
          notTake = recFun(ind - 1, target, coins);
        }

        return take + notTake;
    }

    public static int memFun(int ind, int target, int coins[], int dp[]) {
        if(target == 0) return 0;
        if(dp[ind] != -1) return dp[ind];

        int notTake = 0;
        int take = 0;
        if(coins[ind] <= target) {
            take = target/coins[ind] + memFun(ind - 1, target%coins[ind], coins, dp);
        }
        else {
          notTake = memFun(ind - 1, target, coins, dp);
        }

        return dp[ind] = take + notTake;
    }

    public static void main(String[] args) {
        int coins[] = {1, 2, 3, 5};
        int target = 15;
        // System.out.println(recFun(3, target, coins));
        int dp [] = new int[4];
        Arrays.fill(dp, -1);        
        System.out.println(memFun(3, target, coins, dp));        
    }
}
