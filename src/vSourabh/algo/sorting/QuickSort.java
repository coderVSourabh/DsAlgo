package vSourabh.algo.sorting;

import vSourabh.dataStructures.utils.ArrayUtills;

/**
 * @author Sourabh
 *
 */
public class QuickSort {

	//private static int loopCount;
	/**
	 *  This function takes last element and
	 *  places at its correct position in sorted
	 *  array, and places all smaller element to 
	 *  left and all greater elements to right
	 *  
	 *  Space Complexity = O(1) -> no new elements required
	 *  Time Complexity = O(n)  -> compare each element and put 
	 * 	 						one element in correct position 
	 */
	int partition(int[] arr, int left, int right) {
		
		int element = arr[right], i = left - 1;
		
		for(int j = left; j <= right - 1; j++ ) {
			//loopCount++;
			if(arr[j] <= element) 
				ArrayUtills.swap(arr, j, ++i);
		}
		ArrayUtills.swap(arr, ++i, right);
		return i;
	}
	
	/**
	 *  This function takes last element and
	 *  places at its correct position in sorted
	 *  array, and places all smaller element to 
	 *  left and all greater elements to right
	 *  
	 *  Space Complexity = O(1) -> no new elements required
	 *  Time Complexity = O(n)  -> compare each element and put 
	 * 	 						one element in correct position 
	 */
	int partition(int[] arr, int left, int right, boolean isAscending) {
		int i;
		if(isAscending)
			i = partition(arr, left, right);
		else {
			
			int element = arr[right];
			i = left - 1;
			
			for(int j = left; j <= right - 1; j++ ) {
				//loopCount++;
				if(arr[j] >= element) 
					ArrayUtills.swap(arr, j, ++i);
			}
		ArrayUtills.swap(arr, ++i, right);
		}
		return i;
	}
	
	/**
	 * quickSort also use Partition function to sort the elements
	 * 
	 *  Space Complexity : O(n) worst case and O(Log(n)) average case
	 *  Time Complexity : O(n*n) worst case and O(nLog(n)) average case
	 *                   Worst case O(n) - Partition function
	 *                   T(0) + T(n-1) + .. = O(n) i.e. all elements one 
	 *                   side of the chosen element
	 */
	public void quickSort(int[] arr, int left, int right) {
		if(left < right) {
			int mid = partition(arr, left, right);
			quickSort(arr, left, mid - 1);
			quickSort(arr, mid + 1, right);
		}
	}
	
	
	/**
	 * quickSort also use Partition function to sort the elements
	 * 
	 *  Space Complexity : O(n) worst case and O(Log(n)) average case
	 *  Time Complexity : O(n*n) worst case and O(nLog(n)) best case
	 *                   Worst case O(n) - Partition function
	 *                   T(0) + T(n-1) + .. = O(n) 
	 */
	public void quickSort(int[] arr, int left, int right, boolean isAscending) {
		if (isAscending)
			quickSort(arr, left, right);
		else
		if(left < right) {
			int mid = partition(arr, left, right, isAscending);
			quickSort(arr, left, mid - 1, isAscending);
			quickSort(arr, mid + 1, right, isAscending);
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println("QUICK SORT");
		
		int arr[] = {5, 7, 6, 1, 3, 2, 4};
		ArrayUtills.printArray(arr);
		QuickSort qSort = new QuickSort();
		System.out.print("Sorted Ascending ");
		qSort.quickSort(arr, 0, arr.length - 1);
		//System.out.println("Loop Executed " + loopCount);
		//loopCount = 0;
		ArrayUtills.printArray(arr);
		
		System.out.print("Sorted Descending ");
		qSort.quickSort(arr, 0, arr.length - 1, false);
		//System.out.println("Loop Executed " + loopCount);
		ArrayUtills.printArray(arr);
	}

}
