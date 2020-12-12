package DynamicProgramming.UnboundedKnapsack;

public class RotCutting {

	public static void main(String[] args) {
		RotCutting rc = new RotCutting();
		int[] lengths = { 1, 2, 3, 4, 5 };
		int[] prices = { 2, 6, 7, 10, 13 };
		int maxProfit = rc.solveRodCutting(lengths, prices, 5);
		System.out.println(maxProfit);
	}

	private int solveRodCutting(int[] lengths, int[] prices, int length) {
		if (length < 0 || lengths.length != prices.length) {
			return 0;
		}

		Integer[][] dp = new Integer[length + 1][prices.length + 1];
		return helper(lengths, prices, length, 0, dp);
	}

	private int helper(int[] lengths, int[] prices, int length, int curIndex, Integer[][] dp) {
		if (length <= 0 || curIndex >= prices.length) {
			return 0;
		}

		if (dp[length][curIndex] != null) {
			return dp[length][curIndex];
		}

		int prof1 = 0;
		if (length - lengths[curIndex] >= 0) {
			prof1 = prices[curIndex] + helper(lengths, prices, length - lengths[curIndex], curIndex, dp);
		}

		int prof2 = helper(lengths, prices, length, curIndex + 1, dp);

		dp[length][curIndex] = Math.max(prof1, prof2);
		return dp[length][curIndex];

	}

}
