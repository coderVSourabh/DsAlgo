package vsourabh.datastructures.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sourabh
 * 
 * LeetCode:
 * A strobogrammatic number is a number that looks the same 
 * when rotated 180 degrees (looked at upside down).
 * 
 */
public class StrobogrammaticNumber {

	
	/**
	 * LeetCode:
	 * Strobogrammatic Number I
	 * 
	 * Write a function to determine if a number is strobogrammatic. 
	 * The number is represented as a string.
	 * 
	 * For example, the numbers "69", "88", and "818" are all strobogrammatic.
	 */
	public boolean isStrobogrammatic(String num) {
	    for (int i=0, j=num.length()-1; i <= j; i++, j--)
	        if (!"00 11 88 696".contains(num.charAt(i) + "" + num.charAt(j)))
	            return false;
	    return true;
	}
	
	/**
	 * LeetCode:
	 * Strobogrammatic Number II
	 * 
	 * Find all strobogrammatic numbers that are of length = n.
	 * 
	 * For example,
	 * Given n = 2, return ["11","69","88","96"].
	 * Hint:
	 * 
	 * Try to use recursion and notice that it should recurse with n - 2 instead of n - 1.
	 */

	 public List<String> findStrobogrammatic(int n) {
		 return helper(n, n);
	 }

	 private List<String> helper(int n, int m) {
		 if (n == 0) return new ArrayList<>(Arrays.asList(""));
		 if (n == 1) return new ArrayList<>(Arrays.asList("0", "1", "8"));

		 List<String> list = helper(n - 2, m);
		 List<String> res = new ArrayList<>();

		 for (int i = 0; i < list.size(); i++) {
			 
			 String s = list.get(i);

			 if (n != m) 
				 res.add("0" + s + "0");
			 
			 res.add("1" + s + "1");
			 res.add("6" + s + "9");
			 res.add("8" + s + "8");
			 res.add("9" + s + "6");
		 }
		 return res;
	 } 
	
	
	/**
	 * LeetCode:
	 * Strobogrammatic Number III
	 * 
	 * Write a function to count the total strobogrammatic numbers 
	 * that exist in the range of low <= num <= high.
	 * 
	 * For example,
	 * Given low = "50", high = "100", return 3. 
	 * Because 69, 88, and 96 are three strobogrammatic numbers.
	 * 
	 * Note:
	 * Because the range might be a large number, 
	 * the low and high numbers are represented as string.
	 * 
	 * Understand the problem:
	 * The idea would be very close to the previous problem.
	 * So we find all the strobogrammatic numbers between 
	 * the length of low and high. Note that when the n == low
	 * or n == high, we need to compare and make sure the 
	 * strobogrammatic number we find is within the range.
	 */
	 private static final char[][] pairs = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};

	 public int strobogrammaticInRange(String low, String high) {
	     int[] count = {0};
	     for (int len = low.length(); len <= high.length(); len++) {
	         char[] c = new char[len];
	         dfs(low, high, c, 0, len - 1, count);
	     }
	     return count[0];
	 }

	 private void dfs(String low, String high , char[] c, int left, int right, int[] count) {
	     if (left > right) {
	         String s = new String(c);
	         if ((s.length() == low.length() && s.compareTo(low) < 0) || 
	             (s.length() == high.length() && s.compareTo(high) > 0)) {
	             return;
	         }
	         count[0]++;
	         return;
	     }
	     for (char[] p : pairs) {
	         c[left] = p[0];
	         c[right] = p[1];
	         if (c.length != 1 && c[0] == '0') {
	             continue;
	         }
	         if (left == right && p[0] != p[1]) {
	             continue;
	         }
	         dfs(low, high, c, left + 1, right - 1, count);
	     }
	 }
	 
	public static void main(String[] args) {
		StrobogrammaticNumber sNum = new StrobogrammaticNumber();
		boolean result = sNum.isStrobogrammatic("69"); //Problem 1
		System.out.println("It is " + result + " that 69 is a Strobogrammatic Number");
		
		List<String> list = sNum.findStrobogrammatic(3);
		System.out.println("Strobogrammatic Number of 3 digits ");
		list.forEach(l -> System.out.print(l + " "));
		
		int count = sNum.strobogrammaticInRange("1", "2");
		System.out.println("\nThe number of Strobogrammatic Number of size 2-3 are " + count);
	}

}
