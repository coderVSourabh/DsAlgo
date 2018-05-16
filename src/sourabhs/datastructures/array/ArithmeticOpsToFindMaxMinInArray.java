package sourabhs.datastructures.array;

import java.util.Stack;

import sourabhs.algo.sorting.QuickSort;

/**
 * @author Sourabh
 * 
 * This Class is used to find following operations:
 * Maximum and Minimum sum of contiguous elements in the array
 * Maximum product of contiguous elements in the array
 * Maximum product of 3 increasing sequence elements of a positive array
 * Maximum and Minimum difference of 2 elements in the unsorted array
 */
public class ArithmeticOpsToFindMaxMinInArray {
	
	/**
	 * LeetCode:
	 * 
	 * Time Complexity : O(n)
	 * Space Complexity: O(1)
	 * Also know as Kadane’s Algorithm
     * Given an array to find the sum of 
     * contiguous sub-array with largest sum
	 */
	public int maxContiguousSumInArray(int[] array) {
		int maxSum = Integer.MIN_VALUE, maxCurr = 0;
		
		for(int i = 0; i < array.length; i++) {
			maxCurr = maxCurr < (maxCurr + array[i]) ? (maxCurr + array[i]) : 0;
			maxSum  = Integer.max(maxSum, maxCurr);
		}
		return maxSum;
	}
	
	/**
	 * Time Complexity : O(n)
	 * Space Complexity: O(1)
	 */
	public int minContiguousSumInArray(int[] array) {
		int minSum = Integer.MAX_VALUE, minCurr = 0;
		
		for(int i = 0; i < array.length; i++) {
			minCurr = minCurr > (minCurr + array[i]) ? (minCurr + array[i]) : 0;
			minSum  = Integer.min(minSum, minCurr);
		}
		return minSum;
	}

	/**
	 * Sum of the largest 2 elements in the array
	 * Time Complexity : O(n)
	 * Space Complexity: O(1)
	 */
	public int maxPairSumInArray(int[] arr, int size) {

		if (size < 2)
			return -1;

		int firstmax, secondmax;
		secondmax = Integer.MIN_VALUE;
		firstmax = arr[0];
		for (int i = 1; i < size; i++) {
			if (arr[i] > firstmax) {
				secondmax = firstmax;
				firstmax = arr[i];
			}
			else if (arr[i] > secondmax) {
				secondmax = arr[i];
			}
		}

		System.out.print("\n\n 1st Max=" + firstmax + ",2nd Max=" + secondmax);
		return firstmax + secondmax;
	}
	
	/**
	 * Time Complexity : O(n)
	 * Space Complexity: O(1)
	 */
	public int maxContiguousProductInArray(int[] arr, int n) {
		int maxProduct = Integer.MIN_VALUE;
		if (n <= 0)
			return maxProduct;

		int maxEndingHere = arr[0];
		int minEndingHere = arr[0];
		maxProduct = arr[0];

		int tempMax, tempMin;
		for (int i = 1; i < n; i++) {
			tempMax = maxEndingHere;
			tempMin = minEndingHere;
			maxEndingHere = Math.max(arr[i], Math.max(tempMax * arr[i], tempMin * arr[i]));
			minEndingHere = Math.min(arr[i], Math.min(tempMax * arr[i], tempMin * arr[i]));
			maxProduct = Math.max(maxEndingHere, maxProduct);
		}
		return maxProduct;
	}
	
	/**
	 * Given a sequence of non-negative integers, find the subsequence of length 3
	 * having maximum product with the numbers of the subsequence being in ascending order
	 * Examples: array[] = {1, 5, 10, 8, 9} -> Output: 5 8 9
	 * 
	 * Time Complexity : O(nLog(n))
	 * Space Complexity: O(n)
	 */
	public int max3ElementProductInArrayWithIncreasingSequence(int[] arr) {
		int result = -1, size = arr.length;
		if(size < 3)
			return result;
			
		int largestSmallerOnleft[] = new int[size];
		int largestGreaterOnRight[] = new int[size];
		int maxCurr =  - 1;
		for (int i = size - 1; i >= 0; i--) {
			if (arr[i] > maxCurr) {
				maxCurr = arr[i];
				largestGreaterOnRight[i] = -1;
			} else {
				largestGreaterOnRight[i] = maxCurr;
			}
		}
		
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < size; i++) {
			if (largestGreaterOnRight[i] == -1) {
				largestSmallerOnleft[i] = -1;
				continue;
			}
			maxCurr = -1;
			while (!stack.isEmpty() && arr[i] > stack.peek()) {
				maxCurr = stack.pop();
			}
			largestSmallerOnleft[i] = maxCurr;
			stack.push(arr[i]);
		}
		
		/*System.out.print("\n  largestSmallerOnleft: ");
		ArrayUtills.printArray(largestSmallerOnleft);
		System.out.print("  Original: ");
		ArrayUtills.printArray(arr);
		System.out.print("  largestGreaterOnRight:");
		ArrayUtills.printArray(largestGreaterOnRight);*/
		int b, c, d, curProd;
		b = c = d = result = curProd =  0;
		for (int i = 0; i < size; i++) {
			curProd = largestSmallerOnleft[i] * largestGreaterOnRight[i] * arr[i];
			if (curProd > result) {
				result = curProd;
				b = largestSmallerOnleft[i];
				c = arr[i];
				d = largestGreaterOnRight[i];
			}
		}
		System.out.print(" \n\n Increasing Sequence 1st Max=" + b + ",2nd Max=" + c + ",3rd Max=" + d);
				
