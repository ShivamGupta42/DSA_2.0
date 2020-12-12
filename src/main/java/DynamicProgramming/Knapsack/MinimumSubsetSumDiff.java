package DynamicProgramming.Knapsack;

public class MinimumSubsetSumDiff {

	public int canPartition(int[] num) {

		int total = 0;
		for (int i : num) {
			total += i;
		}

		Integer[][] dp = new Integer[total + 1][num.length + 1];
		return canPartitionRecursive(num, 0, 0, 0, dp);
	}

	private int canPartitionRecursive(int[] num, int currentIndex, int sum1, int sum2, Integer[][] dp) {
		// base check
		if (currentIndex == num.length)
			return Math.abs(sum1 - sum2);

		if (dp[sum1][currentIndex] != null) {
			return dp[sum1][currentIndex];
		}

		// recursive call after including the number at the currentIndex in the first
		int diff1 = canPartitionRecursive(num, currentIndex + 1, sum1 + num[currentIndex], sum2, dp);

		// recursive call after including the number at the currentIndex in the second
		int diff2 = canPartitionRecursive(num, currentIndex + 1, sum1, sum2 + num[currentIndex], dp);

		dp[sum1][currentIndex] = Math.min(diff1, diff2);
		return dp[sum1][currentIndex];
	}

	public static void main(String[] args) {
		MinimumSubsetSumDiff ps = new MinimumSubsetSumDiff();
		int[] num = { 1, 2, 3, 9 };
		System.out.println(ps.canPartition(num));
		num = new int[] { 1, 2, 7, 1, 5 };
		System.out.println(ps.canPartition(num));
		num = new int[] { 1, 3, 100, 4 };
		System.out.println(ps.canPartition(num));
	}

}
