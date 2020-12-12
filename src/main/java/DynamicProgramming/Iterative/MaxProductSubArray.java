package DynamicProgramming.Iterative;

public class MaxProductSubArray {

	public int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0) {
			return Integer.MIN_VALUE;
		}

		int max = nums[0];
		int curMax = max;
		int curMin = max;

		for (int i = 1; i < nums.length; i++) {

			if (nums[i] < 0) {
				int temp = curMax;
				curMax = curMin;
				curMin = temp;
			}

			curMax = Math.max(nums[i], curMax * nums[i]);
			curMin = Math.min(nums[i], curMin * nums[i]);

			max = Math.max(max, curMax);
		}

		return max;

	}

}
