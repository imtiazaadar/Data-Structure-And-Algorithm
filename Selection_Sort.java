package DataStructure;
/*
 * Imtiaz Adar
 * Selection Sort
 */

public class Selection_Sort {
	public static void selectionsort(int[] arr, int size) {
		for(int i = 0; i < size - 1; i++) {
			int minindex = i;
			for(int j = i + 1; j < size; j++) {
				if(arr[minindex] > arr[j]) {
					minindex = j;
				}
			}
			int temp = arr[minindex];
			arr[minindex] = arr[i];
			arr[i] = temp;
 		}
	}
	public static void printArray(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[] arr = {66, 3, 22, 11, 13, 77};
		int size = arr.length;
		selectionsort(arr, size);
		printArray(arr);
	}
}
