package vSourabh.dataStructures.math;

/**
 * @author Sourabh
 * 
 * LeetCode:
 * You have a total of n coins that you want to form in a staircase shape, 
 * where every k-th row must have exactly k coins.
 * 
 * Given n, find the total number of full staircase rows that can be formed.
 * 
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 * 
 * n = 5
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * Because the 3rd row is incomplete, we return 2.
 * 
 * n = 8
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤ 
 * ¤ ¤
 * Because the 3rd row is incomplete, we return 3.
 */
public class ArrangingCoins {

	/**
	 * Time Complexity : O(log_b(n)) [for Best, Worst, Average]
	 * Space Complexity: O(1)
	 */
	public int arrangeCoinsUsingBinarySearch(int n) {
		int start = 0;
		int end = n;
		int mid = 0;
		while (start <= end) {
			mid = (start + end) >>> 1;
			if ((0.5 * mid * mid + 0.5 * mid ) <= n)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return start - 1;
	}

	/**
	 * Time Complexity : O(1) [for Best, Worst, Average]
	 * Space Complexity: O(1)
	 */
	public int arrangeCoinsUsingMath(int n) {
		return (int) ((Math.sqrt(1 + 8.0 * n) - 1) / 2);
	}

	public static void main(String[] args) {
		ArrangingCoins coins = new ArrangingCoins();
		
		int result = coins.arrangeCoinsUsingBinarySearch(5);
		System.out.println("The coins are in columns : " + result);	
		
		result = coins.arrangeCoinsUsingMath(8);
		System.out.println("The coins are in columns : " + result);
	}
}