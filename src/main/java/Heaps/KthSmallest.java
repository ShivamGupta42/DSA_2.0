package Heaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class KthSmallest {

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
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = read.nextInt();
			}
			int k = read.nextInt();

			System.out.println(kthSmallest(arr, k));

		}

	}

	static int kthSmallest(int[] arr, int k) {
		PriorityQueue<Integer> p = new PriorityQueue<Integer>((a, b) -> b - a);

		for (int i = 0; i < k; i++) {
			p.add(arr[i]);
		}

		for (int i = k; i < arr.length; i++) {
			if (arr[i] < p.peek()) {
				p.poll();
				p.add(arr[i]);
			}
		}

		return p.poll();
	}

}
