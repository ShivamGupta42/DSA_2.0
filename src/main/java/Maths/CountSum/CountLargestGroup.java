package Maths.CountSum;

import java.util.HashMap;
import java.util.Map;

public class CountLargestGroup {

	public int countLargestGroup(int n) {
		if (n < 1) {
			return 0;
		}

		int sum = 0;
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 1; i <= n; i++) {
			sum = sumOfDigit(i);
			map.compute(sum, (key, value) -> {
				if (value == null) {
					return 1;
				} else {
					return value + 1;
				}
			});
		}

		int curFreq = 0;
		int maxSize = Integer.MIN_VALUE;
		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			if (e.getValue() > maxSize) {
				curFreq = 1;
				maxSize = e.getValue();
			}

			else if (e.getValue() == maxSize) {
				curFreq++;
			}
		}

        		
		
		return maxSize == Integer.MIN_VALUE ? 0 :curFreq;

	}

	public int sumOfDigit(int n) {
		int count = 0;

		while (n != 0) {
			count += n % 10;
			n = n / 10;
		}
		return count;
	}

	public static void main(String[] args) {
		CountLargestGroup c = new CountLargestGroup();
		System.out.println(c.countLargestGroup(101));
	}

}
