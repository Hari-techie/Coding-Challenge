/*
 * Example 1:
Input:

 Nums = [1,2,3,4,5,0]
Output:

 120
Explanation:

 In the given array, we can see 1×2×3×4×5 gives maximum product value.


Example 2:
Input:
 Nums = [1,2,-3,0,-4,-5]
Output:

 20
Explanation:

 In the given array, we can see (-4)×(-5) gives maximum product value.
 */

public class MaximumProductSubarray {

    public static void findMax(int a[]) {
        int pref = 1, suf = 1, mx = Integer.MIN_VALUE, n = a.length;
        for(int i = 0;i < n; i ++) {
            if(pref == 0) pref = 1;
            if(suf == 0) suf = 1;
            pref = pref * a[i];
            suf = suf * a[n - i - 1];
            mx = Math.max(mx, pref);
            mx = Math.max(mx, suf);
        }

        System.out.println(mx);
    }

    public static void main(String[] args) {
        int a[] = {1,2,-3,0,-4,-5};
        findMax(a);        
    }
}
