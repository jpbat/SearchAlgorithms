import java.util.ArrayList;

public class HillClimbing {
	
	private ArrayList<Fringe_element> fringe;
	private ArrayList<Node> nodes;
	private Utilities util;
	
	HillClimbing(ArrayList<Node> nodes) {
		this.nodes = nodes;
		this.fringe = new ArrayList<Fringe_element>();
		this.util = new Utilities();
	}
	
	public void solve(int source, int destiny, int show) {
		
		Fringe_element f = new Fringe_element(nodes.get(source), 0);
		this.fringe.add(f);
		f.visited.add(source);
		
		Fringe_element aux;
		
		while(fringe.size() > 0) {
			
			if (show == 1)
				this.util.show_fringe(this.fringe);
			aux = this.fringe.remove(0);
			
			if (aux.n.id == destiny) {
				this.util.end(aux, "Hill Climbing");
				return;
			}
			
			int min = getMin(aux.n);
			Node n = this.nodes.get(aux.n.childs.get(min));
			f = new Fringe_element(n, aux.f_function + aux.n.costs.get(min), this.util.copy(aux.visited));
			f.visited.add(n.id);
			this.fringe.add(f);
		}
		
		System.out.println("ERROR! SOLUTION NOT FOUND!");
	}
	
	private int getMin(Node n) {
		int min = 0;

		for (int i = 1; i < n.childs.size(); i++) {
			if (this.nodes.get(n.childs.get(i)).heuristic < this.nodes.get(n.childs.get(min)).heuristic) {
				min = i;
			}
		}
		return min;
	}
}