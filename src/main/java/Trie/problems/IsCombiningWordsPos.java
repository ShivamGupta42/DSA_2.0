package Trie.problems;

import Trie.impl.Trie;

public class IsCombiningWordsPos {

	public static Object isFormationPossible(String[] dict, String word) {
		Trie t = new Trie();

		for (String s : dict) {
			t.insert(s);
		}

		int i = 0;
		for (i = 0; i < word.length(); i++) {
			if (t.search(word.substring(0, i)) && t.search(word.substring(i))) {
				return true;
			}
		}

		return false;
	}

}
