package vsourabh.datastructures.math;

/**
 * @author Sourabh
 *
 * LeetCode
 * 
 * Reverse digits of an integer.
 * x = 123, return 321
 * x = -123, return -321
 * 
 * Here are some good questions to ask before coding. 
 * Bonus points for you if you have already thought through this!
 * If the integer's last digit is 0, what should the output be? 
 * i.e., cases such as 10, 100.
 * 
 * Did you notice that the reversed integer might overflow? 
 * Assume the input is a 32-bit integer, then the reverse of 
 * 1000000003 overflows. How should you handle such cases?
 * 
 * For the purpose of this problem, assume that your function 
 * returns 0 when the reversed integer overflows.
 */
public class ReverseNumber__7 {

	/**
	 * LeetCode:
	 * 
	 * If overflow exists, the new result will not equal previous one.
	 * No flags needed. No hard code like 0xf7777777 needed.
	 */
	public int reverse(int x) {
		int result = 0;

		while (x != 0) {
			int tail = x % 10;
			int newResult = result * 10 + tail;
			if ((newResult - tail) / 10 != result)
				return 0;
			result = newResult;
			x = x / 10;
		}
		return result;
	}

	public static void main(String[] args) {

		ReverseNumber__7 rNum = new ReverseNumber__7();
		int result = rNum.reverse(123);
 
		result = rNum.reverse(-321);
		System.out.println("The reverse number is " + result);
	}
}
