/*
 * Problem Statement: Given two sorted arrays arr1 and arr2 of size m and n respectively, 
 * return the median of the two sorted arrays. The median is defined as the middle value of a sorted list of numbers. 
 * In case the length of the list is even, the median is the average of the two middle elements.

Examples
Example 1:
Input Format:
 n1 = 3, arr1[] = {2,4,6}, n2 = 3, arr2[] = {1,3,5}
Result:
 3.5
Explanation:
 The array after merging 'a' and 'b' will be { 1, 2, 3, 4, 5, 6 }. As the length of the merged list is even, 
 the median is the average of the two middle elements. Here two medians are 3 and 4. So the median will be 
 the average of 3 and 4, which is 3.5.

Example 2:
Input Format:
 n1 = 3, arr1[] = {2,4,6}, n2 = 2, arr2[] = {1,3}
Result:
 3
Explanation:
 The array after merging 'a' and 'b' will be { 1, 2, 3, 4, 6 }. The median is simply 3.
 */

public class MedianOf2SortedArray {

    public static double median(int a[], int b[]) {
        int n1 = a.length, n2 = b.length;
        int n = n1 + n2;
        int low = 0, high = n1;
        int mid1, mid2, r1, r2, l1, l2;
        int left = (n + 1) / 2;
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
                if(n % 2 == 1) {
                    return Math.max(l1, l2);
                }
                else { 
                    return (Math.max(l1, l2) + Math.min(r1, r2))/ 2.0;
                } 
            }
            else if(l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 7, 10, 12};
        int[] b = {2, 3, 6, 15};
        System.out.println("The median of two sorted arrays is " + median(a, b));
    }    
}
