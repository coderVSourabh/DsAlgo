package vSourabh.dataStructures.array;

import vSourabh.dataStructures.utils.ArrayUtills;

/**
 * @author Sourabh
 * 
 * LeetCode
 * Use with Time Complexity O(n) and no extra space
 *
 */
public class MoveZerosToEnd {
	
	public void moveZeroes(int[] nums) {
		if (nums == null || nums.length == 0) 
			return; 

		int insertPos = 0;
		
		for (int num: nums) {
			// Insert all non-zero elements from index 0
			if (num != 0) 
				nums[insertPos++] = num;
		}
		while (insertPos < nums.length) {
	        nums[insertPos++] = 0;
	    }
    }

	public static void main(String[] args) {
		int[] nums = new int[] {0, 1, 0, 3, 12};
		MoveZerosToEnd obj = new MoveZerosToEnd();
		ArrayUtills.printArray(nums);
		obj.moveZeroes(nums);
		ArrayUtills.printArray(nums);
	}

}
