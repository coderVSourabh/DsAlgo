package vsourabh.datastructures.array;

import java.util.Vector;

/**
 * @author Sourabh
 *
 */
public class SearchRange {

	/**
	 * LeetCode:
	 * 
	 * Given an array of integers sorted in ascending order, 
	 * find the starting and ending position of a given target value.
	 * If target is not found in the array, return [-1, -1]
	 * 
	 * Given [5, 7, 7, 8, 8, 10] and target value 8,
	 * return [3, 4]
	 * 
	 * Time Complexity : O(log n).
	 * 
	 */
	public Vector<Integer> searchRange(int[] nums, int target) {
		Vector<Integer> result = new Vector<>();
		result.add(-1);
		result.add(-1);
		int left = 0, right = nums.length;
		// Search for the left one
		while(left < right) {
        	int mid = (right - left) /2 + left;
	        if (nums[mid] < target) 
	        	left = mid + 1;
	        else 
	        	right = mid;
	    }
		
		if (nums[left] != target) return result;
	    else result.set(0, left);
        
		// Search for the right one
		right = nums.length;  // We don't have to set i to 0 the second time.
	    while (left < right) {
	    	int mid = (right - left) /2 + left;
	        if (nums[mid] > target) 
	        	right = mid - 1;
	        else 
	        	left = mid;				// So that this won't make the search range stuck.
	    }
	    result.set(1, right);
		
		return result;
    }
	
	
	
	public static void main(String[] args) {
		int nums[] =  {5, 7, 7, 8, 8, 10};
		SearchRange obj = new SearchRange();
		Vector<Integer> result =  obj.searchRange(nums, 8);
	
		System.out.print("The Element index are in range [" + result.get(0) 
					+ ","+ result.get(1) + "]");
	}

}
