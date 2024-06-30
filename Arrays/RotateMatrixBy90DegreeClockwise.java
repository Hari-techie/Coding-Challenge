/*
 * Problem Statement: Given a matrix, your task is to rotate the matrix 90 degrees clockwise.

Examples
Example 1:
Input:
 [[1,2,3],[4,5,6],[7,8,9]]

Output
: [[7,4,1],[8,5,2],[9,6,3]]

Explanation:
 Rotate the matrix simply by 90 degree clockwise and return the matrix.

Example 2:
Input:
 [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]

Output:
[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

Explanation:
 Rotate the matrix simply by 90 degree clockwise and return the matrix
 */
public class RotateMatrixBy90DegreeClockwise {

    public static void main(String[] args) {

        int a[][] = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        // Transpose the matrix
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a[0].length; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }

        // Reverse the row
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length/2; j++) {
                int temp = a[i][j];
                a[i][j] = a[i][a[0].length-j-1];
                a[i][a[0].length-j-1] = temp;
            }
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
               System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

    }
}
