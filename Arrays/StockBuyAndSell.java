/*
 * Stock Buy And Sell

Problem Statement: You are given an array of prices where prices[i] is the price of a given stock on an ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock. Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Examples
Example 1:
Input:
 prices = [7,1,5,3,6,4]
Output:
 5
Explanation:
 Buy on day 2 (price = 1) and 
sell on day 5 (price = 6), profit = 6-1 = 5.

Note
: That buying on day 2 and selling on day 1 
is not allowed because you must buy before 
you sell.

Example 2:
Input:
 prices = [7,6,4,3,1]
Output:
 0
Explanation:
 In this case, no transactions are 
done and the max profit = 0.
 */

public class StockBuyAndSell {
    public static void main(String[] args) {
        // int a[] = {7,1,5,3,6,4};
        int a[] = {7,6,4,3,1};
        int min = Integer.MAX_VALUE, maxProfit = 0;
        int buy = 0, sell = 0;
        
        for(int i = 0; i < a.length; i ++) {
            if(a[i] < min) {
                min = a[i];
                buy = i;
            }
            else if(a[i] - min > maxProfit) {
                maxProfit = a[i] - min;
                sell = i;
            }
        }

        System.out.println("Max Profit : "+ maxProfit);
        System.out.println("Buy at " + a[buy] + " Sell at " + a[sell]);
    }
}
