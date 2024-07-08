import java.util.*;
/*
 * Problem Statement: Given an array and a sum k, we need to print the length of the longest subarray that sums to k.

Examples
Example 1:
Input Format:
 N = 3, k = 5, array[] = {2,3,5}
Result:
 2
Explanation:
 The longest subarray with sum 5 is {2, 3}. And its length is 2.

Example 2:
Input Format
: N = 3, k = 1, array[] = {-1, 1, 1}
Result:
 3
Explanation:
 The longest subarray with sum 1 is {-1, 1, 1}. And its length is 3.

 Input Format: N = 6, array[] = {9, -3, 3, -1, 6, -5}

Result: 5
 */

public class LongestSubarrayWithKsum {
    public static void main(String [] args) {
        int a[] = {-1, 1, 1};
        int k = 1;
        HashMap<Integer, Integer> res = new HashMap<>();
        int sum = 0, maxLen = 0;
        for(int i = 0; i < a.length; i ++) {
            sum += a[i];
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }

            // calculate the sum of remaining part i.e. x-k:
            int rem = sum - k;

            //Calculate the length and update maxLen:
            if (res.containsKey(rem)) {
                int len = i - res.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            //Finally, update the map checking the conditions:
            if (!res.containsKey(sum)) {
                res.put(sum, i);
            }
        }
    System.out.println(maxLen);
    }
}