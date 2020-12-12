package Trees.bfs;

import java.util.Deque;
import java.util.LinkedList;

public class MinDepth {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}

		@Override
		public String toString() {

			return val + "";
		}
	}

	public int minDepth(TreeNode A) {

		if (A == null) {
			return 0;
		}

		Deque<TreeNode> q = new LinkedList<>();
		q.add(A);
		int levelNodes = 0;
		int minDepth = 0;

		while (!q.isEmpty()) {
			minDepth++;
			levelNodes = q.size();
			while (levelNodes-- > 0) {
				TreeNode temp = q.poll();

				if (temp.left == null && temp.right == null) {
					return minDepth;
				}
				if (temp.left != null) {
					q.add(temp.left);
				}
				if (temp.right != null) {
					q.add(temp.right);
				}
			}
		}

		return minDepth;
	}

	public int minDepth2(TreeNode A) {

		int minDepth = 0;
		if (A == null) {
			return minDepth;
		}

		int l = minDepth2(A.left);
		int r = minDepth2(A.right);

		return l != 0 && r != 0 ? 1+Math.min(l, r) : 1+Math.max(l, r);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);


		root.right.left = null;
		root.right.right = new TreeNode(5);
		root.right.right.right = new TreeNode(7);

		MinDepth min = new MinDepth();
		System.out.println(min.minDepth2(root));
	}

}
