package Trees.TreePropCheck;
public class BalancedBinaryTree {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}

	public int isBalanced(TreeNode a) {
		if (a == null) {
			return 1;
		}

		TreeNode left = a.left;
		int lCount = 0;
		if (left != null) {
			if (left.left != null)
				lCount++;
			if (left.right != null)
				lCount++;
		}

		TreeNode right = a.right;
		int rCount = 0;
		if (right != null) {
			if (right.left != null)
				rCount++;
			if (right.right != null)
				rCount++;
		}

		if (Math.abs(lCount - rCount) > 1) {
			return 0;
		}

		boolean res = isBalanced(left) == 1 && isBalanced(right) == 1;
		return res ? 1 : 0;
	}

}
