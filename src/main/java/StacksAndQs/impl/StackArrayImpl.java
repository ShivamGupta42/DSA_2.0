package StacksAndQs.impl;

public class StackArrayImpl {

	int[] arr;
	int top = -1;

	public StackArrayImpl(int capacity) {
		arr = new int[capacity];
	}

	public void push(int value) {
		if (top == arr.length - 1) {
			throw new RuntimeException("Stack OverFlow");
		}
		top++;
		arr[top] = value;
	}

	public int pop() {
		if (top == -1) {
			throw new RuntimeException("Stack UnderFlow");
		}
		int res = arr[top];
		top--;
		return res;
	}

	public int size() {
		return top + 1;
	}

	public boolean isEmpty() {
		if (top == -1) {
			return true;
		}
		return false;
	}
}