package Strings.Substring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LargestSubstringZeroSequence {

	public static ArrayList<Integer> lszero(ArrayList<Integer> A) {

		ArrayList<Integer> res = new ArrayList<Integer>();

		if (A == null || A.size() == 0) {
			return res;
		}

		int ws = 0;
		int we = 0;
		int maxLen = Integer.MIN_VALUE;
		int sum = 0;
		int start = -1, end = -1;

		for (we = 0; we < A.size(); we++) {
			sum += A.get(we);

			while (sum != 0 && ws < we) {
				sum -= A.get(ws++);
			}
            
			Integer a = 1;
			Integer b = 2;
			a.compareTo(b);
			
			if (sum == 0) {
				if (maxLen < we - ws + 1) {
					maxLen = we - ws + 1;
					start = ws;
					end = we;
				}
			}

		}

		if (start == -1 || end == -1) {
			return res;
		}
		res.addAll(A.subList(start, end + 1));
		return res;
	}

	public static void main(String[] args) {

		int[] arr = new int[] { 1, 2, -2, 4, -4 };
		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
		ArrayList<Integer> res = lszero(new ArrayList<Integer>(list));
		res.stream().forEach(e -> System.out.print(e + " "));
	}
}
