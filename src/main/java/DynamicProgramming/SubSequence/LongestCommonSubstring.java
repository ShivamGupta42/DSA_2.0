package DynamicProgramming.SubSequence;

public class LongestCommonSubstring {

	public static int findLength(int[] A, int[] B) {
		int[][] dp = new int[A.length + 1][B.length + 1];

		int max = Integer.MIN_VALUE;
		for (int i = 1; i < A.length; i++) {
			for (int j = 1; j < B.length; j++) {
				if (A[i - 1] == B[j - 1]) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				}
				if (max < dp[i][j]) {
					max = dp[i][j];
				}
			} // inner
		} // outer

		return max;
	}

	public static void main(String[] args) {
		int[] A = new int[] { 1, 2, 3, 2, 1 };
		int[] B = new int[] { 3, 2, 1, 4, 7 };
		System.out.println(findLength(A, B));
	}

}
