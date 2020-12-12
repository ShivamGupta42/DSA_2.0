package Trees.bfs;

import java.util.HashMap;

public class SnakeAndLadders {

	public static int snakesAndLadders(int[][] board) {
		HashMap<Integer, Integer> mapOfJumps = new HashMap<Integer, Integer>();
		int n = board.length;
		int totalSize = n * n;

		for (int i = 0; i < totalSize - 1; i++) {
			mapOfJumps.put(i + 1, i);
		}

		int row = 5;
		int col = 6;
		for (int i = 0; i < n; i++) {
			row--;
			col = 6;
			;
			for (int j = 0; j < n; j++) {
				col++;
				if (board[i][j] != -1) {
					mapOfJumps.put(board[i][j], row * 6 + col);
				}
			}
		}

		int reachingStart = 36;
		int totalSteps = 0;

		while (reachingStart != 1) {
			totalSteps++;
			reachingStart = mapOfJumps.get(reachingStart);
		}

		return totalSteps;
	}

	public static void main(String[] args) {
		int[][] board = new int[][] { { 1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1 },
				{ -1, 35, -1, -1, 13, -1 }, { -1, -1, -1, -1, -1, -1 }, { -1, 15, -1, -1, -1, -1 } };
		System.out.println(snakesAndLadders(board));

	}

}
