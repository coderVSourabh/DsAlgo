package vsourabh.datastructures.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

	public static boolean containDuplicateBruteForce(int[] nums) {
		for(int i = 0; i < nums.length; i++)
            for(int j = i + 1; j < nums.length; j++)
				if(nums[i] == nums[j])
					return true;
		return false;
	}
	public static boolean containDuplicateSort(int[] nums) {
		Arrays.sort(nums);
		for(int i = 1; i < nums.length - 1; i++) 
			if(nums[i-1] == nums[i])
				return true;
		return false;
	}
	public static boolean containDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for(int n : nums) {
			if(set.contains(n))
				return true;
			else
				set.add(n);
		}
		return false;
	}
	public static void main(String[] args) {
		int nums[] = {1,3,5,6,8,2,3,10};
		int a[] = {1,2,6,9};
		boolean res = containDuplicateBruteForce(nums);
		System.out.println(res);
		res = containDuplicateBruteForce(a);
		System.out.println(res);
		
		res = containDuplicate(nums);
		System.out.println(res);
		res = containDuplicate(a);
		System.out.println(res);
		
		res = containDuplicateSort(nums);
		System.out.println(res);
		res = containDuplicateSort(a);
		System.out.println(res);

	}

}
