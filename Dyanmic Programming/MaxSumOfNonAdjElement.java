/*
 * Problem Statement:

Given an array of ‘N’  positive integers, we need to return the maximum sum of the subsequence such that no two elements of 
the subsequence are adjacent elements in the array.

Note: A subsequence of an array is a list with elements of the array where some elements are deleted ( or not deleted at all) 
and the elements should be in the same order in the subsequence as in the array.
 */

import java.util.*;
public class MaxSumOfNonAdjElement
{   
    static void f(int ind, int a[], List<List<Integer>> dp, List<Integer> seq) {
        if (ind < 0) {
            dp.add(new ArrayList<>(seq));  // Add a copy of the current sequence
            return;
        }

        // Take the current element
        seq.add(a[ind]);
        f(ind - 1, a, dp, seq);

        // Backtrack: Don't take the current element
        seq.remove(seq.size() - 1);
        f(ind - 1, a, dp, seq);
    }
    
    static int fun(int ind, int a[]) {
        if(ind == 0) return a[ind];
        if(ind < 0) return 0;
        
        int take = a[ind] + fun(ind - 2, a);
        int notTake = fun(ind - 1, a);
        
        return Integer.max(take, notTake);
    }
    
    static int dpFun(int ind, int a[], int dp[]) {
        if(ind == 0) return dp[ind] = a[ind];
        if(ind < 0) return 0;
        
        if(dp[ind] != -1) return dp[ind];
        int take = a[ind] + dpFun(ind - 2, a, dp);
        int notTake = dpFun(ind - 1, a, dp);
        
        return dp[ind] = Integer.max(take, notTake);
    }
    
    static int tabFun(int ind, int a[]) {
        int dp[] = new int[4];
        dp[0] = a[0];
        for(int i = 1; i < a.length; i++) {
            int take = a[i];
            if(i != 1) take += dp[i - 2];
            int notTake = dp[i - 1];
            dp[i] = Integer.max(take, notTake);
        }
        return dp[ind];
    }

 	public static void main(String[] args) {
 	    int a[] = {2, 1, 4, 9};
 	    List<List<Integer>> ans = new ArrayList<>();
 	    f(3, a, ans, new ArrayList<>());
		System.out.println(ans);
 	    System.out.println(fun(3, a));
 	    int dp[] = new int[4];
 	    Arrays.fill(dp, -1);
 	    System.out.println(dpFun(3, a, dp));
    	System.out.println(tabFun(3, a));
	}
}
