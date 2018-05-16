package sourabhs.datastructures.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static int[] twoSum(int[] nums, int target) {

		if(nums == null || nums.length == 2)
			return nums;

		int[] res = new int[2];

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length ; i++) {
			if (map.containsKey(nums[i])) {
				res[0] = map.get(nums[i]);
				res[1] = i;
			} else {
				map.put(target - nums[i], i);
			}
		}
		return res;
	}

	// Total Time Complexity O(n^2) 
	public static synchronized int[] twoSumBruteForce(int[] nums, int target) {
		for(int i = 0; i < nums.length; i++) { // O(n)
			for(int j = i+1; j < nums.length; j++) { //O(n)
				if (nums[i] + nums[j] == target)
					return new int[]{i,j};
			}
		}
		return null;
	}
	
	//Total Time O(2*n)
	public static int[] twoSumTwoPass(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>(nums.length);
		for(int i = 0; i < nums.length; i++)
			map.put(nums[i], i);
		
		for(int i = 0; i < nums.length; i++)
			if(map.containsKey(target - nums[i]))
				return new int[] {i, map.get(target - nums[i])};
		return null;
			
	}

	public static void main(String args[]) {
		
		
		int res[] = twoSum(new int[] {2,5,7,9,11}, 12);
		System.out.println("Two Sum Number index: " + res[0] + " & " + res[1]);
		
		res = twoSum(new int[]{1,2,4,6,8,9}, 7);
		System.out.println("Two Sum Number index: " + res[0] + " & " + res[1]);
		
		res = twoSumBruteForce(new int[] {2,5,7,9,11}, 12);
		System.out.println("Two Sum Number index: " + res[0] + " & " + res[1]);
		
		res = twoSumTwoPass(new int[]{1,2,4,6,8,9}, 7);
		System.out.println("Two Sum Number index: " + res[0] + " & " + res[1]);
		
	}

}