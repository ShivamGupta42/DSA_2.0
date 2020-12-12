package Strings.Permutation;

public class LC567_PermutationInString {

	public static boolean checkInclusion(String s1, String s2) {
		if (s1 == null) {
			return false;
		}
		if (s1.equals("")) {
			return true;
		}

		int[] s1char = new int[256];
		for (char c : s1.toCharArray()) {
			s1char[(int) c]++;
		}
		int totalChars = s1.toCharArray().length;

		int[] curCharsToMatch = s1char.clone();
		int curCharsRemaining = totalChars;

		for (int i = 0; i < s2.length(); i++) {
			if (curCharsToMatch[(int) s2.charAt(i)] > 0) {
				curCharsToMatch[(int) s2.charAt(i)]--;
				curCharsRemaining--;
				if (curCharsRemaining == 0) {
					return true;
				}
			} else {
				curCharsToMatch = s1char.clone();
				curCharsRemaining = totalChars;
			}
		}

		curCharsToMatch = s1char.clone();
		curCharsRemaining = totalChars;

		for (int i = s2.length() - 1; i >= 0; i--) {
			if (curCharsToMatch[(int) s2.charAt(i)] > 0) {
				curCharsToMatch[(int) s2.charAt(i)]--;
				curCharsRemaining--;
				if (curCharsRemaining == 0) {
					return true;
				}
			} else {
				curCharsToMatch = s1char.clone();
				curCharsRemaining = totalChars;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		System.out.println(checkInclusion("abc", "dcda"));
	}

}
