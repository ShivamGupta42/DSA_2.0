package Backtracking.Perumutations;

import java.util.ArrayList;
import java.util.List;

public class LC46_AllPossiblePermutations {

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		perm(nums, result, new ArrayList<Integer>(), 0);
		return result;
	}

	public void perm(int[] nums, List<List<Integer>> result, ArrayList<Integer> temp, int start) {
		if (temp.size() == nums.length) {
			result.add(temp);
			return;
		}

		for (int i = start; i < nums.length; i++) {
			temp.add(nums[i]);
			perm(nums, result, temp, start + 1);
			temp.remove(temp.size() - 1);
		}
	}

	public static void main(String[] args) {
		LC46_AllPossiblePermutations lc = new LC46_AllPossiblePermutations();
		List<List<Integer>> result = lc.permute(new int[] {1,2,3});
	}

}
