package vSourabh.dataStructures.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Sourabh
 *
 */
public class SubArraySumEqualsNum {
	
	/**
	 * Given an array of integers and a number , find smallest 
	 * sub-array with sum greater than the given value
	 */
	public int smallestSubArrayOfSumGreatherThanNum(int[] arr, int size, int num) {

		int sum = 0;
		int l = 0;
		int minSize = Integer.MAX_VALUE;
		int minSizeLeft = Integer.MAX_VALUE;
		int minSizeRight = Integer.MAX_VALUE;

		for (int i = 0; i < size; i++) {
			if (arr[i] > num) {
				return 1;
			}
			sum += arr[i];
			while (sum > num && l <= i) {
				if (i - l + 1 < minSize) {
					minSize = i - l + 1;
					minSizeLeft = l;
					minSizeRight = i;
				}
				sum -= arr[l++];
			}
		}
		if (minSize != Integer.MAX_VALUE)
			printSubarray(arr, minSizeLeft, minSizeRight);

		return minSize;
	}
	
	public void subArraysOfSumEqualsToNum(int[] arr, int num) {

		int l = 0, r = 0;
		int sum = arr[r];
		while (true) {
			if (sum < num) {
				r++;
				if (r == arr.length)
					return;
				sum += arr[r];
			} else if (sum > num) {
				sum -= arr[l++];
			} else {
				printSubarray(arr, l, r);
				sum = 0;
				l = r + 1;
			}
		}
	}
	
	/**
	 * LeetCode
	 * In sorted in ascending order, find two numbers such 
	 * that they add up to a specific target number.
	 * 
	 * Input: numbers={2, 7, 11, 15}, target=9
	 * Output: index1=1, index2=2
	 */
	public int[] twoSum(int[] num, int target) {
	    int[] indice = new int[2];
	    if (num == null || num.length < 2) return indice;
	    int left = 0, right = num.length - 1;
	    while (left < right) {
	        int v = num[left] + num[right];
	        if (v == target) {
	            indice[0] = left + 1;
	            indice[1] = right + 1;
	            break;
	        } else if (v > target) {
	            right --;
	        } else {
	            left ++;
	        }
	    }
	    return indice;
	}

	// assumption is k >=1
	public void subArraysOfSumEqualsToK(int[] arr, int k) {

		int sum = 0;
		int l = 0;

		for (int r = 0; r < arr.length; r++) {
			sum += arr[r];
			while (sum > k && l <= r) {
				sum -= arr[l++];
			}
			if (sum == k) {
				printSubarray(arr, l, r);
				sum = 0;
				l = r + 1;
			}
		}
	}

	// assumption is k >=1
	public void subArraysOfSumEqualsNum(int[] a, int n, int num) {

		int sum = 0;
		int l = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] == num) {
				printSubarray(a, i, i);
				l = i + 1;
				sum = 0;
				continue;
			}

			sum += a[i];

			while (l <= i && sum > num) {
				sum -= a[l++];
			}

			if (sum == num) {
				printSubarray(a, l, i);
				sum = 0;
				l = i + 1;
			}

		}
	}
	
	public boolean subArraysOfSumEqualsToZero(int[] arr, int size) {

		int sum = 0;
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < size; i++) {
			sum += arr[i];
			if (arr[i] == 0 || sum == 0 || set.contains(sum)) {
				return true;
			}
			set.add(sum);
			System.out.println(set);
		}
		return false;
	}
	
	private static void printSubarray(int[] a, int l, int r) {
		for (int i = l; i <= r; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		SubArraySumEqualsNum obj = new SubArraySumEqualsNum();
		
		int[] arr = new int[]{ 1, 11, 100, 1, 0, 200, 3, 2, 35, 250 };
		
		System.out.println("\n************ Smallest SubArray Sum greater than k******************");
		obj.smallestSubArrayOfSumGreatherThanNum(arr, arr.length, 280);
		
		System.out.println("\n************ Smallest SubArray Sum Equals to k******************");
		obj.subArraysOfSumEqualsNum(arr, arr.length, 290);
		obj.subArraysOfSumEqualsToK(arr, 304);
		obj.subArraysOfSumEqualsToNum(arr, 113);
		
		System.out.println("\n************ Smallest SubArray Sum Equals to 0******************");
		arr = new int[]{ 6, 2, 4, 3, -2, -2, -2, -1, -1, 3 };
		boolean boolResult = obj.subArraysOfSumEqualsToZero(arr, arr.length);
		System.out.println("***Result***" + boolResult);
		
		arr = new int[] {1, 3, 4, 6, 7, 9};
		int[] result = obj.twoSum(arr, 9);
		System.out.println("the numbers are "+ arr[result[0]] + "," + arr[result[1]]);
	
	}

}
