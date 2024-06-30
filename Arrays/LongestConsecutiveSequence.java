import java.util.*;

/*
 * Problem Statement: You are given an array of ‘N’ integers. You need to find the length of the longest sequence which contains the consecutive elements.

Examples
Example 1:
Input:
 [100, 200, 1, 3, 2, 4]

Output:
 4

Explanation:
 The longest consecutive subsequence is 1, 2, 3, and 4.

Input:
 [3, 8, 5, 7, 6]

Output:
 4

Explanation:
 The longest consecutive subsequence is 5, 6, 7, and 8.
 */
public class LongestConsecutiveSequence {

    public static void getResultUsingSorting(int a[]) {
        Arrays.sort(a);
        int curSmallEle = Integer.MIN_VALUE;
        int curSeq = 1;
        int largeSeq = 1;

        for (int i = 0; i < a.length; i++) {
            if (a[i] - 1 == curSmallEle) {
                curSeq++;
                curSmallEle = a[i];
            } else if (curSmallEle != a[i]) {
                curSeq = 1;
                curSmallEle = a[i];
            }
            largeSeq = Math.max(largeSeq, curSeq);
        }

        System.out.println(largeSeq);
    }

    public static void getResultUsingHashing(int a[]) {
        int n = a.length;
        int longest = 1;
        Set<Integer> set = new HashSet<>();

        // put all the array elements into set
        for (int i = 0; i < n; i++) {
            set.add(a[i]);
        }

        // Find the longest sequence
        for (int it : set) {
            // if 'it' is a starting number
            if (!set.contains(it - 1)) {
                // find consecutive numbers
                int cnt = 1;
                int x = it;
                while (set.contains(x + 1)) {
                    x = x + 1;
                    cnt = cnt + 1;
                }
                longest = Math.max(longest, cnt);
            }
        }

        System.out.println(longest);
    }

    public static void main(String[] args) {
        int a[] = { 100, 200, 1, 3, 2, 4 };
        getResultUsingSorting(a);
        getResultUsingHashing(a);
    }
}
