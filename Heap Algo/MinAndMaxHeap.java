import java.util.Arrays;

public class MinAndMaxHeap {

    public static void heapifyMin(int a[], int i, int n) {
        int l = 2*i + 1;
        int r = 2*i + 2;
        int smallest = i;
        if(l < n && a[l] < a[i]) {
            smallest = l;
        }
        if(r < n && a[r] < a[smallest]) {
            smallest = r;
        }

        if(smallest != i) {
            int temp = a[smallest];
            a[smallest] = a[i];
            a[i] = temp; 
            heapifyMin(a, smallest, n);
        }
    }

    public static void buildMinHeap(int a[], int n) {
        for(int i = n/2 - 1; i >= 0; i--) {
            heapifyMin(a, i, n);
        }
    }

    public static void main(String[] args) {
        int a[] = {2, 7, 4, 6, 1, 9};
        buildMinHeap(a, a.length);
        System.out.println(Arrays.toString(a));
    }    
}
