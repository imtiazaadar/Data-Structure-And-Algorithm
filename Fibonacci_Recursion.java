package DataStructure;

/*
 * Imtiaz Adar
 * Fibonacci (Recursion)
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Fibonacci_Recursion {
	public static int fibonacci(int n) {
		if(n < 2) return n;
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public static void main(String[] args) {
		FastScanner scan = new FastScanner();
		System.out.println("Enter the limit : ");
		int lim = scan.nextInt();
		for(int i = 0; i < lim; i++) {
			int ans = fibonacci(i);
			System.out.print(ans + " ");
		}
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