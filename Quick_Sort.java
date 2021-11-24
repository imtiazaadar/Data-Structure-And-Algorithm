package DataStructure;
/*
 * Imtiaz Adar
 * Quick Sort
 */
public class Quick_Sort {

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static int partial(int[] arr, int low, int high) {
		int higher = arr[high];
		int i = low - 1;
		for(int j = low; j <= high - 1; j++) {
			if(arr[j] < higher) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return i + 1;
	}
	public static void quicksort(int[] arr, int low, int high) {
		if(low < high) {
			int part = partial(arr, low, high);
			quicksort(arr, low, part - 1);
			quicksort(arr, part + 1, high);
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
		quicksort(arr, 0, arr.length - 1);
		printArray(arr);
	}
}
