/*
 * 
Problem Statement: Given an array of N + 1 size, where each element is between 1 and N. Assuming there is only one duplicate number, your task is to find the duplicate number.

Examples:

Example 1: 

Input: arr=[1,3,4,2,2]

Output: 2

Explanation: Since 2 is the duplicate number the answer will be 2.

Example 2:

Input: [3,1,3,4,2]

Output:3

Explanation: Since 3 is the duplicate number the answer will be 3.
 */

public class DuplicateInArray {
    public static void main(String[] args) {
        int a[] = {1,3,4,2,2};
        int slow = a[0];
        int fast = a[0];

        do {
            slow = a[slow];
            fast = a[a[fast]];
        } while(slow != fast);

        fast = a[0];
        while(slow != fast) {
            slow = a[slow];
            fast = a[fast];
        }

        System.out.println(slow);
    }
}
