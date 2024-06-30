import java.util.*;
/*
 * 
Problem Statement: Given an array of intervals, merge all the overlapping intervals and return an array of non-overlapping intervals.

Examples
Example 1:
Input:
 intervals=[[1,3],[2,6],[8,10],[15,18]]

Output:
 [[1,6],[8,10],[15,18]]

Explanation:
 Since intervals [1,3] and [2,6] are overlapping we can merge them to form [1,6]
 intervals.

Example 2:
Input:
 [[1,4],[4,5]]

Output:
 [[1,5]]

Explanation:
 Since intervals [1,4] and [4,5] are overlapping we can merge them to form [1,5].
 */
import java.util.stream.Collectors;

public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        int a[][] = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        List<List<Integer>> intervals = Arrays.stream(a)
                .map(row -> Arrays.stream(row)
                        .boxed()
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
        List<List<Integer>> ans = new ArrayList<>();

        // Arrays.sort(a, (x, y) -> {
        //     if (x[0] != 0 && y[0] != 0) {
        //         return Integer.compare(x[0], y[0]);
        //     } else {
        //         return Integer.compare(x[1], y[1]);
        //     }
        // });
        intervals.sort(Comparator.comparingInt(o -> o.get(0)));


        // for (int[] row : a) {
        //     System.out.println(Arrays.toString(row));
        // }
        System.out.println("Sorted array");
        intervals.forEach(System.out::println);

        for (int i = 0; i < intervals.size(); i++) {
            if(ans.isEmpty() || intervals.get(i).get(0) > ans.get(ans.size()-1).get(1)) {
                ans.add(intervals.get(i));
            }
            else {
                Integer mx = Integer.max(ans.get(ans.size()-1).get(1), intervals.get(i).get(1));
                ans.get(ans.size()-1).remove(1);
                ans.get(ans.size()-1).add(mx);
            }
        }

        System.out.println("Merged Intervals");
        ans.forEach(System.out::println);

    }
}
