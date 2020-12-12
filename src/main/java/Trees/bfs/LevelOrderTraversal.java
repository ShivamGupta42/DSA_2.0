package Trees.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			List<Integer> l = new ArrayList<Integer>();
			int levelNodeCount = q.size();
			while (levelNodeCount > 0) {
				TreeNode cur = q.poll();
				l.add(cur.val);
				if (cur.left != null) {
					q.add(cur.left);
				}
				if (cur.right != null) {
					q.add(cur.right);
				}
				levelNodeCount--;
			}
			list.add(l);
		}

		return list;
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
