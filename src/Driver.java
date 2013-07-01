import GraphAlgorithms.KruskalMST;
import GraphAlgorithms.PrimsMST;

public class Driver {

	public static void main(String[] args) {
		PrimsMST M = new PrimsMST();
		M.setup();
		System.out.println(M.MST());

	}

}
