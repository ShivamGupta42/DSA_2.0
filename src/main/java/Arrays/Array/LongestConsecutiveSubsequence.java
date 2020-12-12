package Arrays.Array;

import java.util.HashMap;


public class LongestConsecutiveSubsequence {
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,9,3,10,4,20,2};
		System.out.println(sequence(arr));
	}

	/*
	->For longest increasing subsequence, you need DP(Why?) 
	->For longest consecutive subsequene, you need this approach
	->We are doing DFS basically 
	->We maintain a hashMap(Node value, visited)
	->Then we check whether there is a path from this number in decreasing/increasing order
	->All the nodes we encounter we mark them as visited
	
	*/
	public static int  sequence(int[] arr) {

		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		for (int i : arr) {
			map.put(i, false);
		}

		int maxLength = Integer.MIN_VALUE;
		int curLength = 0;
		for (int i = 0; i < arr.length; i++) {
			if (map.get(arr[i])) {
				continue;
			}
			map.put(arr[i], true);
			curLength = 1;
			int curValue=arr[i];
			
			//check to the left of current value
		     while(map.containsKey(curValue-1)){
		    	 curLength++;
		    	 map.put(curValue-1, true);
		    	 curValue--;
		     }
		     curValue=arr[i];
		     //check to the right of current value
		     while(map.containsKey(curValue+1)){
		    	 curLength++;
		    	 map.put(curValue+1, true);
		    	 curValue++;
		     }
			maxLength = Math.max(maxLength, curLength);
		}
		return maxLength;
	}
}
