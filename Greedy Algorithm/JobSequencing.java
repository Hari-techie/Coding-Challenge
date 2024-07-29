import java.util.*;
/*
 * Problem Statement: You are given a set of N jobs where each job comes with a deadline and profit. 
 * The profit can only be earned upon completing the job within its deadline. 
 * Find the number of jobs done and the maximum profit that can be obtained. 
 * Each job takes a single unit of time and only one job can be performed at a time.

Examples

Example 1:

Input: N = 4, Jobs = {(1,4,20),(2,1,10),(3,1,40),(4,1,30)}

Output: 2 60

Explanation: The 3rd job with a deadline 1 is performed during the first unit of time .
The 1st job is performed during the second unit of time as its deadline is 4.
Profit = 40 + 20 = 60

Example 2:

Input: N = 5, Jobs = {(1,2,100),(2,1,19),(3,2,27),(4,1,25),(5,1,15)}

Output: 2 127

Explanation: The  first and third job both having a deadline 2 give the highest profit. 
Profit = 100 + 27 = 127
 */

class Job {
    int id, profit, deadline;

    Job(int id, int deadline, int profit) {
        this.id = id;
        this.profit = profit;
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "Job [ id : " + this.id + " - deadline : " + this.deadline + " -  profit : " + this.profit + " ]";
    }
}

class JobComparator implements Comparator<Job> {

    @Override
    public int compare(Job o1, Job o2) {
        return o2.profit - o1.profit;
    }

}

public class JobSequencing {

    public static void getMaxProfit(Job[] jobs) {
        Arrays.sort(jobs, new JobComparator());

        int mxDeadline = 0;
        for(int i = 0; i < jobs.length; i ++) {
            mxDeadline = Integer.max(mxDeadline, jobs[i].deadline);
        }

        int days[] = new int[mxDeadline + 1];
        Arrays.fill(days, -1);
        days[0] = 0;

        int totalProfit = 0;
        int totalJobs = 0;
        for(int i = 0; i < jobs.length; i ++) {
            for(int j = jobs[i].deadline; j > 0; j--) {
                
                if(days[i] == -1) {
                    days[i] = jobs[i].id;
                    totalProfit += jobs[i].profit;
                    totalJobs++;
                    break;
                }
            }
        }

        System.out.println("Total Profit : " + totalProfit);
        System.out.println("Total Jobs done : " + totalJobs);
    }

    public static void main(String[] args) {
        Job[] arr = new Job[4];
        arr[0] = new Job(1, 4, 20);
        arr[1] = new Job(2, 1, 10);
        arr[2] = new Job(3, 2, 40);
        arr[3] = new Job(4, 2, 30);
        getMaxProfit(arr);
    }
}
