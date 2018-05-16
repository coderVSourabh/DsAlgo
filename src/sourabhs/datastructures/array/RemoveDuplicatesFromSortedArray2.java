package sourabhs.datastructures.array;

/**
 * @author Sourabh
 * 
 * LeetCode:
 * 
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * For example, 
 * Given sorted array nums = [1,1,1,2,2,3], 
 * 
 * Your function should return length = 5, with the first 
 * five elements of nums being 1, 1, 2, 2 and 3. It doesn't 
 * matter what you leave beyond the new length. 
 */
public class RemoveDuplicatesFromSortedArray2 {

	public int removeDuplicates(int[] nums) {
		int i = 0;
		for (int n : nums)
			if (i < 2 || n > nums[i-2])
				nums[i++] = n;
		return i;
	}
	
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedArray2 obj = new RemoveDuplicatesFromSortedArray2();
		int nums[] = {1,1,1,2,2,2,2,2,3,3,3,3,3,4};
		int size = obj.removeDuplicates(nums);
		for(int i = 0; i < size; i++)
			System.out.print(nums[i] + " ");
	}
}
