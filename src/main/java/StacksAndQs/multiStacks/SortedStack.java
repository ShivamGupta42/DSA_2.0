package StacksAndQs.multiStacks;

public class SortedStack {
	int top = -1;
	Integer[] data;

	public SortedStack(int capacity) {
		data = new Integer[capacity + 1];
	}

	void push(Integer x) {
		if (top == data.length) {
			return; // throw exception
		}

		data[++top] = x;

		sortArray();

	}

	private void sortArray() {
		boolean sorted = false;
		int i = top;
		while (!sorted && i >= 1) {
			if (data[i] > data[i - 1]) {
				int temp = data[i];
				data[i] = data[i - 1];
				data[i - 1] = temp;
			} else {
				sorted = true;
			}

			i--;
		}

	}

	Integer pop() {
		if (top == -1) {
			// throw exception
		}
		Integer temp = data[top--];
		return temp;
	}

	boolean isEmpty() {
		return top == -1;
	}

	Integer peek() {
		return data[top];
	}

	public static void main(String[] args) {
		SortedStack minStack = new SortedStack(10);
		minStack.push(10);
		minStack.push(20);
		minStack.push(30);
		minStack.push(1);
		minStack.push(2);
		while (!minStack.isEmpty()) {
			System.out.println(minStack.pop());
		}

	}

}
