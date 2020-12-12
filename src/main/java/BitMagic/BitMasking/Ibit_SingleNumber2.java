package BitMagic.BitMasking;

import java.util.ArrayList;
import java.util.List;

public class Ibit_SingleNumber2 {

	public static int singleNumber(final List<Integer> A) {
		if (A == null || A.size() == 0) {
			return -1;
		}

		int[] bits = new int[32];
		// int otherNumbers = (n - 1) / 3;

		for (int i = 0; i < A.size(); i++) {
			int n = A.get(i);
			int index=0;
			while(n!=0) {
				if((n&1)!=0) {
					bits[index]++;
				}
				n=n>>1;
		        index++;
			}
		}

		int num = 0;
		for (int i = 0; i < 32; i++) {
			bits[i] = bits[i] % 3;
			num += bits[i] == 1 ? Math.pow(2, i) : 0;
		}
		return num;
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(2);
		System.out.println(singleNumber(list));
	}
}
