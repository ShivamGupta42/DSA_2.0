package Arrays.Sorting;

public class ShortestWindowSort {

	public static int sort(int[] arr) {
		if (arr == null || arr.length == 1) {
			return 0;
		}

		int f = 0, l = arr.length - 1;

		while (f < l) {
			if (arr[l] < arr[f]) {
				break;
			}
			
			if (arr[f + 1] > arr[f]) {
				f++;
			} else {
				break;
			}

			if (arr[l - 1] < arr[l]) {
				l--;
			} else {
				break;
			}
			
		}

		if (l > f) {
			return l - f + 1;
		}
		return 0;
	}
}