package vsourabh.datastructures.math;

/**
 * 
 * @author Sourabh
 * 
 * LeetCode
 * You are given two jugs with capacities 
 * x and y litres. There is an infinite 
 * amount of water supply available. You 
 * need to determine whether it is possible
 * to measure exactly z litres using these two jugs.
 * 
 * If z liters of water is measurable, you must have
 * z liters of water contained within one or both
 * buckets by the end.
 * 
 * Operations allowed:
 * Fill any of the jugs completely with water.
 * Empty any of the jugs.
 * Pour water from one jug into another till the 
 * 		other jug is completely full or the first
 * 		jug itself is empty.
 * 
 * Example:
 * Input: x = 3, y = 5, z = 4
 * Output: True
 * 
 * Input: x = 2, y = 6, z = 5
 * Output: False
 *
 */
public class WaterAndJug {

	/**
	 * The basic idea is to use the property of
	 * Bézout's identity and check if z is a 
	 * multiple of GCD(x, y)
	 * 
	 * If a or b is negative this means we are 
	 * emptying a jug of x or y gallons respectively.
	 * Similarly if a or b is positive this means 
	 * we are filling a jug of x or y gallons respectively.
	 * 
	 * x = 4, y = 6, z = 8.
	 * GCD(4, 6) = 2
	 * 8 is multiple of 2
	 * so this input is valid and we have:
	 * -1 * 4 + 6 * 2 = 8
	 */
	public boolean canMeasureWater(int x, int y, int z) {
	    //limit brought by the statement that water is finallly in one or both buckets
	    if(x + y < z) return false;
	    //case x or y is zero
	    if( x == z || y == z || x + y == z ) return true;
	    
	    //get GCD, then we can use the property of Bézout's identity
	    return z%GCD(x, y) == 0;
	}

	private int GCD(int a, int b){
	    while(b != 0 ){
	        int temp = b;
	        b = a%b;
	        a = temp;
	    }
	    return a;
	}
	
	public static void main(String[] args) {
		WaterAndJug obj = new WaterAndJug();
		boolean result = obj.canMeasureWater(3, 5, 4);
		System.out.println("4 litters water can be measured by 3 and 5 " + result);

		result = obj.canMeasureWater(4, 6, 8);
		System.out.println("8 litters water can be measured by 4 and 6 " + result);
	}

}
