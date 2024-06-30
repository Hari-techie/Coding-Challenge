import java.util.*;
/*
 * Problem Statement: Given an array of N integers, your task is to find unique quads that add up to give a target value. 
 * In short, you need to return an array of all the unique quadruplets [arr[a], arr[b], arr[c], arr[d]] 
 * such that their sum is equal to a given target.
 * 
 * Note:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
arr[a] + arr[b] + arr[c] + arr[d] == target

Examples
Example 1:
Input Format:
 arr[] = [1,0,-1,0,-2,2], target = 0
Result:
 [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Explanation:
 We have to find unique quadruplets from the array such that the sum of those elements is equal to the target sum given that is 0. The result obtained is such that the sum of the quadruplets yields 0.

Example 2:
Input Format:
 arr[] = [4,3,3,4,4,2,1,2,1,1], target = 9
Result:
 [[1,1,3,4],[1,2,2,4],[1,2,3,3]]
Explanation:
 The sum of all the quadruplets is equal to the target i.e. 9.
 */

public class FourSum {

    public static void getResult(int a[], int target) {
        Arrays.sort(a);
        int n = a.length;
        List<List<Integer>> ansList = new ArrayList<>();

        for(int i = 0; i < n; i ++) {
            if(i > 0 && a[i] == a[i - 1]) continue;
            for(int j = i + 1; j < n; j++) {
                if(j != i + 1 && a[j] == a[j - 1]) continue;

                int k = j + 1;
                int l = n - 1;
                while(k < l) {
                    int sum = a[i] + a[j] + a[k] + a[l];
                    if(sum == target) {
                        List<Integer> res = new ArrayList<>();
                        res.add(a[i]);
                        res.add(a[j]);
                        res.add(a[k]);
                        res.add(a[l]);
                        ansList.add(res);

                        k++; l--;
                        while(k < l && a[k] == a[k - 1]) k++;
                        while(k < l && a[l] == a[l + 1]) l--;
                    }
                    else if(sum < target) k++;
                    else l--;
                }
            }
        }

        ansList.forEach(quads -> {
            System.out.println(quads);
        });
    }

    public static void main(String[] args) {
        int a[] = {4,3,3,4,4,2,1,2,1,1};
        int target = 9;
        getResult(a, target);
    }    
}
