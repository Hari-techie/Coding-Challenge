import java.util.Arrays;

/*
 * We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].

You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that 
there are no two jobs in the subset with overlapping time range.

If you choose a job that ends at time X you will be able to start another job that starts at time X.

Example 1:

Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
Output: 120
Explanation: The subset chosen is the first and fourth job. 
Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.

Example 2:

Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
Output: 150
Explanation: The subset chosen is the first, fourth and fifth job. 
Profit obtained 150 = 20 + 70 + 60.

Example 3:

Input: startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
Output: 6
 */

public class MaximumProfitInJobSequencing {
    
    public static int find(int i, int[][] job, int[] startTime, int n, int[] dp) {
        if (i >= n) return 0;
        if (dp[i] != -1) return dp[i];

        int index = Arrays.binarySearch(startTime, job[i][1]);
        if (index < 0) index = -index - 1;

        int pick = job[i][2] + find(index, job, startTime, n, dp);
        int notpick = find(i + 1, job, startTime, n, dp);
        return dp[i] = Math.max(pick, notpick);
    }

    public static void main(String[] args) {
        int [] startTime = {1,2,3,3}; 
        int [] endTime = {3,4,5,6};
        int [] profit = {50,10,40,70};
        int n = startTime.length;
        int[][] job = new int[n][3];
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        for (int i = 0; i < n; i++) {
            job[i][0] = startTime[i];
            job[i][1] = endTime[i];
            job[i][2] = profit[i];
        }

        Arrays.sort(job,(j1,j2)->
        {
            if(j1[0]!=j2[0])
            {
                return j1[0]-j2[0];
            }
            else if(j1[1]!=j2[1]) { // then by end time
                return j1[1]-j2[1];
            }
            else { //then by profit
                return j2[2]-j1[2];
            }
    
        });
        Arrays.sort(startTime);

        System.out.println(find(0, job, startTime, n, dp));
    }
}
