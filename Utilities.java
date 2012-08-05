import java.util.ArrayList;


class Utilities {

	public void show_fringe_astar(ArrayList<Fringe_element> fringe) {
		System.out.println("Showing Fringe:");
		for (Fringe_element f : fringe) {
			System.out.println("id: "+letter(f.n.id)+"\nheuristic: "+f.n.heuristic+"\nfunction f: "+f.f_function);
			System.out.println("--------------");
		}
		System.out.println("");
	}

	public void show_fringe(ArrayList<Fringe_element> fringe) {
		System.out.println("Showing Fringe:");
		for (Fringe_element f : fringe) {
			System.out.println("id: "+letter(f.n.id)+"\nfunction f: "+f.f_function);
			System.out.println("--------------");
		}
		System.out.println("");
	}
	
	public void show_fringe_greedy(ArrayList<Fringe_element> fringe) {
		System.out.println("Showing Fringe:");
		for (Fringe_element f : fringe) {
			System.out.println("id: "+letter(f.n.id)+"\nheuristic: "+f.n.heuristic);
			System.out.println("--------------");
		}
		System.out.println("");
	}
	
	public ArrayList<Integer> copy(ArrayList<Integer> i) {
		
		ArrayList<Integer> ret = new ArrayList<Integer>();
		
		for (int j = 0; j < i.size(); j++) {
			ret.add(i.get(j));
		}
		
		return ret;
	}
	
	public String letter(int n) {
		String letter[] = {"A","B","C","D","F","I"};
		return letter[n];
	}

	public void sort_astar(ArrayList<Fringe_element> fringe) {
		for(int i = 0; i < fringe.size(); i++) {
			for(int j = 0; j < fringe.size()-i-1; j++) {
				if (fringe.get(j).get_g_function() > fringe.get(j+1).get_g_function()) {
					Fringe_element temp = fringe.get(j);
					fringe.set(j, fringe.get(j+1));
					fringe.set(j+1, temp);
				} else if (fringe.get(j).get_g_function() == fringe.get(j+1).get_g_function()) {
					if (fringe.get(j).n.id > fringe.get(j+1).n.id) {
						Fringe_element temp = fringe.get(j);
						fringe.set(j, fringe.get(j+1));
						fringe.set(j+1, temp);
					}
				}
			}
		}
	}
	
	public void sort(ArrayList<Fringe_element> fringe) {
		for(int i = 0; i < fringe.size(); i++) {
			for(int j = 0; j < fringe.size()-i-1; j++) {
				if (fringe.get(j).get_f_function() > fringe.get(j+1).get_f_function()) {
					Fringe_element temp = fringe.get(j);
					fringe.set(j, fringe.get(j+1));
					fringe.set(j+1, temp);
				} else if (fringe.get(j).get_f_function() == fringe.get(j+1).get_f_function()) {
					if (fringe.get(j).n.id > fringe.get(j+1).n.id) {
						Fringe_element temp = fringe.get(j);
						fringe.set(j, fringe.get(j+1));
						fringe.set(j+1, temp);
					}
				}
			}
		}
	}
	
	public void sort_greedy(ArrayList<Fringe_element> fringe) {
		for(int i = 0; i < fringe.size(); i++) {
			for(int j = 0; j < fringe.size()-i-1; j++) {
				if (fringe.get(j).n.heuristic > fringe.get(j+1).n.heuristic) {
					Fringe_element temp = fringe.get(j);
					fringe.set(j, fringe.get(j+1));
					fringe.set(j+1, temp);
				} else if (fringe.get(j).n.heuristic == fringe.get(j+1).n.heuristic) {
					if (fringe.get(j).n.id > fringe.get(j+1).n.id) {
						Fringe_element temp = fringe.get(j);
						fringe.set(j, fringe.get(j+1));
						fringe.set(j+1, temp);
					}
				}
			}
		}
	}
	
	public void end(Fringe_element aux, String name) {
		System.out.println(name+" found a solution!");
		for (int i = 0; i < aux.visited.size(); i++) {
			System.out.print(letter(aux.visited.get(i)));
			if (i+1 < aux.visited.size())
				System.out.print("->");
		}
		System.out.println("\nCost: "+aux.f_function);
		
	}
}
