package GraphAlgorithms;

import java.util.Scanner;

public class FloydWarshall {
	public Graph gph;
	public Graph spgph;

	public void setup() {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();

		gph = new Graph(N, N * N);
		spgph = new Graph(N, N * N);
		int i;
		for (i = 0; i < (N * (N - 1)) / 2; i++) {
			int u, v;
			double c;
			u = s.nextInt();
			v = s.nextInt();
			c = s.nextDouble();

			gph.addEdge(u, v, c);
			gph.addEdge(v, u, c);
		}

		s.close();
	}

	public void AllPairShortest() {
		int i, j, k;
		for (i = 0; i < gph.vertices; i++) {
			for (j = 0; j < gph.vertices; j++) {
				spgph.addEdge(i, j, gph.adjacencyMatrix[i][j]);
				spgph.addEdge(j, i, gph.adjacencyMatrix[j][i]);
			}

		}
		for (k = 0; k < gph.vertices; k++) {
			for (i = 0; i < gph.vertices; i++) {
				for (j = 0; j < gph.vertices; j++) {
					spgph.adjacencyMatrix[i][j] = Math.min(
							spgph.adjacencyMatrix[i][j],
							spgph.adjacencyMatrix[i][k]
									+ spgph.adjacencyMatrix[k][j]);
				}

			}
		}
	}
}
