package sourabhs.datastructures.math;

/**
 * @author Sourabh
 *
 * LeetCode:
 */
public class UglyNumber {

	/**
	 *  Write a program to check whether a given number is an ugly number.
	 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
	 * For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
	 * Note that 1 is typically treated as an ugly number.
	 */
	public boolean isUglyNum(int num) {	

		for (int i=5; i>=2 && num>0; i--) {
			while (num % i == 0) 
		        num /= i;
		}
		return num == 1;
	}
	
	/**
	 * 
	 * LeetCode:
	 * 			Ugly Number II
	 * Write a program to find the n-th ugly number.
	 * 
	 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
	 * For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
	 * 
	 * Note that 1 is typically treated as an ugly number, and n does not exceed 1690.
	 * 
	 * The ugly-number sequence is 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, …
	 * because every number can only be divided by 2, 3, 5,
	 */
	public int nthUglyNumber(int n) {
		int[] ugly = new int[n];
		ugly[0] = 1;
		int index2 = 0, index3 = 0, index5 = 0;
		int factor2 = 2, factor3 = 3, factor5 = 5;
		for(int i=1;i<n;i++){
			int min = Math.min(Math.min(factor2,factor3),factor5);
			ugly[i] = min;
			if(factor2 == min)
				factor2 = 2*ugly[++index2];
			if(factor3 == min)
				factor3 = 3*ugly[++index3];
			if(factor5 == min)
				factor5 = 5*ugly[++index5];
		}
		return ugly[n-1];

	}
	
	public static void main(String[] args) {
		UglyNumber uNum = new UglyNumber();
		boolean result = uNum.isUglyNum(1024);
		System.out.println("The Number is Ugly " + result);
		
		result = uNum.isUglyNum(1);
		System.out.println("The Number is Ugly " + result);

		result = uNum.isUglyNum(512*5*5*3*3);
		System.out.println("The Number is Ugly " + result);
		
		result = uNum.isUglyNum(28);
		System.out.println("The Number is Ugly " + result);
		
		int num = uNum.nthUglyNumber(28);
		System.out.println("The Number 28th Ugly num is  " + num);
	}
}
