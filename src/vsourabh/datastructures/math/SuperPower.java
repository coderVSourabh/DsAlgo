package vsourabh.datastructures.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sourabh
 * LeetCode:
 * Your task is to calculate a^b mod 1337 
 * where a is a positive integer and b is 
 * an extremely large positive integer 
 * given in the form of an array.
 * 
 * Example
 * a = 2 , b = [3]
 * Result: 8
 * 
 * a = 2, b = [1,0]
 * Result: 1024
 */
public class SuperPower {

	/**
	 * @param args
	 */
	private final int base = 1337;
	
	private  int powmod(int a, int k) { //a^k mod 1337 where 0 <= k <= 10
		a %= base;
		int result = 1;
		for (int i = 0; i < k; ++i)
			result = (result * a) % base;
		return result;
	}
	public int superPow(int a, List<Integer> b) {
		if (b.isEmpty()) return 1;
		int lastDigit = b.remove(b.size() - 1);
		return powmod(superPow(a, b), 10) * powmod(a, lastDigit) % base;
	}
	
	public int superPow(int a, int[] b) {
	    if (a % base == 0) return 0;
	    int p = 0;
	    for (int i : b) p = (p * 10 + i) % 1140;
	    if (p == 0) p += 1440;
	    return powmod(a, p);
	}
	
	public static void main(String[] args) {
		SuperPower sP = new SuperPower();
		List<Integer> b = new ArrayList<>();
		b.add(1);
		b.add(0);
		int result = sP.superPow(2, b);
		System.out.println("Result is " + result);
		
		result = sP.superPow(2, new int[] {1,2});
		System.out.println("Result is " + result);
	}

}
