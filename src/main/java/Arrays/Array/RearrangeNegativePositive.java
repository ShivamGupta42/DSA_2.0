package Arrays.Array;

public class RearrangeNegativePositive {

	public static void main(String[] args) {
		int[] arr = new int[] { -1, -3, -8, 10, 11, -4, -10, 13, -9, 20 };
		rearrangeArray(arr);
		printArray(arr);
	}

	private static void rearrangeArray(int[] arr) {
		int currentNegativeNumber = -1;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				currentNegativeNumber++;
				swap(arr, i, currentNegativeNumber);
			}
		}

	}

	private static void swap(int[] arr, int i, int j) {
		if (i == j) {
			return;
		}
		
		arr[i]=arr[i]+arr[j];
		arr[j]=arr[i]-arr[j];
		arr[i]=arr[i]-arr[j];

	}

	static void printArray(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

}
