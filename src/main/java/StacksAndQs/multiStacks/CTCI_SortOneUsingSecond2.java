package StacksAndQs.multiStacks;

import java.util.Deque;
import java.util.LinkedList;

public class CTCI_SortOneUsingSecond2 {
	Deque<Integer> main;
	Deque<Integer> aux;

	public CTCI_SortOneUsingSecond2() {
		main = new LinkedList<>();
		aux = new LinkedList<>();
	}

	void push(int x) {

		if (main.isEmpty()) {
			main.push(x);
			return;
		}

		if (x <= main.peek()) {
			main.push(x);
		} else {
			while (!main.isEmpty() && x > main.peek()) {
				aux.push(main.pop());
			}

			main.push(x);
			while (!aux.isEmpty()) {
				main.push(aux.pop());
			}
		}
	}

	int pop() {
		return main.pop();
	}

	int peek() {
		return main.peek();
	}

	boolean isEmpty() {
		return main.isEmpty();
	}

	public static void main(String[] args) {
		CTCI_SortOneUsingSecond2 st = new CTCI_SortOneUsingSecond2();
		st.push(1);
		st.push(-1);
		st.push(0);
		st.push(2);
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
	}
}
