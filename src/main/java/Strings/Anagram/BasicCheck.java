package Strings.Anagram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BasicCheck {

	static class Reader {
		BufferedReader br;
		StringTokenizer st;

		public Reader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			if (st == null || !st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine());
			}

			return st.nextToken();
		}

		Integer nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		Reader read = new Reader();
		int T = read.nextInt();

		while (T-- > 0) {
			if (AnaGramCheck(read.next(), read.next())) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}

		}

	}

	private static boolean AnaGramCheck(String f, String s) {
		if (f.length() != s.length()) {
			return false;
		}

		int[] chars1 = new int[256];
		int[] chars2 = new int[256];

		for (char c : f.toCharArray()) {
			chars1[(int) c] = chars1[(int) c] + 1;
		}

		for (char c : s.toCharArray()) {
			chars2[(int) c] = chars2[(int) c] + 1;
		}

		return Arrays.equals(chars1, chars2);

	}

}
