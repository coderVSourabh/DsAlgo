package sourabhs.datastructures.array;

import java.util.Arrays;

/**
 * @author Sourabh
 * 
 * LeetCode:
 * Given an array S of n integers, find three integers in S such that 
 * the sum is closest to a given number, target. Return the sum of the 
 * three integers. You may assume that each input would have exactly one solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
 *
 */
public class ThreeSumCloset {


	public int threeSumClosest(int[] num, int target) {
		int result = num[0] + num[1] + num[num.length - 1];
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			int start = i + 1, end = num.length - 1;
			while (start < end) {
				int sum = num[i] + num[start] + num[end];
				if (sum > target)
					end--;
				else
					start++;
				if (Math.abs(sum - target) < Math.abs(result - target))
					result = sum;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		ThreeSumCloset obj = new ThreeSumCloset();
		int sum = obj.threeSumClosest(new int[] {1,5,-3,8,-4,10}, 0);
		System.out.println("Closet Sum is " + sum);
		
		sum = obj.threeSumClosest(new int[] {1,2,-3,5,-10}, -2);
		System.out.println("Closet Sum is " + sum);
	}

}
