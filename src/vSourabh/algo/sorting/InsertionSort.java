package vsourabh.algo.sorting;

import vsourabh.datastructures.utils.ArrayUtills;

/**
 * @author Sourabh
 *
 */
public class InsertionSort {
	
	//private static int loopCount;
	/** Sorting only in Ascending order 
	 * Time Complexity is O(n*n) 
	 * Space Complexity is O(1) i.e. in-place */
	public void insertionSort(int[] arr) {
		for(int i = 1; i < arr.length ; i++) {
			int currentCompare = arr[i];
			int j = i - 1;
			while(j >= 0 && arr[j] > currentCompare) {
				arr[j+1] = arr[j];
				j--; 
				//loopCount++;
			}
			arr[j+1] = currentCompare;
		}
		
	}
	
	/** Sorting ascending or descending order based on isAscending flag 
	 * Time Complexity is O(n*n) 
	 * Space Complexity is O(1) i.e. in-place */
	public void insertionSort(int[] arr, boolean isAscending) {
		if(isAscending)
			insertionSort(arr);
		else {
			for(int i = 1; i < arr.length ; i++) {
				int currentCompare = arr[i];
				int j = i - 1;
				while(j >= 0 && arr[j] < currentCompare) {
					arr[j+1] = arr[j];
					j--; 
					//loopCount++;
				}
				arr[j+1] = currentCompare;
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("INSERTION SORT");
		
		int arr[] = { 10, 1, 9, 6, 8, 0, 2, 7, 3, -1 , -5, -10 };
		ArrayUtills.printArray(arr);
		InsertionSort iSort = new InsertionSort();
		System.out.print("Sorted Ascending ");
		iSort.insertionSort(arr, true);
		//System.out.println("Loop Executed  " + loopCount);
		//loopCount = 0;
		ArrayUtills.printArray(arr);
		
		System.out.print("Sorted Descending ");
		iSort.insertionSort(arr, false);
		//System.out.println("Loop Executed  " + loopCount);
		ArrayUtills.printArray(arr);
	}

}
