package Greedy;

import java.util.Arrays;

public class ChefSatisfaction {

	public int maxSatisfaction(int[] satisfaction) {
		Arrays.sort(satisfaction);
		int curSum = 0;
		int maxSum = Integer.MIN_VALUE;
		int len = satisfaction.length;

		for (int i = 0; i <= len - 1; i++) {
			maxSum = Math.max(maxSum, calcTotalSatisFaction(satisfaction, i, len));
		}

		 return maxSum<=0?0:maxSum;
	}

	public int calcTotalSatisFaction(int[] satisfaction, int start, int len) {
		int sum = 0;
		int index=1;
		for (int i = start; i <= len - 1; i++) {
			sum += satisfaction[i]*index;
			index++;
		}

		return sum;
	}

	public static void main(String[] args) {
		ChefSatisfaction c = new ChefSatisfaction();
		System.out.println(c.maxSatisfaction(new int[] {-1,-8,0,5,-7}));

	}

}
