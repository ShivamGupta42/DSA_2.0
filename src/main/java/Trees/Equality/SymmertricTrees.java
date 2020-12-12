package Trees.Equality;

public class SymmertricTrees {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}

	public int isSymmetric(TreeNode root) {
		if (root == null) {
			return 1;
		}

		return helper(root.left, root.right);

	}

	public int helper(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return 1;
		}

		if (left == null || right == null) {
			return 0;
		}

		boolean res = left.val == right.val && (helper(left.left, right.right) == 1)
				&& (helper(left.right, right.left) == 1);
		return res ? 1 : 0;
	}

}
