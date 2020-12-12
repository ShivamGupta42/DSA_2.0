package DynamicProgramming.UnboundedKnapsack;


/*
 * Number of ways of making a particular amount
 */
public class CoinChange {

	public static void main(String[] args) {
		CoinChange cc = new CoinChange();
		int[] denominations = { 1, 2, 7};
		System.out.println(cc.countChange(denominations, 5));
	}

	private int countChange(int[] denominations, int sum) {
		Integer[][] dp = new Integer[sum + 1][denominations.length + 1];
		return helper(denominations, sum, 0, dp);
	}

	private int helper(int[] denominations, int sum, int curIndex, Integer[][] dp) {
		if(sum==0) {
			return 1;
		}
		
		if (sum <0 || curIndex >= denominations.length) {
			return 0;
		}

		if (dp[sum][curIndex] != null) {
			return dp[sum][curIndex];
		}

		int total1 = 0;
		if (sum - denominations[curIndex] >= 0) {
			total1 = helper(denominations, sum - denominations[curIndex], curIndex, dp);
		}

		int total2 =  helper(denominations, sum, curIndex + 1, dp);

		dp[sum][curIndex] = total1+ total2;
		return dp[sum][curIndex];
	}
}
