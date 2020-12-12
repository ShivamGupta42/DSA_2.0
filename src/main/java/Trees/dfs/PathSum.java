package Trees.dfs;

import java.util.ArrayList;
import java.util.List;

public class PathSum {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> list = new ArrayList<>();

		pathHelper(root, list, new ArrayList<>(), sum);
		return list;
	}

	public static void pathHelper(TreeNode root, List<List<Integer>> result, List<Integer> tempList, int sumRemain) {

		if (root == null) {
			return;
		}

		int temp = sumRemain - root.val;

		if (temp == 0 && root.left == null && root.right == null) {
			tempList.add(root.val);
			result.add(new ArrayList<>(tempList));
			tempList.remove(tempList.size() - 1);
			return;
		} 

		tempList.add(root.val);
		sumRemain = temp;

		if (root.left != null) {
			pathHelper(root.left, result, tempList, sumRemain);
		}

		if (root.right != null) {
			pathHelper(root.right, result, tempList, sumRemain);
		}

		tempList.remove(tempList.size() - 1);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(-2);
		root.right = new TreeNode(-3);
		System.out.println(pathSum(root, -5));
	}
}
