package Arrays.Array;

import java.util.HashMap;
import java.util.Map;

public class LC_3_LongestSubstring_Without_RepeatingChars {

    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int start = 0;
        int end = -1;

        int index = 0;
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                max = Math.max(max, end - start + 1);
                start = Math.max(start, map.get(c) + 1);
            }
            map.put(c, index);
            end++;
            index++;
        }
        max = Math.max(max, end - start + 1);
        return max;

    }
}
