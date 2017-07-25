/**
 * 
 */
package vsourabh.datastructures.array;

import java.util.Arrays;

import vsourabh.datastructures.utils.ArrayUtills;

/**
 * @author Sourabh
 *
 */
public class ConsecutiveElementCheckInArray {
	
	/**
	 * 
	 *  Time Complexity : O(n), 
	 *  Space Complexity: O(1)
	 *  it works only if all numbers are positive and array modifications are allowed
	 */
	public static boolean isArrayElementsConsecutiveWithSameMemory(int[] arr) {
		int[] minMax= findMinMaxUsingTournamentMethod(arr, 0, arr.length - 1);

		if(minMax.length == 2)
			System.out.println("Min: " + minMax[1] + " Max: " + minMax[0]);
		
		int len = minMax[0] - minMax[1] + 1;
		
		if (len != arr.length)
			return false;

		int index, min = minMax[1];
		for (int i = 0; i < arr.length; i++) {
			index = Math.abs(arr[i]) - min;
			if (arr[index] < 0) {
				return false;
			}
			arr[index] = -arr[index];
		}
		return true;
	}
	/**
	 * Time Complexity  : O(n)
	 * Space Complexity : O(n)
	 * 
	 */
	public static boolean isArrayElementsConsecutive(int[] arr) {
		int[] minMax = findMinMaxUsingTournamentMethod(arr, 0, arr.length - 1);
		
		if(minMax.length == 2)
			System.out.println("Min: " + minMax[1] + " Max: " + minMax[0]);
		
		int len = minMax[0] - minMax[1] + 1;
		//Check if Max - Min = total elements in array otherwise array is not Consecutive
		if (len != arr.length)
			return false;

		int index, min = minMax[1];
		boolean visited[] = new boolean[len];
		for (int i = 0; i < arr.length; i++) {
			index = arr[i] - min; // index will be 0,1,2 ... arr.length if consecutive elements
			if (visited[index]) { // If repeated elements
				return false;
			}
			visited[index] = true;
		}
		return true;
	}
	
	/**
	 * 
	 * Tournament Method Compares 2 elements and decides the winners of that label 
	 * i.e. min and max from that label then goes on to find one min and max
	 * example: Min tournament 
	 *                1
	 *               /\
	 *              1  2
	 *             /\  /\
	 *            1  5 8 2
	 *
	 */
	private static int[] findMinMaxUsingTournamentMethod(int arr[], int start, int end) {
		int curr = end - start + 1;
		int max, min;
		int[] leftmaxmin, rightmaxmin;
		if (curr == 1) {
			min = max = arr[start];
			return new int[] {max, min};
		} else if (curr == 2) {
			if (arr[start] > arr[end]) {
				max = arr[start];
				min = arr[end];
			} else {
				max = arr[end];
				min = arr[start];
			}
			return new int[] {max, min};
		} else {
			int mid = start + (end - start) / 2;
			leftmaxmin = findMinMaxUsingTournamentMethod(arr, start, mid);
			rightmaxmin = findMinMaxUsingTournamentMethod(arr, mid + 1, end);
		}
		max = leftmaxmin[0] > rightmaxmin[0] ? leftmaxmin[0] : rightmaxmin[0];
		min = leftmaxmin[1] < rightmaxmin[1] ? leftmaxmin[1] : rightmaxmin[1];
		return new int[] {max, min};
	}

	/**
	 * Using sorting, brute force
	 * Time Complexity: O(nLog(n))
	 */
	public static boolean isArrayElementsConsecutiveBySort(int arr[]) {
		Arrays.sort(arr);
		boolean retVar = true;
	
		//If no elements in the array
		if(arr.length == 0)
			return false;
		
		for(int i = 0; i < arr.length - 1;) {
			//Check if all elements are consecutive or not if not break the loop by increasing i
			i = (retVar &= (arr[i + 1] - arr[i] == 1)) ? ++i  : arr.length; 
			// Simple condition same as above
		    /*if (arr[i + 1] - arr[i] != 1) {
				return false;
			}*/
		}

		return retVar;
	}
	
	public static void main(String[] args) {
		
		boolean result = false;
		int arrA[] = { 83, 78, 78, 81, 79, 82 };
		int arrB[] = { 83, 78, 80, 81, 79, 82 };
		
		ArrayUtills.printArray(arrB);
		result = ConsecutiveElementCheckInArray.isArrayElementsConsecutiveBySort(arrB);
		System.out.println("is Sorted Array consecutive - " + result);

		ArrayUtills.printArray(arrA);
		result = ConsecutiveElementCheckInArray.isArrayElementsConsecutive(arrA);
		System.out.println("is Array consecutive - " + result);

		result = ConsecutiveElementCheckInArray.isArrayElementsConsecutiveWithSameMemory(arrA);
		System.out.println("is Array consecutive No Extra space method - " + result);

	}

}
