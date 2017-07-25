package vsourabh.datastructures.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sourabh
 *
 */
public class SubSets {

	/**
	 * 
	 * LeetCode:
	 * Given a collection of integers that might contain 
	 * duplicates, nums, return all possible subsets.
	 * The solution set must not contain duplicate subsets.
	 * 
	 * Example:
	 * If nums = [1,2,2], a solution is:
	 * [[2], [1], [1,2,2], [2,2], [1,2], []]
	 * 
	 */
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, 0);
		return list;
	}
	
	List<List<Integer>> subsetsWithDupLoop(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		for(int i=0; i < nums.length;){
			int count = 0; // num of elements are the same
			while(count + i < nums.length && nums[count+i]==nums[i])  count++;
			int previousN = list.size();
			for(int k=0; k<previousN; k++){
				List<Integer> instance = list.get(k);
				for(int j = 0; j < count; j++){
					instance.add(nums[i]);
					list.add(instance);
				}
			}
			i += count;
		}
		return list;
	}
	/*
	 * 
	 */
	
	/**
	 * 
	 * LeetCode:
	 * Given a set of distinct integers, nums, 
	 * return all possible subsets.
	 * solution set must not contain duplicate subsets.
	 * 
	 * Example:
	 * If  nums = [1,2,3], a solution is:
	 * [[3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], []]
	 */
	public List<List<Integer>> subsets(int[] nums) {
		 List<List<Integer>> list = new ArrayList<>();
		 Arrays.sort(nums);
		 backtrack(list, new ArrayList<>(), nums, 0);
		 return list;
	}

	private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start) {
		list.add(new ArrayList<>(tempList));
		for(int i = start; i < nums.length; i++){
			tempList.add(nums[i]);
			backtrack(list, tempList, nums, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}

	public void printList(List<List<Integer>> list) {
		System.out.print("[");
		list.forEach(inner -> {
			System.out.print("[");
			inner.forEach(ele -> System.out.print(ele + " "));
			System.out.print("]");
		});
		System.out.println("]");
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		
		System.out.println("Subsets without Duplicates");
		SubSets obj = new SubSets();
		List<List<Integer>> result = obj.subsets(nums);
		obj.printList(result);
		
		System.out.println("\nSubsets with Duplicates");
		nums = new int[] {1,2,2};
		result = obj.subsetsWithDupLoop(nums);
		obj.printList(result);
	}

}
