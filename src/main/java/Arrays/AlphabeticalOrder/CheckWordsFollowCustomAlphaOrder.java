package Arrays.AlphabeticalOrder;

public class CheckWordsFollowCustomAlphaOrder {

	public static void main(String[] args) {

	}

	public static boolean wordOrder(String[] words, String order, int n) {

		for (int i = 0; i < n - 1; i++) {
			if (!followsOrder(words[i], words[i + 1], order)) {
				return false;
			}
		}

		return true;
	}

	private static boolean followsOrder(String s1, String s2, String order) {

		int n = Math.min(s1.length(), s2.length());

		for (int i = 0; i < n; i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				if (order.indexOf(s1.charAt(i)) > order.indexOf(s2.charAt(i))) {
					return false;
				} else {
					return true;
				}
			}
		}

		//bigger length word comes second
		//abcd abcde -> abcde should come later
		if (s1.length() > s2.length()) {
			return false;
		}

		return true;
	}
}
