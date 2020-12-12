package Arrays.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDup {

	public static int remove(int[] arr) {
		int nextDuplicate = 0;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == arr[i - 1]) {
				arr[nextDuplicate] = arr[i];
			} else {
				arr[++nextDuplicate] = arr[i];
			}
		}
		return nextDuplicate + 1;
	}

	public static int removeDuplicates(List<Integer> a) {
		if (a == null)
			return 0;
		if (a.size() < 2)
			return 1;

		int nonDuplicate = 0;
		int i = 1;
		while (i < a.size()) {
			if (a.get(i).intValue() != a.get(i - 1).intValue()) {
				nonDuplicate++;
				i++;
			} else {
				a.set(nonDuplicate, a.get(i));
				a.remove(i);
			}
		}

		return nonDuplicate + 1;
	}
	
	
	public int removeDuplicatesFaster(ArrayList<Integer> a) {
	       if(a.size()==1){
	            return 1;
	        }
	        int cur = a.get(0);
	        int tilcount = 0;
	        int count =0;
	        for(int i=1;i<a.size();i++){
	            if(cur==a.get(i)){
	                count++;
	            }else{
	                if(count!=0){
	                    tilcount = tilcount+count;
	                    count=0;
	                }
	                a.set(i-tilcount,a.get(i));
	                cur = a.get(i);
	            }
	        }
	        //System.out.println(tilcount);
	        int i=(a.size()-1);
	        int temp = a.size();
	            while(i>=(temp-tilcount-count)){
	            a.remove(i);
	            i--;
	        }
	        return a.size();
	    }

	public static void main(String[] args) {
		int[] arr = new int[] { 2,2,2 };
		System.out.println(removeDuplicates(Arrays.stream(arr).boxed().collect(Collectors.toList())));

	}

	static void printArr(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}

		System.out.println();
	}
}
