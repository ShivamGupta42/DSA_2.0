package Hashing.sorting;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class SortArrByFreq {

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

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

	public static void main(String[] args) throws IOException {

		Reader scan = new Reader();
		int T = scan.nextInt();

		while (T > 0) {
			T--;
			int n = scan.nextInt();
			int[] a = new int[n];

			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

			for (int i = 0; i < n; i++) {
				a[i] = scan.nextInt();
				if (!map.containsKey(a[i])) {
					map.put(a[i], 1);
				} else {
					map.put(a[i], map.get(a[i]) + 1);
				}

			} // end

			List<Entry<Integer, Integer>> list = new ArrayList<Entry<Integer, Integer>>(map.entrySet());

			Collections.sort(list, new Comparator<Entry<Integer, Integer>>() {
				@Override
				public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
					int k = (o2.getValue()).compareTo(o1.getValue());
					if (k != 0) {
						return k;
					} else {
						return o1.getKey() - o2.getKey();
					}
				}

			});

			int k = 0;
			for (Entry<Integer, Integer> e : list) {
				  k = e.getKey();
				for (int i = 0; i < e.getValue(); i++) {
                   bw.write(k+" ");
				}
			}

			bw.write("\n");
			bw.flush();
		} // end test cases

		bw.close();
	}
}
