package Strings.Anagram;

import java.util.ArrayList;
import java.util.List;

public class FindSubAnagrams {

	public void findAnagrams(String s, String p) {
		List<String> set = new ArrayList<>();
		generateCombs(p, set, new StringBuilder(),0);
		set.parallelStream().forEach(System.out::println);

	}

	public void generateCombs(String s, List<String> set, StringBuilder sb, int start) {
		if (sb.length() == s.length()) {
			set.add(sb.toString());
			return;
		}

		for (int i = start; i < s.length(); i++) {
			sb.append(s.charAt(i));
			generateCombs(s, set, sb,start+1);
			sb.delete(sb.length() - 1, sb.length());
		}
	}

	public static void main(String[] args) {
		FindSubAnagrams fs = new FindSubAnagrams();
		fs.findAnagrams("avdsbsdv", "abc");
	}

}
