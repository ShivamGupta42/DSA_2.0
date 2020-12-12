package DynamicProgramming.Fibonachi;

public class ParticularNumberFactors {

	public int CountWays(int n) {
		Integer[] dp = new Integer[n + 1];
		return CountWays(n, dp);
	}

	public int CountWays(int n, Integer[] dp) {
		if (n == 0) {
			return 1;
		} else if (n < 0) {
			return 0;
		}

		if (dp[n] != null) {
			return dp[n];
		}

		int way1 = CountWays(n - 1,dp);
		int way2 = CountWays(n - 3,dp);
		int way3 = CountWays(n - 4,dp);

		dp[n] = way1 + way2 + way3;
		return dp[n];

	}

	public static void main(String[] args) {
		ParticularNumberFactors en = new ParticularNumberFactors();
		System.out.println(en.CountWays(4));
	}

	
}
