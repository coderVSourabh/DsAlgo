package vsourabh.datastructures.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Sourabh
 * 
 * LeetCode:
 * 
 * Given an array S of n integers, are there elements a, b, c in S 
 * such that a + b + c = 0? Find all unique triplets in the array 
 * which gives the sum of zero.
 * 
 * Note: The solution set must not contain duplicate triplets.
 * 
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is:
 * [[-1, 0, 1],
 *  [-1, -1, 2]]
 *
 */
public class ThreeSum {

	public List<List<Integer>> threeSum(int[] num) {
	    Arrays.sort(num);  
	    List<List<Integer>> res = new LinkedList<>(); 
	    for (int i = 0; i < num.length-2; i++) {
	        if (i == 0 || (i > 0 && num[i] != num[i-1])) {
	            int lo = i+1, hi = num.length-1, sum = -num[i];
	            while (lo < hi) {
	                if (num[lo] + num[hi] == sum) { //Matching Case
	                    res.add(Arrays.asList(num[i], num[lo], num[hi]));
	                    while (lo < hi && num[lo] == num[lo+1]) //Ignore equal Terms
	                    	lo++;
	                    while (lo < hi && num[hi] == num[hi-1])  //Ignore equal Terms
	                    	hi--;
	                    lo++;  // Change Low High for next comparision
	                    hi--;
	                } else if (num[lo] + num[hi] < sum) // Less than Sum
	                	lo++;
	                else  // Greater Than Sum 
	                	hi--;
	           }
	        }
	    }
	    return res;
	}
	
	public List<List<Integer>> threeSumUsingMap(int[] num) {
	    Arrays.sort(num);  
	    List<List<Integer>> res = new LinkedList<>(); 
	    for (int i = 0; i < num.length-2; i++) {
	        if (i == 0 || (i > 0 && num[i] != num[i-1])) {
	        	Map<Integer, Integer> twoSum = new HashMap<>();
	            for (int j = i+1; j < num.length; j++) {
	            	if(twoSum.containsKey(0 - (num[i] + num[j])))
	            		res.add(Arrays.asList(i, j, twoSum.get(0 -(num[i] + num[j]))));
	            	else
	            		twoSum.put(num[j], j);
	            }
	        }
	    }
	    return res;
	}
	
	public static void main(String[] args) {
		ThreeSum obj = new ThreeSum();
		List<List<Integer>> result = obj.threeSum(new int[] {1,2,3,-5,-3,4,-7,-8});
		result.forEach( p -> {
			System.out.print("[ ");
			p.forEach(intVal -> System.out.print(intVal + " "));
			System.out.println("] ");
		});
		
		System.out.println("********* USING MAP *********");
		
		int[] arr = new int[] {1,2,3,-5,-3,4,-7,-8};
		result = obj.threeSumUsingMap(arr);
		result.forEach( p -> {
			System.out.print("[ ");
			p.forEach(intVal -> System.out.print(arr[intVal] + " "));
			System.out.println("] ");
		});
	}

}
