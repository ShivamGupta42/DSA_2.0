package Arrays.Matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

	int[][] matrix;

	public SpiralOrder() {
		initMatrix();
	}

	void initMatrix() {
		matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
	}

	List<Integer> printSpiralOrder() {
		List<Integer> result = new ArrayList<>();

		if (matrix == null || matrix.length == 0) {
			return result;
		}

		int rowBegin = 0;
		int rowEnd = matrix.length - 1;
		int colBegin = 0;
		int colEnd = matrix[0].length - 1;

		while (rowBegin <= rowEnd && colBegin <= colEnd) {

			// traversing right (and top row in remaining row)
			for (int i = colBegin; i <= colEnd; i++) {
				result.add(matrix[rowBegin][i]);
			}
			rowBegin++;

			// traversing down (and right most column in remaining columns)
			for (int i = rowBegin; i <= rowEnd; i++) {
				result.add(matrix[i][colEnd]);
			}
			colEnd--;

			if (rowBegin > rowEnd || colBegin > colEnd) {
				break;
			}

			// traversing left (and bottom row in remaining rows)

			for (int i = colEnd; i >= colBegin; i--) {
				result.add(matrix[rowEnd][i]);
			}

			rowEnd--;

			// traversing up (and left most column in remaining columns)

			for (int i = rowEnd; i >= rowBegin; i--) {
				result.add(matrix[i][colBegin]);
			}

			colBegin++;
		}
		
		

		return result;
	}

	public static void main(String[] args) {
		SpiralOrder order = new SpiralOrder();
		System.out.println(order.printSpiralOrder());
	}
}
