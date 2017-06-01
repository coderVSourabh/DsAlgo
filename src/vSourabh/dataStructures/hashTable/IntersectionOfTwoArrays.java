package vSourabh.dataStructures.hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import vSourabh.dataStructures.utils.ArrayUtills;

/**
 * @author Sourabh
 * 
 * LeetCode:
 * 
 * Intersection of Two Arrays: int[] intersection
 * 
 * Intersection of Two Arrays II: int[] intersect
 */
public class IntersectionOfTwoArrays {

	/**
	 * 
	 * LeetCode:
	 * Intersection of Two Arrays II
	 * 
	 * Given two arrays, write a function to compute their intersection.
	 *
	 * Example:
	 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
	 * 
	 * Note:
	 * Each element in the result should appear as many times as 
	 * it shows in both arrays.
	 * The result can be in any order.
	 * 
	 * Follow up:
	 * What if the given array is already sorted? 
	 * How would you optimize your algorithm?
	 * What if nums1's size is small compared to nums2's size? 
	 * Which algorithm is better?
	 * 
	 * What if elements of nums2 are stored on disk, and the 
	 *    memory is limited such that you cannot load all elements 
	 *    into the memory at once?
	 *    Ans: If only nums2 cannot fit in memory, put all elements 
	 *        of nums1 into a HashMap, read chunks of array that fit 
	 *        into the memory, and record the intersections.  
	 *        If both nums1 and nums2 are so huge that neither fit 
	 *        into the memory, sort them individually (external sort), 
	 *        then read 2 elements from each array at a time in memory, 
	 *        record intersections.
	 */

	public int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> result = new ArrayList<>();
		for(int i = 0; i < nums1.length; i++) {
			if(map.containsKey(nums1[i])) 
				map.put(nums1[i], map.get(nums1[i])+1);
			else 
				map.put(nums1[i], 1);
		}

		for(int i = 0; i < nums2.length; i++) {
			if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
				result.add(nums2[i]);
				map.put(nums2[i], map.get(nums2[i])-1);
			}
		}

		int[] r = new int[result.size()];
		for(int i = 0; i < result.size(); i++) {
			r[i] = result.get(i);
		}

		return r;
	}
	
	/**
	 * Given two arrays, write a function to compute their intersection.
	 * Example:
	 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
	 * 
	 * Note:
	 * Each element in the result must be unique.
	 * The result can be in any order.
	 */
	//Time Complexity : O(n)
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
		Set<Integer> intersect = new HashSet<>();
		for (int i = 0; i < nums1.length; i++) {
			set.add(nums1[i]);
		}
		for (int i = 0; i < nums2.length; i++) {
			if (set.contains(nums2[i])) {
				intersect.add(nums2[i]);
			}
		}
		int[] result = new int[intersect.size()];
		int i = 0;
		for (Integer num : intersect) {
			result[i++] = num;
		}
		return result;
	}
	
	//Time Complexity : O(nLog(n))
	public int[] intersectionUsingSort(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i = 0;
		int j = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				i++;
			} else if (nums1[i] > nums2[j]) {
				j++;
			} else {
				set.add(nums1[i]);
				i++;
				j++;
			}
		}
		int[] result = new int[set.size()];
		int k = 0;
		for (Integer num : set) {
			result[k++] = num;
		}
		return result;
	}
	
	//Time Complexity : O(nLog(n))
	public int[] intersectionUsingBinarySearch(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
		Arrays.sort(nums2);
		for (Integer num : nums1) {
			if (binarySearch(nums2, num)) {
				set.add(num);
			}
		}
		int i = 0;
		int[] result = new int[set.size()];
		for (Integer num : set) {
			result[i++] = num;
		}
		return result;
	}

	private boolean binarySearch(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				return true;
			}
			if (nums[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 2, 1};
		int[] arr = {2, 2};
		IntersectionOfTwoArrays obj = new IntersectionOfTwoArrays();
		int[] result;
		result = obj.intersect(nums, arr);
		System.out.print("The output is");
		ArrayUtills.printArray(result);

		result = obj.intersection(nums, arr);
		System.out.print("The output is");
		ArrayUtills.printArray(result);
		
		result = obj.intersectionUsingSort(nums, arr);
		System.out.print("The output is");
		ArrayUtills.printArray(result);
		
		result = obj.intersectionUsingBinarySearch(nums, new int[] {1, 1});
		System.out.print("The output is");
		ArrayUtills.printArray(result);
		


	}

}
