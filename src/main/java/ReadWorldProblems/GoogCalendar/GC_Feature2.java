package ReadWorldProblems.GoogCalendar;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;


/* Not working
* Merge meetings
* */
public class GC_Feature2 {

    static TreeMap<Integer, Integer> intervals = new TreeMap<>();

    public static void main(String args[]) {
        int[][] meetingTimes1 = {{1, 4}, {2, 5}, {6, 8}, {7, 9}, {10, 13}};
        //System.out.println(Arrays.deepToString(mergeMeetings(meetingTimes1)));
        int[][] meetingTimes2 = {{4, 7}, {1, 3}, {8, 10}, {2, 3}, {6, 8}};
        System.out.println(Arrays.deepToString(mergeMeetings(meetingTimes2)));
    }

    private static int[][] mergeMeetings(int[][] meetingTimes) {
        intervals = new TreeMap<>();

        Arrays.sort(meetingTimes, (a, b) -> a[0] - b[0]);

        intervals.put(meetingTimes[0][0], meetingTimes[0][1]);
        for (int i = 1; i < meetingTimes.length; i++) {
            if (meetingTimes[i][0] <= meetingTimes[i - 1][1]) {
                addMergedInterval(meetingTimes, i);
            } else {
                addInterval(meetingTimes, i);
            }
        }

        return processIntervals();
    }

    private static int[][] processIntervals() {
        int[][] result = new int[intervals.size()][2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entries : intervals.entrySet()) {
            result[index++] = new int[]{entries.getKey(), entries.getValue()};
        }
        return result;
    }

    private static void addInterval(int[][] meetingTimes, int i) {
        intervals.put(meetingTimes[i][0], meetingTimes[i][1]);
    }

    private static void addMergedInterval(int[][] meetingTimes, int i) {
        intervals.put(meetingTimes[i - 1][0], meetingTimes[i][1]);
    }

}
