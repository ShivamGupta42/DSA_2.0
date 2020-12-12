package Trees.BST;

public class IsValidBST {

	static class TreeNode {
		TreeNode right;
		TreeNode left;
		int val;

		public TreeNode(int val) {

			this.val = val;
		}

	}

	public static boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}

		return isValidBST(root.left, (long)Integer.MIN_VALUE, (long)root.val - 1)
				&& isValidBST(root.right, root.val + 1, Integer.MAX_VALUE);
	}

	public static boolean isValidBST(TreeNode root, long low, long max) {

		if (root == null) {
			return true;
		}

		if (root.val < low || root.val > max) {
			return false;
		}

		return isValidBST(root.left, low, root.val - 1) && isValidBST(root.right, root.val + 1, max);

	}

	public static void main(String[] args) {

		TreeNode n = new TreeNode(Integer.MIN_VALUE);
		n.left = new TreeNode(Integer.MIN_VALUE);
		System.out.println(isValidBST(n));

	}

}
