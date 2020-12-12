package StacksAndQs.impl;

import java.util.ArrayList;

public class LC1381_StackWithIncrement {
	int[] arr;
	int head = -1;

	public LC1381_StackWithIncrement(int maxSize) {
		arr = new int[maxSize];
	}

	public void push(int x) {
		if (head == arr.length - 1) {
			return;
		}
		arr[++head] = x;
	}

	public int pop() {
		if (head == -1) {
			return head;
		}
		return arr[head--];
	}

	public void increment(int k, int val) {
		int i = 0;
		while (i < k && i <= head) {
			arr[i] += val;
			i++;
		}
		
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list1.addAll(list2);
		
	}

	public static void main(String[] args) {
		LC1381_StackWithIncrement lc = new LC1381_StackWithIncrement(3);
		lc.push(1);
		lc.push(2);
		lc.push(3);
		lc.push(4);
		lc.pop();
		lc.pop();
		lc.increment(3, 100);
	}

}
