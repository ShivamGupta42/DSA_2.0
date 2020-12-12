package DynamicProgramming.Knapsack;

public class ZeroOne {

	public int solveKnapsack(int[] profits, int[] weights, int capacity) {
		Integer[][] dp = new Integer[profits.length + 1][capacity + 1];
		return this.knapsackRecursive(profits, weights, capacity, 0, dp);
	}

	
	
	private int knapsackRecursive(int[] profits, int[] weights, int capacity, int currentIndex, Integer[][] dp) {
		// base checks
		if (capacity <= 0 || currentIndex >= profits.length)
			return 0;

		if (dp[currentIndex][capacity] != null) {
			return dp[currentIndex][capacity];
		}

		int profit1 = 0;
		// After including the element at the currentIndex
		// Note element can only be included if below condition is true
		if (weights[currentIndex] <= capacity)
			profit1 = profits[currentIndex]
					+ knapsackRecursive(profits, weights, capacity - weights[currentIndex], currentIndex + 1, dp);

		// After excluding the element at the currentIndex
		int profit2 = knapsackRecursive(profits, weights, capacity, currentIndex + 1, dp);

		dp[currentIndex][capacity] = Math.max(profit1, profit2);
		return dp[currentIndex][capacity];
	}

	
	
	
	public static void main(String[] args) {
		ZeroOne ks = new ZeroOne();
		int[] profits = { 1, 6, 10, 16 };
		int[] weights = { 1, 2, 3, 5 };
		int maxProfit = ks.solveKnapsack(profits, weights, 7);
		System.out.println("Total knapsack profit ---> " + maxProfit);
		maxProfit = ks.solveKnapsack(profits, weights, 6);
		System.out.println("Total knapsack profit ---> " + maxProfit);
	}

	
	
	
}
