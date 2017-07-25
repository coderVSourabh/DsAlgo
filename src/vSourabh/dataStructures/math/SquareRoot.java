package vsourabh.datastructures.math;

/**
 * @author Sourabh
 *
 * LeetCode
 * Compute and return the square root of x.
 * 
 */
public class SquareRoot {
	
	public int sqrt(int x) {
	    if (x == 0)
	        return 0;
	    int left = 1, right = Integer.MAX_VALUE;
	    while (true) {
	        int mid = left + (right - left)/2;
	        if (mid > x/mid) {
	            right = mid - 1;
	        } else {
	            if (mid + 1 > x/(mid + 1))
	                return mid;
	            left = mid + 1;
	        }
	    }
	}

	public int sqrtLoop(int x) {
		long r = x;
	    while (r*r > x)
	        r = (r + x/r) / 2;
	    return (int) r;
	}
	
	public static void main(String[] args) {
		SquareRoot sRoot = new SquareRoot();
		int result = sRoot.sqrt(729);
		System.out.println("The Square root of 729 is " + result);
		
		result = sRoot.sqrtLoop(676);
		System.out.println("The Square root of 676 is " + result);
	}

}
