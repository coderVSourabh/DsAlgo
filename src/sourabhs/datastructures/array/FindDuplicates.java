package sourabhs.datastructures.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Sourabh
 * LeetCode : Find Duplicates in an 
 * 		Array having integer from 1 to n
 */
public class FindDuplicates {

	/**
	 * Time Complexity : O(n)
	 * Space Complexity : O(1)
	 * 
	 * From LeetCode
	 * 
	 * Integers from 1 to n find duplicates in array
	 */
	public List<Integer> findDuplicates(int[] nums) {
	    List<Integer> result = new ArrayList<>();
	    if(nums == null)
	        return result;
	    for(int i=0; i<nums.length; i++){
	        int location = Math.abs(nums[i])-1;
	        if(nums[location] < 0){
	            result.add(Math.abs(nums[i]));
	        }else{
	            nums[location] = -nums[location];
	        }
	    }
	    
	    //Correcting the original Array
	    for(int i=0; i<nums.length; i++)
	        nums[i] = Math.abs(nums[i]);
	   
	    return result;
	}
	
	

	/**
	 * Time Complexity : O(n)
	 * Space Complexity: O(1)
	 */
	public int findOneRepeating(int arr[]) {
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			int index = Math.abs(arr[i]) - 1;
			if (arr[index] < 0) {
				result = index + 1;
			} else {
				arr[index] = -arr[index];
			}
		}
		
		//Correcting the original Array
	    for(int i=0; i<arr.length; i++)
	        arr[i] = Math.abs(arr[i]);

		return result;
	}
	

	/**
	 * Time Complexity : O(nLog(n))
	 * Space Complexity: O(1)
	 */
	public  int findDuplicateUsingSorting(int arr[]) {
		int result = 0;
		Arrays.sort(arr);
		for(int i = 0; i< arr.length - 1; i++) {
			if(arr[i+1]-arr[i] == 0) {
				result = arr[i];
				break;
			}
		}
		return result;
	}

	/**
	 * LeetCode
	 * 	217. Contains Duplicate
	 * 
	 * Time Complexity : O(n*n)
	 * Space Complexity: O(1)
	 */
	public boolean containsDuplicateBruteForce(int[] nums) {
		
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
	
	
	/**
	 * LeetCode
	 * 	217. Contains Duplicate
	 * 
	 * Time Complexity : O(nlog(n))
	 * Space Complexity: O(1)
	 */
	public boolean containsDuplicateBySorting(int[] nums) {

        Arrays.sort(nums);
        for (int ind = 1; ind < nums.length; ind++) {
            if (nums[ind] == nums[ind - 1]) {
                return true;
            }
        }
        return false;
    }
	
	/**
	 * LeetCode
	 * 	217. Contains Duplicate
	 * 
	 * Time Complexity : O(n)
	 * Space Complexity: O(n)
	 */
	public boolean containsDuplicate(int[] nums) {

	    final Set<Integer> distinct = new HashSet<>();
	    for(int num : nums) {
	        if(distinct.contains(num)) {
	            return true;
	        }
	        distinct.add(num);
	    }
	    return false;
	}
	
	
	/**
	 * 
	 * LeetCode
	 * 	219. Contains Duplicate II
	 * 
	 * Given an array of integers and an integer k, 
	 * find out whether there are two distinct indices 
	 * i and j in the array such that nums[i] = nums[j] 
	 * and the absolute difference between i and j is at
	 * most k.
	 * 
	 * Time Complexity : O(n)
	 * Space Complexity: O(n)
	 * 
	 */
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;    
	}
	
	public static void main(String[] args) {
		int arr[] = {4,3,2,7,8,2,3,1};
		FindDuplicates obj = new FindDuplicates();
		List<Integer> lst =  obj.findDuplicates(arr);
		System.out.print("Duplicates are: ");
		for(int i : lst) 
			System.out.print(i + " ");
		
		arr = new int[] { 1, 3, 4, 5, 5, 6, 2 };
		int repeated = obj.findOneRepeating(arr);
		System.out.println("\n Repeated one is :" + repeated);
		
		repeated = obj.findDuplicateUsingSorting(arr);
		System.out.println("Duplicated one using Sorting is " + repeated);
		
		System.out.println(Math.round(21.9));

	}

}
