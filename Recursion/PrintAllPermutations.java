import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 * Problem Statement: Given an array arr of distinct integers, print all permutations of String/Array.

Examples:

Example 1: 

Input: arr = [1, 2, 3]

Output: 
[
  [1, 2, 3],
  [1, 3, 2],
  [2, 1, 3],
  [2, 3, 1],
  [3, 1, 2],
  [3, 2, 1]
]

Explanation: Given an array, return all the possible permutations.

Example 2:

Input: arr = [0, 1]

Output:
[
  [0, 1],
  [1, 0]
]

Explanation: Given an array, return all the possible permutations.
 */
public class PrintAllPermutations {

    public static void getAllPermutions(int a[], List<Integer> ds, List<List<Integer>> ans, boolean freq[]) {
        if(ds.size() == a.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i = 0; i < a.length; i ++) {
            if(!freq[i]) {
                freq[i] = true;
                ds.add(a[i]);
                getAllPermutions(a, ds, ans, freq);
                ds.remove(ds.size() - 1);
                freq[i] = false;
            }
        }
    }

    public static void printAllPerm(int a[]) {
        List<List<Integer>> ans = new ArrayList<>();
        getAllPermutions(a, new ArrayList<>(), ans, new boolean [a.length]);
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3};
        printAllPerm(nums);
    }
}
