package DynamicProgramming.SubSequence;

import java.util.HashSet;
import java.util.Set;

public class LC994_RottenOranges {

	public int orangesRotting(int[][] grid) {

		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		return helper(grid, grid.length, grid[0].length, 0);

	}

	public int helper(int[][] grid, int m, int n, int totalMinutesElapsed) {
		Set<String> fresh = new HashSet<>();
		Set<String> rotten = new HashSet<>();

		// Noting Fresh and Rotten Oranges orginally
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					fresh.add("" + i + j);
				} else if (grid[i][j] == 2) {
					rotten.add("" + i + j);
				}

			}
		}

		// Applying BFS
		int minutes = 0;
		int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

		while (fresh.size() > 0) {
			Set<String> infected = new HashSet<>();

			for (String s : rotten) {
				int i = s.charAt(0) - '0';
				int j = s.charAt(1) - '0';

				for (int[] d : directions) {
					int nextI = i + d[0];
					int nextY = j + d[1];
					if (fresh.contains("" + nextI + nextY)) {
						fresh.remove("" + nextI + nextY);
						infected.add("" + nextI + nextY);
					}
				}

			}

			if (infected.size() == 0) {
				return -1;
			}

			rotten = infected;
			minutes++;
		}

		return minutes;
	}

	public static void main(String[] args) {
		int[][] grid = new int[][] { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };

		LC994_RottenOranges lc = new LC994_RottenOranges();
		System.out.println(lc.orangesRotting(grid));
	}

}
