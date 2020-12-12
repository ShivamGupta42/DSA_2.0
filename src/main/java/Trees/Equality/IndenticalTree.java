package Trees.Equality;

public class IndenticalTree {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}

	public int isSameTree(TreeNode A, TreeNode B) {
		if (A == null && B == null) {
			return 1;
		}

		if (A == null || B == null) {
			return 0;
		}

		boolean res = (A.val == B.val) && (isSameTree(A.left, B.left) == 1) 
			&& (isSameTree(A.right, B.right) == 1);
		return res == true ? 1 : 0;
	}
	
	
}
