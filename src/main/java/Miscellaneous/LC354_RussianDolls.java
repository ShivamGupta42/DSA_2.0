package Miscellaneous;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LC354_RussianDolls {

    public static int maxEnvelopes(int[][] envelopes) {
        TreeMap<Long,int[]> map = new TreeMap<>();

        for(int i=0;i<envelopes.length;i++){
            map.put(calDiagaonal(envelopes[i]),envelopes[i]);
        }
        return map.keySet().size();
    }

    private static Long calDiagaonal(int[] envelope) {
        return Long.valueOf(envelope[0]*envelope[0]+envelope[1]*envelope[1]);
    }

    public static void main(String[] args) {
       int[][] envelopes = new int[][]{{5,4},{6,4},{6,7},{2,3}};
        System.out.println(maxEnvelopes(envelopes));
    }
}
