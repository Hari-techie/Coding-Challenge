import java.util.*;
/*
 * Problem Statement: There is one meeting room in a firm. You are given two arrays, start and end each of size N.
 * For an index ‘i’, start[i] denotes the starting time of the ith meeting while end[i]  will denote the 
 * ending time of the ith meeting. Find the maximum number of meetings that can be accommodated if 
 * only one meeting can happen in the room at a  particular time. Print the order in which these meetings will be performed.

Example:

Input:  N = 6,  start[] = {1,3,0,5,8,5}, end[] =  {2,4,5,7,9,9}

Output: 1 2 4 5
 */
class Meeting {
    int start;
    int end;
    int position;

    Meeting(int start, int end, int position) {
        this.start = start;
        this.end = end;
        this.position = position;
    }

    @Override
    public String toString() {
        return "Meeting starts " + this.start + " and ends at " + this.end;
    }
}

class MeetingComparator implements Comparator<Meeting>
{
    @Override
    public int compare(Meeting o1, Meeting o2) 
    {
        if (o1.end < o2.end)
            return -1;
        else if (o1.end > o2.end)
            return 1;
        else if(o1.position < o2.position)
            return -1;
        return 1; 
    }
}
 
public class NmeetingsInRoom {

    public static void maxMeetings(int start[], int end[], int n) {
        List<Meeting> meetings = new ArrayList<>();

        for(int i = 0; i < start.length; i++)
            meetings.add(new Meeting(start[i], end[i], i+1));
        
        MeetingComparator mc = new MeetingComparator();
        Collections.sort(meetings, mc);

        System.out.println(meetings);

        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(meetings.get(0).position);
        int limit = meetings.get(0).end; 
        
        for(int i = 1;i<start.length;i++) {
            if(meetings.get(i).start > limit) {
                limit = meetings.get(i).end; 
                answer.add(meetings.get(i).position);
            }
        }
        System.out.println("The order in which the meetings will be performed is ");
        for(int i = 0;i<answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }

    }

    public static void main(String[] args) {
        int n = 6;
        int start[] = {1,0,5,8,5,3};
        int end[] = {2,5,7,9,9,4};
        maxMeetings(start,end,n);
    }    
}
