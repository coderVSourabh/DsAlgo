package vSourabh.dataStructures.math;

/**
 * @author Sourabh
 * 
 * LeetCode:
 * Implement pow(x, n). 
 *
 */
public class PowXtoN {

	/**
	 * @param args
	 */
	public double pow(double x, int n) {
		if(n == 0)
			return 1;
		if(n<0){
			n = -n;
			x = 1/x;
		}
		return (n%2 == 0) ? pow(x*x, n/2) : x*pow(x*x, n/2);
	}
	
	double myPowLoop(double x, int n) { 
	    if(n==0) return 1;
	    if(n<0) {
	        n = -n;
	        x = 1/x;
	    }
	    double ans = 1;
	    while(n>0) {
	        
	    	if((n&1) == 1) 
	        	ans *= x;
	        x *= x;
	        n >>= 1;
	    }
	    return ans;
	}
	
	public static void main(String[] args) {
		PowXtoN obj = new PowXtoN();
		double result = obj.pow(2, 10);
		System.out.println("The result is " + result);

		result = obj.myPowLoop(2, 10);
		System.out.println("The result is " + result);
	}

}
