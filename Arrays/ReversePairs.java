/*
 * Problem Statement: Given an array of numbers, you need to return the count of reverse pairs. Reverse Pairs are those pairs where i<j and arr[i]>2*arr[j].

Examples
Example 1:
Input:
 N = 5, array[] = {1,3,2,3,1)

Output
: 2 

Explanation:
 The pairs are (3, 1) and (3, 1) as from both the pairs the condition arr[i] > 2*arr[j] is satisfied.

Example 2:
Input:
 N = 4, array[] = {3,2,1,4}

Output:
 1

Explaination: 
There is only 1 pair  ( 3 , 1 ) that satisfy the condition arr[i] > 2*arr[j]
 */
public class ReversePairs {

    public static int mergeSort(int a[], int start, int end) {
        int count = 0;
        if (start != end) {
            int mid = (start + end) / 2;
            count += mergeSort(a, start, mid);
            count += mergeSort(a, mid + 1, end);
            count += countPairs(a, start, mid, end);
            merge(a, start, mid, end);
        }
        return count;
    }

    public static int countPairs(int a[], int start, int mid, int end) {
        int right = mid + 1;
        int count = 0;
        for(int i = start; i <= mid; i ++) {
            while(right <= end && a[i] > 2*a[right]) right++;
            count += (right - (mid + 1));
        }
        return count;
    }

    public static void merge(int a[], int start, int mid, int end) {
        int i = start, j = mid + 1, k = 0;
        int temp[] = new int[end - start + 1];

        while (i <= mid && j <= end) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
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
    }

    public static void main(String[] args) {
        // int a[] = { 1, 3, 2, 3, 1 };
        int a[] = {3, 2, 1, 4};
        int count = mergeSort(a, 0, a.length - 1);
        System.out.println(count);
    }
}
