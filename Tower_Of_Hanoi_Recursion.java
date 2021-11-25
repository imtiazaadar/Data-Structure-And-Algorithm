package DataStructure;
/*
 * Author : Imtiaz Adar
 * Tower Of Hanoi
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tower_Of_Hanoi_Recursion {
	public static void towerOfHanoi(int n, char from, char aux, char to) {
		if(n == 1) {
			System.out.println("MOVE DISK 1 FROM " + from + " TO " + to);
			return;
		}
		towerOfHanoi(n - 1, from, aux, to);
		System.out.println("MOVE DISK " + n + " FROM " + from + " TO " + to);
		towerOfHanoi(n - 1, aux, to, from);
	}
	public static void main(String[] args) {
		FastScanner scan = new FastScanner();
		System.out.println("Enter number of disks : ");
		int n = scan.nextInt();
		towerOfHanoi(n, 'A', 'C', 'B');
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
