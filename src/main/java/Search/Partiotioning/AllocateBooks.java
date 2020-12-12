package Search.Partiotioning;

import java.util.ArrayList;

public class AllocateBooks {

	public static int max = Integer.MIN_VALUE;
	public static long totalSum = 0;

	public static int getRequiredReaders(ArrayList<Integer> a, long maxLengthPerReader) {
		long total = 0;
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

		for (int i = 0; i < a.size(); i++) {
			totalSum += a.get(i);
			max = Math.max(a.get(i), max);
		}

		// because the book with maximum pages will be allocated to a student
		// and hence the minimum number of pages per student at minimum can be
		// equal to the book with maximum pages.
		long lo = max;

		// This is the theortetical maximum sum
		// We can't decrease it to totalSum-low -> This could be less than low and
		// our algo won't work in that case
		long hi = totalSum;

		while (lo <= hi) {
			long mid = lo + (hi - lo) / 2;

			int requiredReaders = getRequiredReaders(a, mid);

			if (requiredReaders == b) {
				return Math.toIntExact(mid);
			}

			if (requiredReaders < b) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
		return Math.toIntExact(lo);
	}

}
