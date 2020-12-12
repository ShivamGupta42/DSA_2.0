package Trie.problems;

public class RegularExpression {

	static class Trie {

		class TrieNode {
			TrieNode[] children;
			boolean isWord;

			TrieNode() {
				children = new TrieNode[26];
			}

			void insertChar(char c) {
				children[c - 'a'] = new TrieNode();
			}

			void setWord(boolean value) {
				isWord = value;
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

			cur.setWord(true);
		}

		/** Returns if the word is in the trie. */
		public boolean search(int start, String word, TrieNode curNode) {
			if (word == null || word.equals("")) {
				return true;
			}

			
			for (int i = start; i < word.length(); i++) {
				char curChar = word.charAt(i);

				if (curChar == '.') {
					boolean res = false;
					for (TrieNode node : curNode.children) {
						if(node!=null) {
						res = res || search(i+1,word,node);
						}
					}
					return res;
				}
				int index = curChar - 'a';
				if (curNode.children[index] == null) {
					return false;
				}
				curNode = curNode.children[index];
			}

			return curNode.isWord();
		}

	}

	Trie t;

	/** Initialize your data structure here. */
	public RegularExpression() {
		t = new Trie();
	}

	/** Adds a word into the data structure. */
	public void addWord(String word) {
		t.insert(word);
	}

	/**
	 * Returns if the word is in the data structure. A word could contain the dot
	 * character '.' to represent any one letter.
	 */
	public boolean search(String word) {
		if (word == null || word.trim().equals("")) {
			return false;
		}
		return t.search(0,word.trim(),t.root);
	}
	
	public static void main(String[] args) {
		RegularExpression reg = new RegularExpression();
		reg.addWord("bad");
		reg.addWord("cad");
		reg.addWord("dad");
		System.out.println(reg.search("..d"));
	}
}
