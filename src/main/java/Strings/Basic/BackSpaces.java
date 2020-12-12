package Strings.Basic;

import java.util.Stack;

public class BackSpaces {

	public static boolean compare1(String str1, String str2) {
		String s1 = redStr(str1);
		String s2 = redStr(str2);

		return s1.equals(s2);
	}

	public static String redStr(String s) {
		StringBuilder sb = new StringBuilder();
		int low = 0;
		Stack<Character> st = new Stack<Character>();

		while (low <= s.length() - 1) {
			if (s.charAt(low) != '#') {
				st.push(s.charAt(low));
			} else {
				st.pop();
			}
			low++;
		}

		while (!st.isEmpty()) {
			sb.append(st.pop());
		}
		return sb.reverse().toString();
	}

	public static boolean compare2(String s1, String s2) {
		int i1 = s1.length() - 1, i2 = s2.length() - 1;

		while (i1 >= 0 && i2 >= 0) {
			i1 = getNextValidIndex(s1, i1);
			i2 = getNextValidIndex(s2, i2);

			if (i1 < 0 && i2 < 0) {
				return true;
			}
			if (i1 < 0 || i2 < 0) {
				return false;
			}

			if (s1.charAt(i1) != s2.charAt(i2)) {
				return false;
			}
			i1-=1;
			i2-=1;
		}
		return true;
	}

	private static int getNextValidIndex(String s, int index) {
		int backCount = 0;
		while (index >= 0) {
			if (s.charAt(index) == '#') {
				backCount++;
			} else if (backCount > 0) {
				backCount--;
			} else {
				break;
			}

			index--;
		}
		return index;
	}

	public static void main(String[] args) {
		System.out.println(compare1("xy#z", "xzz#"));
	}

}
