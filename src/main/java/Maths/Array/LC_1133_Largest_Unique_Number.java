package Maths.Array;

import java.util.HashMap;
import java.util.Map;

public class LC_1133_Largest_Unique_Number {

    public int largestUniqueNumber(int[] A) {
        if (A == null) {
            return -1;
        }

        int max = Integer.MIN_VALUE;

        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            freqMap.compute(A[i], (k, v) -> {
                if (v == null) {
                    return 1;
                } else {
                    return v + 1;
                }
            });
        }

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == 1) {
                max = Math.max(max, entry.getKey());
            }
        }

        return max == Integer.MIN_VALUE ? -1 : max;
    }
}
