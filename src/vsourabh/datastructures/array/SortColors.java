package vsourabh.datastructures.array;

import vsourabh.datastructures.utils.ArrayUtills;

/**
 * @author Sourabh
 * 
 * LeetCode:
 * 
 * Given an array with n objects colored red, white or blue, 
 * sort them so that objects of the same color are adjacent, 
 * with the colors in the order red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the 
 * color red, white, and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function 
 * for this problem.
 * 
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm
 * using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's,
 * then overwrite array with total number of 0's, then 1's and followed by 2's.
 * 
 * Could you come up with an one-pass algorithm using only constant space?
 */
public class SortColors {

	public void sortColors(int A[], int n) {
        int second=n-1, zero=0;
        for (int i=0; i<=second; i++) {
            while (A[i]==2 && i<second) ArrayUtills.swap(A, i, second--);
            while (A[i]==0 && i>zero) ArrayUtills.swap(A, i, zero++);
        }
    }
	
	public void sortColorsOneLoop(int A[], int n) {
	    int j = 0, k = n-1;
	    for (int i=0; i <= k; i++) {
	        if (A[i] == 0)
	        	ArrayUtills.swap(A, i, j++);
	        else if (A[i] == 2)
	        	ArrayUtills.swap(A, i--, k--);
	    }
	}
	
	public static void main(String[] args) {
		int arr[] = {0,1,2,1,0,2,0,1,0,2,1,0,1,2,0,1,2,1,0};
		SortColors obj = new SortColors();
		System.out.print("Before :");
		ArrayUtills.printArray(arr);
		obj.sortColors(arr, arr.length);
		System.out.print("After :");
		ArrayUtills.printArray(arr);
		
		arr = new int[] {0,1,2,1,0,2,0,1,0,2,1,0,1,2,0,1,2,1,0};
		System.out.print("\nBefore :");
		ArrayUtills.printArray(arr);
		obj.sortColorsOneLoop(arr, arr.length);
		System.out.print("After :");
		ArrayUtills.printArray(arr);
	
	}

}
