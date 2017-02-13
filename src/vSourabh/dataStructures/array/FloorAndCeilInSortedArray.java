package vSourabh.dataStructures.array;

/**
 * @author Sourabh
 * 
 * Given a sorted array and a value, 
 * the ceiling is the smallest element in array greater than or equal to the value,
 * and the floor is the greatest element smaller than or equal to value
 */
public class FloorAndCeilInSortedArray {
	
	/**
	 * Binary Search
	 * Time Complexity : O(log(n))
	 * Space Complexity: O(1)
	 */
	public int floor(int[] arr, int low, int high, int val) {
		
		if (high <= 0 || arr.length <= 0)
			return -1;
		if (val < arr[low])
			return Integer.MIN_VALUE;
		else if (val > arr[high])
			return arr[high];

		int mid;

		while (low <= high) {
			mid = low + (high - low) / 2;
			if (arr[mid] == val) {
				return arr[mid];
			}
			if (arr[mid] > val && arr[mid - 1] < val) {
				return arr[mid - 1];
			}

			if (arr[mid] >= val) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	/**
	 * Binary Search
	 * Time Complexity : O(log(n))
	 * Space Complexity: O(1)
	 */
	public int ceil(int[] arr, int low, int high, int val) {
		if (high <= 0 || arr.length <= 0)
			return -1;
		if (val < arr[0])
			return arr[0];
		else if (val > arr[high])
			return Integer.MAX_VALUE;

		int mid;

		while (low <= high) {
			mid = low + (high - low) / 2;
			if (arr[mid] == val) {
				return arr[mid];
			}
			if (val > arr[mid] && val < arr[mid + 1]) {
				return arr[mid + 1];
			}

			if (arr[mid] > val) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	/**
	 * Linear Search
	 * Time Complexity : O(n)
	 * Space Complexity: O(1)
	 */
	public int floorOfArrayBruteForce(int[] arr, int size, int val) {
		if (size <= 0)
			return -1;
		if (val < arr[0])
			return Integer.MIN_VALUE;
		if (val > arr[size - 1]) 
			return arr[size - 1];
		
		for (int i = 1; i < size; i++) {
			if (arr[i] == val) {
				return arr[i];
			} else if (val >= arr[i - 1] && val < arr[i]) {
				return arr[i - 1];
			}
		}
		return -1;
	}

	/**
	 * Linear Search
	 * Time Complexity : O(n)
	 * Space Complexity: O(1)
	 */
	public int celingOfArrayBruteForce(int[] arr, int size, int val) {
		if (size <= 0)
			return -1;
		if (val < arr[0]) {
			return arr[0];
		} else if (val > arr[size - 1]) {
			return Integer.MAX_VALUE;
		}
		for (int i = 0; i < size - 1; i++) {
			if (arr[i] == val) {
				return arr[i];
			} else if (val > arr[i] && val <= arr[i + 1]) {
				return arr[i + 1];
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		
		FloorAndCeilInSortedArray obj = new FloorAndCeilInSortedArray();

		int result = -1;
		int a[] = { 1, 2, 8, 10, 10, 12, 19 };
		int n = a.length, x = 9;
		
		System.out.println("*** Using Linear Search for Floor & Ceil for 9 ***");
		// Time : O(n)
		result = obj.celingOfArrayBruteForce(a, n, x);
		System.out.println("Ceil: " +result);
		result = obj.floorOfArrayBruteForce(a, n, x);
		System.out.println("FLoor: " +result);

		System.out.println("*** Using Linear Search for Floor & Ceil for 15 ***");
		// Time : O(log)
		x = 15;
		result = obj.floor(a, 0, n - 1, x);
		System.out.println("FLoor: " + result);
		result = obj.ceil(a, 0, n - 1, x);
		System.out.println("Ceil: " + result);


	}

}
