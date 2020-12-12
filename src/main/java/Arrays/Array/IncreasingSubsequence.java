package Arrays.Array;

public class IncreasingSubsequence {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, -1, 3, 2 };
		int[] res = { -36, -18, -12, 36, -12, -18};

		int[] leftMin = new int[arr.length];

		int minIndex = -1;
		int minValue = Integer.MAX_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < minValue) {
				minValue = arr[i];
				minIndex = i;
				leftMin[i] = -1;
				continue;
			}

			leftMin[i] = minIndex;
		}

		int[] rightMax = new int[arr.length];
		int maxIndex = -1;
		int maxValue = Integer.MIN_VALUE;

		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] > maxValue) {
				maxValue = arr[i];
				maxIndex = i;
				rightMax[i] = -1;
				continue;
			}

			rightMax[i] = maxIndex;
		}
		
		
		
		for (int i = 0; i < arr.length; i++) {
			if(leftMin[i]!=-1&&rightMax[i]!=-1) {
			    System.out.println(arr[leftMin[i]]);
			    System.out.println(arr[i]);
			    System.out.println(arr[rightMax[i]]);
			    return;
			}
		}
		

	}

}
