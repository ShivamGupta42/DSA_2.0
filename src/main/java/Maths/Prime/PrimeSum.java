package Maths.Prime;

import java.util.ArrayList;
import java.util.Collections;

public class PrimeSum {

	public static String getEncryptedName(String name) {
		if (name == null || name.trim().equals("")) {
			return "";
		}

		int start = 0, end = name.length() - 1;
		char[] c = name.toLowerCase().toCharArray();

		while (start < end) {
			char eChar = c[end];
			char sChar = c[start];
			if ((sChar - 'a') < 0 || (sChar - 'a') > 25 || (eChar - 'a') < 0 || (eChar - 'a') > 25) {
				throw new IllegalArgumentException("Try again with valid name");
			}
			c[start] = eChar;
			c[end] = sChar;
			start++;
			end--;
		}

		return new String(c);
	}

	public static ArrayList<Integer> primesum(int A) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if (A < 3) {
			return new ArrayList<Integer>();
		}
		boolean solNotFound = true;
		int curPrime = 2;
		int halfSum = A / 2;

		while (curPrime <= halfSum) {

			int counterPart = A - curPrime;

			boolean pairFound = isPrime(counterPart);
			if (pairFound) {
				ArrayList<Integer> list = new ArrayList<Integer>();
				if (counterPart < curPrime) {
					list.add(counterPart);
					list.add(curPrime);
				} else {
					list.add(curPrime);
					list.add(counterPart);
				}

				res.add(list);
			}

			curPrime = returnNextPrime(curPrime);
		}

		Collections.sort(res, (a, b) -> a.get(0) - b.get(0));
		return res.get(0);

	}

	public static int returnNextPrime(int x) {
		int temp = x;
		// making temp odd since next prime will always be odd
		if (x % 2 == 0) {
			temp = x + 1;
		} else {
			temp = x + 2;
		}

		boolean nextPrimeFound = false;
		while (!nextPrimeFound) {
			nextPrimeFound = true;
			for (int i = 2; i <= Math.sqrt(temp); i++) {
				if (temp % i == 0) {
					nextPrimeFound = false;
					break;
				}
			}
			if (nextPrimeFound) {
				return temp;
			}
			temp = temp + 2;
		}
		return temp;
	}// retNextPrime

	public static boolean isPrime(int x) {
		if (x == 2) {
			return true;
		}
		if ((x % 2) == 0) {
			return false;
		}

		for (int i = 3; i <= Math.sqrt(x); i = i + 2) {
			if (x % i == 0) {
				return false;
			}
		}

		return true;
	}// isPrime

	public static void main(String[] args) {
		System.out.println(getEncryptedName("Kate Winselet"));
	}

}
