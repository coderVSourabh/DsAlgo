package vSourabh.dataStructures.array;

import java.util.Arrays;

/**
 * @author Sourabh
 *
 */
public class CheckSubsetOfArray {

	/**
	 * Time Complexity : O(sizeB*log(sizeB) + sizeA*log(sizeA))
	 * Space Complexity: O(1)
	 */
	public boolean checkSubsetofArrayUsingSortingAndMerging(int[] arrA, int sizeA, int[] arrB, int sizeB) {
		if (sizeA < sizeB)
			return false;

		Arrays.sort(arrA);
		Arrays.sort(arrB);

		int i, j;
		i = j = 0;

		while (i < sizeA && j < sizeB) {
			if (arrA[i] < arrB[j]) {
				i++;
			} else if (arrA[i] > arrB[j]) {
				return false;
			} else {
				i++;
				j++;
			}
		}
		if (j < sizeB)
			return false;
		return true;
	}

	/**
	 * Time Complexity : O(sizeA*log(sizeA) + sizeB*log(sizeB))
	 * Space Complexity: O(1)
	 * 
	 */
	public boolean checkSubsetofArrayUsingSorting(int[] arrA, int sizeA, int[] arrB, int sizeB) {
		boolean isFound = false;
		Arrays.sort(arrA);
		for (int i = 0; i < sizeB; i++) {
			isFound = binarySearch(arrA, 0, sizeA - 1, arrB[i]);
			if (!isFound)
				return false;
		}
		return true;
	}

	private boolean binarySearch(int[] arr, int low, int high, int key) {
		int mid;
		while (low <= high) {
			mid = low + (high - low) / 2;
			if (arr[mid] == key)
				return true;
			else if (arr[mid] > key) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return false;
	}

	/**
	 * Time Complexity : O(n*n)
	 * Space Complexity: O(1)
	 * 
	 */
	public boolean checkSubsetofArrayBruteForce(int[] arrA, int sizeA, int[] arrB, int sizeB) {
		boolean isFound = false;
		for (int i = 0; i < sizeB; i++) {
			isFound = linearSearch(arrA, sizeA, arrB[i]);
			if (!isFound)
				return false;
		}
		return true;
	}

	private boolean linearSearch(int a[], int n, int key) {
		for (int i = 0; i < n; i++) {
			if (a[i] == key) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		CheckSubsetOfArray obj = new CheckSubsetOfArray();

		int a[] = { 11, 1, 13, 21, 3, 7 };
		int b[] = { 11, 3, 7, 1 };
		int m = a.length, n = b.length;

		boolean result = false;

		// Time : O(n2)
		System.out.println("Using Brute Force Version:");
		result = obj.checkSubsetofArrayBruteForce(a, m, b, n);
		System.out.println(result);

		// Time : O(mlogm+nlogm), Using Sorting
		System.out.println("Using Sorting Version:");
		result = obj.checkSubsetofArrayUsingSorting(a, m, b, n);
		System.out.println(result);

		// Time : O(mlogm+nlogn), Using Sorting and merging
		// this complexity is better than above
		System.out.println("Using sorting and Merging Version:");
		result = obj.checkSubsetofArrayUsingSortingAndMerging(a, m, b, n);
		System.out.println(result);

	}

}
