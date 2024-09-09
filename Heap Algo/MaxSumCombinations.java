import java.util.*;
/*
 * Given two equally sized 1-D arrays A, B containing N integers each.

A sum combination is made by adding one element from array A and another element of array B.

Return the maximum C valid sum combinations from all the possible sum combinations.



Problem Constraints
1 <= N <= 105

1 <= A[i] <= 105

1 <= C <= N



Input Format
First argument is an one-dimensional integer array A of size N.

Second argument is an one-dimensional integer array B of size N.

Third argument is an integer C.



Output Format
Return a one-dimensional integer array of size C denoting the top C maximum sum combinations.

NOTE:

The returned array must be sorted in non-increasing order.



Example Input
Input 1:

 A = [3, 2]
 B = [1, 4]
 C = 2
Input 2:

 A = [1, 4, 2, 3]
 B = [2, 5, 1, 6]
 C = 4


Example Output
Output 1:

 [7, 6]
Output 1:

 [10, 9, 9, 8]


Example Explanation
Explanation 1:

 7     (A : 3) + (B : 4)
 6     (A : 2) + (B : 4)
Explanation 2:

 10   (A : 4) + (B : 6)
 9   (A : 4) + (B : 5)
 9   (A : 3) + (B : 6)
 8   (A : 3) + (B : 5)
 */
public class MaxSumCombinations {

    public static List<Integer> maxSumCombinations(int[] A, int[] B, int C) {
        Arrays.sort(A);
        Arrays.sort(B);
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        Set<String> visited = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        pq.add(new int[] {A[A.length - 1] + B[B.length - 1], A.length - 1, B.length - 1});
        visited.add((A.length-1) + "-" + (B.length-1));

        for(int i = 0; i < C; i++) {
            int current[] = pq.poll();
            int sum = current[0];
            int aInd = current[1];
            int bInd = current[2];

            result.add(sum);

            if(aInd - 1 >= 0 && !visited.contains((aInd-1) + "-" + bInd)) {
                pq.add(new int[] {A[aInd - 1] + B[bInd], aInd - 1, bInd});
                visited.add((aInd - 1) + "-" + bInd);
            }

            if(bInd - 1 >= 0 && !visited.contains(aInd + "-" + (bInd - 1))) {
                pq.add(new int[] {A[aInd] + B[bInd - 1], aInd, bInd - 1});
                visited.add(aInd + "-" + (bInd - 1));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] A1 = {3, 2};
        int[] B1 = {1, 4};
        int C1 = 2;

        int[] A2 = {1, 4, 2, 3};
        int[] B2 = {2, 5, 1, 6};
        int C2 = 4;

        System.out.println(maxSumCombinations(A1, B1, C1)); // Output: [7, 6]
        System.out.println(maxSumCombinations(A2, B2, C2)); // Output: [10, 9, 9, 8]
    }
}