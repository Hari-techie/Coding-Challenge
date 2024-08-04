import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Problem Statement: Given an array of integers that may contain duplicates the task is to return all possible subsets. 
 * Return only unique subsets and they can be in any order.

Examples:

Example 1:

Input: array[] = [1,2,2]

Output: [ [ ],[1],[1,2],[1,2,2],[2],[2,2] ]

Explanation: We can have subsets ranging from  length 0 to 3. which are listed above. 
Also the subset [1,2] appears twice but is printed only once as we require only unique subsets.

Input: array[] = [1]

Output: [ [ ], [1] ]

Explanation: Only two unique subsets are available
 */

public class PrintUniqueSubset {

    public static void getUniqSubset(int a[], List<List<Integer>> ans, List<Integer> ds, int ind) {// 0  1  

        ans.add(new ArrayList<>(ds)); // [] [1] [1, 2] [1, 2, 2]

        for(int i = ind; i < a.length; i ++) {
            if(i != ind && a[i] == a[i - 1]) {
                continue;
            }
            ds.add(a[i]); // 1 2 
            getUniqSubset(a, ans, ds,  i + 1);
            ds.remove(ds.size() - 1); // 
        }
    }

    public static void subsetsWithDup(int a[]) {
        Arrays.sort(a);
        List<List<Integer>> ans = new ArrayList<>();
        getUniqSubset(a, ans, new ArrayList<>(), 0);
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 2 };
        subsetsWithDup(nums);
    }
}
