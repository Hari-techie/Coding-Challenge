import java.util.*;

/*
 * Problem Statement: Given an unsorted array, print Kth Largest and Smallest Element from an unsorted array.

Examples:

Example 1:
Input: Array = [1,2,6,4,5,3] , K = 3 
Output: kth largest element = 4, kth smallest element = 3

Example 2:
Input: Array = [1,2,6,4,5] , k = 3
Output : kth largest element = 4,  kth smallest element = 4
 */
public class KthLargestElement {
    public static void getKthSmallest(int a[], int k) {
        Queue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < a.length; i ++) {
            pq.add(a[i]);
        }

        k--;
        while(k > 0) {
            pq.poll();
            k--;
        }
        System.out.println(k + "th smallest element is " + pq.peek());
    }

    public static void getKthLargest(int a[], int k) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < a.length; i ++) {
            pq.add(a[i]);
        }

        k = a.length - k - 1;
        while(k > 0) {
            pq.poll();
            k--;
        }
        System.out.println(k + "th largest element is " + pq.peek());
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 6, 4, 5, 3};
        getKthSmallest(a, 3);
        getKthLargest(a, 3);
    }
}
