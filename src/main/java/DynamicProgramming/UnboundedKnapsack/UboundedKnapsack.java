package DynamicProgramming.UnboundedKnapsack;

public class UboundedKnapsack {

	public static void main(String[] args) {
		UboundedKnapsack ks = new UboundedKnapsack();
		int capacity = 8;
		int[] profits = { 15, 50, 60, 90 };
		int[] weights = { 1, 3, 4, 5 };
		// int maxProfit = ks.solveKnapsackIterative(profits, weights, 8);
		Integer[][] dp = new Integer[capacity + 1][profits.length + 1];
		int maxProfit = ks.solveKnapsackRecursive(profits, weights, capacity, 0, dp);
		System.out.println(maxProfit);
	}

	private int solveKnapsackIterative(int[] profits, int[] weights, int capacity) {
		if (capacity == 0) {
			return 0;
		}

		int maxProfit = Integer.MIN_VALUE;
		int curProfit = 0;

		for (int i = 0; i < profits.length; i++) {
			if (capacity - weights[i] >= 0) {
				curProfit = profits[i] + solveKnapsackIterative(profits, weights, capacity - weights[i]);
				maxProfit = Math.max(maxProfit, curProfit);
			}
		}

		return maxProfit == Integer.MIN_VALUE ? 0 : maxProfit;

	}

	private int solveKnapsackRecursive(int[] profits, int[] weights, int capacity, int curIndex, Integer[][] dp) {
		if (capacity <= 0 || curIndex >= profits.length) {
			return 0;
		}

		if (dp[capacity][curIndex] != null) {
			return dp[capacity][curIndex];
		}

		// taking current element
		int prof1 = 0;
		if (capacity - weights[curIndex] >= 0) {
			prof1 = profits[curIndex]
					+ solveKnapsackRecursive(profits, weights, capacity - weights[curIndex], curIndex, dp);
		}

		// Not taking current element
		int prof2 = solveKnapsackRecursive(profits, weights, capacity, curIndex + 1, dp);

		dp[capacity][curIndex] = Math.max(prof1, prof2);
		return dp[capacity][curIndex];

	}

}
