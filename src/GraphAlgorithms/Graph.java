package GraphAlgorithms;

import java.util.List;
import java.util.Vector;

class Edge {
	int from;
	int to;
	double weight;

	Edge(int from, int to, double weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;

	}
}

public class Graph {
	public int vertices;
	public int edges;

	Graph(int vertices, int edges) {
		this.vertices = vertices;
		this.edges = edges;
	}

	public double adjacencyMatrix[][] = new double[300][300];
	Vector<Vector<Edge>> adjacencyList = new Vector<Vector<Edge>>();
	List<Edge> edgeList = new Vector<Edge>();

	public void addEdge(int src, int dest, double weight) {
		adjacencyMatrix[src][dest] = weight;
		Edge e = new Edge(src, dest, weight);
		edgeList.add(e);

		try {
			adjacencyList.elementAt(src).add(e);
		} catch (Exception exp) {
			Vector<Edge> vtr = new Vector<Edge>();
			vtr.add(e);
			adjacencyList.add(vtr);
		}
	}
}
