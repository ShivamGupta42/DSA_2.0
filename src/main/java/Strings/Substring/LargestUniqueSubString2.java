package Strings.Substring;

import java.util.Arrays;

public class LargestUniqueSubString2 {

	public int lengthOfLongestSubstring(String s) {
		if (s == null) {
			return 0;
		}

		int result = 0;
		int[] cache = new int[26];
		Arrays.fill(cache, -1);
		

		for (int we = 0, ws = 0; we < s.length(); we++) {
			int index = s.charAt(we) - 'a';

			if (cache[index] != -1) {
				ws = Math.max(cache[index] + 1, ws);
			}

			cache[index] = we;
			result = Math.max(result, we - ws + 1);
		}
		return result;

	}

	public static void main(String[] args) {
		LargestUniqueSubString2 two = new LargestUniqueSubString2();
		System.out.println(two.lengthOfLongestSubstring(""));
	}

}
