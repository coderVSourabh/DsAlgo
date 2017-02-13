package vSourabh.dataStructures.array;

import vSourabh.dataStructures.utils.ArrayUtills;

/**
 * 
 * @author Sourabh
 * 
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 * 
 * Example 
 * For the input 123 represented in array [1,2,3], the new array will be [1,2,4].
 * For the input 99 represented in array [9,9] , the new array will be [1,0,0].
 *
 */
public class PlusOne {
	

	/**
	 * 
	 * Time Complexity : O(n)
	 * Space Complexity: O(1)
	 */
	public int[] plusOne(int[] digits) {
        
	    int n = digits.length;
	    for(int i=n-1; i>=0; i--) {
	        if(digits[i] < 9) {
	            digits[i]++;
	            return digits;
	        }   
	        digits[i] = 0;
	    }
	    // Can return digits = new int[n + 1] old array can be GC
	    int[] newNumber = new int [n+1];
	    newNumber[0] = 1;    
	    return newNumber;
	}
	
	public static void main(String[] args) {
		PlusOne obj = new PlusOne();
		
		int[] result = obj.plusOne(new int[] {1,2,3});
		ArrayUtills.printArray(result);
		
		result = obj.plusOne(new int[] {9,9,9});
		ArrayUtills.printArray(result);
		
	}

}
