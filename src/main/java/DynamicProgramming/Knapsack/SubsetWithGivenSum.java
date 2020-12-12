package DynamicProgramming.Knapsack;

public class SubsetWithGivenSum {

	static boolean canPartition(int[] num, int sum) {
		if (num == null) {
			return false;
		}

		if (num.length == 0 && sum == 0) {
			return false;
		}

		Boolean[][] dp = new Boolean[num.length + 1][sum + 1];
		return knapsack(num, sum, 0, dp);
	}

	static boolean knapsack(int[] num, int remainingSum, int curIndex, Boolean[][] dp) {
		if (curIndex > num.length - 1 || remainingSum < 0) {
			return false;
		}

		if (remainingSum == 0) {
			return true;
		}

		if (dp[curIndex][remainingSum] != null) {
			return dp[curIndex][remainingSum];
		}

		boolean curElementSelected = false;
		boolean curElementNotSelected = false;

		if (num[curIndex] <= remainingSum) {
			curElementSelected = knapsack(num, remainingSum - num[curIndex], curIndex + 1, dp);
		}

		curElementNotSelected = knapsack(num, remainingSum, curIndex + 1, dp);

		dp[curIndex][remainingSum] = curElementSelected || curElementNotSelected;
		return dp[curIndex][remainingSum];

	}
}
