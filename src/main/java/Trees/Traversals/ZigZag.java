package Trees.Traversals;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class ZigZag {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}

	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}

		Deque<TreeNode> q = new LinkedList<>();
		q.add(root);
		int nodesAtCurrentLevel = 0;
		boolean nextFromLeft = false;

		while (!q.isEmpty()) {

			nodesAtCurrentLevel = q.size();
			ArrayList<Integer> list = new ArrayList<>();

			while (nodesAtCurrentLevel-- > 0) {
				TreeNode temp = new TreeNode();
				
				list.add(temp.val);
				
				if (nextFromLeft) {
					if (temp.left != null) {
						q.add(temp.left);
					}

					if (temp.right != null) {
						q.add(temp.right);
					}
				} // from left

				else {
					if (temp.right != null) {
						q.add(temp.right);
					}

					if (temp.left != null) {
						q.add(temp.left);
					}

				} // end of else

			}

			result.add(list);
			nextFromLeft = !nextFromLeft;
		}

		return result;
	}// end method
}
