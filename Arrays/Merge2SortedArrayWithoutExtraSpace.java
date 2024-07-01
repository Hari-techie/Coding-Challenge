
public class Merge2SortedArrayWithoutExtraSpace {

    public void swap(int a[], int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String [] args) {
        int a[] = {1, 4, 6, 8};
        int b[] = {3, 7, 8, 10};

        int i = 0, j = 0, m = a.length, n = b.length;

        while(i < m && j < n) {
            if(b[j] < a[i]) {
                
            }
        }
    }
} 