package Trie.impl;

import java.util.HashMap;

class TrieNode2 {
	Character c;
	Boolean isLeaf = false;
	HashMap<Character, TrieNode2> children = new HashMap<>();

	public TrieNode2() {
	}

	public TrieNode2(Character c) {
		this.c = c;
	}
}

public class Trie2 {
	private TrieNode2 root;

	// Implement these methods :
	public Trie2() {
	}

	public void insertWord(String word) {
		TrieNode2 node = root;
		for (int i = 0; i < word.length(); i++) {
			if (!node.children.containsKey(word.charAt(i))) {
				node.children.put(word.charAt(i), new TrieNode2(word.charAt(i)));
			}
			node = node.children.get(word.charAt(i));
		}

		node.isLeaf = true;
	}

	public Boolean searchWord(String word) {
		TrieNode2 node = root;
		for (int i = 0; i < word.length(); i++) {
			if (!node.children.containsKey(word.charAt(i))) {
				return false;
			}
			node = node.children.get(word.charAt(i));
		}

		return node.isLeaf;
	}

	public Boolean searchPrefix(String word) {
		TrieNode2 node = root;
		for (int i = 0; i < word.length(); i++) {
			if (!node.children.containsKey(word.charAt(i))) {
				return false;
			}
			node = node.children.get(word.charAt(i));
		}

		return true;

	}
}