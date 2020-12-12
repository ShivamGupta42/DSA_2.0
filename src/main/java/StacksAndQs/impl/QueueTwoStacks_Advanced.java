package StacksAndQs.impl;

import java.util.Deque;
import java.util.LinkedList;

public class QueueTwoStacks_Advanced {

	Deque<Integer> stackNewest;
	Deque<Integer> stackOldest;

	public QueueTwoStacks_Advanced() {
		/*
		 * stackNewest has all the newest elements on the top stackOldest has all the
		 * oldest elements on the top
		 */
		stackNewest = new LinkedList<>();
		stackOldest = new LinkedList<>();
	}

	void enQ(int x) {
		stackNewest.push(x);
	}

	Integer dQ() {
		if (!stackOldest.isEmpty()) {
			return stackOldest.pop();
		} else {
			shiftStacks();
			if (!stackOldest.isEmpty()) {
				return stackOldest.pop();
			}
		}
		return null;
	}

	void shiftStacks() {
		while (!stackNewest.isEmpty()) {
			stackOldest.push(stackNewest.pop());
		}
	}

	Integer peekLast() {

		if (!stackOldest.isEmpty()) {
			return stackOldest.peek();
		} else {
			shiftStacks();
			if (!stackOldest.isEmpty()) {
				return stackOldest.peek();
			}
		}
		return null;
	}

	Integer peekFirst() {

		if (!stackNewest.isEmpty()) {
			return stackNewest.peek();
		} else {
			if (!stackOldest.isEmpty()) {
				return stackOldest.peekLast();
			}
		}
		return null;
	}

	public static void main(String[] args) {
		QueueTwoStacks_Advanced qs = new QueueTwoStacks_Advanced();
		qs.enQ(1);
		qs.enQ(2);
		qs.enQ(3);
		qs.enQ(4);
		qs.enQ(5);
		System.out.println(qs.dQ());
		System.out.println(qs.dQ());
		System.out.println(qs.peekFirst());
		System.out.println(qs.peekLast());
	}

}
