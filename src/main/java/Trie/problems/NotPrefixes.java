package Trie.problems;

import java.util.ArrayList;
import java.util.List;

public class NotPrefixes {
	static class Trie {

		class TrieNode {
			TrieNode[] children;
			String word;
			boolean isWord;

			TrieNode() {
				children = new TrieNode[26];
			}

			void insertChar(char c) {
				children[c - 'a'] = new TrieNode();
			}

			void setWord(boolean value, String word) {
				isWord = value;
				this.word=word;
			}

			boolean isWord() {
				return isWord;
			}
		}

		TrieNode root;

		/** Initialize your data structure here. */
		public Trie() {
			root = new TrieNode();
		}

		/** Inserts a word into the trie. */
		public void insert(String word) {
			if (word == null || word.trim().equals("")) {
				return;
			}
			TrieNode cur = root;
			for (int i = 0; i < word.length(); i++) {
				char curChar = word.charAt(i);
				int index = curChar - 'a';
				if (cur.children[index] == null) {
					cur.children[index] = new TrieNode();
				}
				cur = cur.children[index];
			}

			cur.setWord(true,word);
		}

		public void nonPrefix(TrieNode cur, List<String> res) {
			
			if(!hasChildren(cur)) {
				if(cur.isWord) {
					res.add(cur.word);
				}
				return;
			}
			
			for (TrieNode child : cur.children) {
				if (child != null) {
					nonPrefix(child,res);
				}
			}

		}

		public boolean hasChildren(TrieNode root) {

			for (TrieNode child : root.children) {
				if (child != null) {
					return true;
				}
			}

			return false;
		}
	}

	public static void main(String[] args) {
		Trie t = new Trie();
		String[] array = new String[] { "abc", "abcd", "abcde", "x", "xy", "xyz" ,"kaushik"};

		for (String s : array) {
			t.insert(s);
		}

		List<String> res = new ArrayList<String>();
		t.nonPrefix(t.root,res);
		res.forEach(System.out::println);
	}
}
