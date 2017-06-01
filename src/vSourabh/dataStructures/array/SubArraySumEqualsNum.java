package vSourabh.dataStructures.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Sourabh
 *
 */
public class SubArraySumEqualsNum {
	
	/**
	 * 
	 * LeetCode:
	 * Given an array of n positive integers and a positive integer s, 
	 * find the minimal length of a contiguous sub-array of which the 
	 * sum >= s. If there isn't one, return 0 instead.
	 * 
	 * For example, given the array [2,3,1,2,4,3] and s = 7,
	 * the sub-array [4,3] has the minimal length under the problem constraint.
	 * Time Complexity : O(n)
	 */
	public int minSubArrayLen(int s, int[] a) {
		if (a == null || a.length == 0)
			return 0;

		int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

		while (j < a.length) {
			sum += a[j++];

			while (sum >= s) {
				min = Math.min(min, j - i);
				sum -= a[i++];
			}
		}

		return min == Integer.MAX_VALUE ? 0 : min;
	}
	
	/**
	 * LeetCode:
	 * Given an array of n positive integers and a positive integer s, 
	 * find the minimal length of a contiguous sub-array of which the 
	 * sum >= s. If there isn't one, return 0 instead.
	 * 
	 * For example, given the array [2,3,1,2,4,3] and s = 7,
	 * the sub-array [4,3] has the minimal length under the problem constraint.
	 * Time Complexity : O(nLog(n))
	 */
	private int minSubArraySumLogN(int s, int[] nums) {
		int[] sums = new int[nums.length + 1];
		for (int i = 1; i < sums.length; i++) sums[i] = sums[i - 1] + nums[i - 1];
		int minLen = Integer.MAX_VALUE;
		for (int i = 0; i < sums.length; i++) {
			int end = binarySearch(i + 1, sums.length - 1, sums[i] + s, sums);
			if (end == sums.length) break;
			if (end - i < minLen) minLen = end - i;
		}
		return minLen == Integer.MAX_VALUE ? 0 : minLen;
	}

	private int binarySearch(int lo, int hi, int key, int[] sums) {
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (sums[mid] >= key){
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		return lo;
	}
	
	/**
	 * Given an array of integers and a number , find smallest 
	 * sub-array with sum greater than equal to the given value
	 */
	public int minSizeSubArraySum(int[] arr, int size, int num) {

		int sum = 0;
		int l = 0;
		int minSize = Integer.MAX_VALUE;
		int minSizeLeft = Integer.MAX_VALUE;
		int minSizeRight = Integer.MAX_VALUE;

		for (int i = 0; i < size; i++) {
			if (arr[i] >= num) 
				return 1; // Return if value >=  target
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
		
		System.out.println("\n************ Smallest SubArray Sum greater than 280******************");
		obj.minSizeSubArraySum(arr, arr.length, 280);
		
		System.out.println("\n************ Smallest SubArray Sum Equals to k******************");
		obj.subArraysOfSumEqualsNum(arr, arr.length, 290);
		obj.subArraysOfSumEqualsToK(arr, 304);
		obj.subArraysOfSumEqualsToNum(arr, 113);
		
		System.out.println("\n************ Smallest SubArray Sum Equals to 0******************");
		arr = new int[]{ 6, 2, 4, 3, -2, -2, -2, -1, -1, 3 };
		boolean boolResult = obj.subArraysOfSumEqualsToZero(arr, arr.length);
		System.out.println("***Result*** " + boolResult);
		
		arr = new int[] {1, 3, 4, 6, 7, 9};
		int[] result = obj.twoSum(arr, 9);
		System.out.println("the numbers are "+ arr[result[0]] + "," + arr[result[1]]);
		
		arr = new int[] {2,3,1,2,4,3};
		int minVal = obj.minSubArrayLen(7, arr);
		System.out.println("The Minimum Size Subarray Sum : " + minVal);
	
		minVal = obj.minSubArraySumLogN(7, arr);
		System.out.println("The Minimum Size Subarray Sum : " + minVal);
	}

}
