package DynamicProgramming.Fibonachi;

public class StairCase {

	public int CountWays(int n, Integer[] dp) {
		if (n == 0)
			return 1;

		if (n < 0) {
			return 0;
		}

		if (dp[n] != null) {
			return dp[n];
		}

		int take1Step = CountWays(n - 1, dp);
		int take2Step = CountWays(n - 2, dp);
		int take3Step = CountWays(n - 3, dp);

		dp[n] = take1Step + take2Step + take3Step;
		return dp[n];
	}

	public static void main(String[] args) {
		StairCase sc = new StairCase();

		int n = 5;
		Integer[] dp = new Integer[n+1];
		System.out.println(sc.CountWays(n, dp));
	}

}
