/*
 * Problem Statement: You have been given a 2-D array 'mat' of size 'N x M' where 'N' and 'M' denote the number of rows and columns, respectively. The elements of each row are sorted in non-decreasing order. Moreover, the first element of a row is greater than the last element of the previous row (if it exists). You are given an integer ‘target’, and your task is to find if it exists in the given 'mat' or not.

Examples
Example 1:
Input Format:
 N = 3, M = 4, target = 8,
mat[] = 
1 2 3 4
5 6 7 8 
9 10 11 12
Result:
 true
Explanation:
 The ‘target’  = 8 exists in the 'mat' at index (1, 3).

Example 2:
Input Format:
 N = 3, M = 3, target = 78,
mat[] = 
1 2 4
6 7 8 
9 10 34
Result:
 false
Explanation:
 The ‘target' = 78 does not exist in the 'mat'. Therefore in the output, we see 'false'
 */

public class SearchInSorted2dArray {

    public static boolean binearySearch(int a[],int k) {
        int start = 0, end = a.length -1, mid = 0;

        while(mid <= end) {
            mid = (start + end)/ 2;
            if(a[mid] == k) {
                return true;
            }
            else if(a[mid] < k) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        return false;
    }

    public static void isPresentElement(int a[][], int n, int m, int k) {
        int start = 0, end = (m * n) - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            int row = mid / m;
            int col = mid % m;
            if(a[row][col] == k) {
                System.out.println("true");
                return;
            }
            else if(a[row][col] < k) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        System.out.println("false");
    }

    public static void main(String[] args) {
        int a[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int target = 8;
        int n = 3;
        int m = 4;
        boolean isFound = false;

        for(int i = 0; i < n; i ++) {
            if(a[i][0] <= target && a[i][m-1] >= target) {
                isFound = binearySearch(a[i], target);
            }
        }

        System.out.println(isFound);

        isPresentElement(a, n, m, target);
       

    }
}
