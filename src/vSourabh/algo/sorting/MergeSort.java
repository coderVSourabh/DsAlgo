package vSourabh.algo.sorting;

import vSourabh.dataStructures.utils.ArrayUtills;

/**
 * @author Sourabh
 *
 */
public class MergeSort {

	/**
	 * Merge uses divide and conquer method 
	 * i.e. array is divided into 2 sub-arrays
	 * and merged based on element order
	 * 
	 * Space Complexity = O(n) - as extra array is required to copy ;
	 * Time Complexity = O(n) - for comparing each element and copying
	 */
	void merge(int[] arr, int left, int mid, int right) {
		//Size of Sub-arrays 
		int sizeL = mid - left + 1, sizeR = right - mid;
		int arLeft[] = new int[sizeL], arRight[]  = new int[sizeR];
		
		//Inserting elements into sub-arrays
		for (int i = 0; i < sizeL;  i++)
			arLeft[i] = arr[left + i];
		for (int i = 0; i < sizeR;  i++)
			arRight[i] = arr[mid + i + 1];
		
		int i, j, k;
		// Merging both arrays
		for (k = left,i = 0, j = 0; k < right && i < sizeL && j < sizeR; k++) {
			if(arLeft[i] <= arRight[j]) {
				arr[k] = arLeft[i];
				i++;
			} else {
				arr[k] = arRight[j];
				j += 1;
			}
		}
		
		 // Copy remaining elements if any from Left Array
        while (i < sizeL) {
            arr[k] = arLeft[i];
            i++;
            k++;
        }
        // Copy remaining elements if any from Right Array
        while (j < sizeR)
            arr[k++] = arRight[j++];
        
	}
	
	/**
	 * LeetCode
	 * Merge 2 sorted arrays to one
	 *  
	 */
	public int[] merge(int A[], int m, int B[], int n) {
        int i=m-1;
		int j=n-1;
		int k = m+n-1;
		int[] arr = new int[k+1];
		while(i >=0 && j>=0) {
			if(A[i] > B[j])
				arr[k--] = A[i--];
			else
				arr[k--] = B[j--];
		}
		
		while(j>=0)
			arr[k--] = B[j--];
		
		while(i>=0)
			arr[k--] = A[i--];
		
		return arr;
    }
	
	/**
	 * mergeSort is done using merge function; 
	 * Space Complexity = O(n + Log(n)) = O(n)
	 *      O(Log(n) + 1) -> Size of the stack for recursion
	 *      O(n)          -> for merge function;
	 * Time Complexity = T(n) * O(n) = O(nLog(n))
	 *      T(n) = T(n\2) + T(n\2) = O(Log(n)) for recursion calls
	 *      O(n) = for merge function
	 * 
	 * @param arr - the array Element to be sorted
	 * @param indexL - Left Index for merging
	 * @param indexR - Right Index for merging
	 */
	public void mergeSort(int[] arr, int indexL, int indexR) {
		if (indexL < indexR) {
			int mid = (indexL + indexR) / 2;
			mergeSort(arr, indexL, mid);
			mergeSort(arr, mid + 1, indexR);
			merge(arr, indexL, mid, indexR);
		}
		
	}
	
	public static void main(String[] args) {
		int arr[] = {9, 6, 5, 0, 8, 2, -1, 10, 15, -5};
		MergeSort mSort = new MergeSort();
		mSort.mergeSort(arr, 0, arr.length -1);
		ArrayUtills.printArray(arr);
		
		int[] arrA = new int[]{1,4,6,8};
		int arrB[] = new int[]{2,3,5,7};
		int[] arrC = mSort.merge(arrA, 4 ,arrB, 4);
		ArrayUtills.printArray(arrA);
		ArrayUtills.printArray(arrB);
		ArrayUtills.printArray(arrC);
	}

}
