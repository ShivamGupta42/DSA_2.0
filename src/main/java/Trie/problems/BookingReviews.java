package Trie.problems;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookingReviews {

	Trie t;

	public BookingReviews() {
		t = new Trie();
	}

	public ArrayList<Integer> solve(String A, ArrayList<String> B) {
		ArrayList<Integer> res = new ArrayList<Integer>();

		// Boundary cases
		if (B == null || B.size() == 0) {
			return res;
		}

		// ->If A is null, it means return the index of all elements
		if (A == null) {
			return Stream.iterate(0, i -> i + 1).limit(B.size()).collect(Collectors.toCollection(ArrayList::new));
		}

		// inserting all the good words
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < A.length(); i++) {
			if (A.charAt(i) == '_') {
				t.insert(sb.toString());
				sb = new StringBuilder();
				continue;
			}

			sb.append(A.charAt(i));
		}

		t.insert(sb.toString());

		// Sorting based on goodness score
		TreeMap<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>((a,b)->b-a);
		int index = 0;
		for (String s : B) {
			int score = goodNessScore(s);
			if (!map.containsKey(score)) {
				map.put(score, new ArrayList<Integer>());
			}
			map.get(score).add(index);
			index++;
		}

		for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
			res.addAll(e.getValue());
		}
		return res;
	}

	public int goodNessScore(String A) {
		int count = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < A.length(); i++) {
			if (A.charAt(i) == '_') {
				count = t.search(sb.toString()) ? count+1 : count;
				sb = new StringBuilder();
				continue;
			}

			sb.append(A.charAt(i));
		}

		return t.search(sb.toString()) ? count+1 : count;
	}

	static class Trie {
		TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		public void insert(String s) {
			if (s == null || s.isBlank() || s.isEmpty()) {
				return;
			}

			TrieNode current = root;

			for (int i = 0; i < s.length(); i++) {
				
				TrieNode child = current.children[s.charAt(i) - 'a'];
				if (child == null) {
					current.children[s.charAt(i) - 'a'] = new TrieNode();
				}
				current=current.children[s.charAt(i) - 'a'];
			}

			current.isWord = true;
		}

		public boolean search(String s) {
			if (s == null || s.isBlank() || s.isEmpty()) {
				return false;
			}

			TrieNode current = root;

			for (int i = 0; i < s.length(); i++) {
				TrieNode child = current.children[s.charAt(i) - 'a'];
				if (child == null) {
					return false;
				}
				current=current.children[s.charAt(i) - 'a'];
			}

			return current.isWord;
		}

	}

	static class TrieNode {
		TrieNode[] children;
		boolean isWord;

		TrieNode() {
			children = new TrieNode[26];
		}

	}

	public static void main(String[] args) {
		String A = "cool_ice_wifi";
		String[] s = new String[] { "water_is_cool", "cold_ice_drink", "cool_wifi_speed" };
		ArrayList<String> list = Arrays.stream(s).collect(Collectors.toCollection(ArrayList::new));

		BookingReviews brs = new BookingReviews();

		ArrayList<Integer> res = brs.solve(A, list);
		for (int i : res) {
			System.out.print(i + " ");
		}
	}

}
