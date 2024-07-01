import java.util.*;

/**
 * 
Problem Statement: This problem has 3 variations. They are stated below:

Variation 1: Given row number r and column number c. Print the element at position (r, c) in Pascal’s triangle.

Variation 2: Given the row number n. Print the n-th row of Pascal’s triangle.

Variation 3: Given the number of rows n. Print the first n rows of Pascal’s triangle.
 */

public class PascalTriangle {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);

        // System.out.println("Enter n and r");

        // int n = sc.nextInt();
        // int r = sc.nextInt();
        // n -= 1;
        // r -= 1;
        // int result = 1;

        // for(int i = 0; i < r; i++) {
        //     result = result * (n-i);
        //     result = result / (i+1);
        // }

        // System.out.println("Output is : "+ result);

//         5C3
	 
//         5!
//         3! 2!
   
//         5 4 3 2
//         3 2 2
   
//         5 4 3 
//         3 2 1
   
//         10

            System.out.println("Enter n : ");
            int n = sc.nextInt();
            int result;
            for(int i = 0; i < n; i++) {
                if(i == 0 || i == n-1) {
                    System.out.print("1 ");
                }
                else {
                    result = (n-i)/i;
                    System.out.print(result+" ");
                }
            }

//         Current element = prevElement * (rowNumber - colIndex) / colIndex

    }
}