/* 
 *  Problem Statement: Given a value V, if we want to make a change for V Rs, and we have an infinite supply of 
 * each of the denominations in Indian currency, i.e., we have an infinite supply of 
 * { 1, 2, 5, 10, 20, 50, 100, 500, 1000} valued coins/notes, 
 * what is the minimum number of coins and/or notes needed to make the change.

Examples:

Example 1:

Input: V = 70

Output: 2

Explaination: We need a 50 Rs note and a 20 Rs note.

Example 2:

Input: V = 121

Output: 3

Explaination: We need a 100 Rs note, a 20 Rs note and a 1 Rs coin. 
 */

public class MinimumCoins {

    public static void getCoins(int coins[], int n, int rupees) {
        int noOfCoin = 0, count = 0;
        int i = n - 1;
        while(i >= 0 && rupees > 0) {
            if(coins[i] <= rupees) {
                count = rupees/coins[i];
                noOfCoin += count;
                rupees -= coins[i] * count;
            }
            i--;
        }

        System.out.println(noOfCoin);
    }

    public static void main(String[] args) {
        int coins[] = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
        int n = coins.length;
        int rupees = 49;
        getCoins(coins, n, rupees);
    }
}
