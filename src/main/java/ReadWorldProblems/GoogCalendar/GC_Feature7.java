package ReadWorldProblems.GoogCalendar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* find longest busy interval */
public class GC_Feature7 {

    public static void main(String args[]) {
        Integer[] schedule = {3, 1, 8, 5, 2, 12, 10, 4, 8, 9};
        System.out.println(lengthOfLongestBusyPeriod(schedule));
    }


    /*Easiest algo would be to simply sort it and then do adjacent comparisons
     * but it will take nlogn
     * here we will be implementing O(n) time, O(n) space solution
     */
    private static int lengthOfLongestBusyPeriod(Integer[] schedule) {

        Set<Integer> slotSet = new HashSet<>(Arrays.asList(schedule));

        //Here instead of traversing both ways
        //We are going to ignore if there is a adjacent slot which is less than current slot
        //Since current slot will feature in the forward list of that slot
        int maxConsecutiveSlots = 0;

        for (Integer slot : slotSet) {
            if (!slotSet.contains(slot - 1)) {
                int currentSlotLen = 1;
                while (slotSet.contains(++slot)) {
                    currentSlotLen++;
                }
                maxConsecutiveSlots = Math.max(currentSlotLen, maxConsecutiveSlots);
            }
        }
        return maxConsecutiveSlots;
    }

}
