package Backtracking.SubSets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC78_Subsets {

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, 0);
		return list;
	}

	private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
		list.add(new ArrayList<>(tempList));
		for (int i = start; i < nums.length; i++) {
			tempList.add(nums[i]);
			backtrack(list, tempList, nums, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> list = subsets(new int[] { 1, 2, 3, 4 });

		for (List<Integer> l : list) {
			System.out.print("\n[");
			for (int i : l) {
               System.out.print(i+",");
			}
			System.out.print("]");
		}
	}
	
	
	public List<List<Integer>> subsetsArray(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int n : nums){
            int size = result.size();
            for(int i=0; i<size; i++){
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(n);
                result.add(subset);
            }
        }
        return result;
    }
}
