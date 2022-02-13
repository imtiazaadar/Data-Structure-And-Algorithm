import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import static java.lang.Math.*;
/**
 * @author: Imtiaz Adar
 */
public class bfs {
    private ArrayList<ArrayList<Integer>> adj;
    private int nodes;
    bfs(int nodes){
        this.nodes = nodes;
        adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < nodes; i++){
            adj.add(new ArrayList<Integer>());
        }
    }
    public void addEdge(int u, int v){
        adj.get(u).add(v);
    }
    public void BFS(int source){
        boolean[] visited = new boolean[this.nodes];
        for(int i = 0; i < visited.length; i++)
            visited[i] = false;
        Queue<Integer> q = new LinkedList<>();
        visited[source] = true;
        q.add(source);
        while(!q.isEmpty()){
            int node = q.poll();
            System.out.print(node + " ");
            Iterator<Integer> it = adj.get(node).iterator();
            while(it.hasNext()){
                int neighbour = it.next();
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    q.add(neighbour);
                }
            }
        }
        System.out.println();
    }
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        StringTokenizer token = new StringTokenizer("");
        InputReader scan = new InputReader(br, token);
        System.out.println("Nodes : ");
        int vertex = scan.nextInt();
        bfs bfsobj = new bfs(vertex);
        System.out.println("Edges : ");
        int edges = scan.nextInt();
        while(edges-- > 0){
            int parent = scan.nextInt();
            int child = scan.nextInt();
            bfsobj.addEdge(parent, child);
        }
        System.out.println("Source : ");
        int source = scan.nextInt();
        bfsobj.BFS(source);
    }
    static class InputReader {
        private BufferedReader readfile;
        private StringTokenizer token;
    
        InputReader(BufferedReader br, StringTokenizer st)
        {
            this.readfile = br;
            this.token = st;
        }
        String next(){
            while (!this.token.hasMoreTokens()){
                try{
                    token = new StringTokenizer(readfile.readLine());
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
            return this.token.nextToken();
        }
        String nextLine() throws IOException {
            return readfile.readLine();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
        int[] readArray(int size) throws IOException {
            int[] dp = new int[size];
            token = new StringTokenizer(readfile.readLine());
            for (int i = 0; i < size; i++) {
                dp[i] = Integer.parseInt(token.nextToken());
            }
            return dp;
        }
    }
}
