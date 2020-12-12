package DynamicProgramming.Knapsack;

public class EqualSubsetSumPartition {

	public boolean canPartition(int[] nums) {
		int total = 0;
		for (int i : nums) {
			total += i;
		}

		if (total % 2 != 0) {
			return false;
		}

		Boolean[][] dp = new Boolean[nums.length + 1][(total / 2) + 1];
		// Knapsack with total weight = total/2
		return Knapsack(nums, total / 2, 0, 0, dp);

	}

	public boolean Knapsack(int[] nums, int total, int curIndex, int curSum, Boolean[][] dp) {
		if (curIndex >= nums.length || curSum > total) {
			return false;
		}

		if (curSum == total) {
			return true;
		}

		if (dp[curIndex][curSum] != null) {
			return dp[curIndex][curSum];
		}

		boolean resSelected = false;
		boolean resNotSelected = false;

		if (curSum + nums[curIndex] <= total) {
			resSelected = Knapsack(nums, total, curIndex + 1, curSum + nums[curIndex], dp);
		}

		resNotSelected = Knapsack(nums, total, curIndex + 1, curSum, dp);

		dp[curIndex][curSum] = resSelected || resNotSelected;

		return dp[curIndex][curSum];
	}

	public static void main(String[] args) {
		EqualSubsetSumPartition eq = new EqualSubsetSumPartition();
		int[] a = new int[] { 1, 2, 5 ,10,3};
		System.out.println(eq.canPartition(a));

	}
}
