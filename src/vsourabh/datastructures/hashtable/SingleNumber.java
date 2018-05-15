package vsourabh.datastructures.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sourabh
 *
 * LeetCode
 */
public class SingleNumber {

	/**
	 * LeetCode:
	 * Given an array of integers, every element 
	 * appears twice except for one. Find that single one.
	 * 
	 * Algorithm should have a linear runtime complexity. 
	 * Could you implement it without using extra memory?
	 * 
	 */
	public int singleNumber(int[] nums) {
		int result = 0;
		for (int i = 0; i < nums.length; i++)
			result ^= nums[i];
		return result;
	}

	public int singleNumber2(int[] nums) {
		int result = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++)
			if(map.containsKey(nums[i]))
				map.put(nums[i], map.get(nums[i]) + 1);
			else
				map.put(nums[i], 1);
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue() == 2) continue;
			else return entry.getKey();
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 2, 1, 5, 11, 4, 5, 6, 11, 6};
		SingleNumber obj = new SingleNumber();
		int result = obj.singleNumber(nums);
		System.out.println("The Single Number is " + result);

		result = obj.singleNumber2(nums);
		System.out.println("The Single Number is " + result);

	}

}
