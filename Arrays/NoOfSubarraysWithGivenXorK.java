import java.util.*;
/*
 * Problem Statement: Given an array of integers A and an integer B. Find the total number of subarrays having bitwise XOR of all elements equal to k.

Pre-requisite: Find the number of subarrays with the sum K

Examples
Example 1:
Input Format:
 A = [4, 2, 2, 6, 4] , k = 6
Result:
 4
Explanation:
 The subarrays having XOR of their elements as 6 are  [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], [6]

Example 2:
Input Format:
 A = [5, 6, 7, 8, 9], k = 5
Result:
 2
Explanation:
 The subarrays having XOR of their elements as 5 are [5] and [5, 6, 7, 8, 9]
 */
public class NoOfSubarraysWithGivenXorK {

    public static void getCount(int a[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int xor = 0;
        int count = 0;
        map.put(0, 1);

        for(int i = 0; i < a.length; i ++) {
            xor = xor ^ a[i];
            int x = xor ^ k;

            if(map.containsKey(x)) {
                count += map.get(x);
            }

            map.put(a[i], map.getOrDefault(xor, 0) + 1);
        }

        System.out.println(count);
    }

    public static void main(String[] args) {
        int a[] = {4, 2, 2, 6, 4};
        int k = 6;
        getCount(a, k);
    }
}
