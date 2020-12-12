package JavaCollections.Lists;

public class MyArrayList<T> {

	private final int sizeFactor = 5;
	private T[] data;
	private int lastFilledIndex = -1;

	public MyArrayList(int capacity) {
		data = (T[]) new Object[capacity];
	}

	public void add(T a) {
		if (lastFilledIndex > data.length - 1) {
			increaseSize();
		}
		data[++lastFilledIndex] = a;
	}

	private void increaseSize() {
		int size = data.length + sizeFactor;
		T[] newData = (T[]) new Object[size];

		for (int i = 0; i < data.length; i++) {
			newData[i] = data[i];
		}

		lastFilledIndex = data.length - 1;
		data = newData;
	}

	public void remove(int a) {
		int index = -1;
		for (int i = 0; i <= lastFilledIndex; i++) {
			if (data[i] == Integer.valueOf(a)) {
				index = i;
				break;
			}
		}

		if (index == -1) {
			System.out.println("Object not found");
			return;
		}

		for (int i = index; i < lastFilledIndex; i++) {
			data[i] = data[i + 1];
		}

		lastFilledIndex--;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= lastFilledIndex; i++) {
			sb.append(data[i].toString() + " ");
		}
		return sb.toString();
	}

}
