package Trie.impl;

public class TrieNode {

	public TrieNode[] children;
	public Boolean isEndWord;

	public TrieNode() {
		children = new TrieNode[26];
		isEndWord = false;
	}

	void markAsLeaf() {
		isEndWord = true;
	}

	void unMarkAsLeaf() {
		isEndWord = false;
	}

}
