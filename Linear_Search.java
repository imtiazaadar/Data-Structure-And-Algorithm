package DataStructure;
/*
 * Imtiaz Adar
 * Linear Search
 */
public class Linear_Search {

	public static int linear_search(int[] arr, int ele) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == ele) {
				return i;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40, 50, 60, 70};
		int pos = linear_search(arr, 70);
		if(pos != -1)
			System.out.println("Element exists in position : " + pos);
		else System.out.println("Element Not exists");
	}
}
