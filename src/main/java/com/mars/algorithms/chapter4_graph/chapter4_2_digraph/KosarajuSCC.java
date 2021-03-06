package com.mars.algorithms.chapter4_graph.chapter4_2_digraph;

import com.mars.algorithms.chapter1.chapter1_3.Bag;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * SCC: strongly connected component
 * @author LiMingzhong
 */
public class KosarajuSCC {
	private boolean[] marked; 		// 已访问过的顶点
	private int[] id; 				// 强连通分量的标识符
	private int count; 				// 强连通分量的数量

	public KosarajuSCC(Digraph G) {
		marked = new boolean[G.V()];
		id = new int[G.V()];
		DepthFirstOrder order = new DepthFirstOrder(G.reverse());
		for (int s : order.reversePost()) {
			if (!marked[s]) {
				dfs(G, s);
				count++;
			}
		}
	}

	private void dfs(Digraph G, int v) {
		marked[v] = true;
		id[v] = count;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				dfs(G, w);
			}
		}
	}

	public boolean stronglyConnected(int v, int w) {
		return id[v] == id[w];
	}

	public int id(int v) {
		return id[v];
	}

	public int count() {
		return count;
	}

	public static void main(String[] args) {
		Digraph G = new Digraph(new In(args[0]));
		KosarajuSCC cc = new KosarajuSCC(G);

		int M = cc.count();
		StdOut.println(M + " components");

		Bag<Integer>[] components = (Bag<Integer>[]) new Bag[M];
		for (int i = 0; i < M; i++) {
			components[i] = new Bag<Integer>();
		}
		for (int v = 0; v < G.V(); v++) {
			components[cc.id(v)].add(v);
		}
		for (int i = 0; i < M; i++) {
			for (int v : components[i]) {
				StdOut.print(v + " ");
			}
			StdOut.println();
		}
	}
}
