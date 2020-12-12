package Strings.Substring;

public class LongestSubstringKDistinct {
	public static int findLength(String str, int k) {

		char[] c = str.toCharArray();
		int[] chars = new int[256];

		int winStart = 0, winEnd = 0;
		int curdistinctChar = 0;
		int maxLen = Integer.MIN_VALUE;

		for (winEnd = 0; winEnd < str.length(); winEnd++) {
			chars[(int) c[winEnd]]++;

			if (chars[(int) c[winEnd]] == 1) {
				curdistinctChar++;
			} 

			if (curdistinctChar > k) {
				if (chars[(int) c[winStart]] == 1) {
					curdistinctChar--;
				}
				
				chars[(int) c[winStart]]--;
				winStart++;
			}

			maxLen = Math.max(maxLen, winEnd - winStart + 1);}
		return maxLen;
	}

	public static void main(String[] args) {
		System.out.println(findLength("araaci", 1));
	}

}
