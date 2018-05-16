package sourabhs.datastructures.math;

/**
 * @author Sourabh
 * 
 * CSC 560
 * This Class is used for Calculating number of 
 * Multiplication needed to get power of a term
 */
public class NumOfMultiplicationCount {

	private static int multiplicationCount;
	
	/**
	 * 
	 * @param a
	 * @param n
	 * @return a^n
	 * 
	 * Descrption:
	 * The function return a ^ n
	 */
	public static double power(double a, int n) {
		
		if(0 == a)
			return 0;
		if(n == 1)
			return a;
		if( n == 0)
			return 1;
		
		if( n%2 == 0) {
			multiplicationCount++;
			return power(a * a, n/2);			
		}
		
		multiplicationCount += 2;
		return a * power(a * a, n/2);
	}
	
	public static void main(String[] args) {
		double a = 5.0;
		for (int i = 1; i <= 10; i++) {
			multiplicationCount = 0;
			System.out.println(" Power of " + a + "^" + i + " is: " + power(a, i));
			System.out.println("Number of Multiplications are : " + multiplicationCount);
		}
	

	}

}
