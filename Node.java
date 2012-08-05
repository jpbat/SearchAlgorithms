import java.util.ArrayList;

public class Node {

	ArrayList<Integer> childs;
	ArrayList<Integer> costs;
	int heuristic;
	int id;
	
	Node(int id, int heuristic) {
		this.id = id;
		this.heuristic = heuristic;
		this.childs = new ArrayList<Integer>();
		this.costs = new ArrayList<Integer>();
	}

}
