package Hashing.Ibit;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Diff2 {

	public static int diffPossible(final List<Integer> A, int k) {
		if (A == null || A.size() < 2) {
			return 0;
		}

		if (k == 0) {
			return A.size();
		}

		Collections.sort(A);

		int i = 0, j = 1;
		k = k < 0 ? -k : k;
		int count = 0;

		while (j < A.size()) {
			if (A.get(j) - A.get(i) == k) {
				count++;
				j++;
			} else if (A.get(j) - A.get(i) < k) {
				j++;
			} else {
				i++;
				if (i == j) {
					j++;
				}
			}
		}

		return count;
	}

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(66, 37, 46, 56, 49, 65, 62, 21, 7, 70, 13, 71, 93, 26, 18, 84, 96, 65, 92,
				69, 97, 47, 6, 18, 17, 47, 28, 71, 70, 24, 46, 58, 71, 21, 30, 44, 78, 31, 45, 65, 16, 3, 22, 54, 51,
				68, 19, 86, 44, 99, 53, 24, 40, 92, 38, 81, 4, 96, 1, 13, 45, 76, 77, 8, 88, 50, 89, 38, 60, 61, 49, 25,
				10, 80, 49, 63, 95, 74, 29, 27, 52, 27, 40, 66, 38, 22, 85, 22, 91, 98, 19, 20, 78, 77, 48, 63, 27);
	   
		System.out.println(diffPossible(list, 31));
	
	}

}
