package Trees.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KdistanceNodes {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}

	Map<TreeNode, Integer> nodeDistance = new HashMap<>();

	public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
		List<Integer> res = new ArrayList<Integer>();
		// code to find the distance of every node from target
		find(root, target);

		dfs(res,root,nodeDistance.get(root),target,K);
		
		return res;
	}

	private void dfs(List<Integer> res, TreeNode root, int distance, TreeNode target, int K) {
		if(root==null) {
			return;
		}
		
		if(nodeDistance.containsKey(root)) {
			distance=nodeDistance.get(root);
		}
		
		if(distance==K) {
			res.add(root.val);
		}
		
		dfs(res,root.left,distance+1,target,K);
		dfs(res,root.right,distance+1,target,K);
		
	}

	private int find(TreeNode root, TreeNode target) {
		if(root==null) {
			return -1;
		}
		
		if(root==target) {
			nodeDistance.put(root, 0);
			return 0;
		}
		
		int left = find(root.left,target);
		if(left>=0) {
			nodeDistance.put(root,left+1);
			return left+1;
		}
		
		int right = find(root.right,target);
		
		if(right>=0) {
			nodeDistance.put(root,right+1);
			return right+1;
		}
		
		return -1;
	}

}
