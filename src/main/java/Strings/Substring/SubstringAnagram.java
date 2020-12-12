package Strings.Substring;

import java.util.ArrayList;
import java.util.Arrays;

public class SubstringAnagram {

	public static ArrayList<Integer> solve(String A, String B) {

		ArrayList<Integer> res = new ArrayList<Integer>();

		if (A == null || A.trim().equals("") || B == null || B.length() > A.length() || B.trim().equals("")) {
			return res;
		}

		int[] bmap = new int[26];

		for (char c : B.toCharArray()) {
			bmap[c - 'a']++;
		}

		int ws = 0;
		int[] amap = new int[26];

		for (int we = 0; we < A.length(); we++) {
			amap[A.charAt(we) - 'a']++;

			if (Arrays.equals(amap, bmap)) {
				res.add(ws);

			}

			amap[A.charAt(ws++) - 'a']--;
		}

		return res;

	}

	public static void main(String[] args) {
		System.out.println(solve("hblzqhrswn", "blzqh"));
	}

}
