
public class MedianInArray {

    public static int upperBound(int a[], int x, int n) {
        int low = 0, high = n - 1;
        int ans = n, mid;
        while(low <= high) {
            mid = (high + low)/ 2;
            if(a[mid] > x) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public  static int countSmallEqual(int[][] matrix, int m, int n, int x) {
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            cnt += upperBound(matrix[i], x, n);
        }
        return cnt;
    }

    public static int median(int a[][], int m, int n) {
        int high = Integer.MIN_VALUE, low = Integer.MAX_VALUE;
        
        for(int i = 0; i < m; i ++) {
            low = Math.min(low, a[i][0]);
            high = Math.max(high, a[i][n - 1]);
        }

        int req = (m * n) / 2;
        int mid;
        int smallerEqualCount;
        while(low <= high) {
            mid = (high + low)/2;
            smallerEqualCount = countSmallEqual(a, m, n, mid);
            if(smallerEqualCount <= req) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return low;
    }
    
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4, 5},
            {8, 9, 11, 12, 13},
            {21, 23, 25, 27, 29}
        };
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = median(matrix, m, n);
        System.out.println("The median element is: " + ans);        
    }
}
