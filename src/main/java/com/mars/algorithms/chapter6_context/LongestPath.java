package com.mars.algorithms.chapter6_context;

import com.mars.algorithms.chapter4_graph.chapter4_1.Graph;

public class LongestPath {
	private boolean[] marked;
	private int max;

	public LongestPath(Graph G, int s, int t) {
		marked = new boolean[G.V()];
		dfs(G, s, t, 0);
	}

	private void dfs(Graph G, int v, int t, int i) {
		if (v == t && i > max) {
			max = i;
		}
		if (v == t) {
			return;
		}
		marked[v] = true;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				dfs(G, w, t, i + 1);
			}
		}
		marked[v] = false;
	}

	public int maxLength() {
		return max;
	}
}
