package Search.Median;

import java.util.Arrays;
import java.util.List;

public class MedianSortedArrays {

	// Function to find max
	static int maximum(int a, int b) {
		return a > b ? a : b;
	}

	// Function to find minimum
	static int minimum(int a, int b) {
		return a < b ? a : b;
	}

	// Function to find median
	// of two sorted arrays

	public double findMedianSortedArrays(List<Integer> a, List<Integer> b) {
		if (b.size() < a.size()) {
			List<Integer> temp = b;
			a = b;
			b = temp;
		}

		int m = b.size(), n = a.size();

		// n is smaller index
		int min_index = 0, max_index = n, i = 0, j = 0, median = 0;

		while (min_index <= max_index) {
			i = (min_index + max_index) / 2;
			j = ((n + m + 1) / 2) - i;

			// if i = n, it means that Elements
			// from a[] in the second half is an
			// empty set. and if j = 0, it means
			// that Elements from b[] in the first
			// half is an empty set. so it is
			// necessary to check that, because we
			// compare elements from these two
			// groups. Searching on right
			if (i < n && j > 0 && b.get(j - 1) > a.get(i))
				min_index = i + 1;

			// if i = 0, it means that Elements
			// from a[] in the first half is an
			// empty set and if j = m, it means
			// that Elements from b[] in the second
			// half is an empty set. so it is
			// necessary to check that, because
			// we compare elements from these two
			// groups. searching on left
			else if (i > 0 && j < m && b.get(j) < a.get(i - 1))
				max_index = i - 1;

			// we have found the desired halves.
			else {
				// this condition happens when we
				// don't have any elements in the
				// first half from a[] so we
				// returning the last element in
				// b[] from the first half.
				if (i == 0)
					median = b.get(j - 1);

				// and this condition happens when
				// we don't have any elements in the
				// first half from b[] so we
				// returning the last element in
				// a[] from the first half.
				else if (j == 0)
					median = a.get(i - 1);
				else
					median = maximum(a.get(i - 1), b.get(j - 1));
				break;
			}
		}

		// calculating the median.
		// If number of elements is odd
		// there is one middle element.
		if ((n + m) % 2 == 1)
			return (double) median;

		// Elements from a[] in the
		// second half is an empty set.
		if (i == n)
			return (median + b.get(j)) / 2.0;

		// Elements from b[] in the
		// second half is an empty set.
		if (j == m)
			return (median + a.get(i)) / 2.0;

		return (median + minimum(a.get(i), b.get(j))) / 2.0;
	}

	public static void main(String[] args) {
		Integer[] a = new Integer[] { 1, 4, 5 };
		Integer[] b = new Integer[] { 2, 3 };

		MedianSortedArrays ms = new MedianSortedArrays();
		System.out.println(ms.findMedianSortedArrays(Arrays.asList(a), Arrays.asList(b)));
	}

}
