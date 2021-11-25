package DataStructure;
/*
 * Imtiaz Adar
 * Binary Search
 */
public class Binary_Search {

	public static int binary_search(int[] arr, int ele) {
		int left = 0;
		int right = arr.length - 1;
		while(left <= right) {
			int mid = left + (right - left) / 2;
			if(arr[mid] == ele)
				return mid;
			else if(arr[mid] < ele)
				left = mid + 1;
			else right = mid - 1;
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40, 50, 60, 70};
		int pos = binary_search(arr, 50);
		if(pos != -1)
			System.out.println("Element exists in position : " + pos);
		else System.out.println("Element Not exists");
	}
}
