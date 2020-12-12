package Arrays.Array;

public class SortedSquares {

	public static int[] makeSquares(int[] arr) {
		int[] squares = new int[arr.length];
		int low = 0;
		int high = arr.length - 1;
		int curIndex = high;
		int a = 0, b = 0;

		while (low < high && curIndex >= 0) {
			a = arr[low] * arr[low];
			b = arr[high] * arr[high];

			if (a > b) {
				squares[curIndex--] = a;
				low++;
			} else if (a < b) {
				squares[curIndex--] = b;
				high--;
			} else {
				squares[curIndex--] = a;
				squares[curIndex--] = b;
				low++;
				high--;
			}

		}
		return squares;
	}

	public static void main(String[] args) {
		int[] arr = { -2, -1, 0, 2, 3 };
		for (int i : makeSquares(arr)) {
			System.out.print(i + " ");
		}
		String str;
		
	}
}