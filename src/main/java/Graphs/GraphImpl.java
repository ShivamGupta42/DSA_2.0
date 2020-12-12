package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphImpl {
	int vertexCount;
	ArrayList<ArrayList<Integer>> arr;

	public GraphImpl(int vertexCount) {
		arr = new ArrayList<ArrayList<Integer>>(vertexCount);
		this.vertexCount = vertexCount;
		init();
	}

	private void init() {
		for (int i = 0; i < 11; i++) {
			arr.add(new ArrayList<Integer>());
		}

		// creating a sample graph
		/*
		 * arr.get(0).add(0);
		 * 
		 * arr.get(0).add(1); arr.get(0).add(5);
		 * 
		 * arr.get(1).add(1); arr.get(1).add(0); arr.get(1).add(2); arr.get(1).add(4);
		 * 
		 * arr.get(2).add(2); arr.get(2).add(1); arr.get(2).add(3);
		 * 
		 * arr.get(3).add(3); arr.get(3).add(2);
		 * 
		 * arr.get(4).add(4); arr.get(4).add(1);
		 * 
		 * arr.get(5).add(5); arr.get(5).add(0); arr.get(5).add(6); arr.get(5).add(7);
		 * 
		 * arr.get(6).add(6); arr.get(6).add(5);
		 * 
		 * arr.get(7).add(7); arr.get(7).add(5);
		 * 
		 * // Sparse Section of Graph arr.get(8).add(8); arr.get(8).add(9);
		 * arr.get(8).add(10);
		 * 
		 * arr.get(9).add(9); arr.get(9).add(8);
		 * 
		 * arr.get(10).add(10); arr.get(10).add(8);
		 */

		/*
		 * arr.get(2).add(2); arr.get(2).add(3);
		 * 
		 * arr.get(3).add(3); arr.get(3).add(2);
		 */
	}

	void addEdge(ArrayList<ArrayList<Integer>> list, int i, int j) {
		list.get(i).add(j);
	}

	static void bfs_sparse(ArrayList<ArrayList<Integer>> list, boolean vis[]) {

		Queue<Integer> q = new LinkedList<Integer>();
		int visiting = -1;

		for (int j = 0; j < list.size(); j++) {
			if (vis[j]) {
				continue;
			}
			q.add(j);
			vis[j] = true;

			while (!q.isEmpty()) {
				int cur = q.poll();
				System.out.print(cur + " ");
				for (int i = 0; i < list.get(cur).size(); i++) {
					visiting = list.get(cur).get(i);
					if (!vis[visiting]) {
						vis[visiting] = true;
						q.add(visiting);
					}
				}

			}

		}

	}

	public int getVertexCount() {
		return vertexCount;
	}

	public ArrayList<ArrayList<Integer>> getArr() {
		return arr;
	}

	public static void main(String[] args) {
		
		

		GraphImpl g2 = new GraphImpl(11);

		g2.addEdge(g2.getArr(), 0, 1);
		g2.addEdge(g2.getArr(), 0, 0);

		System.out.println(Cycles.isCyclic(g2.getArr(), 2));

		GraphImpl g = new GraphImpl(11);

		g.addEdge(g.getArr(), 0, 1);
		g.addEdge(g.getArr(), 1, 2);
		g.addEdge(g.getArr(), 2, 3);

		System.out.println(Cycles.isCyclic(g.getArr(), 4));

	}

	private static void bfs(int s, ArrayList<ArrayList<Integer>> list, boolean[] vis) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		int visiting = -1;
		vis[s] = true;

		while (!q.isEmpty()) {
			int cur = q.poll();
			System.out.print(cur + " ");
			for (int i = 0; i < list.get(cur).size(); i++) {
				visiting = list.get(cur).get(i);
				if (!vis[visiting]) {
					vis[visiting] = true;
					q.add(visiting);
				}
			}

		}

	}

	static void dfs(int src, ArrayList<ArrayList<Integer>> list, boolean vis[]) {

		if (vis[src]) {
			return;
		}

		vis[src] = true;
		System.out.print(src + " ");

		for (int i = 0; i < list.get(src).size(); i++) {
			if (!vis[list.get(src).get(i)]) {
				dfs(list.get(src).get(i), list, vis);
			}
		}

	}

	static void dfs_stack(int src, ArrayList<ArrayList<Integer>> list, boolean vis[]) {

	}

	/*
	 * Keeping track of a recursion stack also If while doing dfs we encounter the
	 * node again it means that we have a cycle
	 * 
	 * The following implementation also takes care of sparse graphs
	 */

}
