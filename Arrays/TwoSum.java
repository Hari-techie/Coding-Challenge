import java.util.*;
/*
 * Problem Statement: Given an array of integers arr[] and an integer target.

1st variant: Return YES if there exist two numbers such that their sum is equal to the target. Otherwise, return NO.

2nd variant: Return indices of the two numbers such that their sum is equal to the target. Otherwise, we will return {-1, -1}.

Note: You are not allowed to use the same element twice. Example: If the target is equal to 6 and num[1] = 3, then nums[1] + nums[1] = target is not a solution.

Examples:

Example 1:
Input Format: N = 5, arr[] = {2,6,5,8,11}, target = 14
Result: YES (for 1st variant)
       [1, 3] (for 2nd variant)
Explanation: arr[1] + arr[3] = 14. So, the answer is YES for the first variant and [1, 3] for 2nd variant.

Example 2:
Input Format: N = 5, arr[] = {2,6,5,8,11}, target = 15
Result: NO (for 1st variant)
	[-1, -1] (for 2nd variant)
Explanation: There exist no such two numbers whose sum is equal to the target.
 */

public class TwoSum {

    public static void findByHashing(int n, int target, int a[]) {
        int isFound = 0;

        HashMap<Integer, Integer> ansMap = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int numNeedToAchieveTarget = target - a[i];
            if(ansMap.containsKey(numNeedToAchieveTarget)) {
                System.out.println(numNeedToAchieveTarget+ " "+ a[i]);
                isFound = 1;
                break;
            }
            ansMap.put(a[i], 1);
        }

        if(isFound == 0) {
            System.out.print("Not found");
        }
    }

    public static void findByTwoPointer(int n, int target, int a[]) {
        Arrays.sort(a);
        int isFound = 0;
        int left = 0, right = n-1;
        while(left < right) {
            int sum = a[left] + a[right];
            if(sum == target) {
                isFound = 1;
                System.out.print(a[left]+ " "+ a[right]);
                break;
            }
            else if(sum < target) {
                left++;
            }
            else {
                right--;
            }
        }

        if(isFound == 0) {
            System.out.print("Not found");
        }
    }

    public static void main(String [] args) {
        int a[] = {2,6,5,8,11};
        int n = 5, target = 14;
        findByHashing(n, target, a);
        findByTwoPointer(n, target, a);
    }
}