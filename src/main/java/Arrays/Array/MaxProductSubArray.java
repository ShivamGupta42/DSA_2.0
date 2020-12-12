package Arrays.Array;

public class MaxProductSubArray {

	public static int maxProduct(int[] nums) {

		int ws = 0;
		int curProduct = 1;
		int maxProduct = Integer.MIN_VALUE;
		
		

		for (int we = 0; we < nums.length; we++) {

			if (nums[we] == 0) {
				ws = we + 1;
				curProduct = 1;
				maxProduct = Math.max(0, maxProduct);
				continue;
			}

			curProduct *= nums[we];

			while (curProduct <= 0 && ws < we) {
				if (nums[ws] != 0) {
					curProduct /= nums[ws++];
				}
				maxProduct = Math.max(curProduct, maxProduct);
			}

			maxProduct = Math.max(curProduct, maxProduct);
		}

		return maxProduct;
	}

	public static void main(String[] args) {
		System.out.println(maxProduct(new int[] { -2, 0, -1 }));
	}

}
