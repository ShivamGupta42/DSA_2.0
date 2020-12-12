package Trie.problems;

import Trie.impl.TrieNode;

public class countWords {

	public static int totalWords(TrieNode root) {
		if (root == null) {
			return 0;
		}

		int totalCount = 0;

		if (root.isEndWord) {
			totalCount++;
		}

		for (int i = 0; i < 26; i++) {
			if (root.children[i] != null) {
				totalCount += totalWords(root.children[i]);
			}
		} // end of child loop

		return totalCount;

	}// end of method
}
