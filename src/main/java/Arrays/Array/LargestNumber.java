package Arrays.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {

	public class Solution {
		// DO NOT MODIFY THE LIST. IT IS READ ONLY
		public String largestNumber(final List<Integer> A) {
			ArrayList<Integer> arr = new ArrayList<Integer>(A);
			Collections.sort(arr, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					String s1 = String.valueOf(o1) + String.valueOf(o2);
					String s2 = String.valueOf(o2) + String.valueOf(o2);

					return s1.compareTo(s2) > 0 ? -1 : 1;
				}
			});

			StringBuilder sb = new StringBuilder();
			
			if(arr.get(0)==0) {
				return 0+"";
			}
			
			for (int i : arr) {
				sb.append(i);
			}

			return sb.toString();
		}
	}

}
