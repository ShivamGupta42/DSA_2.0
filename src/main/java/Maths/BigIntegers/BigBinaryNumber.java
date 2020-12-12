package Maths.BigIntegers;

import java.math.BigInteger;

public class BigBinaryNumber {

	public static void main(String[] args) {
		System.out.println(FindBigBinary(3L));
	}

	/*
	 Given a number N 
	 Add the binary string of all numbers from 1..N
	
	*/
	
	
	
	private static Long FindBigBinary(long n) {
		long mod = 10 ^ 9 + 7;
		StringBuilder sb = new StringBuilder();

		for (long i = 1; i <= n; i++) {
			sb.append(Long.toBinaryString(i));
		}

		String finalNumber = sb.toString();
		BigInteger big  = new BigInteger(finalNumber,2);
		big.mod(new BigInteger(Long.toBinaryString(mod),2));
		return big.longValue();
		
		//return calculateMod(finalNumber, mod);
	}
	
	

	static Long calculateMod(String str, long m) {
		long[] pwrTwo = new long[str.length()];
		pwrTwo[0] = 1 % m;
		for (int i = 1; i < str.length(); i++) {
			pwrTwo[i] = pwrTwo[i - 1] * (2 % m);
			pwrTwo[i] %= m;
		}

		long res = 0;
		int i = 0, j =str.length()-1;

		while (i < str.length()) {
			if (str.charAt(j) == '1') {
				res += (pwrTwo[i]);
				res %= m;
			}

			i++;
			j--;
		}

		return res;

	}

}
