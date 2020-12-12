package Heaps;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KFreqLeetcode {

	public int[] topKFrequent(int[] nums, int K) {
		if (nums == null || nums.length < K || K <= 0) {
			return new int[] {};
		}

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			map.compute(nums[i], (k, v) -> {
				if (v == null) {
					return 1;
				} else {
					return v + 1;
				}
			});
		}

		Comparator<Map.Entry<Integer, Integer>> c = (a, b) -> a.getValue() - b.getValue();

		PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue<Map.Entry<Integer, Integer>>(c);

		int count = 0;
		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			if (count < K) {
				q.add(e);
				count++;
			} else {
				if (e.getValue() > q.peek().getValue()) {
					q.poll();
					q.add(e);
				}
			}
		}

		int[] res = new int[K];

		int i = 0;
		while (i < K) {
			res[i++] = q.poll().getKey();
		}

		return res;
	}

}
