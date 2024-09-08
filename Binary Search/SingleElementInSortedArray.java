/*
 * Problem Statement: Given an aay of N integers. Every number in the aay except one appears twice. 
 * Find the single number in the aay.
 * 
 * Examples
Example 1:
Input Format:
 a[] = {1,1,2,2,3,3,4,5,5,6,6}
Result:
 4
Explanation:
 Only the number 4 appears once in the aay.

Example 2:
Input Format:
 a[] = {1,1,3,5,5}
Result:
 3
Explanation:
 Only the number 3 appears once in the aay.
 */

import java.util.*; 
public class SingleElementInSortedArray {

    public static int singleNonDuplicate(ArrayList<Integer> a) {
        if(a.size() == 1) {
            return a.get(0);
        }
        if(!a.get(0).equals(a.get(1))) {
            return a.get(0);
        }
        if(!a.get(a.size() - 1).equals(a.get(a.size() - 2))) {
            return a.get(a.size() - 1);
        }

        int low = 1, high = a.size() - 2;
        while(low <= high) {
            int mid = (low + high) / 2;

            // If a[mid] is the single element:
            if (!a.get(mid).equals(a.get(mid + 1)) && !a.get(mid).equals(a.get(mid - 1))) {
                return a.get(mid);
            }

            // We are in the left:
            if ((mid % 2 == 1 && a.get(mid).equals(a.get(mid - 1)))
                    || (mid % 2 == 0 && a.get(mid).equals(a.get(mid + 1)))) {
                // Eliminate the left half:
                low = mid + 1;
            }
            // We are in the right:
            else {
                // Eliminate the right half:
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String [] args) {
        ArrayList<Integer> a =
            new ArrayList<>(Arrays.asList(1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6));
        int ans = singleNonDuplicate(a);
        System.out.println("The single element is: " + ans);
    }
}