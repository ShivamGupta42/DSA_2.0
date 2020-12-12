package Trie.problems;

import Trie.impl.TrieNode;

import java.util.ArrayList;

public class ReturnAllWordsSorted {

	public static ArrayList<String> returnSorted(ArrayList<String> list, TrieNode root, String s) {
		if (root == null) {
			return list;
		}

		if (root.isEndWord) {
			list.add(s);
		}

		for (int i = 0; i < 26; i++) {
			if (root.children[i] != null) {
				list = returnSorted(list, root.children[i], s + ((char) (i + (int) 'a')));
				;
			}
		}

		return list;

	}// end of method

	
}
