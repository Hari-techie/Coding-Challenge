import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Problem Statement: 

Given an array of distinct integers and a target, you have to return the list of all unique combinations where 
the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from the given array an unlimited number of times. Two combinations are unique i
f the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

Examples:

Example 1:

Input: array = [2,3,6,7], target = 7

Output: [[2,2,3],[7]]

Explanation: 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
             7 is a candidate, and 7 = 7.
             These are the only two combinations.


Example 2:

Input: array = [2], target = 1

Output: []

Explaination: No combination is possible.
 */

public class CombinationSum1 {

    public static void getSumSubset(int a[], List<List<Integer>> ans, List<Integer> ds, int ind, int target) {

        if (ind == a.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if (a[ind] <= target) {
            ds.add(a[ind]);
            getSumSubset(a, ans, ds, ind, target - a[ind]);
            ds.remove(ds.size() - 1);        
        }
        getSumSubset(a, ans, ds, ind + 1, target);
    }

    public static void subsetsWithGnSum(int a[], int target) {
        Arrays.sort(a);
        List<List<Integer>> ans = new ArrayList<>();
        getSumSubset(a, ans, new ArrayList<>(), 0, target);
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int a[] = { 2, 3, 6, 7 };
        int target = 7;
        subsetsWithGnSum(a, target);
    }
}
