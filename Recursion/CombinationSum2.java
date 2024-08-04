import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * "Combination Sum II - Find all unique combinations".

Problem Statement: Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target. Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

Examples:

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8

Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]]


Explanation: These are the unique combinations whose sum is equal to target.
 
Example 2:

Input: candidates = [2,5,2,1,2], target = 5

Output: [[1,2,2],[5]]

Explanation: These are the unique combinations whose sum is equal to target.
 */

public class CombinationSum2 {

    public static void getSumSubset(int a[], List<List<Integer>> ans, List<Integer> ds, int ind, int target) {

        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = ind; i < a.length; i++) {
            if (i > ind && a[i] == a[i - 1]) {
                continue;
            }
            if(a[i] > target) {
                break;
            }
            ds.add(a[i]);
            getSumSubset(a, ans, ds, i + 1, target - a[i]);
            ds.remove(ds.size() - 1);
        }
    }

    public static void subsetsWithGnSum(int a[], int target) {
        Arrays.sort(a);
        List<List<Integer>> ans = new ArrayList<>();
        getSumSubset(a, ans, new ArrayList<>(), 0, target);
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int a[] = { 2, 5, 2, 1, 2 };
        int target = 5;
        subsetsWithGnSum(a, target);
    }
}
