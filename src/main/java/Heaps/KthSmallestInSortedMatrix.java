package Heaps;

import java.util.PriorityQueue;

public class KthSmallestInSortedMatrix {

	public static int findKthSmallest(int[][] matrix, int k) {
		PriorityQueue<Integer> p = new PriorityQueue<Integer>((a, b) -> b - a);
		int m = matrix.length;
		long count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				
				if(count<k) {
					p.add(matrix[i][j]);
				}
					
				else if (count >= k && matrix[i][j] < p.peek()) {
					p.poll();
					p.add(matrix[i][j]);
				} 
				
				count++;
			}

		}
		return p.peek();
	}

	public static void main(String[] args) {
		int matrix[][] = { { 2, 6, 8 }, { 3, 7, 10 }, { 5, 8, 11 } };
		int result = KthSmallestInSortedMatrix.findKthSmallest(matrix, 5);
		System.out.print("Kth smallest number is: " + result);
	}

}
