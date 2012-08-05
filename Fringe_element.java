import java.util.ArrayList;


public class Fringe_element {
	
	Node n;
	int f_function;
	int g_function;
	ArrayList<Integer> visited;
	
	Fringe_element(Node n, int f_function) {
		this.n = n;
		this.f_function = f_function;
		this.visited = new ArrayList<Integer>();
		this.g_function = this.f_function+this.n.heuristic;
	}
	
	Fringe_element(Node n, int f_function, ArrayList<Integer> visited) {
		this.n = n;
		this.f_function = f_function;
		this.visited = visited;
		this.g_function = this.f_function+this.n.heuristic;
	}
	
	public int get_g_function() {
		return this.g_function;
	}
	
	public int get_f_function() {
		return this.f_function;
	}

}
