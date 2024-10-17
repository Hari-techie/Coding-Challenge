import java.util.Arrays;

/*
 * Given two strings, 'S' and 'T' with lengths 'M' and 'N', find the length of the 'Longest Common Subsequence'.

For a string 'str'(per se) of length K, the subsequences are the strings containing characters in the
 same relative order as they are present in 'str,' but not necessarily contiguous. 
 Subsequences contain all the strings of length varying from 0 to K.

Example :
Subsequences of string "abc" are:  ""(empty string), a, b, c, ab, bc, ac, abc.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= M <= 10 ^ 3
0 <= N <= 10 ^ 3

Time Limit: 1 sec
Sample Input 1 :
adebc
dcadb
Sample Output 1 :
3
Explanation of the Sample Output 1 :
Both the strings contain a common subsequence 'adb', which is the longest common subsequence with length 3. 
Sample Input 2 :
ab
defg
Sample Output 2 :
0
Explanation of the Sample Output 2 :
The only subsequence that is common to both the given strings is an empty string("") of length 0.
 */

public class LongestCommonSubsequence {

    public static int recFun(int ind1, int ind2, String s1, String s2) {
        if (ind1 < 0 || ind2 < 0)
            return 0;

        if (s1.charAt(ind1) == s2.charAt(ind2)) {
            return 1 + recFun(ind1 - 1, ind2 - 1, s1, s2);
        }

        return Math.max(recFun(ind1 - 1, ind2, s1, s2), recFun(ind1, ind2 - 1, s1, s2));
    }

    public static int memFun(int ind1, int ind2, String s1, String s2, int dp[][]) {
        if (ind1 < 0 || ind2 < 0)
            return 0;

        if (dp[ind1][ind2] != -1)
            return dp[ind1][ind2];

        if (s1.charAt(ind1) == s2.charAt(ind2)) {
            return dp[ind1][ind2] = 1 + recFun(ind1 - 1, ind2 - 1, s1, s2);
        }

        return dp[ind1][ind2] = Math.max(recFun(ind1 - 1, ind2, s1, s2), recFun(ind1, ind2 - 1, s1, s2));
    }

    public static void main(String[] args) {
        String s1 = "adebc";
        String s2 = "dcadb";
        // System.out.println(recFun(s1.length() - 1, s2.length() - 1, s1, s2));
        int dp[][] = new int[s1.length()][s2.length()];
        for(int a[]: dp) Arrays.fill(a, -1);
        int length = memFun(s1.length() - 1, s2.length() - 1, s1, s2, dp);
        System.out.println(length);
    }
}
