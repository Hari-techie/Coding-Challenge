/*
 * Problem Statement: Given an array of N integers. Find the elements that appear more than N/3 times in the array. If no such element exists, return an empty vector.
 * 
 * Examples
Example 1:
Input Format
: N = 5, array[] = {1,2,2,3,2}
Result
: 2
Explanation:
 Here we can see that the Count(1) = 1, Count(2) = 3 and Count(3) = 1.Therefore, the count of 2 is greater than N/3 times. Hence, 2 is the answer.

Example 2:
Input Format
:  N = 6, array[] = {11,33,33,11,33,11}
Result:
 11 33
Explanation:
 Here we can see that the Count(11) = 3 and Count(33) = 3. Therefore, the count of both 11 and 33 is greater than N/3 times. Hence, 11 and 33 is the answer.
 */

public class MajorityElementGreaterThanOneThirdOfSize {
    public static void main(String [] args) {
        // int a[] = {1,2,2,3,2};
        int a[] = {11,33,33,11,33,11};
        int ele1 = 0, ele2 = 0;
        int count1 = 0, count2 = 0;

        for(int i = 0; i < a.length; i ++) {
            if(count1 == 0 && ele1 != a[i]) {
                ele1 = a[i];
                count1++;
            }
            else if(count2 == 0 && ele2 != a[i]) {
                ele2 = a[i];
                count2++;
            }
            else if(ele1 != a[i]) {
                count1--;
            }
            else if(ele2 != a[i]) {
                count2--;
            }
            else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        if (ele1 > ele2) { 
            int temp = ele1; 
            ele1 = ele2; 
            ele2 = temp; 
        }
        for(int i = 0; i < a.length; i ++) {
            if(a[i] == ele1) {
                count1++;
            }
            if(a[i] == ele2) {
                count2++;
            }
        }

        if(count1 > a.length/3) {
            System.out.print(ele1 + " ");
        }
        if(count2 > a.length/3) {
            System.out.print(ele2 + " ");
        }
    }
}