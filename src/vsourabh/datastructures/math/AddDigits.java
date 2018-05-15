package vsourabh.datastructures.math;

/**
 * @author Sourabh
 * 
 * LeetCode:
 * Given a non-negative integer num, repeatedly 
 * add all its digits until the result has only one digit.
 * 
 * For example:
 * Given num = 38, 
 * the process is like: 
 * 3 + 8 = 11, 1 + 1 = 2. 
 * Since 2 has only one digit, return it.
 * 
 * Follow Up? without any loop/recursion in O(1) runtime
 */
public class AddDigits {

	/**
	 * LeetCode:
	 * https://en.wikipedia.org/wiki/Digital_root#Congruence_formula
	 * 
	 * input: 0 1 2 3 4 ...
	 * output: 0 1 2 3 4 5 6 7 8 9 1 2 3 4 5 6 7 8 9 1 2 3 ..
	 */
	public int addDigits(int num) {
		return 1 + (num - 1) % 9;
    }
	
	public int addDigits2(int num) {
		if(num == 0) return 0;
		return num % 9 == 0 ? 9 : num % 9;
	}
	public static void main(String[] args) {
		AddDigits digit = new AddDigits();
		int result = digit.addDigits(99);
		System.out.println("The addition of digit 99 is " + result);
		
		result = digit.addDigits2(99);
		System.out.println("The addition of digit 99 is " + result);
		
		result = digit.addDigits(289);
		System.out.println("The addition of digit 289 is " + result);

		result = digit.addDigits2(289);
		System.out.println("The addition of digit 289 is " + result);
		
		result = digit.addDigits(38);
		System.out.println("The addition of digit 38 is " + result);
		
		result = digit.addDigits2(38);
		System.out.println("The addition of digit 38 is " + result);
	}

}
