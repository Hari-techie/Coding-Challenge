/*
 * Problem Statement: Given an array of non-negative integers representation elevation of ground.
 *  Your task is to find the water that can be trapped after rain.

Examples:

Example 1:

Input: height= [0,1,0,2,1,0,1,3,2,1,2,1]

Output: 6

Explanation: As seen from the diagram 1+1+2+1+1=6 unit of water can be trapped

Example 2:

Input:  [4,2,0,3,2,5]

Output:9
 */

public class TrappingRainWater {

    public static void getTrappedWater(int a[]) {
        int left = 0, right = a.length - 1, leftMax = 0, rightMax = 0, res = 0;
        while(left < right) {
            if(a[left] <= a[right]) {
                if(a[left] >= leftMax) {
                    leftMax = a[left];
                }
                else {
                    res = res + leftMax - a[left];
                }
                left++;
            }
            else {
                if(a[right] >= rightMax) {
                    rightMax = a[right];
                }
                else {
                    res = res + rightMax - a[right];
                }
                right--;
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) {
        int a[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        getTrappedWater(a);
    }
}
