package Arrays.Array;

import java.util.Arrays;
import java.util.HashSet;

public class TripletSumZero {

	// T - N^2
	// S - N
	public static boolean findTripletsMap(int arr[], int n) {
		HashSet<Integer> set;
		int k = 0;

		for (int i = 0; i < n; i++) {
			set = new HashSet<>();
			k = -arr[i];

			for (int j = i + 1; j < n; j++) {
				if (set.contains(k - arr[j])) {
					return true;
				}
				set.add(arr[j]);
			}

		} //

		return false;
	}

	// T - N^2LOGN
	// S - !
	public static boolean findTripletsSorting(int arr[], int n) {
		int k = 0;
		int low = -1;
		int high = -1;
		Arrays.parallelSort(arr);

		for (int i = 0; i < n; i++) {
			k = -arr[i];
			low = i + 1;
			high = n-1;

			while (low < high && low < n && high > 0) {
				if (arr[low] + arr[high] > k) {
					high--;
				} else if (arr[low] + arr[high] < k) {
					low++;
				} else {
					return true;
				}

			}

		} //

		return false;
	}

	public static void main(String[] args) {
		int[] arr = { 0, -1, 2, -3, 1 };
		System.out.println(findTripletsSorting(arr, arr.length));
	}
	

}
