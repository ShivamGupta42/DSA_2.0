package ReadWorldProblems.GoogCalendar;

import java.util.Arrays;

/*
"Schedule a New Meeting" feature for our "Google Calendar" project.
(Advanced merging)
 */
public class GC_Feature4 {


    public static void main(String args[]) {
        int[][] meetingTimes = {{1, 3}, {4, 6}, {8, 10}, {10, 12}, {13, 15}, {16, 18}};
        int[] newMeeting = {9, 13};
        System.out.println(Arrays.deepToString(insertMeeting(meetingTimes, newMeeting)));
    }

    private static int[][] insertMeeting(int[][] meetingTimes, int[] newMeeting) {
        int[][] updatedCalendar = addNewMeeting(meetingTimes,newMeeting);
        return ConsolidateAllMeetings(updatedCalendar);
    }

    private static int[][] ConsolidateAllMeetings(int[][] updatedCalendar) {
        return null;
    }

    private static int[][] addNewMeeting(int[][] meetingTimes, int[] newMeeting) {

        for(int i=0;i< meetingTimes.length;i++){
            if(newMeeting[1]>meetingTimes[i][0]&&newMeeting[0]<meetingTimes[i][1]){

            }
        }
        return null;
    }


}
