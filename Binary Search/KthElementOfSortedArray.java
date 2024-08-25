/*
 * Problem statement
You're given two sorted arrays 'arr1' and 'arr2' of size 'n' and 'm' respectively and an element 'k'.

Find the element that would be at the 'kth' position of the combined sorted array.

Position 'k' is given according to 1 - based indexing, but arrays 'arr1' and 'arr2' are using 0 - based indexing.

For example :
Input: 'arr1' = [2, 3, 45], 'arr2' = [4, 6, 7, 8] and 'k' = 4
Output: 6
Explanation: The merged array will be [2, 3, 4, 6, 7, 8, 45]. The element at position '4' of this array is 6. 
Hence we return 6.

Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
5
2 3 6 7 9
4
1 4 8 10
4
Sample Output 1:
4
Explanation of sample input 1 :
The merged array will be: [1, 2, 3, 4, 6, 7, 8, 9, 10]

The element at position '4' is 4 so we return 4.
Sample Input 2:
5
1 2 3 5 6
5
4 7 8 9 100  
6
Sample Output 2:
6
Explanation of sample input 2 :
The merged array will be: [1, 2, 3, 4, 5, 6, 7, 8, 9, 100]

The element at position '6'  is 6, so we return 6.
 */

public class KthElementOfSortedArray {
    public static int getKthElement(int a[], int b[], int k) {
        int n1 = a.length, n2 = b.length;
        if(n1 < n2) getKthElement(b, a, k);
        int n = n1 + n2;
        int low = Integer.max(0, k - n2), high = Integer.min(n1, k);
        int mid1, mid2, r1, r2, l1, l2;
        int left = k;
        while(low <= high) {
            mid1 = (low + high) / 2;
            mid2 = left - mid1;
            l1 = Integer.MIN_VALUE;
            l2 = Integer.MIN_VALUE;
            r1 = Integer.MAX_VALUE;
            r2 = Integer.MAX_VALUE;
            if(mid1 - 1 >= 0) l1 = a[mid1 - 1];
            if(mid2 - 1 >= 0) l2 = b[mid2 - 1];
            if(mid1 < n1) r1 = a[mid1];
            if(mid2 < n2) r2 = b[mid2];
            if(l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);                
            }
            else if(l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 7, 10, 12};
        int[] b = {2, 3, 6, 15};
        int k = 5;
        System.out.println("The " + k + "th element of two sorted arrays is " + getKthElement(a, b, k));
    }
}
