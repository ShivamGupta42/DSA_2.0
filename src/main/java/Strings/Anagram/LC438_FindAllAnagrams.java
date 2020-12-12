package Strings.Anagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC438_FindAllAnagrams {

	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<Integer>();

		if (s == null || p == null || s.length() < p.length()) {
			return result;
		}

		int[] sMap = new int[256];
		int[] pMap = new int[256];

		for (char c : p.toCharArray()) {
			pMap[(int) c]++;
		}

		int i = 0, j = 0;

		while (j < s.length()) {
			sMap[(int) s.charAt(j)]++;
			if (j < p.length() - 1) {
				j++;
				continue;
			}

			if (Arrays.equals(sMap, pMap)) {
				result.add(i);
			}
			j++;
			sMap[(int) s.charAt(i)]--;
			i++;
		}

		return result;
	}

	public static List<Integer> findAnagrams2(String s, String p) {
		List<Integer> result = new ArrayList<Integer>();

		if (s == null || p == null || s.length() < p.length()) {
			return result;
		}

		int[] cMap = new int[26];

		for (char c : p.toCharArray()) {
			cMap[c - 'a']++;
		}

		int i = 0;
		while (i < p.length() - 1) {
			cMap[s.charAt(i++) - 'a']--;
		}

		i = 0;
		int j = p.length() - 1;

		while (j < s.length()) {
			cMap[s.charAt(j++) - 'a']--;
			if (isEqual(cMap)) {
				result.add(i);
			}

			cMap[s.charAt(i++) - 'a']++;
		}

		return result;

	}

	public static boolean isEqual(int[] a) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] != 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		List<Integer> result = findAnagrams2("cbaebabacd", "abc");
		result.stream().forEach(e -> System.out.print(e + " "));
	}

}
