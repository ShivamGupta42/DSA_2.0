package Trees.bfs;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Ibit_KthSmallest {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
		
		@Override
		public String toString() {
			return val+"";
		}
	}

	public int kthsmallest(TreeNode A, int B) {
		//PriorityQueue<TreeNode> minHeap = new PriorityQueue<TreeNode>((a, b) -> a.val - b.val);
		PriorityQueue<TreeNode> maxHeap = new PriorityQueue<TreeNode>((a, b) -> b.val - a.val);
		return bfs(maxHeap, A, B);
	}

	public int bfs(PriorityQueue<TreeNode> maxHeap, TreeNode root, int k) {
		if (root == null) {
			return -1;
		}
		Deque<TreeNode> levelNodes = new LinkedList<>();
		levelNodes.add(root);
		int totalValuesInHeap = 0;
		
		while (!levelNodes.isEmpty()) {
			int curLevelNodes = levelNodes.size();
			
			//Iterating through a level in a tree
			while (curLevelNodes-- > 0) {
				TreeNode x = levelNodes.poll();
				if (totalValuesInHeap < k) {
					maxHeap.add(x);
					totalValuesInHeap++;
				} else {
					int temp = maxHeap.peek().val;
					if (x.val < temp) {
						maxHeap.poll();
						maxHeap.add(x);
					}
				}
				
				if (x.left != null) {
					levelNodes.add(x.left);
				}
				if (x.right != null) {
					levelNodes.add(x.right);
				}
			}

		} // level Nodes Loop
		return maxHeap.peek().val;
	}
	
	

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.left.left = new TreeNode(2);
		root.left.left.left.left = new TreeNode(1);
		Ibit_KthSmallest ksmall = new Ibit_KthSmallest();
		System.out.println(ksmall.kthsmallest(root, 2));
	}

}