		return result;
	}

	/**
	 * Time Complexity : O(n)
	 * Space Complexity: O(1)
	 */
	public int maxDiffOfTwoElementInArray(int[] arr, int n) {
		int maxDiff = Integer.MIN_VALUE;
		int maxCurr = arr[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			if (maxCurr - arr[i] > maxDiff) {
				maxDiff = maxCurr - arr[i];
			}
			if (arr[i] > maxCurr) {
				maxCurr = arr[i];
			}
		}
		return maxDiff;
	}

	/**
	 * The function assumes that there are at least two elements in array. The
	 * function returns a negative value if the array is sorted in decreasing
	 * order. Returns 0 if elements are equal
	 * Time Complexity : O(n)
	 * Space Complexity: O(1)
	 */
	public int maxDiffOfTwoElementInArrayV2(int[] arr, int n) {
		int maxDiff = Integer.MIN_VALUE;
		int minCurr = arr[0];
		for (int i = 1; i < n; i++) {
			if (arr[i] - minCurr > maxDiff) {
				maxDiff = arr[i] - minCurr;
			}
			if (arr[i] < minCurr) {
				minCurr = arr[i];
			}
		}
		return maxDiff;
	}

	/**
	 * Time Complexity : O(n*n)
	 * Space Complexity: O(1)
	 */
	public int maxDiffOfTwoElementInArrayBruteForce(int[] arr, int n) {
		int maxDiff = Integer.MIN_VALUE;
		//int maxPair1 = -1;
		//int maxPair2 = -1;

		int diff = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (arr[j] > arr[i]) {
					diff = arr[j] - arr[i];
					if (diff > maxDiff) {
						maxDiff = diff;
						//maxPair1 = arr[i];
						//maxPair2 = arr[j];
					}
				}
			}
		}
		//System.out.println(" 1st=" + maxPair2 + ",2nd=" + maxPair1 + ":: Diff=" + maxDiff);
		return maxDiff;
	}
	
	/**
	 * Time Complexity : O(n * n)
	 * Space Complexity: O(1)
	 */
	public int minDiffOfTwoElementInArrayBruteForce(int[] arr, int n) {
		int diff = Integer.MAX_VALUE;
		for (int i = 0; i < n-1; i++)
			for (int j = i+1; j < n; j++)
				if (Math.abs(arr[i] - arr[j]) < diff)
					diff =Math.abs(arr[i] - arr[j]);
		 return diff;
	}
	
	/**
	 * Time Complexity : O(n Log(n))
	 * Space Complexity: O(1)
	 */
	public int minDiffOfTwoElementInArrayWithSorting(int[] arr, int n) {
		
		new QuickSort().quickSort(arr, 0, n - 1, false);
		int minDiff = Integer.MAX_VALUE;
		for (int i = n-1; i > 0; i--)
			if (Math.abs(arr[i] - arr[i -1]) < minDiff)
				minDiff = Math.abs(arr[i] - arr[i - 1]);
		return minDiff;
	}
	
	
	public static void main(String[] args) {
		ArithmeticOpsToFindMaxMinInArray obj = new ArithmeticOpsToFindMaxMinInArray();
		int arr[] =  {-2, -3, 4, -1, -2, 1, 5, -3};
		int result = obj.maxContiguousSumInArray(arr);
		System.out.printf(" Maximum contiguous sum is %d", result);
		
		result = obj.minContiguousSumInArray(arr);
		System.out.printf("\n Minimum contiguous sum is %d", result);
		
		result = obj.maxContiguousProductInArray(arr, arr.length);
		System.out.printf("\n Maximum contiguous Product is %d", result);
		
		result = obj.maxDiffOfTwoElementInArray(arr, arr.length);
		System.out.printf("\n Maximum Difference V1 is %d", result);
		
		arr = new int[]  { 3, 2, 10, 6, 13, 8, 1 };
		result = obj.maxDiffOfTwoElementInArrayV2(arr, arr.length);
		System.out.printf("\n Maximum Difference V2 is %d", result);
		
		result = obj.maxDiffOfTwoElementInArrayBruteForce(arr, arr.length);
		System.out.printf("\n Maximum Difference V3 is %d", result);
		
		arr = new int[]  { -2, -12, 21, 1, 15, 8, -7 };
		result = obj.minDiffOfTwoElementInArrayBruteForce(arr, arr.length);
		System.out.printf("\n Minimum Difference Brute Force is %d", result);
	
		result = obj.minDiffOfTwoElementInArrayWithSorting(arr, arr.length);
		System.out.printf("\n Mainimum Difference With Sorting %d", result);
		arr = new int[]  { 3, 2, 10, 6, 13, 8, 1 };

		arr = new int[]  { 3, 2, 10, 16, 13, 8, 1 };
		result = obj.max3ElementProductInArrayWithIncreasingSequence(arr);
		System.out.printf("\n Maximum Product of 3 elements is  %d", result);
		
		result = obj.maxPairSumInArray(arr, arr.length);
		System.out.printf("\n Sum of Max 2 elements is  %d", result);
	}

}
