package Arrays.Merging;

import java.util.ArrayList;

public class MergeTwoSortedArrays {

	public static void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
		if (a == null) {
			return;
		}

		if (b == null || b.size() == 0) {
			return;
		}

		int m = a.size();
		int n = b.size();

		int i = 0, j = 0;
		while (i < m && j < n) {
			if (b.get(j) >= a.get(i)) {
				i++;
			}

			else if (b.get(j) < a.get(i)) {

				int temp = a.get(i);
				a.set(i, b.get(j));
				b.set(j, temp);
				while (j < n - 1 && b.get(j) > b.get(j + 1)) {
					int temp2 = b.get(j);
					b.set(j, b.get(j + 1));
					b.set(j + 1, temp2);
					j++;
				}

				i++;
				j = 0;
			}
		}

		for (int el : b) {
			a.add(el);
		}
	}

	public static void merge2(ArrayList<Integer> a, ArrayList<Integer> b) {
		if (a == null) {
			return;
		}

		if (b == null || b.size() == 0) {
			return;
		}

		int m = a.size();
		int n = b.size();
		int asize = m;
		int bsize = n;
		int i = 0, j = 0;
		while (i < asize && j < bsize) {
			if (b.get(j) >= a.get(i)) {
				i++;
			}

			else {
				a.add(i, b.get(j));
				b.remove(j);
				i = i + 1;
				asize = a.size();
				bsize = b.size();
			}
		}

		for (int el : b) {
			a.add(el);
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		a.add(-4);
		a.add(3);

		b.add(-2);
		b.add(-2);

		merge2(a, b);
		for (int i : a) {
			System.out.print(i + " ");
		}

	}

}
