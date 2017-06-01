package vSourabh.dataStructures.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sourabh
 * 
 * LeetCode:
 * Given a set of distinct positive integers,
 * find the largest subset such that every 
 * pair (Si, Sj) of elements in this subset 
 * satisfies: Si % Sj = 0 or Sj % Si = 0.
 * 
 * If there are multiple solutions, return any subset is fine.
 * 
 * Example:
 * nums: [1,2,3]
 * Result: [1,2] (of course, [1,3] will also be ok)
 * 
 * nums: [1,2,4,8]
 * Result: [1,2,4,8]
 */
public class LargestDivisibleSubset {

	/**
	 * let's say we have a set P = { 4, 8, 16 },
	 * P satisfies the divisible condition. Now 
	 * consider a new number 2, it can divide the 
	 * smallest number 4, so it can be placed into 
	 * the set; similarly, 32 can be divided by 16, 
	 * the biggest number in P, it can also placed into P.
	 */
	public List<Integer> largestDivisibleSubset(int[] nums) {
		int n = nums.length;
		int[] count = new int[n];
		int[] pre = new int[n];
		Arrays.sort(nums);
		int max = 0, index = -1;
		for (int i = 0; i < n; i++) {
			count[i] = 1;
			pre[i] = -1;
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] % nums[j] == 0) {
					if (1 + count[j] > count[i]) {
						count[i] = count[j] + 1;
						pre[i] = j;
					}
				}
			}
			if (count[i] > max) {
				max = count[i];
				index = i;
			}
		}
		List<Integer> res = new ArrayList<>();
		while (index != -1) {
			res.add(nums[index]);
			index = pre[index];
		}
		return res;
	}
	
	public static void main(String[] args) {
		LargestDivisibleSubset obj = new LargestDivisibleSubset();
		List<Integer> result = obj.largestDivisibleSubset(new int[] {1,2,3});
		result.forEach(p-> System.out.print(p + " "));

		System.out.println("\n--------------------");
		result = obj.largestDivisibleSubset(new int[] {2, 4, 8, 16, 10});
		result.forEach(p-> System.out.print(p + " "));
	}

}
