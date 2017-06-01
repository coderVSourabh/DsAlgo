package vSourabh.dataStructures.array;

import java.util.Arrays;

/**
 * @author Sourabh
 *
 * LeetCode:
 * Given a sorted array, remove the duplicates in place such 
 * that each element appear only once and return the new length.
 * 
 * Don't create a new array for return, change the existing array and 
 * return the new size, the elements after new length doesn't matter
 * 
 * [1,1,2], Function should return length = 2
 * 
 */
public class RemoveDuplicatesFromSortedArray {
	
	/**
	 * 
	 * LeetCode:
	 * Time Complexity : O(n)
	 * Space Complexity: O(1)
	 * 
	 */
	public int removeDuplicates(int nums[]) {
		
		int id = 1;
        if(nums != null && nums.length < 2)
        	return nums.length;
        
        for(int i = 1; i < nums.length; ++i) 
            if(nums[i] != nums[i-1])
            	nums[id++] = nums[i];
        return id;
    }

	public static void main(String[] args) {
		
		int[] nums = {0,1,2,3,4,5,6,4,3,2,1,1};
		Arrays.sort(nums);
		
		RemoveDuplicatesFromSortedArray obj = new RemoveDuplicatesFromSortedArray();
		System.out.println("Sorted Input Array: " + Arrays.toString(nums));
		int length = obj.removeDuplicates(nums);
		System.out.print("\nSorted without Duplicate Array: ");
		for (int i = 0; i < length; i++)
			System.out.print(nums[i] + ", ");
		
		nums = new int[] {0,0,1,2,3,4,5,5,6,6,7};
		length = obj.removeDuplicates(nums);
		System.out.print("\nSorted without Duplicate Array: ");
		for (int i = 0; i < length; i++)
			System.out.print(nums[i] + ", ");
	}
}
