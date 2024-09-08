/*
 * Problem Statement: Given two numbers N and M, find the Nth root of M. 
 * The nth root of a number M is defined as a number X when raised to the power N equals M. If the 'nth root is not an integer, return -1.

Examples
Example 1:
Input Format:
 N = 3, M = 27
Result:
 3
Explanation:
 The cube root of 27 is equal to 3.

Example 2:
Input Format:
 N = 4, M = 69
Result:
 -1
Explanation:
 The 4th root of 69 does not exist. So, the answer is -1.
 */
public class NthRootOfNumber {

    public static int getProd(int n, int m) {
        int res = 1;
        for(int i = 1; i <= m; i ++) {
            res = res * n;
        }
        return res;
    }

    public static void getAns(int n, int m) {
        int low = 1, high = m, mid, prod;
        while(low <= high) {
            mid = (low + high) / 2;
            prod = getProd(mid, n);
            if(prod == m) {
                System.out.println("Ans : " + mid);
                break;
            }
            else if(prod < m) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
    }

    public static void main(String [] args) {
        int n = 3, m = 27;
        getAns(n, m);
    }
}