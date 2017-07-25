package vsourabh.algo.sorting;

import vsourabh.datastructures.utils.ArrayUtills;

/**
 * @author Sourabh
 * 
 * LeetCode
 * 
 * nums = [3, 5, 2, 1, 6, 4] and one possible answer is [1, 6, 2, 5, 3, 4]
 * 		A[0] <= A[1] >= A[2] <= A[3] >= A[4] <= A[5]
 *		So we could actually observe that there is pattern that
 *		A[even] <= A[odd],
 *		A[odd] >= A[even].
 */
public class WiggleSort {
	
	public void wiggleSort(int[] nums) {
	    for (int i=1; i<nums.length; i++) {
	        int a = nums[i-1];
	        if ((i%2 == 1) == (a > nums[i])) {
	            nums[i-1] = nums[i];
	            nums[i] = a;
	        }
	    }
	}

	public static void main(String[] args) {
		WiggleSort sort = new WiggleSort();
		int[] nums = {1, 1, 1, 3, 3, 3, 2, 2, 2};
		sort.wiggleSort(nums);
		ArrayUtills.printArray(nums);
		
		nums = new int[] {3,5,2,1,6,4};
		sort.wiggleSort(nums);
		ArrayUtills.printArray(nums);
	
	}

}
