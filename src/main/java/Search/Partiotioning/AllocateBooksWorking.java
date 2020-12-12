package Search.Partiotioning;

import java.util.ArrayList;

public class AllocateBooksWorking {

	public static int getMax(ArrayList<Integer> a) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < a.size(); i++) {
			max = Math.max(a.get(i), max);
		}
		return max;
	}

	public static int getSum(ArrayList<Integer> a) {
		int total = 0;
		for (int i = 0; i < a.size(); i++) {
			total += a.get(i);
		}
		return total;
	}

	public static int getRequiredReaders(ArrayList<Integer> a, int maxLengthPerReader) {
		int total = 0;
		int readers = 1;
		for (int i = 0; i < a.size(); i++) {
			total += a.get(i);
			if (total > maxLengthPerReader) {
				total = a.get(i);
				readers++;
			}
		}
		return readers;
	}

	public static int books(ArrayList<Integer> a, int b) {
		if (a == null || a.size() == 0 || a.size() < b || b < 1)
			return -1;

		// because the book with maximum pages will be allocated to a student
		// and hence the minimum number of pages per student at minimum can be
		// equal to the book with maximum pages.
		int lo = getMax(a);

		// This is the theortetical maximum sum
		// We can't decrease it to totalSum-low -> This could be less than low and
		// our algo won't work in that case
		int hi = getSum(a);

		while (lo < hi) {
			int mid = (int) (lo + (hi - lo) / 2);

			// as mid increases the requiredReaders decrease
			// if we increase total pages for one reader
			// Since the total pages remain constant
			// number of readers decrease

			int requiredReaders = getRequiredReaders(a, mid);

			// if the number of readers we are assigning is less than we require
			// we need to decrease mid's value
			if (requiredReaders <= b) {
				hi = mid;
			}

			// if we are assigning more readers
			// then we need to increase mid's value
			else {
				lo = mid + 1;
			}
		}
		return lo;
	}

}
