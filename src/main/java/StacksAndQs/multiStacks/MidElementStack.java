package StacksAndQs.multiStacks;

public class MidElementStack {
	private Node mid;
	private Node top;
	int totalNodes = 0;

	static class Node {
		int val;
		Node prev;
		Node next;

		Node(int val) {
			this.val = val;
		}
	}

	final int capacity;

	public MidElementStack(int capacity) {
		this.capacity = capacity;
	}
	
	// 1 2 3
	// 1 2 3 4 

	void push(Integer x) {

		if (isEmpty()) {
			top = new Node(x);
			mid = top;
			totalNodes++;
		} else {
			Node n = new Node(x);
			n.next = top;
			top.prev = n;
			top = n;
			totalNodes++;
			if (totalNodes % 2 != 0) {
				mid = mid.prev;
			}
		}
	}

	Integer pop() {
		int temp = top.val;
		top = top.next;
		top.prev = null;
		totalNodes--;
		if (totalNodes % 2 == 0) {
			mid = mid.next;
		}
		return temp;
	}

	boolean isEmpty() {
		return top == null;
	}

	Integer peek() {
		return top.val;
	}

	Node midElement() {
		return mid;
	}

	void removeMid() {
		Node prev = mid.prev;
		Node next = mid.next;
		prev.next = next;
		next.prev = prev;
	}

	public static void main(String[] args) {
		MidElementStack st = new MidElementStack(20);
		st.push(10);
		st.push(20);
		st.push(30);
		st.push(40);
		st.push(50);
		System.out.println(st.midElement().val);
		st.pop();
		System.out.println(st.midElement().val);
		st.pop();
		st.pop();
		st.pop();
		System.out.println(st.midElement().val);
	}
}
