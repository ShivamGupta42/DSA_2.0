package BitMagic.BitMasking;

public class Ibit_SingleNumber3 {

	public static int[] singleNumber(int[] nums) {
		int xor = 0;

		for (int i : nums) {
			xor = xor ^ i;
		}

		int x = (xor & ~(xor - 1));
		int xor2 = 0;

		for (int i : nums) {
			if ((i & x) != 0) {
				xor2 ^= i;
			}
		}

		return new int[] { xor2, (xor2^xor) };
	}
	
	
	public static void main(String[] args) {
		System.out.println(3^6);
		int[] result = singleNumber(new int[] {1,1,2,2,3,5});
		for(int i: result) {
			System.out.print(i+" ");
		}
	}

}
