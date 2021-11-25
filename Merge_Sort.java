package DataStructure;
/*
 * Imtiaz Adar
 * Merge Sort
 */
public class Merge_Sort {

	public static void merge_sort(int[] arr, int l, int mid, int r) {
		int n1 = mid - l + 1;
		int n2 = r - mid;
		int[] left = new int[n1];
		int[] right = new int[n2];
		for(int i = 0; i < n1; i++) {
			left[i] = arr[l + i];
		}
		for(int i = 0; i < n2; i++) {
			right[i] = arr[mid + i + 1];
		}
		int i = 0, j = 0, k = l;
		while(i < n1 && j < n2) {
			if(left[i] <= right[j]) {
				arr[k] = left[i];
				i++;
			}
			else {
				arr[k] = right[j];
				j++;
			}
			k++;
		}
		while(i < n1) {
			arr[k] = left[i];
			i++;
			k++;
		}
		while(j < n2) {
			arr[k] = right[j];
			j++;
			k++;
		}
	}
	public static void merge(int[] arr, int l, int r) {
		if(l < r) {
			int mid = l + (r - l) / 2;
			merge(arr, l, mid);
			merge(arr, mid + 1, r);
			merge_sort(arr, l, mid, r);
		}
	}
	public static void printArray(int[] arr) {
		for(Integer item : arr) {
			System.out.print(item + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[] arr = {4, 12, 7, 23, 25, 24, 55, 33, 37, 9};
		merge(arr, 0, arr.length - 1);
		printArray(arr);
	}
}
