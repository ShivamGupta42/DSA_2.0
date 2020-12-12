package Search.RotatedSorted;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BasicSearch {
	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public int search(final List<Integer> A, int B) {
		if (A == null || A.size() < 1) {
			return -1;
		}
		int pivot = findPivot(A, 0, A.size() - 1);

		if (B == A.get(0)) {
			return 0;
		} else if (B > A.get(0)) {
			return bs(A, 0, pivot - 1, B);
		} else {
			return bs(A, pivot, A.size() - 1, B);
		}

	}

	public int findPivot(List<Integer> A, int start, int end) {
		if (start <= end) {
			int mid = start + (end - start) / 2;
			if (mid == 0 || A.get(mid) < A.get(0) && A.get(mid) < A.get(mid - 1)) {
				return mid;
			} else if (A.get(mid) < A.get(0)) {
				return findPivot(A, start, mid - 1);
			} else {
				return findPivot(A, mid + 1, end);
			}
		}

		return -1;
	}

	public int bs(List<Integer> A, int start, int end, int target) {
		if (start <= end) {
			int mid = start + (end - start) / 2;
			if (A.get(mid) == target) {
				return mid;
			} else if (A.get(mid) < target) {
				return bs(A, mid + 1, end, target);
			} else {
				return bs(A, start, mid - 1, target);
			}

		}
		return -1;
	}

	public static void main(String[] args) {
		BasicSearch bs = new BasicSearch();
		int[] arr = new int[] { 180, 181, 182, 183, 184, 187, 188, 189, 191, 192, 193, 194, 195, 196, 201, 202, 203,
				204, 3, 4, 5, 6, 7, 8, 9, 10, 14, 16, 17, 18, 19, 23, 26, 27, 28, 29, 32, 33, 36, 37, 38, 39, 41, 42,
				43, 45, 48, 51, 52, 53, 54, 56, 62, 63, 64, 67, 69, 72, 73, 75, 77, 78, 79, 83, 85, 87, 90, 91, 92, 93,
				96, 98, 99, 101, 102, 104, 105, 106, 107, 108, 109, 111, 113, 115, 116, 118, 119, 120, 122, 123, 124,
				126, 127, 129, 130, 135, 137, 138, 139, 143, 144, 145, 147, 149, 152, 155, 156, 160, 162, 163, 164, 166,
				168, 169, 170, 171, 172, 173, 174, 175, 176, 177 };

		int[] arr2 = new int[] { 101, 103, 106, 109, 158, 164, 182, 187, 202, 205, 2, 3, 32, 57, 69, 74, 81, 99, 100 };

		System.out.println(bs.search(Arrays.stream(arr2).boxed().collect(Collectors.toList()), 202));
	}

}
