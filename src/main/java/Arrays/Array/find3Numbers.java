package Arrays.Array;

import java.util.ArrayList;

public class find3Numbers {

	public static ArrayList<Integer> find3Numbers(int[] arr, int n) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 1; i < n - 1; i++) {

			int left = -1;
			int right = -1;

			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					left = j;
					break;
				}
			}

			if (left == -1) {
				continue;
			}

			for (int j = i + 1; j < n; j++) {
				if (arr[j] > arr[i]) {
					right = j;
					break;
				}
			}
			if (right == -1) {
				continue;
			}

			list.add(arr[left]);
			list.add(arr[i]);
			list.add(arr[right]);
			break;

		}

		return list;
	}

	public static ArrayList<Integer> find3NumbersOptimized(int[] arr, int n) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		// finding if there exists a value which is smaller than
		// current value to the right
		int[] smaller = new int[n];
		smaller[0] = -1;
		int minIndex = 0;
		int min = arr[0];

		for (int i = 1; i < n; i++) {
			if (arr[i] < min) {
				min = arr[i];
				smaller[i] = -1;
				minIndex = i;
			} else {
				smaller[i] = minIndex;
			}
		}

		int[] greater = new int[n];
		greater[n - 1] = -1;
		int maxIndex = n - 1;
		int max = arr[n - 1];

		for (int i = n - 2; i >= 0; i--) {
			if (arr[i] > max) {
				max = arr[i];
				greater[i] = -1;
				maxIndex = i;
			} else {
				greater[i] = maxIndex;
			}
		}

		
		
		for (int i = 1; i < n - 1; i++) {
			if (smaller[i] != -1 && greater[i] != -1) {
				list.add(arr[smaller[i]]);
				list.add(arr[i]);
				list.add(arr[greater[i]]);
				break;
			}
		}

		return list;

	}// end

}
