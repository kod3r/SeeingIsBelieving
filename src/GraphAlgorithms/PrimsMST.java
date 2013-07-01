package GraphAlgorithms;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

class Node {
	public double Key;
	public int value;
	public int vertex;

	public Node(double Key, int value, int vertex) {
		this.Key = Key;
		this.value = value;
		this.vertex = vertex;

	}
};

public class PrimsMST {

	private static int INF = 100000;
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

			// Undirected edge for Prim's Algorithm
			gph.addEdge(u, v, c);
			gph.addEdge(v, u, c);
		}

		s.close();
	}

	public double MST() {
		double total = 0;
		PriorityQueue<Node> Q = new PriorityQueue<Node>(gph.vertices,
				new Comparator<Node>() {

					@Override
					public int compare(Node arg0, Node arg1) {
						if (arg0.Key > arg1.Key)
							return 1;
						return -1;
					}

				});
		boolean containedIn[] = new boolean[gph.vertices + 1];

		HashMap<Integer, Node> objectMap = new HashMap<Integer, Node>();
		int i;
		for (i = 0; i < gph.vertices; i++) {
			Node nd = new Node(INF, -1, i); // -1 signifies NULL
			Q.add(nd);
			objectMap.put(i, nd);
			containedIn[i] = true;
		}

		Node top = Q.poll();
		top.Key = 0;
		Q.add(top);

		while (!Q.isEmpty()) {
			top = Q.poll();
			containedIn[top.vertex] = false;
			for (i = 0; i < gph.adjacencyList.elementAt(top.vertex).size(); i++) {
				Edge v = gph.adjacencyList.elementAt(top.vertex).elementAt(i);
				Node vNode = objectMap.get(v.to);
				if (containedIn[v.to] && v.weight < vNode.Key) {
					Q.remove(vNode);
					objectMap.remove(v.to);
					vNode.Key = v.weight;
					vNode.value = top.vertex;
					Q.add(vNode);
					objectMap.put(v.to, vNode);

				}

			}
		}
		Set<Entry<Integer, Node>> nodes = objectMap.entrySet();
		for (Entry<Integer, Node> nd : nodes) {
			total += nd.getValue().Key;

		}
		return total;
	}
};
