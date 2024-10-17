import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Problem Statement: Given a string s, partition s such that every substring of the partition is a palindrome. 
 * Return the minimum cuts needed for a palindrome partitioning of s.

Examples
Example 1:
Input:
 s = "bababcbadcede"
Output
: 4
Explanation:
 If we do 4 partitions in the following way, 
each substring of the partition will be a palindrome.
bab | abcba | d | c | ede
Input
: s = "aab"
Output
: 1
Explanation
: If we do 1 partition in the following way, 
each substring of the partition will be a palindrome.
aa | b
 */

public class PalindromePartition {

    public static int recFun(int start, String s) {
        if(start == s.length())
            return 0;

        int cost, min = Integer.MAX_VALUE;
        for(int end = start + 1; end <= s.length(); end ++) {
            String a = s.substring(start, end);
            String b = new StringBuilder(a).reverse().toString();
            if(a.equals(b)) {
                cost = 1 + recFun(end, s);
                min = Math.min(cost, min);
            }
        }

        return min;
    }

    public static int memFun(int start, String s, int dp[]) {
        if(start == s.length())
            return 0;
        
        if(dp[start] != -1)
            return dp[start];

        int cost, min = Integer.MAX_VALUE;
        for(int end = start + 1; end <= s.length(); end ++) {
            String a = s.substring(start, end);
            String b = new StringBuilder(a).reverse().toString();
            if(a.equals(b)) {
                cost = 1 + memFun(end, s, dp);
                min = Math.min(cost, min);
            }
        }

        return dp[start] = min;
    }

    public static void main(String[] args) {
        String s = "bababcbadcede";
        // System.out.println(recFun(0, s) - 1);
        int dp[] = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        System.out.println(memFun(0, s, dp) - 1);
    }
}
