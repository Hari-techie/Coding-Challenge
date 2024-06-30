
/*
 * 
Problem Statement: Given an array Arr[] of integers, rearrange the numbers of the given array into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange to the lowest possible order (i.e., sorted in ascending order).

Examples
Example 1 :

Input format:
 Arr[] = {1,3,2}
Output
: Arr[] = {2,1,3}
Explanation: 
All permutations of {1,2,3} are {{1,2,3} , {1,3,2}, {2,13} , {2,3,1} , {3,1,2} , {3,2,1}}. So, the next permutation just after {1,3,2} is {2,1,3}.
Example 2:

Input format:
 Arr[] = {3,2,1}
Output: 
Arr[] = {1,2,3}
Explanation: 
As we see all permutations of {1,2,3}, we find {3,2,1} at the last position. So, we have to return the topmost permutation.
 * 
 */

public class NextPermutation {

    public static void reverseArray(int a[], int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
           swap(a, i, j);
        }
    }

    public static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // 2 1// 5 4 3 0 0

    public static void main(String[] args) {
        // int a[] = new int[] {1, 3, 2 };
        // int a[] = new int[] { 3, 2, 1 };
        // int a[] = new int[] { 2, 1, 5, 4, 3, 0, 0 };
        int a[] = new int[] {1, 1, 5};

        int n = a.length;
        int ind = -1;

        // Finding break point
        for (int i = n - 2; i >= 0; i--) {
            if (a[i] < a[i + 1]) {
                ind = i;
                break;
            }
        }

        // If already sorted in descending, sort it in ascending
        if (ind == -1) {
            reverseArray(a, 0, n - 1);
        }
        else {
            System.out.println(ind);

            // Finding next element greater than break point
            for(int i = n - 1; i >= ind; i--) {
                if(a[i] > a[ind]) {
                    swap(a, i, ind);
                    break;
                }
            }

            reverseArray(a, ind + 1, n - 1);

        }

        System.out.println("Next Permutation : ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }
}