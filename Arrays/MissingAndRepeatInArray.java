import java.util.*;

/*
 * 
Problem Statement: You are given a read-only array of N integers with values also in the range [1, N] both inclusive. Each integer appears exactly once except A which appears twice and B which is missing. The task is to find the repeating and missing numbers A and B where A repeats twice and B is missing.

Examples
Example 1:
Input Format
:  array[] = {3,1,2,5,3}
Result
: {3,4)
Explanation
: A = 3 , B = 4 
Since 3 is appearing twice and 4 is missing

Example 2:
Input Format
: array[] = {3,1,2,5,4,6,7,5}
Result
: {5,8)
Explanation
: A = 5 , B = 8 
Since 5 is appearing twice and 8 is missing
 */
public class MissingAndRepeatInArray {

    public static void find_dm(int a[], int n) {
        int sum_n = n * (n + 1) / 2; // 1 to n
        int sum_n2 = n * (n + 1) * ((2 * n) + 1) / 6;
        int sum_a = 0, sum_a2 = 0;
        for (int i = 0; i < n; i++) {
            sum_a += a[i];
            sum_a2 = sum_a2 + (a[i] * a[i]);
        }
        int x_y = sum_n - sum_a; // sum+x+y - (sum+2y) = x-y
        int x2_y2 = sum_n2 - sum_a2;
        int xy = x2_y2 / x_y; // x2-y2 = (x+y)(x-y) ==> (x+y is written as xy bcz + not allowed in variable)
        int x = (xy + x_y) / 2;
        int y = xy - x;
        System.out.println("Missing number : " + x);
        System.out.println("Repeating number : " + y);
    }

    public static void findUsingMap(int a[], int n) {
        HashMap<Integer, Boolean> h = new HashMap<>();
        int i, r = a[0], m = a[0];
        for (i = 0; i < n; i++) {
            if (h.get(a[i]) == null) {
                h.put(a[i], true);
            } else {
                r = a[i];
            }
        }
        for (i = 1; i <= n; i++) {
            if (h.get(i) == null) {
                m = i;
                break;
            }
        }
        System.out.println("Missing number : " + m);
        System.out.println("Repeating number : " + r);
        System.out.println(h);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        int i;
        for (i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        find_dm(a, n);
        findUsingMap(a, n);
    }
}
