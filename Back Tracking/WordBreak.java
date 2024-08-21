/*
 * Given a string s and a dictionary of strings wordDict, return true 
 * if s can be segmented into a space-separated sequence of one or more dictionary words.

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

import java.util.*;

public class WordBreak {

    public static boolean solveByRecursion(String s, Set<String> wordDict, int start) {
        if(start == s.length()) {
            return true;
        }

        for(int i = start; i < s.length(); i++) {
             // Check if the current substring is in the dictionary
            if (wordDict.contains(s.substring(start, i + 1))) {
                // Recursively check the remainder of the string
                if (solveByRecursion(s, wordDict, i + 1)) {
                    return true; // If the remainder can be segmented, return true
                }           
            }        
        }

        return false;
    }

    public static void main(String [] args) {
        Set<String> wordDict = new HashSet<>();
        wordDict.add("apple");
        wordDict.add("pen");
        System.out.println(solveByRecursion("applepenapple", wordDict, 0));
    }
}