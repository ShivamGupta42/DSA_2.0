package Strings.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LexicographicRank {

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

			String s = read.next();
			System.out.println(lexicalRank(s));

		}

	}

	// In case characters are repeated
	// it returns rank as zero
	private static int lexicalRank(String s) {

		int n = s.length();

		int[] chars = new int[256];

		// calculating count of each character
		for (int i = 0; i < n; i++) {
			chars[(int) s.charAt(i)]++;
			if (chars[(int) s.charAt(i)] > 1) {
				return 0;
			}
		}

		// calculating cumulative count of characters smaller than the current character
		for (int i = 1; i < 256; i++) {
			chars[i] = chars[i] + chars[i - 1];
		}

		int fact = factorial(n);
		int rank = 1;

		for (int i = 0; i < n - 1; i++) {
			// Basically calculating all the characters which are smaller than current
			// characters and multiplying them with permutations
			fact = fact / (n - i);
			rank += (fact) * chars[s.charAt(i) - 1];

			// because we have used up a character in above scenario,
			// then for next permutation to work we need to decrease a character from each
			// character
			// greater than current character
			for (int j = (int) s.charAt(i); j < 256; j++) {
				--chars[j];
			}

		}

		return rank % 1000003;

	}

	private static int factorial(int n) {
		return (n <= 1) ? 1 : n * factorial(n - 1);
	}

}
