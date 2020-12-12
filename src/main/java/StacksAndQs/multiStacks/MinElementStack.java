package StacksAndQs.multiStacks;

public class MinElementStack {
	int top = -1;
	Integer[] data;

	public MinElementStack(int capacity) {
		data = new Integer[capacity];
	}

	void push(Integer x) {
		if (top == data.length) {
			return; // throw exception
		}

		if (isEmpty()) {
			data[++top] = x;
		}

		else {
			if (x.compareTo(peek()) > 0) {
				int temp = pop();
				data[++top] = x;
				data[++top] = temp;
			}else {
				data[++top]=x;
			}

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

	Integer minElement() {
		return peek();
	}

	public static void main(String[] args) {
		MinElementStack minStack = new MinElementStack(10);
		minStack.push(10);
		minStack.push(20);
		minStack.push(30);
		System.out.println(minStack.minElement());
		minStack.push(1);
		System.out.println(minStack.minElement());
		minStack.push(2);
		System.out.println(minStack.minElement());

	}

}
