package DataStructure;
/*
 * Imtiaz Adar
 * BFS
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class BFS {
	private ArrayList<ArrayList<Integer>> adj;
	private int vertex;
	BFS(int vertex){
		this.vertex = vertex;
		adj = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < vertex; i++) {
			adj.add(new ArrayList<Integer>());
		}
	}
	public void addEdge(int u, int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
	public void bfs(int source) {
		boolean[] visited = new boolean[vertex];
		for(int i = 0; i < visited.length; i++)
			visited[i] = false;
		LinkedList<Integer> queue = new LinkedList<Integer>();
		visited[source] = true;
		queue.add(source);
		while(queue.size() != 0) {
			int node = queue.poll();
			System.out.print(node + " ");
			Iterator<Integer> it = adj.get(source).iterator();
			while(it.hasNext()) {
				int val = it.next();
				if(!visited[val]) {
					visited[val] = true;
					queue.add(val);
				}
			}
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter how many nodes you want to add : ");
		int nodes = scan.nextInt();
		BFS obj = new BFS(nodes);
		obj.addEdge(0, 2);
		obj.addEdge(1, 2);
		obj.addEdge(2, 0);
		obj.addEdge(2, 3);
		obj.addEdge(3, 3);
		System.out.println("Enter source : ");
		int source = scan.nextInt();
		System.out.println("\n< - BFS - >\n");
		obj.bfs(source);
	}
}
