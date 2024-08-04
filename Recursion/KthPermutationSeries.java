import java.util.ArrayList;
import java.util.List;

/*
 * Problem Statement: Given N and K, where N is the sequence of numbers from 1 to N([1,2,3..... N]) 
 * find the Kth permutation sequence.

For N = 3  the 3!  Permutation sequences in order would look like this:-
 1  123
 2  132
 3  213
 4  231
 5  312
 6  321

 Note: 1<=K<=N! Hence for a given input its Kth permutation always exists

Examples:

Example 1:

Input: N = 3, K = 3

Output: "213"

Explanation: The sequence has 3! permutations as illustrated in the figure above. K = 3 corresponds to the third sequence.

Example 2:

Input: N = 3, K = 5 

Result: "312"

Explanation: The sequence has 3! permutations as illustrated in the figure above. K = 5 corresponds to the fifth sequence.

 */
public class KthPermutationSeries {

    public static void getKthValue(int n, int k) {
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();
        for(int i = 1; i < n; i ++) {
            fact *= i; // 1*2 = 2
            numbers.add(i);
        }
        numbers.add(n); // 1 2 3
        k -= 1; // 4
        String ans = "";
        while (true) {
            ans = ans + "" + numbers.get(k / fact); // 3 1
            numbers.remove(k / fact); //  2
            if (numbers.size() == 0) {
                break;
            }

            k = k % fact; // 0 
            fact = fact / numbers.size(); // 1
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        int n = 3, k = 5;
        getKthValue(n, k);
    }
}
