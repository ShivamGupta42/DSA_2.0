package Strings.Math;

public class Powerof2 {

	public int power(String A) {
		java.math.BigInteger a = new java.math.BigInteger(A);
		if (a.compareTo(java.math.BigInteger.ONE) == 0 || a.compareTo(java.math.BigInteger.ZERO) == 0)
			return 0;
		for (int i = 0; i < a.bitLength() - 1; i++) {
			if (a.testBit(i))
				return 0;
		}
		return a.testBit(a.bitLength() - 1) ? 1 : 0;
	}

}
