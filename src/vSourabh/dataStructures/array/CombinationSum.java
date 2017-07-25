package vsourabh.datastructures.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sourabh
 * 
 * LeetCode:
 *
 */
public class CombinationSum {

	/**
	 * LeetCode:
	 * Find all possible combinations of k numbers 
	 * that add up to a number n, given that only 
	 * numbers from 1 to 9 can be used and each 
	 * combination should be a unique set of numbers.
	 * 
	 * Input:  k = 3, n = 7
	 * Output: [[1,2,4]]
	 * 
	 * Input:  k = 3, n = 9
	 * Output: [[1,2,6], [1,3,5], [2,3,4]]
	 */
	public List<List<Integer>> combinationSum3(int k, int n) {
	    List<List<Integer>> ans = new ArrayList<>();
	    combination(ans, new ArrayList<>(), k, 1, n);
	    return ans;
	}

	private void combination(List<List<Integer>> ans, List<Integer> comb, int k,  int start, int n) {
		if (comb.size() == k && n == 0) {
			List<Integer> li = new ArrayList<>(comb);
			ans.add(li);
			return;
		}
		for (int i = start; i <= 9; i++) {
			comb.add(i);
			combination(ans, comb, k, i+1, n-i);
			comb.remove(comb.size() - 1);
		}
	}
	
	/**
	 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), 
	 * find all unique combinations in C where the candidate numbers sums to T.
	 * 
	 * The same repeated number may be chosen from C unlimited number of times.
	 * Example, given candidate set [2, 3, 6, 7] and target 7, 
	 * Solution : [[7],  [2, 2, 3]]
	 */
	public List<List<Integer>> combinationSum(int[] nums, int target) {
		List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, target, 0);
	    return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
	    if(remain < 0) return;
	    else if(remain == 0) list.add(new ArrayList<>(tempList));
	    else{ 
	        for(int i = start; i < nums.length; i++){
	            tempList.add(nums[i]);
	            backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
	            tempList.remove(tempList.size() - 1);
	        }
	    }
	}

	
	/**
	 * Given a collection of candidate numbers (C) and a target number (T), 
	 * find all unique combinations in C where the candidate numbers sums to T.
	 * Each number in C may only be used once in the combination.
	 * 
	 * All numbers (including target) will be positive integers.
	 * The solution set must not contain duplicate combinations.
	 * 
	 * For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
	 * [[1, 7], [1, 2, 5], [2, 6], [1, 1, 6]]
	 * 
	 */
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		dfs_com(candidates, 0, target, path, res);
		return res;
	}
	
	private void dfs_com(int[] cand, int cur, int target, List<Integer> path, List<List<Integer>> res) {
		
		if (target == 0) {
			res.add(new ArrayList<>(path));
			return;
		}
		
		if (target < 0) 
			return;
		
		for (int i = cur; i < cand.length; i++){
			if (i > cur && cand[i] == cand[i-1]) 
				continue;
			
			path.add(path.size(), cand[i]);
			dfs_com(cand, i+1, target - cand[i], path, res);
			path.remove(path.size()-1);
		}
	}
	
	
	/**
	 * Printing the List of List
	 */
	public void printList(List<List<Integer>> result) {
		System.out.print("[");
		result.forEach(p -> {
			System.out.print("[");
			p.forEach( j -> System.out.print(j + " "));
			System.out.print("]");
		});System.out.println("]");
	}
	
	public static void main(String[] args) {

		System.out.println("combinationSum3");
		CombinationSum obj = new CombinationSum();
		List<List<Integer>> result = obj.combinationSum3(3, 9);
		obj.printList(result);
		
		System.out.println("\ncombinationSum2");
		int[] input = {10, 1, 2, 7, 6, 1, 5};
		result = obj.combinationSum2(input, 8);
		obj.printList(result);
		
		System.out.println("\ncombinationSum");
		input = new int[] {2, 3, 6, 7};
		result = obj.combinationSum(input, 7);
		obj.printList(result);
	}
}
