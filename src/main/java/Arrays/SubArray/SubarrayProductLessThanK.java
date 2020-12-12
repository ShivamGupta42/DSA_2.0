package Arrays.SubArray;

import java.util.ArrayList;
import java.util.List;

public class SubarrayProductLessThanK {

	public static List<List<Integer>> findSubarrays(int[] arr, int target) {
		List<List<Integer>> subarrays = new ArrayList<>();
		int winStart = 0;
		int winEnd = 0;
		int curProd = 1;

		List<Integer> list = new ArrayList<>();

		if (arr[0] < target) {
			List<Integer> l = new ArrayList<>();
			l.add(arr[0]);
			subarrays.add(l);
			list.add(arr[0]);
			curProd = arr[0];
		} else {
			winStart++;
		}

		for (winEnd = 1; winEnd < arr.length; winEnd++) {
			if (arr[winEnd] < target) {
				List<Integer> l = new ArrayList<>();
				l.add(arr[winEnd]);
				subarrays.add(l);
			}
			list.add(arr[winEnd]);
			curProd *= arr[winEnd];
			while (curProd >= target) {
				if (arr[winStart] != 0) {
					curProd /= arr[winStart];
				}
				winStart++;
				list.remove(0);
			}

			if (list.size() >= 2) {
				List<Integer> list1 = new ArrayList<>(list);
				subarrays.add(list1);
			}
		}
		return subarrays;
	}
}

