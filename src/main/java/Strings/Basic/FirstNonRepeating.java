package Strings.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FirstNonRepeating {

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
			int n = read.nextInt();
			String s = read.next();

			Character Character;
			if ((Character = firstNonRepeat(n, s)) != null) {
				System.out.println(Character);
			} else {
				System.out.println(-1);
			}

		}

	}

	private static Character firstNonRepeat(int n, String s) {
		int[] chars = new int[256];

		for (char c : s.toCharArray()) {
			chars[(int) c] = chars[(int) c] + 1;
		}

		for (char c : s.toCharArray()) {
			if (chars[(int) c] == 1) {
				return c;
			}
		}

		return null;
	}

	private int firstNonRepeat2(int n, String s) {
		int[] chars = new int[256];

		Arrays.fill(chars, -1);
		// One traversal of string
		for (int i = 0; i < n; i++) {
			if (chars[(int) s.charAt(i)] == -1) {
				chars[(int) s.charAt(i)]=i;
			} else {
				chars[(int) s.charAt(i)]=-2;
			}
		}

		int res=Integer.MAX_VALUE;
		for(int i=0;i<256;i++) {
			if(chars[i]>=0) {
				res=Math.min(res, chars[i]);
			}
		} 
		
		return res;
	}

}
