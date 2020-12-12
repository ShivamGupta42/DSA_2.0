package Strings.Math;

public class BinaryStrings {

	public static String addBinary(String a, String b) {

		String result = "";

		// Initialize digit sum
		int s = 0;
		StringBuilder sb = new StringBuilder();

		// Traverse both strings starting
		// from last characters
		int i = a.length() - 1, j = b.length() - 1;
		while (i >= 0 || j >= 0 || s == 1) {

			// Comput sum of last
			// digits and carry
			s += ((i >= 0) ? a.charAt(i) - '0' : 0);
			s += ((j >= 0) ? b.charAt(j) - '0' : 0);

			// If current digit sum is
			// 1 or 3, add 1 to result
			sb.append((char) (s % 2 + '0'));

			// Compute carry
			s /= 2;

			// Move to next digits
			i--;
			j--;
		}

		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		System.out.println(addBinary("11", "1"));
	}
}
