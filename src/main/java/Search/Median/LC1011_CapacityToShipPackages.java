package Search.Median;

import java.util.Arrays;

public class LC1011_CapacityToShipPackages {

	public static int shipWithinDays(int[] weights, int D) {
		int low = 0, high = 0;
		low = Arrays.stream(weights).boxed().max((a,b)->a-b).get();
		high = Arrays.stream(weights).boxed().reduce(0, (a,b)->a+b);

		while (low < high) {
            int mid = low+(high-low)/2,days=1,curPartionWeight=0;
            
            for(int w:weights) {
            	
            	if(curPartionWeight+w>mid) {
            		days++;
            		curPartionWeight=0;
            	}
            	
            	curPartionWeight+=w;
            }
            
            if(days==D) {return mid;}
            if(days>D) {low=mid+1;} //partition size should be more than mid
            else {high=mid-1;}//partition size should be less than mid
		}

		return high+1;
	}
	
	public static void main(String[] args) {
		int[] weights = new int[]{3,2,2,4,1,4};
	    System.out.println(shipWithinDays(weights, 3));
  	}
}
