import java.util.Scanner;
import java.util.Arrays;

/*
 * Problem Statement: Given a matrix if an element in the matrix is 0 
 * then you will have to set its entire column and row to 0 
 * and then return the matrix.
 * 
 * 

Examples 1:
Input:
 matrix=[[1,1,1],[1,0,1],[1,1,1]]

Output:
 [[1,0,1],[0,0,0],[1,0,1]]

Explanation:
 Since matrix[2][2]=0.Therefore the 2nd column and 2nd row wil be set to 0.
 
Input:
 matrix=[[0,1,2,0],[3,4,5,2],[1,3,1,5]]

Output:
[[0,0,0,0],[0,4,5,0],[0,3,1,0]]

Explanation:
Since matrix[0][0]=0 and matrix[0][3]=0. 
Therefore 1st row, 1st column and 4th column will be set to 0

*/

public class SetMatrixZero {

    public boolean checkForZeros(int element) {
        return element == 0;
    }

    public void convertGivenIndexedRowsAndColumnsIntoZero(int arr[][],int row, int column, int mxRow, int mxCol) {
       
        for(int i = 0; i < mxRow; i++) {
            arr[i][column] = 0;
        }

        for(int j = 0; j < mxCol; j++) {
            arr[row][j] = 0;
        }
    }

    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);
        SetMatrixZero setMatrixZero = new SetMatrixZero();
        
        System.out.println("Enter no of rows");
        int rows = sc.nextInt();
        
        System.out.println("Enter no of columns");
        int columns = sc.nextInt();

        int arr[][] = new int[rows][columns];
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                System.out.print("Enter value for "+i+" "+j +": ");
                arr[i][j] = sc.nextInt();
            }
        }

        int brr[][] = Arrays.stream(arr).map(int[]::clone).toArray(int[][]::new);

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
               if(setMatrixZero.checkForZeros(arr[i][j])) {
                setMatrixZero.convertGivenIndexedRowsAndColumnsIntoZero(brr, i, j, rows, columns);
               }
            }
        }

        System.out.println("Modified Array");
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                System.out.print(brr[i][j] + " ");
            }
            System.out.println("");            
        }

    }
}

/*
 * import java.util.Scanner;

public class SetMatrixZero {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter number of rows:");
        int rows = sc.nextInt();
        
        System.out.println("Enter number of columns:");
        int columns = sc.nextInt();

        int[][] arr = new int[rows][columns];
        
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        setZeroes(arr);

        System.out.println("Modified Array:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Check if the first row has any zeros
        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Check if the first column has any zeros
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // Use first row and first column as markers
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // Zero out cells based on markers
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Zero out the first row if needed
        if (firstRowZero) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }

        // Zero out the first column if needed
        if (firstColZero) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}

 */