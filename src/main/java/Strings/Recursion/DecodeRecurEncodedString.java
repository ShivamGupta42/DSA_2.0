package Strings.Recursion;

public class DecodeRecurEncodedString {

	public static void main(String[] args) {
		String a = "3[b2[ca]]";
		decodeString(a, 0, a.length() - 1);
	}

	private static void decodeString(String a, int start, int end) {
		if (a == null || a.isBlank() || a.isEmpty()) {
			return;
		}

		int t = (int) a.charAt(start);
		int num = 0;
		while (t >= 48 && t <= 57) {
			num = num * 10;
			num += (t - 48);
		}
		for (int i = 0; i < num; i++) {
			processString(a, start, end);
		}

	}

	private static void processString(String a, int start, int end) {

	}

}
