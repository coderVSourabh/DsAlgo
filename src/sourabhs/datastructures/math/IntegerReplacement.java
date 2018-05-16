package sourabhs.datastructures.math;

/**
 * @author Sourabh
 * 
 * LeetCode
 * Given a positive integer n and you can do operations as follow:
 * If n is even, replace n with n/2.
 * If n is odd, you can replace n with either n + 1 or n - 1.
 * What is the minimum number of replacements needed for n to become 1?
 * 
 * Example:
 * Input: 8
 * Output: 3
 * Explanation:
 * 8 -> 4 -> 2 -> 1
 */
public class IntegerReplacement {

	/**
	 * 
	 * Example :-
	 * Input:7
	 * Output:4
	 * Explanation:
	 * 7 -> 8 -> 4 -> 2 -> 1
	 * or
	 * 7 -> 6 -> 3 -> 2 -> 1
	 * 
	 * Input : 59
	 * By subtracting 1
	 * 111011 -> 111010 -> 11101 -> 11100 -> 1110 -> 111 -> 1000 -> 100 -> 10 -> 1	
	 * Better Way is by Adding 1:
	 * 111011 -> 111100 -> 11110 -> 1111 -> 10000 -> 1000 -> 100 -> 10 -> 1
	 * 
	 * In case of 3 ()
	 * By Adding 1 
	 * 11 -> 100 -> 10 -> 1
	 * Better Way is Subtracting 1:
	 * 11 -> 10 -> 1
	 * 
	 * If n is even, halve it.
	 * If n=3 or n-1 has less 1's than n+1, decrement n.
	 * Otherwise, increment n.
	 */
	public int integerReplacement(int n) {
		int c = 0;
		while (n != 1) {
			if ((n & 1) == 0) {
				n >>>= 1;
			} else if (n == 3 || Integer.bitCount(n + 1) > Integer.bitCount(n - 1)) {
				--n;
			} else {
				++n;
			}
			++c;
		}
		return c;
	}
	
	/**
	 * Better way
	 */
	public int integerReplacementWithoutBitCount(int n) {
	    int c = 0;
	    while (n != 1) {
	        if ((n & 1) == 0) {
	            n >>>= 1;
	        } else if (n == 3 || ((n >>> 1) & 1) == 0) {
	            --n;
	        } else {
	            ++n;
	        }
	        ++c;
	    }
	    return c;
	}
	
	
	public static void main(String[] args) {
		int result;
		IntegerReplacement obj = new IntegerReplacement();
		result = obj.integerReplacement(57);
		System.out.println("The Number of Replacements are " + result);
		
		result = obj.integerReplacement(9);
		System.out.println("The Number of Replacements are " + result);
		
		result = obj.integerReplacementWithoutBitCount(57);
		System.out.println("The Number of Replacements are " + result);
	}

}
