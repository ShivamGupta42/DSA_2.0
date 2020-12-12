package Recursion;

public class SortArray {

	public static void sortArray(int[] array, int n) {
		if (n == array.length) {
			return;
		}
		for (int i = n + 1; i < array.length; i++) {
			if (array[n] > array[i]) {
				swap(array, n, i);
			}
		}
		sortArray(array, n + 1);
	}

	static void swap(int[] a, int i, int j) {
		a[i] = a[i] + a[j];
		a[j] = a[i] - a[j];
		a[i] = a[i] - a[j];
	}

	public static void main(String[] args) {
		int[] arr = { 3, 2, 1 ,-1,-4,6};
		printArray(arr);
		sortArray(arr, 0);
		printArray(arr);
		
		int x=0;
		System.out.println(x|1<<0);

	}

	static void printArray(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
