package StacksAndQs.Advanced;

import java.util.LinkedList;

public class MedianFinderInsertion {

	/** initialize your data structure here. */
	static LinkedList<Integer> list = new LinkedList<Integer>();

	public static void addNum(int num) {
		if (list.size() == 0) {
			list.add(num);
			return;
		}
		int i = 0;
		int current = 0;
		while (i < list.size()) {
			current = list.get(i);
			if (current == num) {
				list.add(i, num);
				return;
			}

			int j = i - 1;
			while (j >= 0 && list.get(j) > current) {
				list.set(j + 1, list.get(j));
				j--;
			}

			list.set(j + 1, current);
			i++;
		}
	}

	public static double findMedian() {
		int size = list.size();
		if ((size & (size - 1)) != 0) {
			return list.get(size / 2);
		} else {
			return ((double) list.get(size / 2) + (double) list.get((size / 2) - 1)) / 2;
		}
	}

	public static void main(String args[]) {
		addNum(4);
		//System.out.println(findMedian());
		addNum(8);
		System.out.println(findMedian());
		addNum(2);
		System.out.println(findMedian());
		addNum(11);
		System.out.println(findMedian());
		addNum(13);
		System.out.println(findMedian());
		addNum(14);
		System.out.println(findMedian());
		addNum(-1);
		System.out.println(findMedian());

	}

}
