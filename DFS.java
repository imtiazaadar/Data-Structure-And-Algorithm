package DataStructure;
/*
 * Imtiaz Adar
 * DFS
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DFS {
	private ArrayList<ArrayList<Integer>> adj;
	private int vertex;
	DFS(int vertex){
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
	public void dfsUtil(boolean[] visited, int source) {
		visited[source] = true;
		System.out.print(source + " ");
		Iterator<Integer> it = adj.get(source).iterator();
		while(it.hasNext()) {
			int node = it.next();
			if(!visited[node]) {
				dfsUtil(visited, node);
			}
		}
	}
	public void dfs() {
		boolean[] visited = new boolean[vertex];
		for(int i = 0; i < visited.length; i++) {
			if(!visited[i]) {
				dfsUtil(visited, i);
			}
		}
	}
	public static void main(String[] args) {
		FastScanner scan = new FastScanner();
		System.out.println("Enter how many nodes you want to add : ");
		int nodes = scan.nextInt();
		DFS obj = new DFS(nodes);
		obj.addEdge(0, 2);
		obj.addEdge(1, 2);
		obj.addEdge(2, 0);
		obj.addEdge(2, 3);
		obj.addEdge(3, 3);
		System.out.println("\n< - DFS - >\n");
		obj.dfs();
		System.out.println();
	}
	static class FastScanner{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		String next(){
			while(!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				}
				catch(IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		String nextLine() {
			String str = "";
			try{
				str = br.readLine();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
		int nextInt() {
			return Integer.parseInt(next());
		}
		long nextLong() {
			return Long.parseLong(next());
		}
		double nextDouble() {
			return Double.parseDouble(next());
		}
		int[] readIntArray(int size) {
			int[] x = new int[size];
			for(int i = 0; i < x.length; i++) {
				x[i] = nextInt();
			}
			return x;
		}
	}
}
