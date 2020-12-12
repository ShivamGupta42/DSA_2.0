package Trie.impl;

import Trie.problems.IsCombiningWordsPos;
import Trie.problems.ReturnAllWordsSorted;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// Input keys (use only 'a' through 'z' and lower case)
		String keys[] = { "the", "a", "there", "answer", "any", "by", "bye", "their", "abc" };

		Trie t = new Trie();
		insertKeys(t, keys);
		//printSorted(t);
		System.out.println(IsCombiningWordsPos.isFormationPossible(keys, "anyby"));

	}

	static void insertKeys(Trie t, String[] keys) {
		for (int i = 0; i < keys.length; i++) {
			t.insert2(keys[i]);
		}
	}

	static void printSorted(Trie t) {
		ArrayList<String> sortedList = ReturnAllWordsSorted.returnSorted(new ArrayList<String>(), t.root, "");
		for (String string : sortedList) {
			System.out.println(string);
		}
	}

}
