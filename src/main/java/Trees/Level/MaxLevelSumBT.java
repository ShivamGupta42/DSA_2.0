package Trees.Level;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSumBT {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int maxLevelSum(TreeNode root) {
		if (root == null) {
			return 0;
		}

		Queue<TreeNode> q = new LinkedList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		q.add(root);
		int level = 0;
		int nodesAtLevel = q.size();
		int maxSum = Integer.MIN_VALUE;
		int curSum = 0;

		while (!q.isEmpty()) {

			nodesAtLevel = q.size();
			curSum = 0;
			level++;

			while (nodesAtLevel-- > 0) {
				TreeNode x = q.poll();
				curSum += x.val;
				if (x.left != null) {
					q.add(x.left);
				}

				if (x.right != null) {
					q.add(x.right);
				}
			}

			if (maxSum < curSum) {
				maxSum = curSum;
				map.put(maxSum, level);
			}
		}

		int maxKey = map.keySet().stream().max((a,b)->a.compareTo(b)).get();
		return map.get(maxKey);
	}
}