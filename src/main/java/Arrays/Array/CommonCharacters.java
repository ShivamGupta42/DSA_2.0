package Arrays.Array;

import java.util.ArrayList;
import java.util.List;

public class CommonCharacters {

	public static void main(String[] args) {
		String[] A = { "cool", "lock", "cook" };
		System.out.println(commonChars(A));
	}

	public static List<String> commonChars(String[] A) {
		int[] chars = new int[256];
		int[] temp;

		for (int i = 0; i < A[0].length(); i++) {
			chars[(int) A[0].charAt(i)] += 1;
		}
		
		for (int i = 1; i < A.length; i++) {
			temp = new int[256];
			
			for (int j = 0; j < A[i].length(); j++) {
				temp[(int) A[i].charAt(j)]+=1;
			}

			for (int k = 0; k < 256; k++) {
				
				if (chars[k]==0) {
					continue;
				} 
				
				if (chars[k] != temp[k]) {
					chars[k] = Math.min(chars[k], temp[k]);
				}
			}
		}

		List<String> list = new ArrayList<String>();

		for (int k = 0; k < 256; k++) {
			if (chars[k] > 0) {
				for (int i = 0; i < chars[k]; i++) {
					list.add(Character.toString((char) k));
				}
			}
		}

		return list;

	}

}
