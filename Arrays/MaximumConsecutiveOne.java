/*
 * Problem Statement: Given an array that contains only 1 and 0 return the count of maximum consecutive ones in the array.

Examples:

Example 1:

Input: prices = {1, 1, 0, 1, 1, 1}

Output: 3

Explanation: There are two consecutive 1’s and three consecutive 1’s in the array out of which maximum is 3.

Input: prices = {1, 0, 1, 1, 0, 1} 

Output: 2

Explanation: There are two consecutive 1's in the array. 
 */

public class MaximumConsecutiveOne {

    public static void getCount(int a[]) {
        int count = 0, mx = 0;
        for(int i = 0; i < a.length; i ++) {
            if(a[i] == 1) {
                count++;
                mx = Math.max(mx, count);
            }
            else {
                count = 0;
            }
        }

        System.out.println(mx);
    }

    public static void main(String[] args) {
        int a[] = {1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0};
        getCount(a);
    }
}
