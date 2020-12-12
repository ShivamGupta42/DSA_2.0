package DynamicProgramming.UnboundedKnapsack;

public class MinimumCoinChange2 {

	public static void main(String[] args) {
		MinimumCoinChange2 cc = new MinimumCoinChange2();
		int[] denominations = { 1, 2, 3 };
		System.out.println(cc.countChange(denominations, 5));
	}

	private int countChange(int[] denominations, int sum) {
		Integer[][] dp = new Integer[sum + 1][denominations.length + 1];
		int res = helper(denominations, sum, 0, dp);
		return res == Integer.MAX_VALUE ? -1 : res;
	}

	private int helper(int[] denominations, int sum, int curIndex, Integer[][] dp) {
		if (sum == 0) {
			return 0;
		}

		if (sum < 0 || curIndex >= denominations.length) {
			return Integer.MAX_VALUE;
		}

		if (dp[sum][curIndex] != null) {
			return dp[sum][curIndex];
		}

		
		int total1 = Integer.MAX_VALUE;

		if (sum - denominations[curIndex] >= 0) {
		    total1 = helper(denominations, sum - denominations[curIndex], curIndex, dp);
			if (total1 != Integer.MAX_VALUE) {
				total1++;
			}
		}
		
		int total2 = helper(denominations, sum, curIndex + 1, dp);

		dp[sum][curIndex] =Math.min(total1, total2);
		return dp[sum][curIndex];
	}

}
