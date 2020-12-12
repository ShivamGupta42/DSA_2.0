package StacksAndQs.impl;

public class CTCI_ConstantMinOperation<T extends Comparable<T>> {

	static class StackNode<T> {
		T data;
		StackNode<T> next;

		public StackNode(T data) {
			this.data = data;
		}
	}

	StackNode<T> top;
	StackNode<T> min;

	void push(T data) {

		StackNode<T> cur = new StackNode<>(data);
		if (top == null) {
			top = cur;
			min = new StackNode<>(data);
			return;
		}

		if (min.data.compareTo(cur.data) > 0) {
			StackNode<T> node = new StackNode<>(cur.data);
			node.next = min;
			min = node;
		}

		cur.next = top;
		top = cur;

	}

	StackNode<T> pop() {

		if (top == null) {
			throw new StackOverflowError("Stack is empty");
		}

		StackNode<T> cur = new StackNode<>(top.data);
		top = top.next;

		if (min.data.compareTo(cur.data) == 0) {
			min = min.next;
		}
		return cur;
	}

	String min() {
		return min.data.toString();
	}

	public static void main(String[] args) {
		CTCI_ConstantMinOperation<Integer> ct = new CTCI_ConstantMinOperation<Integer>();
		ct.push(1);
		ct.push(3);
		ct.push(4);
		ct.push(2);
		System.out.println(ct.min.data.intValue());
		ct.pop();
		System.out.println(ct.min.data.intValue());
		ct.pop();
		System.out.println(ct.min.data.intValue());
		ct.pop();
		System.out.println(ct.min.data.intValue());
		ct.pop();
		

	}
}
