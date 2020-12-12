package Arrays.SubArray;

import java.util.Deque;
import java.util.LinkedList;

public class LC1004_MaxOnes {

	public static int longestOnes(int[] A, int K) {
		if (A == null || A.length == 0 || K < 0) {
			return 0;
		}

		int ws = 0;
		int we = 0;
		int curFlip = 0;
		int max = Integer.MIN_VALUE;
		Deque<Integer> flippedIndexes = new LinkedList<>();

		for (we = 0; we < A.length; we++) {
			if (A[we] == 1) {
				continue;
			}
			if (A[we] == 0 && curFlip < K) {
				flippedIndexes.add(we);
				curFlip++;
			} else if (curFlip == K) {
				flippedIndexes.add(we);
				max = Math.max(max, we - ws);
				ws = flippedIndexes.poll() + 1;
			}
		}

		return Math.max(max, we - ws);
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
		System.out.println(longestOnes(arr, 2));
	}
}
