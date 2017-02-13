package vSourabh.dataStructures.array;

import vSourabh.dataStructures.utils.ArrayUtills;

/**
 * @author Sourabh
 *
 */
public class ReverseArray {
	
	public void reverseRecursive(int[] a, int l, int r) {
		if (l > r)
			return;
		ArrayUtills.swap(a, l, r);
		reverseRecursive(a, ++l, --r);
	}
	
	public void reverse(int[] a) {
		int l = 0, r = a.length - 1;
		while (l < r) {
			ArrayUtills.swap(a, l, r);
			l++;
			r--;
		}
	}
	/**
	 * LeetCode
	 * Rotate an array of n elements to the right by k steps.
	 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
	 */
	public void rotate(int[] nums, int k) {
	    k %= nums.length;
	    reverse(nums, 0, nums.length - 1);
	    reverse(nums, 0, k - 1);
	    reverse(nums, k, nums.length - 1);
	}

	private void reverse(int[] nums, int start, int end) {
	    while (start < end) {
	        int temp = nums[start];
	        nums[start] = nums[end];
	        nums[end] = temp;
	        start++;
	        end--;
	    }
	}

	public static void main(String[] args) {
		ReverseArray revArr = new ReverseArray();
		int a[] = { 1, 2, 3, 4, 5 };
		revArr.reverse(a);
		ArrayUtills.printArray(a);
		revArr.reverseRecursive(a, 0, a.length - 1);
		ArrayUtills.printArray(a);
		
		int arr[] = {1,2,3,4,5,6,7};
		revArr.rotate(arr, 3);
		ArrayUtills.printArray(arr);
	}
}
