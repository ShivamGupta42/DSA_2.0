package BitMagic.Reversing;

import java.util.Arrays;

public class LC190_ReverseBits {

	public int reverseBits(int n) {
		int[] c = new int[32];
		Arrays.fill(c, 0);

		for (int i = 0; i < 32; i++) {
			if (n > 0 && ((n & 1) != 0)) {
				c[31 - i] = 1;
			}
			n = n >>> 1;
		} // end

		int index = 0;
		int num = 0;
		for (int i : c) {
			if (i == 1) {
				num += Math.pow(2, index);
			}
			index++;
		}

		return num;
	}

	public static void main(String[] args) {
		String s = "11111111111111111111111111111101";
		System.out.println(s.length());
		//int[] c = reverseBits(4294967293);
	}

}
