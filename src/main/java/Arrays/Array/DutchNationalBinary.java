package Arrays.Array;

public class DutchNationalBinary {

	public static void main(String[] args) {
		int[] arr = { 0, 1, 0, 1, 0, 1, 1 };

		int start = 0, end = arr.length - 1, i = 0;
		while (i < end) {
			if (arr[i] == 0) {
				swap(arr, start, i);
				start++;
			}
			i++;
		}

		for (int k : arr) {
			System.out.print(k + " ");
		}
	}

	private static void swap(int[] arr, int start, int i) {
		arr[start] = arr[start] + arr[i];
		arr[i] = arr[start] - arr[i];
		arr[start] = arr[start] - arr[i];
	}

}
