package DynamicProgramming.Knapsack;

public class CountSubsetsWithGivenSum {

	public int countSubsets(int[] num, int sum) {
		Integer[][] dp = new Integer[sum + 1][num.length + 1];
		return countSubsetsRecursive(num, sum, 0, dp);
	}

	private int countSubsetsRecursive(int[] num, int sum, int currentIndex, Integer[][] dp) {
		if (sum == 0) {
			return 1;
		}

		if (sum < 0 || currentIndex >= num.length) {
			return 0;
		}

		if (dp[sum][currentIndex] != null) {
			return dp[sum][currentIndex];
		}

		int sub1 = countSubsetsRecursive(num, sum - num[currentIndex], currentIndex + 1, dp);
		int sub2 = countSubsetsRecursive(num, sum, currentIndex + 1, dp);

		dp[sum][currentIndex] = sub1 + sub2;
		return dp[sum][currentIndex];
	}

	public static void main(String[] args) {
		CountSubsetsWithGivenSum ss = new CountSubsetsWithGivenSum();
		int[] num = { 1, 1, 2, 3 };
		System.out.println(ss.countSubsets(num, 4));
		num = new int[] { 1, 2, 7, 1, 5 };
		System.out.println(ss.countSubsets(num, 9));
	}

}
