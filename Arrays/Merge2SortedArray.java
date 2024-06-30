import java.util.*;
/*
 * Problem statement: Given two sorted arrays arr1[] and arr2[] of sizes n and m in non-decreasing order. Merge them in sorted order. Modify arr1 so that it contains the first N elements and modify arr2 so that it contains the last M elements.

Examples
Example 1:
Input:
 
n = 4, arr1[] = [1 4 8 10] 
m = 5, arr2[] = [2 3 9]

Output:
 
arr1[] = [1 2 3 4]
arr2[] = [8 9 10]

Explanation:

After merging the two non-decreasing arrays, we get, 1,2,3,4,8,9,10.

Example2:
Input:
 
n = 4, arr1[] = [1 3 5 7] 
m = 5, arr2[] = [0 2 6 8 9]

Output:
 
arr1[] = [0 1 2 3]
arr2[] = [5 6 7 8 9]

Explanation:

After merging the two non-decreasing arrays, we get, 0 1 2 3 5 6 7 8 9.
 */
public class Merge2SortedArray {
    
    public static void swap(int a[],int b[], int i, int j) {
        int temp = a[i];
        a[i] = b[j];
        b[j] = temp;
    }

    public static void main(String[] args) {
        int arr1[] = {0, 1, 3, 8};
        int arr2[] = {2, 6, 9, 11, 15};

        int m = arr1.length, n = arr2.length;
        int left = m - 1, right = 0;
        while(left > 0 && right < n) {
            if(arr2[right] < arr1[left]) {
                swap(arr1, arr2, left, right);
            }
            else {
                break;
            }
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for(int i = 0; i <  m; i++)
        {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();

        for(int j = 0; j <  n; j++)
        {
            System.out.print(arr2[j] + " ");
        }
    }
}
