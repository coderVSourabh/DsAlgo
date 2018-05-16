package sourabhs.datastructures.array;

import sourabhs.datastructures.utils.ArrayUtills;

/**
 * @author Sourabh
 *
 * LeetCode
 * 
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * 
 * Example: nums = [3,2,2,3], remove = 3
 * new Array of length 2 and first 2 number contains 2
 * 
 */
public class RemoveElementInArray {
	
	public int removeGivenElement(int[] nums, int target) {
		int index = 0;
		if(nums != null && nums.length < 2)
			return nums.length;
		
		for(int i = 0; i < nums.length; i++)
			if(nums[i] != target)
				nums[index++] = nums[i];

		return index;
	}

	public static void main(String[] args) {
		int[] nums = {1,2,4,3,6,7,1,2,1,4,6,1,6,4};
		RemoveElementInArray obj = new RemoveElementInArray();
		
		System.out.print("Input");
		ArrayUtills.printArray(nums);
		int newLength = obj.removeGivenElement(nums, 4);
		System.out.print("\n\nOutput Array: ");
		
		for(int i = 0; i < newLength; i++) 
			System.out.print(nums[i] + " ");

	}

}
