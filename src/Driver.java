import GraphAlgorithms.FloydWarshall;
import GraphAlgorithms.KruskalMST;
import GraphAlgorithms.PrimsMST;

public class Driver {

	public static void main(String[] args) {
		FloydWarshall M = new FloydWarshall();
		M.setup();
		M.AllPairShortest();

		int i, j;
		for (i = 0; i < M.spgph.vertices; i++) {
			for (j = 0; j < M.spgph.vertices; j++)
				System.out.print(M.spgph.adjacencyMatrix[i][j] + " ");
			System.out.println();

		}

	}

}
