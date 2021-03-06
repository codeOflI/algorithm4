package com.mars.algorithms.chapter4_graph.chapter4_3_mst;

import com.mars.algorithms.chapter1.chapter1_3.Bag;

import edu.princeton.cs.algs4.In;

/**
 * 加权无向图的数据类型
 * @author LiMingzhong
 */
public class EdgeWeightedGraph {
	private final int V; // 顶点总数
	private int E; // 边的总数
	private Bag<Edge>[] adj; // 邻接表

	public EdgeWeightedGraph(int V) {
		this.V = V;
		this.E = 0;
		adj = (Bag<Edge>[]) new Bag[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new Bag<Edge>();
		}
	}

	/**
	 * Exercise 4.3.9
	 * 
	 * @param in
	 */
	public EdgeWeightedGraph(In in) {
		this(in.readInt());
		int E = in.readInt();
		for (int i = 0; i < E; i++) {
			int v = in.readInt();
			int w = in.readInt();
			double weight = in.readDouble();
			Edge edge = new Edge(v, w, weight);
			addEdge(edge);
		}
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public void addEdge(Edge e) {
		int v = e.either(), w = e.other(v);
		adj[v].add(e);
		adj[w].add(e);
		E++;
	}

	public Iterable<Edge> adj(int v) {
		return adj[v];
	}

	public Iterable<Edge> edges() {
		Bag<Edge> b = new Bag<Edge>();
		for (int v = 0; v < V; v++) {
			for (Edge e : adj[v]) {
				if (e.other(v) > v) {
					b.add(e);
				}
			}
		}
		return b;
	}

	/**
	 * Exercise 4.3.17
	 */
	@Override
	public String toString() {
		String s = V + " vertices, " + E + " edges\n";
		for (int v = 0; v < V; v++) {
			s += v + ": ";
			for (Edge w : this.adj(v)) {
				s += w + " ";
			}
			s += "\n";
		}
		return s;
	}
}
