import java.util.Scanner;

public class BinarySearch {

    public static int search(int a[], int key) {
        int start = 0;
        int end = a.length - 1;
        int mid;

        while(start <= end) {

            mid = (start + end)/ 2;

            if(a[mid] == key) {
                return mid;
            }
            else if(a[mid] < key) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length of array : ");
        int n = sc.nextInt();
        int a[] = new int[n];

        System.out.print("Enter array values : ");
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.print("Enter value to search : ");
        int key = sc.nextInt();
        int ind = search(a,key);

        System.out.print("Value is present in index : "+ind);
    }   
}