/*
 * 
Problem Statement: Given an integer array arr, find the contiguous subarray (containing at least one number) which
has the largest sum and returns its sum and prints the subarray.

Examples
Example 1:
Input:
 arr = [-2,1,-3,4,-1,2,1,-5,4] 

Output:
 6 

Explanation:
 [4,-1,2,1] has the largest sum = 6. 

Examples 2:
Input:
 arr = [1] 

Output:
 1 

Explanation:
 Array has only one element and which is giving positive sum of 1. 
 */

public class MaximumSumInContagiousArray {
    public static void main(String[] args) {
        int a[] = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        int n = a.length;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int start = 0, end = 0;

        for(int i = 0; i < n; i++) {
            sum += a[i];
            if(sum > maxSum) {
                maxSum = sum;
                end = i;
            }
            if(sum < 0) {
                sum = 0;
                start = i+1;
            }
        }

        System.out.println("Maxsum : "+ maxSum);
        for(int i = start; i <= end; i ++) {
            System.out.print(a[i]+ " ");
        }
    }
}
