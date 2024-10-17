import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/*
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 
Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
 
 */
public class WordBreak {

    public static boolean recFun(int start, String s, List<String> dict, List<String> ans) {
        if(start == s.length()) 
            return true;

        for(int end = start + 1; end <= s.length(); end ++) {
            String prefix = s.substring(start, end);
            if(dict.contains(prefix) && recFun(end, s, dict, ans)) {
                ans.add(prefix);
                return true;
            }
        }

        return false;
    }

    public static boolean memFun(int start, String s, List<String> dict, List<String> ans, Boolean dp[]) {
        if(start == s.length()) 
            return dp[start] = true;
        
        if(dp[start] != null) 
            return dp[start];

        for(int end = start + 1; end <= s.length(); end ++) {
            String prefix = s.substring(start, end);
            if(dict.contains(prefix) && memFun(end, s, dict, ans, dp)) {
                ans.add(prefix);
                return dp[start] = true;
            }
        }

        return dp[start] = false;
    }

    public static boolean wordBreak(String s, Set<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // base case: empty string can be segmented

        // Build the dp array
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                String word = s.substring(j, i);

                // If dp[j] is true and s[j:i] is in the dictionary
                if (dp[j] && wordDict.contains(word)) {
                    dp[i] = true;
                    break; // No need to check further
                }
            }
        }

        // The result is whether the whole string can be segmented
        return dp[n];
    }

    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> dict = Arrays.asList("apple","pen");
        List<String> ans = new ArrayList<>();
        // if(recFun(0, s, dict, ans)) {
        //     System.out.println("Can be break in to words as " + ans);
        // }
        // else {
        //     System.out.println("Words cannot be broken");
        // }
        Boolean dp[] = new Boolean[s.length() + 1];
        if(memFun(0, s, dict, ans, dp)) {
            System.out.println("Can be break in to words as " + ans);
        }
        else {
            System.out.println("Words cannot be broken");
        }
    }
}
