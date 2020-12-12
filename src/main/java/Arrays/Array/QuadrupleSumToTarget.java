package Arrays.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuadrupleSumToTarget {

	public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
		Arrays.sort(arr);
		List<List<Integer>> quadruplets = new ArrayList<>();
		int ws = 0;
		int cs = 0;
		List<Integer> list = new ArrayList<>();

		for (int we = 0; we < arr.length; we++) {
			list.add(we);
			cs += arr[we];
			if (cs == target) {
				if (list.size() == 4) {
					List<Integer> l = new ArrayList<>(list);
					quadruplets.add(l);
				}
			}

			while (cs > target) {
				cs -= arr[ws];
				list.remove(0);
				ws++;
			}

		}

		return quadruplets;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 4, 1, 2, -1, 1, -3 };

		List<List<Integer>> c = searchQuadruplets(arr, 1);
		for (List<Integer> q : c) {
			for (int i : q) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}