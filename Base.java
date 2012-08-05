import java.util.ArrayList;
import java.util.Scanner;

class Base {
	
	public static void main(String[] args) {
		
		Scanner a = new Scanner(System.in);
	
		ArrayList<Node> nodes = new ArrayList<Node>();
		
		int n_nodes = a.nextInt();
		
		for (int i = 0; i < n_nodes; i++) {
			Node x = new Node(i, a.nextInt());
			int childs = a.nextInt();
			for (int j = 0; j < childs; j++) {
				x.childs.add(a.nextInt());
				x.costs.add(a.nextInt());
			}
			nodes.add(x);
		}
		
		int source = a.nextInt();
		int destiny = a.nextInt();
		boolean x = true;
		
		while (x) {
			System.out.println("");
			System.out.println("Wich Algorithm do you wich to use?");
			System.out.println("--- Blind Search ---");
			System.out.println("1 - BFS");
			System.out.println("2 - DFS");
			System.out.println("3 - Dijkstra");
			System.out.println("--- Heuristic Search ---");
			System.out.println("4 - A*");
			System.out.println("5 - Greedy");
			System.out.println("6 - Hill Climbing");
			System.out.println("--- Stochastic Search ---");
			System.out.println("7 - Random Search");
			System.out.println("\n0 - Exit\n");
			
			int choice = a.nextInt();
			int fringe = 0;
			if (choice != 0) {
				System.out.println("Do you wish to show the fringe?\n1 - Yes\n2 - No");
				fringe = a.nextInt();
			}
			
			switch (choice) {
				case 1:
					BFS bfs = new BFS(nodes);
					bfs.solve(source, destiny, fringe);
					break;
				case 2:
					DFS dfs = new DFS(nodes);
					dfs.solve(source, destiny, fringe);
					break;
				case 3:
					Dijkstra dijkstra = new Dijkstra(nodes);
					dijkstra.solve(source, destiny, fringe);
					break;
				case 4:
					A_Star astar = new A_Star(nodes);
					astar.solve(source, destiny, fringe);
					break;
				case 5:
					Greedy g = new Greedy(nodes);
					g.solve(source, destiny, fringe);
					break;
				case 6:
					HillClimbing hc = new HillClimbing(nodes);
					hc.solve(source, destiny, fringe);
					break;
				case 7:
					RandomSearch rs = new RandomSearch(nodes);
					rs.solve(source, destiny, fringe);
					break;
				case 0:
					x = false;
					break;
			}
		}
		System.out.println("Hope it helped!");
	}
}
