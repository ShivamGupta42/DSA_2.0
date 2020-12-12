package Arrays.Misc;

import java.util.ArrayList;

public class Ibit_ContainerWithMostWater {
	class Wall {
		int index;
		int value;

		Wall(int index, int value) {
			this.index = index;
			this.value = value;
		}
		
		@Override
		public String toString() {
			return value+"";
		}
	}
    
    
    public int maxArea(int[] A) {
        if (A == null || A.length< 2) {
			return 0;
		}
        
		Wall[] leftMax = new Wall[A.length];

		int maxHeight = A[0];
		int maxIndex = 0;

		for (int i = 0; i < A.length; i++) {
			if (maxHeight < A[i]) {
				leftMax[i] = new Wall(maxIndex, maxHeight);
				maxIndex = i;
				maxHeight = A[i];
				continue;
			}

			leftMax[i] = new Wall(maxIndex, maxHeight);
		}

		Wall[] rightMax = new Wall[A.length];
		maxHeight = A[A.length - 1];
		maxIndex = A.length - 1;

		for (int i = A.length - 1; i >= 0; i--) {
			if (maxHeight < A[i]) {
				rightMax[i] = new Wall(maxIndex, maxHeight);
				maxIndex = i;
				maxHeight = A[i];
				continue;
			}

			rightMax[i] = new Wall(maxIndex, maxHeight);
		}
		
		

		long maxAreaTotal = 0;
		int base = 0;
        int maxWall=0;
        int minWall=0;
        long curMaxArea=0;
		for (int i = 0; i <= A.length-1; i++) {
           maxWall= Math.max(leftMax[i].value, rightMax[i].value);
           minWall=Math.min(leftMax[i].value,rightMax[i].value);
            
           if(A[i]>=maxWall){
                int leftArea = leftMax[i].value*(i-leftMax[i].index);
                int rightArea = rightMax[i].value*(rightMax[i].index-i);
                curMaxArea=Math.max(leftArea,rightArea);
                maxAreaTotal=Math.max(maxAreaTotal,curMaxArea);
               
           } 
              curMaxArea=Math.abs(rightMax[i].index-leftMax[i].index)*minWall; 
              maxAreaTotal=Math.max(maxAreaTotal,curMaxArea);
			
		}

		return (int)maxAreaTotal;
    }
	public static void main(String[] args) {
		Ibit_ContainerWithMostWater i = new Ibit_ContainerWithMostWater();
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(5);
		a.add(4);
		a.add(3);
		int[] arr = new int[] { 1, 1 };
		System.out.println(i.maxArea(arr));
	}
}
