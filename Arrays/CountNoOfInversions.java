/*
 * Problem Statement: Given an array of N integers, count the inversion of the array (using merge-sort).

What is an inversion of an array? Definition: for all i & j < size of array, if i < j then you have to find pair (A[i],A[j]) such that A[j] < A[i].

Examples
Example 1:
Input Format
: N = 5, array[] = {1,2,3,4,5}
Result
: 0
Explanation
: we have a sorted array and the sorted array has 0 inversions as for i < j you will never find a pair such that A[j] < A[i]. More clear example: 2 has index 1 and 5 has index 4 now 1 < 5 but 2 < 5 so this is not an inversion.

Example 2:
Input Format
: N = 5, array[] = {5,4,3,2,1}
Result
: 10
Explanation
: we have a reverse sorted array and we will get the maximum inversions as for i < j we will always find a pair such that A[j] < A[i]. Example: 5 has index 0 and 3 has index 2 now (5,3) pair is inversion as 0 < 2 and 5 > 3 which will satisfy out conditions and for reverse sorted array we will get maximum inversions and that is (n)*(n-1) / 2.For above given array there is 4 + 3 + 2 + 1 = 10 inversions.

Example 3:
Input Format
: N = 5, array[] = {5,3,2,1,4}
Result
: 7
Explanation
: There are 7 pairs (5,1), (5,3), (5,2), (5,4),(3,2), (3,1), (2,1) and we have left 2 pairs (2,4) and (1,4) as both are not satisfy our condition. 

 */
public class CountNoOfInversions {

    public static int mergeSort(int a[], int start, int end) {
        int count = 0;
        if (start != end) {
            int mid = (start + end) / 2;
            count += mergeSort(a, start, mid);
            count += mergeSort(a, mid + 1, end);
            count += merge(a, start, mid, end);
        }
        return count;
    }

    public static int merge(int a[], int start, int mid, int end) {
        int i = start, j = mid + 1, k = 0;
        int temp[] = new int[end - start + 1];
        int count = 0;

        while (i <= mid && j <= end) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
                count += (mid - start + 1);
            }
        }

        while (i <= mid) {
            temp[k++] = a[i++];
        }

        while (j <= end) {
            temp[k++] = a[j++];
        }

        for (i = start; i <= end; i++) {
            a[i] = temp[i - start];
        }

        return count;
    }

    public static void main(String[] args) {
        int a[] = { 5, 4, 3, 2, 1 };
        int count = mergeSort(a, 0, a.length - 1);
        System.out.println(count);
    }
}
