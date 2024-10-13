import java.util.Arrays;

/*
 * You are given an array 'arr' of size 'n' containing positive integers and a target sum 'k'.



Find the number of ways of selecting the elements from the array such that the sum of chosen elements is equal to the target 'k'.



Since the number of ways can be very large, print it modulo 10 ^ 9 + 7.



Example:
Input: 'arr' = [1, 1, 4, 5]

Output: 3

Explanation: The possible ways are:
[1, 4]
[1, 4]
[5]
Hence the output will be 3. Please note that both 1 present in 'arr' are treated differently.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
4 5
1 4 4 5


Sample Output 1 :
 3


Explanation For Sample Output 1:
The possible ways are:
[1, 4]
[1, 4]
[5]
Hence the output will be 3. Please note that both 1 present in 'arr' are treated differently.


Sample Input 2 :
3 2
1 1 1


Sample Output 2 :
3


Explanation For Sample Output 1:
There are three 1 present in the array. Answer is the number of ways to choose any two of them.


Sample Input 3 :
3 40
2 34 5


Sample Output 3 :
0


Expected time complexity :
The expected time complexity is O('n' * 'k').


Constraints:
1 <= 'n' <= 100
0 <= 'arr[i]' <= 1000
1 <= 'k' <= 1000

Time limit: 1 sec
 */
public class CountSubsetsWithSumK {

    public static int recFun(int ind, int k, int a[]) {
        if(k == 0) return 1;
        if(ind == 0) return a[ind] == k ? 1 : 0;

        int notTake = recFun(ind - 1, k, a);
        int take = 0;
        if(a[ind] <= k) {
            take = recFun(ind - 1, k - a[ind], a);
        }

        return notTake + take;
    }

    public static int memFun(int ind, int k, int a[], int dp[][]) {
        if(k == 0) return 1;
        if(ind == 0) return a[ind] == k ? 1 : 0;
        if(dp[ind][k] != -1) return dp[ind][k];

        int notTake = memFun(ind - 1, k, a, dp);
        int take = 0;
        if(a[ind] <= k) {
            take = memFun(ind - 1, k - a[ind], a, dp);
        }

        return dp[ind][k] = notTake + take;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 2, 3};
        int k = 3;
        // System.out.println(recFun(3, k, arr));
        int dp[][] = new int[4][k + 1];
        for(int a[]: dp)  
            Arrays.fill(a, -1);
        System.out.println(memFun(3, k, arr, dp));
    }
}
