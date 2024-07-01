
/*
 * Problem Statement: Given an array of N integers, write a program to return an element that occurs more than N/2 times in the given array. You may consider that such an element always exists in the array.

Examples
Example 1:
Input Format
: N = 3, nums[] = {3,2,3}
Result
: 3
Explanation
: When we just count the occurrences of each number and compare with half of the size of the array, you will get 3 for the above solution. 

Example 2:
Input Format:
  N = 7, nums[] = {2,2,1,1,1,2,2}

Result
: 2

Explanation
: After counting the number of times each element appears and comparing it with half of array size, we get 2 as result.

Example 3:
Input Format:
  N = 10, nums[] = {4,4,2,4,3,4,4,3,2,4}

Result
: 4
 */
public class MajorityElementGreaterThanHalfOfSize {
    public static void main(String [] args) {
        // int a[] = {4,4,2,4,3,4,4,3,2,4};
        int a[] = {3,2,3};
        int element = 0, count = 0;
        for(int i = 0; i < a.length; i ++) {
            if(count == 0) {
                element = a[i];
                count++;
            }
            else if(a[i] == element) {
                count++;
            }
            else {
                count--;
            }
        }

        for(int i = 0; i < a.length; i ++) {
            if(a[i] == element) {
                count++;
            }
        }

        if(count > a.length / 2) {
            System.out.print("Element found : "+ element);
        }
        else {
            System.out.print("Element not found");  
        }
    }
}