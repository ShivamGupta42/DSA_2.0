package Strings.Basic;

import java.util.ArrayList;

public class ReverseEachWord {

	public static void main(String[] args) {
		String str = "I know a lot of books knowledge but true knowledge lies within.";

		System.out.println(reverseWords("a good   example"));
		// in place reversing
		/*
		 * Arrays.stream(str.split(" ")).map(e -> reverseStr(e)).forEach(s ->
		 * System.out.print(s + " ")); ;
		 * 
		 * System.out.println(); // reverse all words positions and words themselves //
		 * in place reversing Arrays.stream(reverseArray(str.split(" "))).map(e ->
		 * reverseStr(e)).forEach(s -> System.out.print(s + " "));
		 * 
		 * ;
		 */
	}

	public static String reverseStr(String str) {
		char[] c = str.toCharArray();
		int start = 0;
		int end = c.length - 1;
		char temp;
		while (start < end) {
			temp = c[end];
			c[end] = c[start];
			c[start] = temp;
			start++;
			end--;
		}

		return String.valueOf(c);
	}

	static <T> T[] reverseArray(T[] arr) {
		int start = 0;
		int end = arr.length - 1;
		T temp;

		while (start < end) {
			temp = arr[end];
			arr[end] = arr[start];
			arr[start] = temp;
			start++;
			end--;
		}

		return arr;
	}

	public static String reverseWords(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		String[] split = splitter(s, ' ');
		int start = 0, end = split.length - 1;

		while (start < end) {
			String temp = split[end];
			split[end] = split[start];
			split[start] = temp;
			start++;
			end--;
		}

		StringBuilder sb = new StringBuilder();
		for (String sr : split) {
			sb.append(sr + " ");
		}

		String res = sb.toString();
		return res.substring(0, res.length() - 1);
	}

	static String[] splitter(String s, char c) {
		ArrayList<String> split = new ArrayList<String>();
		StringBuilder sbBuilder = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == c) {
				if (sbBuilder.length() != 0) {
					split.add(sbBuilder.toString());
					sbBuilder.setLength(0);
				}
				continue;
			}

			sbBuilder.append(s.charAt(i));
		}
		
		if (sbBuilder.length() != 0) {
			split.add(sbBuilder.toString());
		}
		return split.toArray(new String[split.size()]);
	}
}
