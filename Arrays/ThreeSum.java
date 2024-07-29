import java.util.*;
/*
 * Problem Statement: Given an array of N integers, your task is to find unique triplets 
 * that add up to give a sum of zero. In short, you need to return an array of all 
 * the unique triplets [arr[a], arr[b], arr[c]] such that i!=j, j!=k, k!=i, and their
 * sum is equal to zero.
 * 
 * Examples
Example 1:
Input:
 nums = [-1,0,1,2,-1,-4]

Output:
 [[-1,-1,2],[-1,0,1]]

Explanation:
 Out of all possible unique triplets possible, [-1,-1,2] and [-1,0,1] 
 satisfy the condition of summing up to zero with i!=j!=k

Example 2:
Input:
 nums=[-1,0,1,0]
Output:
 Output: [[-1,0,1],[-1,1,0]]
Explanation:
 Out of all possible unique triplets possible, [-1,0,1] and [-1,1,0] 
 satisfy the condition of summing up to zero with i!=j!=k
 */

public class ThreeSum {

    public static void getTriplet(int a[]) {
        Arrays.sort(a);
        List<List<Integer>> result = new ArrayList<>();
        int i, j, k, n = a.length, sum;
        for(i = 0; i < n; i ++) {
            if(i != 0 && a[i] == a[i - 1]) continue;

            j = i + 1;
            k = n - 1;
            while(j < k) {
                sum = a[i] + a[j] + a[k];
                if(sum < 0){
                    j++;
                }
                else if(sum > 0) {
                    k--;
                } 
                else {
                    List<Integer> ans = Arrays.asList(a[i], a[j], a[k]);
                    result.add(ans);
                    j++;
                    k--;
                    while(j < k && a[j] == a[j - 1]) j++;
                    while(j < k && a[k] == a[k + 1]) k--;
                }
            }
        }

        result.forEach(item -> {
            System.out.println(item);
        });
    }

    public static void main(String [] args) {
        int a[] = {0, 1, -2, 2, 0, 2, -2, 1, 0, 2, 2, 1, -2};
        getTriplet(a);
    }
}