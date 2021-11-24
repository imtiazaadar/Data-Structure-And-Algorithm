package DataStructure;
/*
 * Imtiaz Adar
 * Insertation Sort
 */
public class Insertation__Sort {

	public static void insertationsort(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j = i - 1;
			while(j >= 0 && arr[j] > temp) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = temp;
		}
	}
	public static void printArray(int[] arr) {
		for(Integer it : arr) {
			System.out.print(it + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[] arr = {2, 44, 12, 23, 52, 77, 33};
		insertationsort(arr);
		printArray(arr);
	}
}
