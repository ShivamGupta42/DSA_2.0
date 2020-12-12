package Strings.Basic;

public class LeftMostIndexOfRepeating {
	public static void main(String[] args) {

	}

	Character firstLeftMostAppearance(String s) {
		boolean[] visited = new boolean[256];
		int leftMostVisited = -1;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (!visited[s.charAt(i)]) {
				visited[s.charAt(i)] = true;
			} else {
				leftMostVisited = i;
			}
		}
		if (leftMostVisited != -1) {
			return s.charAt(leftMostVisited);
		} else {
			return null;
		}
	}

}
