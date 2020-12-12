package Arrays.Array;

public class TrappingRainWater3D {

	public static int trapRainWater(int[][] heightMap) {
		int m = heightMap.length;
		int n = heightMap[0].length;

		int[][] rowLeftMax = new int[m][n];
		int lMaxVal = Integer.MIN_VALUE;

		for (int i = 1; i < m - 1; i++) {
			lMaxVal = Integer.MIN_VALUE;

			for (int j = 0; j < n; j++) {
				if (lMaxVal < heightMap[i][j]) {
					lMaxVal = heightMap[i][j];
				}
				rowLeftMax[i][j] = lMaxVal;
			}
		}

		int[][] rowRightMax = new int[m][n];
		int rMaxVal = Integer.MIN_VALUE;

		for (int i = 1; i < m - 1; i++) {
			rMaxVal = Integer.MIN_VALUE;

			for (int j = n - 1; j >= 0; j--) {
				if (rMaxVal < heightMap[i][j]) {
					rMaxVal = heightMap[i][j];
				}
				rowRightMax[i][j] = rMaxVal;
			}
		}
		
		
		int[][] colLeftMax = new int[m][n];
		int colLeftMaxVal = Integer.MIN_VALUE;

		for (int j = 1; j < n - 1; j++) {
			colLeftMaxVal = Integer.MIN_VALUE;

			for (int i = 0; i < m; i++) {
				if (colLeftMaxVal < heightMap[i][j]) {
					colLeftMaxVal = heightMap[i][j];
				}
				colLeftMax[i][j] = colLeftMaxVal;
			}
		}
		
		
		int[][] colRighttMax = new int[m][n];
		int colRightMaxVal = Integer.MIN_VALUE;

		for (int j = 1; j < n - 1; j++) {
			colRightMaxVal = Integer.MIN_VALUE;
			for (int i = m-1; i >=0; i--) {
				if (colRightMaxVal < heightMap[i][j]) {
					colRightMaxVal = heightMap[i][j];
				}
				colRighttMax[i][j] = colRightMaxVal;
			}
		}
		
		

		int res = 0;
		for (int i = 1; i < m - 1; i++) {
			for (int j = 1; j < n - 1; j++) {
				int maximumSideRise = Math.min(rowLeftMax[i][j], rowRightMax[i][j]);
				int maximumfrontRise = Math.min(colLeftMax[i][j], colRighttMax[i][j]);
				int volume= Math.min(maximumSideRise, maximumfrontRise) - heightMap[i][j];
				res+=volume>0?volume:0;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		int[][] heightMap = new int[][] { {12,13,1,12},{13,4,13,12},{13,8,10,12},{12,13,12,12},{13,13,13,13} };
		System.out.println(trapRainWater(heightMap));
	}

}
