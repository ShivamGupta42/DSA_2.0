package Arrays.Duplicates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveTriplcates {

	public static int removeDuplicates(List<Integer> A) {
		if (A == null) {
			return -1;
		}
		if (A.size() <= 2) {
			return A.size();
		}

		int deleteVal = A.get(A.size() - 1);
		int i = A.size() - 3;
		while (i >= 0) {
			if (A.get(i) == deleteVal) {
				A.remove(i);

			} else if (A.get(i).equals(A.get(i + 1))) {
				deleteVal = A.get(i);
			}
			i--;
		}

		return A.size();

	}

	public static void main(String[] args) {
		Integer[] arr = new Integer[] { 1000, 1000, 1000, 1000, 1001, 1002, 1003, 1003, 1004, 1010 };
		List<Integer> list = new ArrayList<>(Arrays.asList(arr));
		int len = removeDuplicates(list);
		System.out.println(len);
	}

}
