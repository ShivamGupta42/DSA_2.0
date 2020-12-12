package Trees.TreePropCheck;

public class LowestCommonAncestor {
	static class TreeNode{
		int val;
		TreeNode right;
		TreeNode left;
	}

	boolean val1Found = false, val2Found = false;

	public int lca(TreeNode root, int B, int C) {
		TreeNode res = lca_helper(root, B, C);
		return val1Found && val2Found ? res.val : -1;
	}

	public TreeNode lca_helper(TreeNode root, int B, int C) {
		if (root == null) {
			return null;
		}

		// So that if B and C are equal we can handle that case
		TreeNode temp = null;
		;
		if (root.val == B) {
			val1Found = true;
			temp = root;
		}

		if (root.val == C) {
			val2Found = true;
			temp = root;
		}

		TreeNode left = lca_helper(root.left, B, C);
		TreeNode right = lca_helper(root.right, B, C);

		// So that if one value lies under another value, it is still marked
		if (temp != null) {
			return temp;
		}

		if (left != null && right != null) {
			return root;
		}

		return left != null ? left : right;
	}

}
