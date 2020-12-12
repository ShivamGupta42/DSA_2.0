package StacksAndQs.impl;

import java.util.Deque;
import java.util.LinkedList;

public class QueueTwoStacks {

	Deque<Integer> s1;
	Deque<Integer> s2;

	public QueueTwoStacks() {
		s1 = new LinkedList<>();
		s2 = new LinkedList<>();
	}

	// T - 2 * n
	void enQ(int x) {

		while (!s1.isEmpty()) {
			s2.push(s1.pop());
		}
		s2.push(x);
		while (!s2.isEmpty()) {
			s1.push(s2.pop());
		}

	}

	// T - 1
	Integer dQ() {
		return !s1.isEmpty() ? s1.pop() : null;
	}

	public static void main(String[] args) {
		QueueTwoStacks impl = new QueueTwoStacks();
		impl.enQ(1);
		impl.enQ(2);
		impl.enQ(3);
		impl.enQ(4);
		System.out.println(impl.dQ());
		System.out.println(impl.dQ());
		System.out.println(impl.dQ());
		System.out.println(impl.dQ());

	}

}
