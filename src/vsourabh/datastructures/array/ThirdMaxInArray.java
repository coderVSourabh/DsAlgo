package vsourabh.datastructures.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Sourabh
 *
 * LeetCode
 * Given a non-empty array of integers, 
 * return the third maximum number in this array. 
 * If it does not exist, return the maximum number. 
 * The time complexity must be in O(n).
 */
public class ThirdMaxInArray {
	
	/**
	 * LeetCode
	 * Time Complexity : O(n)
	 * Space Complexity: O(1)
	 * 
	 */
	public int findThirdMax(int[] nums) {
		Integer max1 = null;
		Integer max2 = null;
		Integer max3 = null;
		for (Integer n : nums) {
			if (n.equals(max1) || n.equals(max2) || n.equals(max3)) 
				continue;
			if (max1 == null || n > max1) {
				max3 = max2;
				max2 = max1;
				max1 = n;
			} else if (max2 == null || n > max2) {
				max3 = max2;
				max2 = n;
			} else if (max3 == null || n > max3) {
				max3 = n;
			}
		}
		return max3 == null ? max1 : max3;
	}
	
	public int findThirdMax(List<Integer> nums) {
		Integer max[] = new Integer[3];

		if(nums == null || nums.isEmpty())
			return 0;
		
		nums.forEach((Integer val) -> {
			if (val == null || val.equals(max[0]) || val.equals(max[1]) 
					|| val.equals(max[2]))
				return;
			if (max[0] == null || val > max[0]) {
				max[2] = max[1];
				max[1] = max[0];
				max[0] = val;
			} else if(max[1] == null || val > max[1]) {
				max[2] = max[1];
				max[1] = val;
			} else if(max[1] == null || val > max[1]) {
				max[2] = val;
			}
		});
		
		return max[2] == null? max[0] : max[2];
	}

	public static void main(String[] args) {

		int arr[] = {2, 2, 3, 1};
		ThirdMaxInArray obj = new ThirdMaxInArray();
		int result = obj.findThirdMax(arr);
		System.out.println("Third Max is " + result);
		
		result = obj.findThirdMax(Collections.emptyList());
		System.out.println("Third Max is " + result);
		
		result = obj.findThirdMax(Arrays.asList(2, 2, 1, 1, 4, 5, 4));
		System.out.println("Third Max is " + result);
	}

}
