package sourabhs.datastructures.math;

/**
 * @author Sourabh
 * 
 * LeetCode:
 * Divide two integers without using
 *   multiplication, division and mod operator.
 * If it is overflow, return MAX_INT.
 */
public class DivisionTwoIntegers {

	/**
	 * Suppose we want to divide 15 by 3, so 15 is dividend and 3 is divisor.
	 * Well, division simply requires us to find how many times we can subtract 
	 * the divisor from the the dividend without making the dividend negative.
	 * 
	 * 15 = 3 * 4 + 3. We now get part of the quotient (4), with a remainder 3
	 * we repeat the above process again. We subtract divisor = 3 from the 
	 * remaining dividend = 3 and obtain 0. We know we are done. No shift 
	 * happens, so we simply add 1 << 0 to the answer.
	 * 
	 * Well, two cases may cause overflow:
	 * 		divisor = 0;
	 * 		dividend = INT_MIN and divisor = -1 (because abs(INT_MIN) = INT_MAX + 1).
	 */
	
	int divide(int dividend, int divisor) {
        if (divisor == 0 || (dividend == Integer.MAX_VALUE && divisor == -1))
            return Integer.MAX_VALUE;
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1; //Bitwise XOR 0 if both are 0 or 1
        long dvnd = Math.abs(dividend);
        long dvsr = Math.abs(divisor);
        int res = 0;
        while (dvnd >= dvsr) { 
            
        	long temp = dvsr, multiple = 1; 
            
            while (dvnd >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            dvnd -= temp;
            res += multiple;
        }
        
        return sign == 1 ? res : -res; 
    }
	
	public static void main(String[] args) {
		DivisionTwoIntegers obj = new DivisionTwoIntegers();
		int result = obj.divide(10, 2);
		System.out.println("The division result is " + result);
		
		result = obj.divide(-10, 3);
		System.out.println("The division Quotient is " + result);

		result = obj.divide(10, -4);
		System.out.println("The division Quotient is " + result);
	}

}
