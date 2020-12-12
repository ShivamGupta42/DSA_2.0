package Arrays.Array;

import java.util.ArrayList;
import java.util.Collections;

public class ZigZag2 {
	
	 public ArrayList<Integer> wave(ArrayList<Integer> A) {
		    
	        Collections.sort(A);
	        for(int i=1;i<A.size();i=i+2){
	        	int temp = A.get(i-1);
	        	A.set(i-1,A.get(i));
	        	A.set(i,temp);
	        }
	        
	        return A;
	        
	   }

}
