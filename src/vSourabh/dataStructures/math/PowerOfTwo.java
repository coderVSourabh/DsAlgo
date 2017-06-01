package vSourabh.dataStructures.math;

/**
 * @author Sourabh
 * 
 * LeetCode:
 * Given an integer, write a function to determine if it is a power of two.
 */
public class PowerOfTwo {

	/**
	 *   00000100 ( = 4)
	 * & 00000111 ( = 7)
	 * ==========
	 *   00000100 ( = 4)
	 *   
	 *  i.e. in decimal 4 & 7 = 4 
	 */
	public boolean isPowerOfTwo(int num) {
		if(num <= 0) return false;
		else if((int) (num & (num - 1)) == 0)
			return true;
		else
			return false;
	}
	
	public boolean isPowerOfTwoUsingBitCount(int n) {
		return n > 0 && Integer.bitCount(n) == 1;
	}
	
	public static void main(String[] args) {
		PowerOfTwo pTwo = new PowerOfTwo();
		boolean result = pTwo.isPowerOfTwo(10);
		System.out.println("result is " + result);
		result = pTwo.isPowerOfTwo(256);
		System.out.println("result is " + result);
		result = pTwo.isPowerOfTwoUsingBitCount(1000);
		System.out.println("result is " + result);
		result = pTwo.isPowerOfTwoUsingBitCount(1024);
		System.out.println("result is " + result);
	}
}
