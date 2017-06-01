package vSourabh.dataStructures.math;

/**
 * @author Sourabh
 * 
 * LeetCode:
 * Given an integer n, count the total number of 
 * digit 1 appearing in all non-negative integers 
 * less than or equal to n.
 * 
 * For example:
 * Given n = 13,
 * Return 6, 
 * because digit 1 occurred in the following 
 * numbers: 1, 10, 11, 12, 13.
 * 
 * Hint: Beware of overflow.
 */
public class NumberOfDigitOne {

	/**
	 * 0, 1, 2, 3 ... 9 (1)
	 * 10, 11, 12, 13 ... 19 (1) + 10
	 * 20, 21, 22, 23 ... 29 (1)
	 * ...
	 * 90, 91, 92, 93 ... 99 (1)
	 * 100, 101, 102, 103 ... 109 (10 + 1)
	 * 110, 111, 112, 113 ... 119 (10 + 1) + 10
	 * 120, 121, 122, 123 ... 129 (10 + 1)
	 * ...
	 * 190, 191, 192, 193 ... 199 (10 + 1)
	 */
	public int countDigitOne(int n) {
		int ones = 0;
		for (long m = 1; m <= n; m *= 10)
			ones += (n/m + 8) / 10 * m + (n/m % 10 == 1 ? n%m + 1 : 0);
		return ones;
	}
	
	public static void main(String[] args) {
		NumberOfDigitOne obj = new NumberOfDigitOne();
		int result = obj.countDigitOne(11);
		System.out.println("The Number of ones are " + result);
	}

}
