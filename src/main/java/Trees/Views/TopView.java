package Trees.Views;

import java.util.*;

public class TopView {

	class Node {
		int data;
		Node left;
		Node right;

	}

	public static void topView(Node root) {
		class QNode {
			int hdist;
			Node n;

			QNode(Node n, int hdist) {
				this.n = n;
				this.hdist = hdist;
			}
		}

		if (root == null) {
			return;
		}

		TreeMap<Integer, Node> map = new TreeMap<>();
		Queue<QNode> q = new LinkedList<>();
		q.add(new QNode(root, 0));

		while (!q.isEmpty()) {
			QNode temp = q.poll();
			int curHdistance = temp.hdist;
			if (!map.containsKey(curHdistance)) {
				map.put(curHdistance, temp.n);
			}

			if (temp.n.right != null) {
				q.add(new QNode(temp.n.right, curHdistance + 1));
			}

			if (temp.n.left != null) {
				q.add(new QNode(temp.n.left, curHdistance - 1));
			}
		}

		StringJoiner sj = new StringJoiner(" ");
		for (Map.Entry<Integer, Node> node : map.entrySet()) {
			sj.add(node.getValue().data + "");
		}
		System.out.println(sj.toString());
	}

}
