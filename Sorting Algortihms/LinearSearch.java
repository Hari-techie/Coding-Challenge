import java.util.Scanner;

public class LinearSearch {

    public static int search(int a[], int key) {

        for(int i = 0; i < a.length; i++) {
            if(a[i] == key) {
                return i;
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