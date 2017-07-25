package vsourabh.datastructures.designproblems;

import vsourabh.datastructures.utils.ArrayUtills;

/**
 * @author Sourabh
 * 
 * LeetCode
 * 
 * Given:
 * 	    length = 5,
 * 	    updates = [[1,  3,  2],
 *                 [2,  4,  3],
 *                 [0,  2, -2]]
 * Output:
 * 		[-2, 0, 3, 5, 3]
 * 
 * Explanation:
 * 		Initial state:
 * 			[ 0, 0, 0, 0, 0 ]
 * 		After applying operation [1, 3, 2]:
 * 			[ 0, 2, 2, 2, 0 ]
 * 		After applying operation [2, 4, 3]:
 * 			[ 0, 2, 5, 5, 3 ]
 * 		After applying operation [0, 2, -2]:
 * 			[-2, 0, 3, 5, 3 ]
 *
 */
public class RangeAddition {
	
	public int[] getModifiedArray(int length, int[][] updates) {

	    int[] res = new int[length];
	     for(int[] update : updates) {
	        int value = update[2];
	        int start = update[0];
	        int end = update[1];
	        
	        res[start] += value;
	        
	        if(end < length - 1)
	            res[end + 1] -= value;
	        
	    }
	    
	    int sum = 0;
	    for(int i = 0; i < length; i++) {
	        sum += res[i];
	        res[i] = sum;
	    }
	    
	    return res;
	}

	public static void main(String[] args) {
		RangeAddition rangeAdd = new RangeAddition();
		int[] result = rangeAdd.getModifiedArray(5, new int[][] {{1,  3,  2},{2,  4,  3},{0,  2, -2}});
		ArrayUtills.printArray(result);

	}

}
