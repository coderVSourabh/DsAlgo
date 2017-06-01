package vSourabh.dataStructures.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sourabh
 * 
 * LeetCode:
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * "123" "132" "213" "231" "312" "321"
 * Given n and k, return the kth permutation sequence.
 * 
 * Note: Given n will be between 1 and 9 inclusive.
 *
 */
public class PermutationSequence {

	/**
	 * The pattern was that:
	 * say n = 4, you have {1, 2, 3, 4}
	 * First Term constant + (permutations of 3 Terms)
	 * 
	 * (permutations of 3 Terms) =
	 * First Term constant + (permutations of 2 Terms)
	 * 
	 * (permutations of 2 Terms) = {a,b} and {b,a}
	 * 
	 */
	public String getPermutation(int n, int k) {
		
		List<Integer> numbers = new ArrayList<>();
		int[] factorial = new int[n+1];
		StringBuilder sb = new StringBuilder();

		// create an array of factorial lookup
		int sum = 1;
		factorial[0] = 1;
		for(int i=1; i<=n; i++){
			sum *= i;
			factorial[i] = sum;
		}
		// factorial[] = {1, 1, 2, 6, 24, ... n!}

		// create a list of numbers to get indices
		for(int i=1; i<=n; i++){
			numbers.add(i);
		}
		// numbers = {1, 2, 3, 4}

		k--;

		for(int i = 1; i <= n; i++){
			int index = k/factorial[n-i];
			sb.append(String.valueOf(numbers.get(index)));
			numbers.remove(index);
			k-=index*factorial[n-i];
		}

		return String.valueOf(sb);
	}
	
	public static void main(String[] args) {
		PermutationSequence obj = new PermutationSequence();
		String result = obj.getPermutation(4, 3);
		System.out.println("The Permutation is " + result);

	}

}
