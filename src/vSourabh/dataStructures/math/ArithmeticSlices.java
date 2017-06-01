package vSourabh.dataStructures.math;

/**
 * @author Sourabh
 *
 * LeetCode:
 * A sequence of number is called arithmetic 
 * if it consists of at least three elements 
 * and if the difference between any two c
 * onsecutive elements is the same.
 * 
 * For example, 
 * These are arithmetic sequence:
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * 
 * The following sequence is not arithmetic.
 * 1, 1, 2, 5, 7
 *
 */
public class ArithmeticSlices {

	/**
	 * LeetCode: 413
	 * 
	 * Example
	 *  A zero-indexed array arr consisting of N numbers
	 * is given. A slice of that array is any pair of
	 * integers (P, Q) such that 0 <= P < Q < N.
	 * 
	 * A slice (P, Q) of array arr is called arithmetic 
	 * if the sequence:
	 * arr[P], arr[p + 1], ..., arr[Q - 1], arr[Q] is arithmetic.
	 * In particular, this means that P + 1 < Q.
	 * 
	 * The function should return the number of arithmetic slices in the array arr.
	 * arr = [1, 2, 3, 4]
	 * return: 3, for 3 arithmetic slices in arr: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
	 */
	public int numberOfArithmeticSlices(int[] arr) {
		int curr = 0, sum = 0;
		for (int i=2; i<arr.length; i++)
			if (arr[i]-arr[i-1] == arr[i-1]-arr[i-2]) {
				curr += 1;
				sum += curr;
			} else {
				curr = 0;
			}
		return sum;
	}
	
	public static void main(String[] args) {
		ArithmeticSlices obj = new ArithmeticSlices();
		int result = obj.numberOfArithmeticSlices(new int[] {2, 4, 6, 8, 10});
		System.out.println("The number of Arithmetic Series Slices are " + result);
		
		result = obj.numberOfArithmeticSlices(new int[] {1, 1, 1});
		System.out.println("The number of Arithmetic Series Slices are " + result);
		
		result = obj.numberOfArithmeticSlices(new int[] {1, -1, 5});
		System.out.println("The number of Arithmetic Series Slices are " + result);
	}

}
