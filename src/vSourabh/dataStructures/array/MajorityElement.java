package vSourabh.dataStructures.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Sourabh
 *
 * Leetcode
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊ n/2 ⌋  times.
 * 
 */
public class MajorityElement {

	public int majorityUsingSorting(int[] nums) {
	    Arrays.sort(nums);
	    return nums[nums.length/2];
	}
	
	public int majorityUsingHashMap(int[] nums) {
	    Map<Integer, Integer> myMap = new HashMap<>();
	    int ret = 0;
	    for (int num: nums) {
	        if (!myMap.containsKey(num))
	            myMap.put(num, 1);
	        else
	            myMap.put(num, myMap.get(num)+1);
	        if (myMap.get(num) > nums.length/2) {
	            ret = num;
	            break;
	        }
	    }
	    return ret;
	}
	
	// Moore voting algorithm
	public int majorityUsingMooreAlgo(int[] nums) {
	    int count=0, ret = 0;
	    for (int num: nums) {
	        if (count==0)
	            ret = num;
	        if (num!=ret)
	            count--;
	        else
	            count++;
	    }
	    return ret;
	}

	// Bit manipulation 
	public int majorityUsingBit(int[] nums) {
	    int[] bit = new int[32];
	    for (int num: nums)
	        for (int i=0; i<32; i++) 
	            if ((num>>(31-i) & 1) == 1)
	                bit[i]++;
	    int ret=0;
	    for (int i=0; i<32; i++) {
	        bit[i]=bit[i]>nums.length/2?1:0;
	        ret += bit[i]*(1<<(31-i));
	    }
	    return ret;
	}
	
	public static void main(String[] args) {
		MajorityElement obj = new MajorityElement();
		
		int result = obj.majorityUsingSorting(new int[] {1, 2, 5, 6, 8, 1, 8, 2, 5, 1, 7, 2, 1, 9, 1});
		System.out.println("The Majority Element is " + result);
		
		int[] nums = new int[] {1, 2, 5, 6, 8, 1, 8, 2, 5, 1, 7, 2, 1, 9, 1};
		result = obj.majorityUsingHashMap(nums);
		System.out.println("The Majority Element is " + result);
		
		result = obj.majorityUsingMooreAlgo(nums);
		System.out.println("The Majority Element is " + result);

		result = obj.majorityUsingBit(nums);
		System.out.println("The Majority Element is " + result);
	}

}
