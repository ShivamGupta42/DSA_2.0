package Greedy;

import java.util.Arrays;
import java.util.List;

public class MajorityElement {

	public static int majorityElement(final List<Integer> A) {

		int major = A.get(0), count = 1;

		for (int i = 1; i < A.size(); i++) {

			if (count == 0) {
				major = A.get(i);
				count = 1;
			} else if (A.get(i).equals(A.get(i - 1))) {
				count++;
			} else {
				count--;
			}

		}

		return major;

	}

	public static void main(String[] args) {
		System.out.println(majorityElement(Arrays.asList(2, 2, 1, 1, 1)));
	}

}
