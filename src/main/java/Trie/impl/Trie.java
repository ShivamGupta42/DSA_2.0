package Trie.impl;

public class Trie {
	public TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public int getIndex(char x) {
		return x - 'a';
	}

	public boolean insert(String key) {
		if (key == null || key.isEmpty() || key.isBlank()) {
			return false;
		}

		key = key.toLowerCase();
		TrieNode current = root;
		int index = -1;
		for (int i = 0; i < key.length(); i++) {
			index = this.getIndex(key.charAt(i));

			if (current.children[index] == null) {
				current.children[index] = new TrieNode();
			}
			// this ensures we are at the last inserted
			// character reference at the end of each loop
			current = current.children[index];

		}
		// to signal end of work down this path
		current.markAsLeaf();
		return true;
	}

	public void insert2(String key) {
		if (key == null || key.isEmpty() || key.isBlank()) {
			return;
		}
		insertRecursive(key.toLowerCase(), root, 0);
	}

	public void insertRecursive(String key, TrieNode current, int i) {

		if (i >= key.length()) {
			current.markAsLeaf();
			return;
		}
		if (current.children[this.getIndex(key.charAt(i))] == null) {
			current.children[this.getIndex(key.charAt(i))] = new TrieNode();
		}

		current = current.children[this.getIndex(key.charAt(i))];

		insertRecursive(key, current, i + 1);
	}

	public boolean search(String key) {
		if (key == null || key.isEmpty() || key.isBlank()) {
			return false;
		}

		key = key.toLowerCase();
		TrieNode current = root;
		int index = -1;

		for (int i = 0; i < key.length(); i++) {
			index = this.getIndex(key.charAt(i));
			if (current.children[index] == null) {
				return false;
			}
			current = current.children[index];
		}

		return current.isEndWord;
	}

	public boolean delete(String key) {
		if (key == null || key.isEmpty() || key.isBlank()) {
			return false;
		}

		if (this.search(key)) {
			return delete_helper(key.toLowerCase(), root, key.length(), 0);
		}

		return false;
	}

	private boolean delete_helper(String key, TrieNode current, int keylength, int index) {
		boolean deletedSelf = false;

		if (current == null) {
			System.out.println("Key doesn't exist");
			return deletedSelf;
		}

		if (index == keylength) {

			// Case 1 or Case 3
			if (hasNoMoreChildren(current)) {
				current = null;
				deletedSelf = true;

			}

			else {// Case 2 ("The" is to be deleted, but "Their" also exists in the tree
				current.isEndWord = false;
				deletedSelf = false;
			}
		}

		else {
			TrieNode childNode = current.children[this.getIndex(key.charAt(index))];
			boolean childDeleted = delete_helper(key, childNode, keylength, index + 1);

			// Either Case 1 or Case 3
			if (childDeleted) {
				childNode = null;

				// Case 3 ("their" was to be deleted, but we also have word "the")
				if (current.isEndWord) {
					deletedSelf = false;
				}
				// Case 3 ("their" was to be delted, but we also have word "themselves")
				else if (!hasNoMoreChildren(current)) {
					deletedSelf = false;
				}
				// Case 1 ("their" is to be deleted and there is no other words starting with t
				// in trie
				else {
					current = null;
					deletedSelf = true;
				}

			} else {
				deletedSelf = false;
			}

		}

		return deletedSelf;
	}

	public boolean hasNoMoreChildren(TrieNode current) {
		if (current == null)
			return true;

		for (int i = 0; i < 26; i++) {
			if (current.children[i] != null) {
				return false;
			}
		}

		return true;

	}

}
