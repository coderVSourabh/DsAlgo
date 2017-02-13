package vSourabh.dataStructures.utils;

/**
 * @author Sourabh
 *
 */
public class ArrayUtills {

	/** Printing the integer array elements */
	public static void printArray(int[] arr) {
		System.out.print("The Array is : ");
		for(int i = 0; i < arr.length - 1; i++) {
			System.out.print(arr[i] + " , ");
		}
		// For avoiding last comma in the print statement
		System.out.println(arr[arr.length-1]);
	}
	
	/** Printing the character array elements */
	public static void printArray(char[] arr) {
		System.out.print("The Array is : ");
		for(int i = 0; i < arr.length - 1; i++) {
			System.out.print(arr[i] + " , ");
		}
		// For avoiding last comma in the print statement
		System.out.println(arr[arr.length-1]);
	}
	
	/** Printing the array object elements */
	public static void printArray(Object[] arr) {
		System.out.print("The Array is : ");
		for(Object obj : arr) {
			System.out.print(obj + "  ");
		}
		System.out.print("\n");
	}
	
	/** Printing the 2D array of object elements */
	public static void printArray(Object[][] arr, int start, int end) {
		for (int i = 0; i < start; i++) {
			for (int j = 0; j < end; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	/** Printing the character 2D array elements */
	public static void printArray(char[][] arr, int start, int end) {
		for (int i = 0; i < start; i++) {
			for (int j = 0; j < end; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	/** Printing the integer 2D array elements */
	public static void printArray(int[][] arr, int start, int end) {
		for (int i = 0; i < start; i++) {
			for (int j = 0; j < end; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * Swap the element in the original Array 
	 * as reference object is passed
	 * @param arr = reference object to integer array
	 * @param left = left element 
	 * @param right = right element
	 */
	public static void swap (int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
	
	/**
	 * Swap the element in the original Array 
	 * as reference object is passed
	 * @param arr = reference object to character array
	 * @param left = left element 
	 * @param right = right element
	 */
	public static void swap (char[] arr, int left, int right) {
		char temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
	
	/**
	 * Swap the element in the original Array 
	 * as reference object is passed
	 * @param arr = reference object to array of objects
	 * @param left = left element 
	 * @param right = right element
	 */
	public static void swap (Object[] arr, int left, int right) {
		Object temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
	
}
