package Arrays.SubArray;

import java.util.ArrayList;

public class MaxNonNegativeSubArray {
	
	 public static ArrayList<Integer> maxset(ArrayList<Integer> A) {
	        /*
	        int[] pSum= new int[A.size()];
	        pSum[0]=A.get(0);
	        for(int i=1;i<A.size();i++){
	            pSum[i]=A.get(i)+pSum[i-1];
	        }*/
	        
	        int start=0;
	        int end=-1;
	        
	        int curStart=0;
	        int curEnd=-1;
	        
	        int max=Integer.MIN_VALUE;
	        int curSum=0;
	        
	        for(int i=1;i<A.size();i++){
	            if(A.get(i)<0){
	                curSum=0;
	                curStart=i+1;
	                curEnd=-1;
	                
	            }
	            
	            curEnd=i;
	            curSum+=A.get(i);
	            
	            if(curSum>max){
	                start=curStart;
	            	end=curEnd;
	                max=curSum;
	            }
	            
	        }
	        
	        ArrayList<Integer> list = new ArrayList<Integer>();
	        if(end!=-1){
	           for(int i=start;i<=end;i++){
	               list.add(A.get(i));
	           }
	            
	        } 
	        
	        
	        
	        return list;
	    }
	 
	 public static void main(String[] args) {
		 ArrayList<Integer> list = new ArrayList<Integer>();
		 list.add(1);
		 list.add(2);
		 list.add(5);
		 list.add(-7);
		 list.add(2);
		 list.add(3);
		 System.out.println(maxset(list));
	}

}
