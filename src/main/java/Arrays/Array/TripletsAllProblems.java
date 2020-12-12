package Arrays.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class TripletsAllProblems {

	public static void main(String[] args) {
		int arr[] = { -1, 4, 2, 1, 3 };
		System.out.println(SumSmallerThanTargetNumber(arr, 5));
	}

	// count all triplets such that sum of two numbers is also present in the array
	private static void countTriplets(int[] arr, int n) {
		HashSet<Integer> set = new HashSet<Integer>();

		int counter = 0;
		for (int i = 0; i < n; i++) {
			set.add(arr[i]);
		}

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (set.contains(arr[i] + arr[j])) {
					counter++;
				}
			}
		}

		if (counter == 0) {
			System.out.println(-1);
		} else {
			System.out.println(counter);
		}

	}

	// triplets with sum equal to zero
	public static List<List<Integer>> searchTriplets(int[] arr) {
		Arrays.sort(arr);
		List<List<Integer>> triplets = new ArrayList<>();
		for (int i = 0; i < arr.length - 2; i++) {
			if (i > 0 && arr[i] == arr[i - 1]) // skip same element to avoid duplicate triplets
				continue;
			searchPair(arr, -arr[i], i + 1, triplets);
		}

		return triplets;
	}

	private static void searchPair(int[] arr, int targetSum, int left, List<List<Integer>> triplets) {
		int right = arr.length - 1;
		while (left < right) {
			int currentSum = arr[left] + arr[right];
			if (currentSum == targetSum) { // found the triplet
				triplets.add(Arrays.asList(-targetSum, arr[left], arr[right]));
				left++;
				right--;
				while (left < right && arr[left] == arr[left - 1])
					left++; // skip same element to avoid duplicate triplets
				while (left < right && arr[right] == arr[right + 1])
					right--; // skip same element to avoid duplicate triplets
			} else if (targetSum > currentSum)
				left++; // we need a pair with a bigger sum
			else
				right--; // we need a pair with a smaller sum
		}
	}

	// Sum closest to a target number
	public static int SumClosestToTargetNumber(int[] arr, int targetSum) {
		if (arr == null || arr.length < 3) {
			new IllegalArgumentException();
		}

		Arrays.sort(arr);

		int minSum = Integer.MAX_VALUE, minDiff = Integer.MAX_VALUE;
		int curSum = 0, diff = 0;
		int start = 1, end = arr.length - 1;

		for (int i = 0; i < arr.length; i++) {
			start = i + 1;
			end = arr.length - 1;

			while (start < end) {
				curSum = arr[start] + arr[end] + arr[i];
				diff = targetSum - curSum;

				if (diff == 0) {
					return curSum;
				} else if (diff > 0) {
					start++;
				} else {
					end--;
				}

				if (minDiff > Math.abs(diff)) {
					minDiff = diff;
					minSum = curSum;
				}
			}
		}
		return minSum;
	}

	// Sum smaller than target number
	public static int SumSmallerThanTargetNumber(int[] arr, int target) {
		if (arr == null || arr.length < 3) {
			new IllegalArgumentException();
		}

		Arrays.sort(arr);

		int count = 0;
		int diff = 0;
		int start = 1, end = arr.length - 1;

		for (int i = 0; i < arr.length - 2; i++) {
			if (arr[i] > target) {
				break;
			}
			start = i + 1;
			end = arr.length - 1;

			//{ -1, 1, 2, 3, 4 };
			while (start < end) {
				diff = target - (arr[start] + arr[end] + arr[i]);

				// incrementing both since incrementing one won't have any affect
				if (diff > 0) {
					count = count + (end - start);//for that start Index
					start++;
				} else {
					end--;
				}

			}
		}
		return count;
	}

}
