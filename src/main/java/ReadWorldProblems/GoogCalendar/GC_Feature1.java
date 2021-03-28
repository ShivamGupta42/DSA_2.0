package ReadWorldProblems.GoogCalendar;


import java.util.ArrayList;

/*
We have a schedule of meetings available.
We want to determine and block the minimum number of meeting rooms for these meetings.
 */
public class GC_Feature1 {

    public static void main(String[] args) {
        // Driver code
        int[][] meetingTimes = {{2, 8}, {3, 4}, {3, 9}, {5, 11}, {8, 20}, {11, 15}};
        System.out.print(minMeetingRooms(meetingTimes));
    }


    private static int minMeetingRooms(int[][] meetingTimes) {
        ArrayList<Integer> startTimes = fetchTime(0,meetingTimes);
        ArrayList<Integer> endTimes = fetchTime(1,meetingTimes);
        int roomsRequired = 0;
        int maxRooms=0;

        int m=0;
        int n= 0;
        while(m<startTimes.size()&&n<endTimes.size()){
              if(endTimes.get(n)>startTimes.get(m)){
                  roomsRequired++;
                  maxRooms=Math.max(maxRooms,roomsRequired);
                  m++;
              }else{
                  roomsRequired--;
                  n++;
              }
        }

        while(m<startTimes.size()){
            roomsRequired++;
            maxRooms=Math.max(maxRooms,roomsRequired);
        }

        return maxRooms;
    }

    private static ArrayList<Integer> fetchTime(int m,int[][] meetingTimes) {
        ArrayList<Integer> times = new ArrayList<>();
        for(int i=0;i<meetingTimes.length;i++){
            times.add(meetingTimes[i][m]);
        }
        times.sort((a,b)->a-b);
        return times;
    }

}
