package DynamicProgramming.SubSequence;

public class NDigitNumberWithGivenSum {

	public int solve(int n, int sum) {
		if (sum == 0) {
			return 1;
		}

		int res = 0;
		Integer[][] dp = new Integer[n + 1][sum + 1];

		for (int i = 1; i <= 9; i++) {
			res = (res + calculate(1, i, n, sum, dp)) % 1000000007;
		}

		return res;
	}

	int calculate(int currentDigit, int curSum, int maxDigit, int target, Integer[][] dp) {

		if (currentDigit > maxDigit || curSum > target) {
			return 0;
		}

		if (currentDigit == maxDigit && curSum == target) {
			return 1;
		}

		if (dp[currentDigit][curSum] != null) {
			return dp[currentDigit][curSum];
		}

		int curCount = 0;
		for (int i = 0; i <= 9; i++) {
			curCount = (curCount + calculate(currentDigit + 1, curSum + i, maxDigit, target, dp)) % 1000000007;
		}
		
		dp[currentDigit][curSum] = curCount;
		return curCount;

	}

	public static void main(String[] args) {
		NDigitNumberWithGivenSum num = new NDigitNumberWithGivenSum();
		System.out.println(num.solve(2, 2));
	}

}
