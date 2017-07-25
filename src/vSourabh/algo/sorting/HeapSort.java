package vsourabh.algo.sorting;

import vsourabh.datastructures.utils.ArrayUtills;

/**
 * @author Sourabh
 */
//TODO ExtractMax and ExtractMin and IncreaseElement needs to corrected
public class HeapSort {
	
	public int size;
	//private static int loopCount;
	
	/**
	 * Used to sort the tree with root being the max
	 * Time Complexity = O(Log(n)) -> same as height of tree
	 * Space Complexity O(Log(n)) -> Recursion stack size 
	 */
	void maxHeapify(int[] arr, int index) {
		//loopCount++;
		int largest, left, right;
		left = 2 * index + 1;
		right =  2 * index + 2; 
		largest = index;
		if (left < size && arr[left] > arr[largest])
	            largest = left;	
		
		if (right < size && arr[right] > arr[largest])
			largest = right;
		
		// If largest is not root
	    if (largest != index) {
	    	ArrayUtills.swap(arr, index, largest);
	    	maxHeapify(arr, largest);
	    }
	}

	/**
	 * Used to sort the tree with root being the max
	 * Time Complexity = O(Log(n)) -> same as height of tree
	 * Space Complexity O(Log(n)) -> Recursion stack size 
	 */
	void minHeapify(int arr[], int index) {
		//loopCount++;
		int smallest, left, right;
		left = 2 * index + 1;
		right =  2 * index + 2; 
		smallest = index;
		if (left < size && arr[left] < arr[smallest])
	            smallest = left;
	 
		if (right < size && arr[right] < arr[smallest])
			smallest = right;
		
		// If largest is not root
	    if (smallest != index) {
	    	ArrayUtills.swap(arr, index, smallest);
	    	minHeapify(arr, smallest);
	    }
	}
	
	/**
	 * Build-Heap always works at a level Upper[n/2^(n+1)]
	 * i.e. only at one level in the tree
	 * Time Complexity = O(n)
	 * Space Complexity = O(Log(n)) due to stack
	 */
	public void buildHeap(int arr[], boolean isMaxHeap) {
		if(isMaxHeap)
			for (int i = size / 2 - 1; i >= 0; i--) {
				maxHeapify(arr, i);
			}
		else 
			for (int i = size / 2 - 1; i >= 0; i--) {
				minHeapify(arr, i);
			}
	}
	
	public void heapify(int[] arr, int index, boolean isMaxHeap) {
		if(isMaxHeap) 
			maxHeapify(arr, index);
		else 
			minHeapify(arr, index);
	}
	/**
	 * n times heapify
	 * Time Complexity = O(nLog(n))
	 * Space Complexity = O(nLog(n))
	 */
	public void heapSort(int[] arr, boolean isMaxHeap){
		this.size = arr.length;
		this.buildHeap(arr, isMaxHeap);

		for (int i = size - 1; i > 0; i--) {
			ArrayUtills.swap(arr, 0, i);
			this.size = i;
			heapify(arr, 0, isMaxHeap);
		}
	}
	/**
	 * Extract the First Max and last element
	 * will be duplicated as array size can't
	 * be reduced in java and Arrange the tree again
	 * Time Complexity = O(Log(n))
	 * Space Complexity = O(Log(n))
	 */
	public int extractMax(int[] arr) {
		if (arr.length <= 0)
			return -1;
		int max = arr[0];
		arr[0] = arr[arr.length - 1];
		this.size = arr.length - 1;
		maxHeapify(arr, 0);
		return max;
	}
	
	/**
	 * Extract the First Max and last element
	 * will be duplicated as array size can't
	 * be reduced in java and Arrange the tree again
	 * Time Complexity = O(Log(n))
	 * Space Complexity = O(Log(n))
	 */
	public int extractMin(int[] arr) {
		if (arr.length <= 0)
			return -1;
		int max = arr[0];
		arr[0] = arr[arr.length - 1];
		this.size = arr.length - 1;
		minHeapify(arr, 0);
		return max;
	}
	
	public void increaseElement(int arr[], int index, int value) {
		if (index > arr.length)
			return;
		
		if(value < arr[index]) 
			return;
		arr[index] = value;
		int parent = (index % 2 == 0) ? (index / 2 - 1) : index / 2;
		while(parent >= 0 &&  arr[parent] < arr[index]) {
			ArrayUtills.swap(arr, index, index/2);
			parent = (index % 2 == 0) ? (index / 2 - 1) : index / 2;
		}
	}
	
	public void decreaseKey(int arr[], int index, int value) {
		if (index < 0 || index >= size)
			return;
		if (arr[index] < value) 
			return;
		
		arr[index] = value;
		int parent = (index % 2 == 0) ? (index / 2 - 1) : index / 2;

		while (parent >= 0 && arr[parent] > arr[index]) {
			ArrayUtills.swap(arr, index, parent);
			index = parent;
			parent = (index % 2 == 0) ? (index / 2 - 1) : index / 2;
		}
	}

	public static void main(String[] args) {
		System.out.println("HEAP SORT");
		int arr[] = {12, 11, 13, 5, 6, 7, -2, 0, 15, 1, -1};
		ArrayUtills.printArray(arr);
		
		HeapSort hSort = new HeapSort();
		hSort.heapSort(arr, false);
		//System.out.println("Loop Executed " + loopCount);
		//loopCount = 0;
		System.out.print("Sorted Descending or MinHeap  ");
		ArrayUtills.printArray(arr);
		
		System.out.print("Increase element 6 to 16 ");
		hSort.increaseElement(arr, 6, 16);
		ArrayUtills.printArray(arr);
		
		System.out.println("Extract Maximum :" + hSort.extractMax(arr));
		ArrayUtills.printArray(arr);
		
		hSort.heapSort(arr, true);
		//System.out.println("Loop Executed " + loopCount);
		System.out.print("Sorted Ascending or MaxHeap ");
		ArrayUtills.printArray(arr);

		System.out.println("Minimun is :" + hSort.extractMin(arr));
		ArrayUtills.printArray(arr);
	}
}
