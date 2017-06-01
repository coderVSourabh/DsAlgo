package vSourabh.dataStructures.hashTable;

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
	
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 2, 1, 5, 11, 4, 5, 6, 11, 6};
		SingleNumber obj = new SingleNumber();
		int result = obj.singleNumber(nums);
		System.out.println("The Single Number is " + result);

	}

}
