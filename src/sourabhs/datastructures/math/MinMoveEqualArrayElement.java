package sourabhs.datastructures.math;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author Sourabh
 * 
 * LeetCode:
 * 
 */
public class MinMoveEqualArrayElement {

	/**
	 * LeetCode:
	 * 
	 * Given a non-empty integer array of size n, 
	 * find the minimum number of moves required 
	 * to make all array elements equal, where a 
	 * move is incrementing n - 1 elements by 1.
	 *
	 * Input:  [1,2,3]
	 * Output: 3
	 * Explanation: 
	 * Only three moves are needed (remember each move increments two elements):
	 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
	 */
	public int minMoves(int[] nums) {
		if (nums.length == 0) 
			return 0;
		int min = nums[0];
		
		for (int n : nums)
			min = Math.min(min, n);
		
		int res = 0;
		for (int n : nums) 
			res += n - min;
		return res;

	}
	
	// Same as minMoves
	public int minMovesUsingStream(int[] nums) {
		return IntStream.of(nums).sum() - nums.length * IntStream.of(nums).min().getAsInt();
	}
	
	/**
	 * LeetCode: 
	 * Given a non-empty integer array, find the minimum number of moves required 
	 * to make all array elements equal, where a move is incrementing a selected 
	 * element by 1 or decrementing a selected element by 1.
	 * 
	 * You may assume the array's length is at most 10,000.
	 * 
	 * Input: [1,2,3] 
	 * Output: 2
	 * Explanation:
	 * Only two moves are needed (remember each move increments or decrements one element):
	 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
	 */
	public int minMovesII(int[] nums) {
		Arrays.sort(nums);
		int i = 0, j = nums.length-1;
		int count = 0;
		while(i < j){
			count += nums[j]-nums[i];
			i++;
			j--;
		}
		return count;
	}
	
	public static void main(String[] args) {
		MinMoveEqualArrayElement obj = new MinMoveEqualArrayElement();
		int[] nums = {1,2,3,4};
		int result = obj.minMoves(nums);
		System.out.println("The number of moves are " + result);
		
		result = obj.minMovesUsingStream(new int[] {1,2,3});
		System.out.println("The number of moves are " + result);
		
		result = obj.minMovesII(new int[] {1,2,3});
		System.out.println("The number of moves in II are " + result);
	}

}
