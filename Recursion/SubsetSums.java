import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Problem Statement: Given an array print all the sum of the subset generated from it, in the increasing order.

Examples:

Example 1:

Input: N = 3, arr[] = {5,2,1}

Output: 0,1,2,3,5,6,7,8

Explanation: We have to find all the subset’s sum and print them.in this case 
the generated subsets are [ [], [1], [2], [2,1], [5], [5,1], [5,2]. [5,2,1],so the sums we get will be  0,1,2,3,5,6,7,8


Input: N=3,arr[]= {3,1,2}

Output: 0,1,2,3,3,4,5,6

Explanation: We have to find all the subset’s sum and print them.in this case 
the generated subsets are [ [], [1], [2], [2,1], [3], [3,1], [3,2]. [3,2,1],so the sums we get will be  0,1,2,3,3,4,5,6
 */
public class SubsetSums {

    public static void subsetSum(List<Integer> a, List<Integer> res, int sum, int ind) {
        if (ind == a.size()) {
            res.add(sum);
            return;
        }
        subsetSum(a, res, sum + a.get(ind), ind + 1);
        subsetSum(a, res, sum, ind + 1);
    }

    public static void getSubsetSum(List<Integer> a) {
        List<Integer> res = new ArrayList<>(); 
        subsetSum(a, res, 0, 0);
        Collections.sort(res);
        System.out.println(res);
    }

    public static void main(String[] args) {
        int n = 3;
        List<Integer> a = Arrays.asList(3, 1, 2);
        getSubsetSum(a);
    }
}
