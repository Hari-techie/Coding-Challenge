/*
 * Problem Statement: Given a double x and integer n, calculate x raised to power n. Basically Implement pow(x, n).

Examples:

Example 1:

Input: x = 2.00000, n = 10

Output: 1024.00000

Explanation: You need to calculate 2.00000 raised to 10 which gives ans 1024.00000

Example 2:

Input: x = 2.10000, n = 3

Output: 9.26100

Explanation: You need to calculate 2.10000 raised to 3 which gives ans 9.26100
 */

public class PowOfN {
    public static void main(String[] args) {
        int x = 2, n = 10;
        long y = x;
        long m = n;
        double ans = 1.0;
        if(n < 0) {
            m = m * -1;
        } 
        
        while(m != 0) {
            if(m%2 != 0) {
                ans *= y;
                m -= 1;
            }
            else {
                y *= y;
                m /= 2;
            }
        }

        if(n < 0) {
            ans = ans * -1.0;
        }

        System.out.println(ans);
    }
}

/*
 *  (2)^ 10 = (2) ^ (5*2) = 2^5 * 2^5 = (2*2)^5 = 4^5  = 1024
 *  4^5 = 4 * 4^4 = 256 * 4 = 1024
 *  4^4 = (4*4)^2 = 16^2 = 256
 *  16^2 = 16^1 * 16^1 = 256
 */
