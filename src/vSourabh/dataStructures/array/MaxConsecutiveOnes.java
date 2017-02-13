package vSourabh.dataStructures.array;

/**
 * @author Sourabh
 * LeetCode
 * 
 * Given a binary array, 
 * find the maximum number of consecutive 1s in this array.
 *
 */
public class MaxConsecutiveOnes {

	public int findMaxConsecutiveOnes(int[] nums) {
		int result = 0, count =0;
		
		for(int val : nums) {
			if(val == 1) {
				count++;
				result = Math.max(count, result);
			} else
				count = 0;
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		MaxConsecutiveOnes obj = new MaxConsecutiveOnes();
		
		int[] arr = new int[] {1,1,0,1,1,1};
		System.out.print("Maximum Consecutive Ones are: " + obj.findMaxConsecutiveOnes(arr));
		
		
	}

}
