package Heaps;

import java.util.*;
import java.util.stream.Collectors;

public class KFrequent {

	static List<Integer> kthFreq(int[] arr, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
			} else {
				map.put(arr[i], map.get(arr[i]) + 1);
			}
		}

		// Create a list from elements of HashMap
		List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(map.entrySet());

		// Sort the list
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});

		return list.stream().map(e -> e.getKey()).limit(k).collect(Collectors.toList());
	}
}
