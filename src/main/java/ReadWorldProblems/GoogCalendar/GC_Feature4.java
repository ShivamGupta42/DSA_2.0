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

    private static Object[] insertMeeting(int[][] meetingTimes, int[] newMeeting) {
        return null;
    }


}
