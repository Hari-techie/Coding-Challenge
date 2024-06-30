/*
 * 
 * 
Problem Statement: Given an array consisting of only 0s, 1s, and 2s. Write a program to in-place sort the array without using inbuilt sort functions. ( Expected: Single pass-O(N) and constant space)

Examples
Input:
 nums = [2,0,2,1,1,0]
Output
: [0,0,1,1,2,2]

Input:
 nums = [2,0,1]
Output:
 [0,1,2]

Input:
 nums = [0]
Output:
 [0]
 */
public class SortArrayOf0s1s2s {

    public static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int a[] = new int[] {0,1,0,2,2,0,1,2};
        int n = a.length;
        int start = 0, end = n-1 , mid = 0;
        while(mid <= end) {
            if(a[mid] == 0) {
                swap(a, start, mid);
                start++;
                mid++;
            }
            else if(a[mid] == 1) {
                mid++;
            }
            else {
                swap(a, mid, end);
                end--;
            }
        }
        System.out.println(start+ " "+ mid + " "+ end);
        
        for(int i = 0; i < n; i ++) {
            System.out.print(a[i] + " ");
        }
    }
}
