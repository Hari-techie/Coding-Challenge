import java.util.*;;
/*
 * Problem Statement: We are given two arrays that represent the arrival and departure times of trains 
 * that stop at the platform. We need to find the minimum number of platforms needed at the railway 
 * station so that no train has to wait.

Examples 1:

Input: N=6, 
arr[] = {9:00, 9:45, 9:55, 11:00, 15:00, 18:00} 
dep[] = {9:20, 12:00, 11:30, 11:50, 19:00, 20:00}

Output:3
 */
public class MinimumPlatforms {

    public static int findPlatform(int arr[], int dep[], int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 0, j = 0, count = 0, mx = 0;
        while(i < n && j < n) {
            if(arr[i] < dep[j]) {
                i++;
                count++;
            }
            else {
                j++;
                count--;
            }
            mx = Math.max(count, mx);
        }

        return mx;
    }

    public static void main(String[] args) {
        int[] arr = {900,945,955,1100,1500,1800};
		int[] dep= {920,1200,1130,1150,1900,2000};
		int n = arr.length;
		int totalCount = findPlatform(arr,dep,n);
		System.out.println("Minimum number of Platforms required " + totalCount);
    }
}
