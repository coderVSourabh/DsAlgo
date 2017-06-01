package vSourabh.dataStructures.array;

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

	public static void main(String[] args) {

		int arr[] = {2, 2, 3, 1};
		ThirdMaxInArray obj = new ThirdMaxInArray();
		int result = obj.findThirdMax(arr);
		System.out.println("Third Max is " + result);
	}

}
