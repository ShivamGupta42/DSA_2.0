package DynamicProgramming.UnboundedKnapsack;

public class MinimumCoinChange {

	public int coinChange(int[] coins, int amount) {
		if (coins == null || coins.length == 0 || amount == 0) {
			return 0;
		}

		Integer[] dp = new Integer[amount + 1];
		helper(coins, amount, dp);
		return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
	}

	public int helper(int[] coins, int remAmount, Integer[] dp) {

		if (remAmount < 0) {
			return Integer.MAX_VALUE;
		}

		if (remAmount == 0) {
			return 0;
		}

		if (dp[remAmount] != null) {
			return dp[remAmount];
		}

		int curCoins = 0;
		int minCoins = Integer.MAX_VALUE;
		;

		for (int coin : coins) {
			curCoins = helper(coins, remAmount - coin, dp);
			minCoins = Math.min(curCoins, minCoins);
		}

		dp[remAmount] = minCoins == Integer.MAX_VALUE ? Integer.MAX_VALUE : minCoins + 1;
		return dp[remAmount];
	}

	/*
	 * Why this doesn't work?
	 * 
	 */
	public int old_helper(int[] coins, int remAmount, int curIndex, int totalCoins) {

		if (remAmount != 0 && curIndex < 0) {
			return Integer.MAX_VALUE;
		}

		if (remAmount == 0 || curIndex < 0) {
			return totalCoins;
		}

		// Taking this denomination
		int total1 = old_helper(coins, remAmount - coins[curIndex], curIndex - 1, totalCoins + 1);

		// Not taking this denomination
		int total2 = old_helper(coins, remAmount, curIndex - 1, totalCoins);

		return Math.min(total1, total2);
	}

	public static void main(String[] args) {
		MinimumCoinChange c = new MinimumCoinChange();
		// System.out.println(c.coinChange(new int[] { 186, 419, 83, 408 }, 6249));
		System.out.println(c.coinChange(new int[] { 1, 2, 5 }, 11));
	}

}
