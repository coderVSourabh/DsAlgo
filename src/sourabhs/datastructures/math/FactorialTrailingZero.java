package sourabhs.datastructures.math;

/**
 * @author Sourabh
 * 
 * LeetCode:
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity.
 */
public class FactorialTrailingZero {

	/**
	 * LeetCode:
	 * Recursive method 
	 */
	 public int trailingZeroes(int n) {      
		   return  n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
	 }
	 
	 int trailingZeroesUsingLoop(int n) {
		 int result = 0;
		 for(long i = 5; n/i > 0; i*=5){
			 result += (n/i);
		 }
		 return result;
	}
	 
	public static void main(String[] args) {
		FactorialTrailingZero obj = new FactorialTrailingZero();
		int result = obj.trailingZeroes(3_628_800);
		System.out.println("The Trailing number of zeros are " + result);
	
		result = obj.trailingZeroesUsingLoop(120);
		System.out.println("The Trailing number of zeros are " + result);
	}

}
