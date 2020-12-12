package Strings.Basic;

import java.util.Arrays;

public class removeDuplicates {

	String removeDup(String s) {
		int[] c = new int[256];
		StringBuilder sb = new StringBuilder();

		Arrays.fill(c, -1);
		for (int i = 0; i < s.length(); i++) {
			if (c[(int) s.charAt(i)] == -1) {
				sb.append(s.charAt(i));
			}
			c[(int) s.charAt(i)]++;
		}

		return sb.toString();

	}

}
