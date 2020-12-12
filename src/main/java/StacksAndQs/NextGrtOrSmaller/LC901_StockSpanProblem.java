package StacksAndQs.NextGrtOrSmaller;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class LC901_StockSpanProblem {

	ArrayList<Integer> arr;
	Deque<Integer> q;

	public LC901_StockSpanProblem() {
		arr = new ArrayList<Integer>();
		q = new LinkedList<>();
	}

	public int next(int price) {
		int spanLength = 1;
		int index = arr.size() - 1;
		while (!q.isEmpty() && q.peek() <= price && index >= 0) {
			spanLength += arr.get(index);
			arr.remove(index);
			q.pop();
			index = arr.size() - 1;
		}

		q.push(price);
		arr.add(spanLength);
		return spanLength;
	}

	public static void main(String[] args) {
		LC901_StockSpanProblem sp = new LC901_StockSpanProblem();
		System.out.println(sp.next(100));
		System.out.println(sp.next(80));
		System.out.println(sp.next(60));
		System.out.println(sp.next(70));
		System.out.println(sp.next(60));
		System.out.println(sp.next(75));
		System.out.println(sp.next(85));
	}

}
