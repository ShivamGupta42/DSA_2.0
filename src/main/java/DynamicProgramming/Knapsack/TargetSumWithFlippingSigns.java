package DynamicProgramming.Knapsack;

//Leetcode target Sum
public class TargetSumWithFlippingSigns {

	
	public int findTargetSumWays(int[] nums, int S) {

		int totalSum = 0;
		for (int i : nums) {
			totalSum += i;
		}

		// This sum has to be mathematically even
		if (totalSum<S||((S + totalSum) & 1) != 0) {
			return 0;
		}

		int targetSum = (S + totalSum) >> 1;

		Integer[][] dp = new Integer[targetSum + 1][nums.length + 1];
		return countSubsetsWithGivenSum(nums, targetSum, 0, dp);

	}

	public int countSubsetsWithGivenSum(int[] nums, int targetSum, int curIndex, Integer[][] dp) {
		if (targetSum == 0) {
			return 1;
		}

		if (targetSum < 0 || curIndex >= nums.length) {
			return 0;
		}

		if (dp[targetSum][curIndex] != null) {
			return dp[targetSum][curIndex];
		}

		// Choosing curElement
		int sol1 = countSubsetsWithGivenSum(nums, targetSum - nums[curIndex], curIndex + 1, dp);
		// Not Choosing curElement
		int sol2 = countSubsetsWithGivenSum(nums, targetSum, curIndex + 1, dp);

		dp[targetSum][curIndex] = sol1 + sol2;
		return dp[targetSum][curIndex];
	}

}
