package DivideAndConquer;

import java.util.Arrays;

public class CountInversions {

	public int reversePairs(int[] nums) {
		return enMergeSort(nums, 0, nums.length - 1);
	}

	public int enMergeSort(int[] nums, int l, int r) {
		int count = 0;

		if (l < r) {
			int mid = l + (r - l) / 2;
			count = enMergeSort(nums, l, mid);
			count += enMergeSort(nums, mid + 1, r);
			count += merge(nums, l, mid, r);

		}

		return count;
	}

	public int merge(int[] nums, int l, int m, int r) {
		int count = 0;

		int[] L = Arrays.copyOfRange(nums, l, m + 1);
		int[] R = Arrays.copyOfRange(nums, m + 1, r + 1);

		int i = 0, j = 0, k = l;

		while (i < L.length && j < R.length) {

			if (L[i] <= R[j]) {
				nums[k++] = L[i++];
			} else {

				count += (L.length - i);
				nums[k++] = R[j++];

			}
		}

		while (i < L.length) {
			nums[k++] = L[i++];
		}

		while (j < R.length) {
			nums[k++] = R[j++];
		}

		return count;

	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 3, 2, 3, 1 };
		CountInversions ci = new CountInversions();
		System.out.println(ci.reversePairs(arr));
	}
}
