/*
 * Given two strings s1 and s2 of lengths m and n respectively and below operations that can be performed on s1. Find the minimum number of edits (operations) to convert ‘s1‘ into ‘s2‘.  

Insert: Insert any character before or after any index of s1
Remove: Remove a character of s1
Replace: Replace a character at any index of s1 with some other character.
Note: All of the above operations are of equal cost. 

Examples: 

Input:   s1 = "geek", s2 = "gesek"
Output:  1
Explanation: We can convert s1 into s2 by inserting a ‘s’ between two consecutive ‘e’ in s2.


Input:   s1 = "cat", s2 = "cut"
Output:  1
Explanation: We can convert s1 into s2 by replacing ‘a’ with ‘u’.


Input:   s1 = "sunday", s2 = "saturday"
Output:  3
Explanation: Last three and first characters are same.  
We basically need to convert "un" to "atur".  This can be done using below three operations. 
Replace ‘n’ with ‘r’, insert t, insert a
 */

import java.util.*; 
public class EditDistance {

    public static int recFun(int i, int j, String s1, String s2) {
        if(i < 0) return j + 1;
        if(j < 0) return i + 1;

        if(s1.charAt(i) == s2.charAt(j)) return recFun(i - 1, j - 1, s1, s2);
        int ins = 1 + recFun(i , j - 1, s1, s2);
        int upd = 1 + recFun(i - 1, j - 1, s1, s2);
        int del = 1 + recFun(i - 1, j , s1, s2);
        return(Math.min( ins, Math.min(upd, del)));
    }

    public static int memFun(int i, int j, String s1, String s2, int dp[][]) {
        if(i < 0) return j + 1;
        if(j < 0) return i + 1;
        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)) return dp[i][j] = recFun(i - 1, j - 1, s1, s2);
        int ins = 1 + recFun(i , j - 1, s1, s2);
        int upd = 1 + recFun(i - 1, j - 1, s1, s2);
        int del = 1 + recFun(i - 1, j , s1, s2);
        return dp[i][j] = (Math.min( ins, Math.min(upd, del)));
    }

    public static void main(String [] args) {
        String s1 = "horse";
        String s2 = "ros";
        // String s1 = "cat";
        // String s2 = "cut";
        int n1 = s1.length(), n2 = s2.length();
        // System.out.println(recFun(n1 - 1, n2 - 1, s1, s2));
        int dp[][] = new int[n1][n2];
        for(int a[]: dp) Arrays.fill(a, -1);
        System.out.println(memFun(n1 - 1, n2 - 1, s1, s2, dp));
    }
}