package ReadWorldProblems.GoogCalendar;


import java.util.Arrays;

/*
Working
Check if a meeting can be scheduled with another user
 */
public class GC_Feature3 {

    public static void main( String args[] ) {
        int[][] meetingTimes = {{1, 3}, {4, 6}, {8, 10}, {10, 12}, {13, 15}};
        int[] newMeeting = {7, 8};
        System.out.println(checkMeeting(meetingTimes, newMeeting));
        newMeeting = new int[] {9, 11};
        System.out.println(checkMeeting(meetingTimes, newMeeting));
    }

    private static boolean checkMeeting(int[][] meetingTimes, int[] newMeeting) {
        Arrays.sort(meetingTimes,(a,b)->a[0]-b[0]);

        for(int i=0;i<meetingTimes.length;i++){
            if(meetingTimes[i][1]-newMeeting[0]>0&&newMeeting[1]-meetingTimes[i][0]>0){
                return false;
            }
        }
        return true;
    }
}
