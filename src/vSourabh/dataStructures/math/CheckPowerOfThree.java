package vSourabh.dataStructures.math;

/**
 * @author Sourabh
 * 
 * LeetCode
 * Given an integer, write a function to determine if it is a power of three.
 * Follow up: Could you do it without using any loop / recursion?
 */
public class CheckPowerOfThree {

	public boolean isPowerOfThreeNoLoop(int n) {
		// 1162261467 is 3^19,  3^20 is bigger than int  
		return ( n>0 &&  1162261467%n==0);
	}
	
	public boolean isPowerOfThreeUsingLog(int n) {
	    return (Math.log10(n) / Math.log10(3)) % 1 == 0;
	}
	
	public boolean isPowerOfThreeUsingRecursion(int n) {
	    return n>0 && (n==1 || (n%3==0 && isPowerOfThreeUsingRecursion(n/3)));
	}
	
	public boolean isPowerOfThreeUsingLoop(int n) {
	    if(n>1)
	        while(n%3==0) n /= 3;
	    return n==1;
	}
	
	public boolean isPowerOfThreeUsingMaxIntOfPow3(int n) {
	    int maxPowerOfThree = (int)Math.pow(3, (int)(Math.log(0x7fffffff) / Math.log(3)));
	    return n>0 && maxPowerOfThree%n==0;
	}
	
	public static void main(String[] args) {
		CheckPowerOfThree cube = new CheckPowerOfThree();
		boolean result = cube.isPowerOfThreeNoLoop(27);
		System.out.println("The Number is 3 Power's " + result);
		
		result = cube.isPowerOfThreeUsingLog(81);
		System.out.println("The Number is 3 Power's " + result);
		
		result = cube.isPowerOfThreeUsingLoop(2187);
		System.out.println("The Number is 3 Power's " + result);
		
		result = cube.isPowerOfThreeUsingMaxIntOfPow3(59049);
		System.out.println("The Number is 3 Power's " + result);
		
		result = cube.isPowerOfThreeUsingRecursion(531441);
		System.out.println("The Number is 3 Power's " + result);
	}
}
