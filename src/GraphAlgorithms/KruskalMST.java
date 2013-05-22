package GraphAlgorithms;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class DisjointSets {

	private int[] parent;

	public DisjointSets(int numElements) {
		parent = new int[numElements + 3];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = -1;
		}
	}

	public void union(int root1, int root2) {
		if (parent[root2] < parent[root1]) {
			parent[root1] = root2;
		} else {
			if (parent[root1] == parent[root2]) {
				parent[root1]--;
			}
			parent[root2] = root1;
		}
	}

	public int find(int x) {
		if (parent[x] < 0) {
			return x;
		} else {
			parent[x] = find(parent[x]);
			return parent[x];
		}
	}
};

public class KruskalMST {
	Graph gph;
	Graph MST;

	public void setup() {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int E = s.nextInt();

		gph = new Graph(N, E);
		MST = new Graph(N, N - 1);
		int i;
		for (i = 0; i < E; i++) {
			int u, v;
			double c;
			u = s.nextInt();
			v = s.nextInt();
			c = s.nextDouble();

			// Undirected edge for Kruskal's Algorithm
			gph.addEdge(u, v, c);
			gph.addEdge(v, u, c);
		}

		s.close();
	}

	public double MST() {
		int i, pu, pv;
		double total = 0;

		DisjointSets dj = new DisjointSets(gph.vertices);
		Collections.sort(gph.edgeList, new Comparator<Edge>() {
			public int compare(Edge e1, Edge e2) {
				double diff = (e1.weight - e2.weight);
				if (diff > 0)
					return 1;
				if (diff < 0)
					return -1;
				return 0;
			}

		});

		for (i = 0; i < gph.edges; i++) {
			pu = dj.find(gph.edgeList.get(i).from);
			pv = dj.find(gph.edgeList.get(i).to);
			if (pu != pv) {
				MST.addEdge(gph.edgeList.get(i).from, gph.edgeList.get(i).to,
						gph.edgeList.get(i).weight);
				total += gph.edgeList.get(i).weight;
				dj.union(pu, pv);
			}
		}
		return total;
	}
};
