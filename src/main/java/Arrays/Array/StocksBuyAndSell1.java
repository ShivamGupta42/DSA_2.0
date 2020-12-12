package Arrays.Array;

public class StocksBuyAndSell1 {

	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int[] leftLowest = new int[prices.length];
		int[] rightHighest = new int[prices.length];

		int min = prices[0];
		leftLowest[0] = min;

		for (int i = 1; i < prices.length; i++) {
			if (min > prices[i]) {
				min = prices[i];
			}

			leftLowest[i] = min;
		}

		int max = prices[prices.length - 1];
		rightHighest[prices.length - 1] = max;

		for (int i = prices.length - 2; i >= 0; i--) {
			if (max < prices[i]) {
				max = prices[i];
			}

			rightHighest[i] = max;
		}

		int maxProfit = 0;

		int i = 0, j = 0;
		while (i < prices.length && j < prices.length) {
			if (leftLowest[i] < rightHighest[j]) {
				if (i < j) {
					maxProfit = Math.max(maxProfit, rightHighest[j] - leftLowest[i]);
					i++;
				} else {
					j++;
				}
			} else {
				i++;
			}
		}

		return maxProfit;

	}

	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] { 2,1,4 }));
	}
}
