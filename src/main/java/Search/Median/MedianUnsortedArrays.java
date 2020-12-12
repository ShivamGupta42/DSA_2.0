package Search.Median;

import java.util.List;

public class MedianUnsortedArrays {

	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {

		if (b == null || b.size() == 0) {
			returnMedian(a);
		}

		if (a == null || a.size() == 0) {
			returnMedian(b);
		}

		int m = a.size();
		int n = b.size();

		int count = 0;
		double m1 = 0, m2 = 0;
		int i = 0, j = 0;

		if ((m + n) % 2 == 1) {

			for (count = 0; count <= (m + n) / 2; count++) {
				if (i < m && j < n) {
					m1 = a.get(i) < b.get(j) ? a.get(i++) : b.get(j++);
				} else if (i < m) {
					m1 = a.get(i++);
				}

				else if (j < n) {
					m1 = b.get(j++);
				}
			}

		} else {

			for (count = 0; count <= (m + n) / 2; count++) {
				m2 = m1;
				if (i < m && j < n) {
					m1 = a.get(i) < b.get(j) ? a.get(i++) : b.get(j++);
				} else if (i < m) {
					m1 = a.get(i++);
				}

				else if (j < n) {
					m1 = b.get(j++);
				}
			}

			m1 = (m1 + m2) / 2;

		}

		return m1;
	}

	public double returnMedian(final List<Integer> arr) {
		int size = arr.size();
		int hSize = size / 2;
		if (size % 2 == 1) {
			return arr.get(hSize);
		}

		return ((double) arr.get(hSize) + (double) arr.get(hSize - 1)) / 2;
	}

}
