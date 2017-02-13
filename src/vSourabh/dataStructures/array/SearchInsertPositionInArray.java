package vSourabh.dataStructures.array;

/**
 * @author Sourabh
 * 
 * LeetCode
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 *
 */
public class SearchInsertPositionInArray {

	/**
	 * LeetCode
	 * Time Complexity : O(log(n))
	 * Space Complexity: O(1)
	 * 
	 */
	public int searchInsert(int[] A, int target) {
		int low = 0, high = A.length-1;
		while(low <= high) {
			int mid = (high - low) / 2 + low;
			if (A[mid] == target)
				return mid;
			else if (A[mid] > target)
				high = mid-1;
			else
				low = mid+1;
		}
		return low;
	}

	public static void main(String[] args) {
		SearchInsertPositionInArray obj = new SearchInsertPositionInArray();
		int num[] = {1,3,5,6};
		int result;
		result = obj.searchInsert(num, 0);
		System.out.println("SearchInsert 0 at " + result);
		
		result = obj.searchInsert(num, 4);
		System.out.println("SearchInsert 4 at " + result);
		
		result = obj.searchInsert(num, 8);
		System.out.println("SearchInsert 8 at " + result);
		

	}	

}
