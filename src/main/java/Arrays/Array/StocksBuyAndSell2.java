package Arrays.Array;

public class StocksBuyAndSell2 {

	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int profit = 0;
		int i = 0;
		while (i < prices.length - 1) {
			if (prices[i] < prices[i + 1]) {
				profit += prices[i + 1] - prices[i];
			}
			i++;
		}

		return profit;

	}

	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] { 2, 1, 4 }));
		System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
	}

}
