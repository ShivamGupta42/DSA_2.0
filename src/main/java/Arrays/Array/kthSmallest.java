package Arrays.Array;

public class kthSmallest {

	public static void main(String[] args) {
		int[] arr = { 34, 12, 11, 1, 4, 54, 3, 32, 3 };

		int  k = kSmallest(arr, 5);
		System.out.println(k);
	}

	private static int kSmallest(int[] arr, int k) {

		
		int min = Integer.MAX_VALUE;
		int index=-1;

		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==-1)continue;
			if (arr[i]<=min) {
				min = arr[i];
				index=i;
			}
		}
		
		
		if (k == 1)
			return min;
		else {
		  arr[index]=-1;
		  return kSmallest(arr, k-1);
		}

	}

}
