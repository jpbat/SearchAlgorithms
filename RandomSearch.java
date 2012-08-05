import java.util.ArrayList;

public class RandomSearch {
	
	private ArrayList<Fringe_element> fringe;
	private ArrayList<Node> nodes;
	private Utilities util;
	
	RandomSearch(ArrayList<Node> nodes) {
		this.nodes = nodes;
		this.fringe = new ArrayList<Fringe_element>();
		this.util = new Utilities();
	}

	public void solve(int source, int destiny, int show) {
		
		Fringe_element f = new Fringe_element(this.nodes.get(source), 0);
		this.fringe.add(f);
		f.visited.add(source);
		
		Fringe_element aux;
		
		while (true) {
			
			if (show == 1)
				util.show_fringe(this.fringe);
			aux = this.fringe.remove(0);
			
			if (aux.n.id == destiny) {
				this.util.end(aux, "Random Search");
				return;
			}
			
			int jump = randint(aux.n.childs.size());
			f = new Fringe_element(this.nodes.get(aux.n.childs.get(jump)), aux.f_function+aux.n.costs.get(jump), this.util.copy(aux.visited));
			f.visited.add(aux.n.childs.get(jump));
			this.fringe.add(f);
		}
	}
	
	private int randint(int last) {
		return (int)(Math.random()*last);
	}
}
