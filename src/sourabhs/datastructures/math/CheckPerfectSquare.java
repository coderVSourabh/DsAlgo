package sourabhs.datastructures.math;

/**
 * @author Sourabh
 *
 * LeetCode:
 * Given a positive integer num, write a function which returns True 
 * if num is a perfect square else False.
 * 
 * Note: Do not use any built-in library function such as sqrt.
 * Input: 16 Returns: True
 * Input: 14 Returns: False
 */
public class CheckPerfectSquare {

	/**
	 * Time Complexity :O(n)
	 * Space Complexity:O(1)
	 */
	public boolean isPerfectSquare(int num) {
	     int i = 1;
	     while (num > 0) {
	         num -= i;
	         i += 2;
	     }
	     return num == 0;
	 }

	/**
	 * Time Complexity :O(Log(n))
	 * Space Complexity:O(1)
	 */
	public boolean isPerfectSquareUsingBinarySearch(int num) {
        int low = 1, high = num;
        while (low <= high) {
            long mid = (low + high) >>> 1;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }
        return false;
    }
	/**
	 * Time Complexity :O(Log(n))
	 * Space Complexity:O(1)
	 * 
	 * ref: https://en.wikipedia.org/wiki/Integer_square_root#Using_only_integer_division
	 */	
	public boolean isPerfectSquareUsingNewtonMethod(int num) {
        long x = num; //long to avoid overflow 
        while (x * x > num) {
            x = (x + num / x) >> 1;
        }
        return x * x == num;
    }
	
	public static void main(String[] args) {
		CheckPerfectSquare sqr = new CheckPerfectSquare();
		boolean result = sqr.isPerfectSquare(9);
		System.out.println("The number is perfect square " + result);
		
		result = sqr.isPerfectSquareUsingBinarySearch(100);
		System.out.println("The number is perfect square " + result);
		
		result = sqr.isPerfectSquareUsingNewtonMethod(121);
		System.out.println("The number is perfect square " + result);
	}

}
