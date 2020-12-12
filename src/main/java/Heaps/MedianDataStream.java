package Heaps;

import java.util.PriorityQueue;

public class MedianDataStream {


	PriorityQueue<Integer> maxP;
	PriorityQueue<Integer> minP;

	public MedianDataStream() {
		maxP = new PriorityQueue<Integer>((a, b) -> b - a);
		minP = new PriorityQueue<Integer>((a, b) -> a - b);
	}

	public void addNum(int num) {
		if (maxP.size() == 0) {
			maxP.add(num);
			return;
		}

		if (maxP.size() == minP.size()) {
			if (num <= minP.peek()) {
				maxP.add(num);
			} else {
				int temp = minP.poll();
				maxP.add(temp);
				minP.add(num);
			}
		} else {
			int temp = 0;

			if (num >= maxP.peek()) {
				minP.add(num);
			} else {
				temp = maxP.poll();
				maxP.add(num);
				minP.add(temp);
			}
		}

	}

	
	
	public double findMedian() {
		if (minP.size() == maxP.size()) {
			return ((double) minP.peek() + (double) maxP.peek()) / 2;
		} else {
			return (double) maxP.peek();
		}
	}
}