/*
 * Problem Statement: You are given an array 'arr' of size 'n' which denotes the position of stalls.
You are also given an integer 'k' which denotes the number of aggressive cows.
You are given the task of assigning stalls to 'k' cows such that the minimum distance between any two of them is the maximum possible.
Find the maximum possible minimum distance.

Examples
Example 1:
Input Format:
 N = 6, k = 4, arr[] = {0,3,4,7,10,9}
Result:
 3
Explanation:
 The maximum possible minimum distance between any two cows will be 3 when 4 cows are placed at positions {0, 3, 7, 10}. 
 Here the distances between cows are 3, 4, and 3 respectively. We cannot make the minimum distance greater than 3 in any ways.

Example 2:
Input Format:
 N = 5, k = 2, arr[] = {4,2,1,3,6}
Result:
 5
Explanation:
 The maximum possible minimum distance between any two cows will be 5 when 2 cows are placed at positions {1, 6}.
 */

import java.util.*;

public class AggressiveCows {

    public static boolean canWePlaceCow(int a[], int cows, int dist) {
        int placedCows = 1;
        int lastDist = a[0];
        for(int i = 0; i < a.length; i++) {
            if(a[i] - lastDist >= dist) {
                placedCows++;
                lastDist = a[i];
            }

            if(placedCows >= cows) {
                return true;
            }
        }
        return false;
    }

    public static int aggressiveCows(int stalls[], int cows) {
        Arrays.sort(stalls);
        int low = stalls[0];
        int high = stalls[stalls.length - 1];
        while(low <= high) {
            int mid = (low + high)/ 2;
            if(canWePlaceCow(stalls, cows, mid)) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        int[] stalls = {0, 3, 4, 7, 10, 9};
        int k = 4;
        int ans = aggressiveCows(stalls, k);
        System.out.println("The maximum possible minimum distance is: " + ans);
    }
}
