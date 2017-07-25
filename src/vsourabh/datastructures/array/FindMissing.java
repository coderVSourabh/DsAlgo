package vsourabh.datastructures.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import vsourabh.datastructures.utils.ArrayUtills;

/**
 * @author Sourabh
 * LeetCode : To Find Numbers missing in an 
 *  	array on integers 1 to n
 *
 */
public class FindMissing {
	
	
	/**
	 * Time Complexity : O(n)
	 * Space Complexity: O(1);
	 * 
	 * LeetCode
	 */
	 public static List<Integer> findDisappearedNumbers(int[] nums) {
	        List<Integer> ret = new ArrayList<>();
	        
	        for(int i = 0; i < nums.length; i++) {
	            int val = Math.abs(nums[i]) - 1;
	            if(nums[val] > 0) {
	                nums[val] = -nums[val];
	            }
	        }
	        
	        for(int i = 0; i < nums.length; i++) {
	            if(nums[i] > 0) {
	                ret.add(i+1);
	            }
	        }
	        return ret;
	    }
	 
	/**
	 * Time Complexity : O(n)
	 * Space Complexity: O(1)
	 */
	public static int findMissingIn1toN(int[] arr) {
		 int i, total;
		 total  = (arr.length + 1) * (arr.length + 2)/2;   
		 for ( i = 0; i< arr.length; i++)
			 total -= arr[i];
		 return total;
	}
	
	
	/**
	 * LeetCode:
	 * 
	 * Given an array containing n distinct numbers 
	 * taken from 0, 1, 2, ..., n, 
	 * find the one that is missing from the array.
	 * 
	 * Given nums = [0, 1, 3] return 2.
	 * 
	 * Time Complexity : O(n)
	 * Space Complexity: O(1)
	 */
	public static int missingNumber(int[] nums) {

	    int xor = 0, i = 0;
		for (i = 0; i < nums.length; i++) {
			xor = xor ^ i ^ nums[i];
		}
		return xor ^ i;
	}

	/**
	 * Time Complexity : O(n)
	 * Space Complexity: O(1)
	 */
	public static int findMissingIn1toNUsingXOR(int[] arr) {
		int i;
	    int x1 = arr[0]; /* For xor of all the elements in array */
	    int x2 = 1;     /* For xor of all the elements from 1 to n+1 */
	     
	    for (i = 1; i< arr.length; i++)
	        x1 = x1^arr[i];
	            
	    for ( i = 2; i <= arr.length + 1; i++)
	        x2 = x2^i;         
	    return (x1^x2);
	}
	

	/**
	 * Time Complexity : O(nLog(n))
	 * Space Complexity: O(1)
	 */
	public static int findMissing(int[] arr) {
		Arrays.sort(arr);
		int result = 0;
		if(arr[arr.length - 1]  - arr[0] == arr.length + 1)
			return 0; // Nothing is missing
		for (int i = 0; i < arr.length - 1; i++) {
			if(arr[i+1] - arr[i] > 1) {
				result =  arr[i+1] - 1;
				break;
			}
		}
		return result;
	}
	
	/**
	 * Time Complexity : O(n)
	 * Space Complexity: O(n) -- for stack
	 */
	public static int findMissingSmallestNumberUsingRecursiveBinarySearch(int[] arr, int left, int right) {
		if (left > right)
			return right + 1;

		if (arr[left] != left ) // Array starting with 1
			return left;

		int mid = left + (right - left) / 2;

		if (arr[mid] > mid) 
			return findMissingSmallestNumberUsingRecursiveBinarySearch(arr, left, mid);
		else 
			return findMissingSmallestNumberUsingRecursiveBinarySearch(arr, mid + 1, right);
	}
	
	public static int findSmallestMissingNumberUsingBinarySearch(int[] arr, int left, int right) {
		int mid, retVal = right - left + 1;
		while (left <= right) {
			mid = left + (right - left) / 2;
			if (arr[mid] != mid && (mid == 0 || arr[mid - 1] == mid - 1)) {
				return mid;
			} else if (arr[mid] == mid) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return retVal;
	}

	
	/**
	 * Time Complexity : O(n)
	 */
	public static int findSmallestMissingPositiveNumber(int[] arr) {
		int left = 0, right = arr.length - 1,  index;
		while (left < right) {
			while (left < right && arr[left] > 0)
				left++;
			while (left < right && arr[right] < 0)
				right--;
			if (left < right) {
				ArrayUtills.swap(arr, left, right);
				left++;
				right--;
			}
		}
		
		for (int i = 0; i < left; i++) {
			index = Math.abs(arr[i]) - 1;
			if (index < left && arr[index] > 0) {
				arr[index] = -arr[index];
			}
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				return i + 1;
			}
		}
		return left;
	}


	public static void main(String[] args) {
		int arrA[] = { 1, 3, 4, 5, 5, 6, 2 };
		int arrB[] = {1, 2, 4, 5, 6};
		
		int missed = findMissingIn1toN(arrB);
		System.out.println("The missing element between 1 - " + arrB.length + " is " + missed);
		
		//LeetCode
		List<Integer> lst = findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
		System.out.println("The disappeared numbers are "+ lst);
		
		missed = findMissingIn1toNUsingXOR(arrA);
		System.out.println("The missing element using XOR method between 1 - " + arrB.length + " is " + missed);
		
		
		arrB = new int[]{2 ,4, 1, 5, -1};
		missed = findSmallestMissingPositiveNumber(arrB);
		System.out.println("The Missing positive element of array from 1 - " + (arrB.length -1) + " is " + missed);
		
		arrB = new int[] {0, 1, 2, 3 , 5, 6};
		missed = findMissingSmallestNumberUsingRecursiveBinarySearch(arrB, 0, arrB.length - 1);
		System.out.println("The Missing element using recusrsive Binary Search of array from 0 - " + (arrB.length -1) + " is " + missed);
		
		missed = findSmallestMissingNumberUsingBinarySearch(arrB, 0, arrB.length - 1);
		System.out.println("The Missing element using Binary Search of array from 0 - " + (arrB.length -1) + " is " + missed);
		
		arrA = new int[]{7, 4, 10, 6, 9, 11, 5};
		arrB = new int[]{5, 8, 6 , 10, 12 , 12, 11, 9 , 7};
		
		missed = findMissing(arrA);
		System.out.println("The missing element is " + missed);		
		
		missed = missingNumber(new int[] {0,1,2,4,5,6});
		System.out.println("The missing number is " + missed);		
	}
}
