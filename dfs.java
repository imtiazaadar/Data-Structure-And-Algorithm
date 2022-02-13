import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import static java.lang.Math.*;
/**
 * @author: Imtiaz Adar
 */
public class dfs {
    private int nodes;
    private ArrayList<ArrayList<Integer>> adj;
    dfs(int nodes){
        this.nodes = nodes;
        adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < nodes; i++){
            adj.add(new ArrayList<Integer>());
        }
    }
    public void addEdge(int parent, int child){
        adj.get(parent).add(child);
    }
    public void dfsUtil(boolean visited[], int source){
        visited[source] = true;
        System.out.print(source + " ");
        Iterator<Integer> it = adj.get(source).iterator();
        while(it.hasNext()){
            int item = it.next();
            if(!visited[item]){
                dfsUtil(visited, item);
            }
        }
    }
    public void DFS(){
        boolean[] visited = new boolean[this.nodes];
        for(int i = 0; i < visited.length; i++){
            if(!visited[i]){
                dfsUtil(visited, i);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        StringTokenizer token = new StringTokenizer("");
        InputReader scan = new InputReader(br, token);
        System.out.println("Nodes : ");
        int vertex = scan.nextInt();
        dfs dfsobj = new dfs(vertex);
        System.out.println("Edges : ");
        int edges = scan.nextInt();
        while(edges-- > 0){
            int parent = scan.nextInt();
            int child = scan.nextInt();
            dfsobj.addEdge(parent, child);
        }
        dfsobj.DFS();
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
