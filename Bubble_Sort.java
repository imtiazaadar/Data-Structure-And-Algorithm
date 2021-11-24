package DataStructure;
/*
 * Imtiaz Adar
 * Bubble Sort
 */

public class Bubble_Sort {
	public static void bubblesort(int[] arr, int n) {
		for(int i = 0; i < n - 1; i++) {
			for(int j = 0; j < n - i - 1; j++) {
				if(arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
	public static void printArray(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[] arr = {12, 5, 22, 88, 44, 33};
		int size = arr.length;
		bubblesort(arr, size);
		printArray(arr);
	}
}
