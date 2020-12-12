package Graphs;

import java.util.ArrayList;

public class Cycles {

	static boolean isCyclic_directed(ArrayList<ArrayList<Integer>> list, int V) {

		boolean visited[] = new boolean[V];
		boolean recStack[] = new boolean[V];

		for (int i = 0; i < V; i++) {
			if (dfs_cycle_directed(list, i, visited, recStack)) {
				return true;
			}
		}
		return false;
	}

	static boolean dfs_cycle_directed(ArrayList<ArrayList<Integer>> list, int src, boolean[] vis, boolean[] rec) {

		if (rec[src]) {
			return true;
		}

		if (vis[src]) {
			return false;
		}

		vis[src] = true;
		rec[src] = true;

		for (int i = 0; i < list.get(src).size(); i++) {
			if (dfs_cycle_directed(list, list.get(src).get(i), vis, rec)) {
				return true;
			}
		}

		rec[src] = false;
		return false;
	}

	static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V)
    {
      	int[] parent = new int[V];
      	for(int k=0;k<V;k++){
      	    parent[k]=-1;
      	}

		
		for (int i = 0; i < V; i++) {

			for (int j = 0; j < list.get(i).size(); j++) {
				int src = find(parent, i);
				int dest = find(parent, list.get(i).get(j));

				if (src == dest) {
					return true;
				}

				union(parent, i, list.get(i).get(j));
			}

		}

		return false;
    }
    
    
   
	static void union(int[] parent, int x, int y) {
		int xSet = find(parent, x);
		int ySet = find(parent, y);
		parent[xSet] = ySet;

	}

	static int find(int[] parent, int i) {
		if (parent[i] == -1) {
			return i;
		}
		return find(parent, parent[i]);
	}

}
