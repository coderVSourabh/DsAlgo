package sourabhs.datastructures.math;

/**
 * @author Sourabh
 * 
 * LeetCode:
 * Given a positive integer n, break it into the 
 * sum of at least two positive integersv& maximize
 * the product of those integers. Return the maximum
 * product you can get.
 * 
 * For example, given n = 2, return 1 (2 = 1 + 1); 
 * given n = 10, return 36 (10 = 3 + 3 + 4).
 * 
 * Note: You may assume that n is not less than 2 
 * and not larger than 58.
 * 
 * Hint: There is a simple O(n) solution to this problem
 *
 */
public class IntegerBreak {

	/**
	 * @param args
	 */
	public int integerBreak(int n) {
		if(n==2) return 1;
		if(n==3) return 2;
		int product = 1;
		while(n>4){
			product*=3;
			n-=3;
		}
		product*=n;

		return product;
	}
	
	public static void main(String[] args) {
		IntegerBreak obj = new IntegerBreak();
		int result = obj.integerBreak(10);
		System.out.println("Breaks are " + result);

		result = obj.integerBreak(8);
		System.out.println("Breaks are " + result);
	}
}
