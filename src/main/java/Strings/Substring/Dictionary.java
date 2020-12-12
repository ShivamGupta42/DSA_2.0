package Strings.Substring;

import java.util.Set;

public class Dictionary {

	public static void main(String[] args) {

	}

	public boolean wordBreak(Set<String> dictionary, String givenString) {

		int n = givenString.length();

		for (int i = 0; i <= n - 1; i++) {
			if (dictionary.contains(givenString.substring(0, i))
					&& wordBreak(dictionary, givenString.substring(i, n))) {
				return true;
			}
		}

		return false;

	}

}
