/*
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time

Example 1:
Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

Example 2:

Input: grid = [[1,2,3],[4,5,6]]
Output: 12
 */
public class MinimumPathSum
{
    public static int fun(int a[][], int i, int j) {
        if(i == 0 && j == 0) return a[i][j]; 
        if(i < 0 || j < 0) return (int) Math.pow(10, 9); 
        int up = a[i][j] + fun(a, i - 1, j);  
        int down = a[i][j] + fun(a, i, j - 1);
        return Integer.min(up, down);
    }

    public static int recFum(int i, int j, int n, int a[][]) {
        if(i == n - 1) return a[i][j];

        int down = a[i][j] + recFum(i+1, j, n, a);
        int diagonal = a[i][j] + recFum(i+1, j+1, n, a);
        return Integer.min(down, diagonal);
    }

	public static void main(String[] args) {
	    // int a[][] = {
	    //     {5, 9, 6},
	    //     {11, 5, 2}
	    // };
        // int a[][] = {
        //     {1, 2, 3},
        //     {4, 5, 6}
        // };
	    // System.out.println(fun(a, 1, 2));

         int triangle[][] = {{1},
                            {2, 3},
                            {3, 6, 7},
                            {8, 9, 6, 10}};

        int n = triangle.length;
        System.out.println(recFum(0,0, n, triangle));
	}
}
