package sourabhs.datastructures.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sourabh
 * 
 * LeetCode: 
 * Given a triangle, find the minimum path sum from 
 * top to bottom. Each step you may move to adjacent 
 * numbers on the row below.
 * 
 * For example, given the following triangle
 * [  [2],
 *   [3,4],
 *  [6,5,7],
 * [4,1,8,3]]
 * 
 * The minimum path sum from top to 
 * bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11). 
 * 
 * Note: Bonus point if you are able to do this 
 * using only O(n) extra space, where n is the total number 
 * of rows in the triangle. 
 *
 */
public class Triangle {

	public int minimumTotal(List<List<Integer>> triangle) {
	    int n = triangle.size(), minLen[] = new int[n+1];
	    for (int layer = n-1; layer >= 0; layer--) {// For each layer
	        for (int i = 0; i < triangle.get(layer).size(); i++) { // Check its every 'node'
	            // Find the lesser of its two children, and sum the current value in the triangle with it.
	            minLen[i] = Math.min(minLen[i], minLen[i+1]) + triangle.get(layer).get(i); 
	        }
	    }
	    return minLen[0];
	}
	
	public static void main(String[] args) {
		List<List<Integer>> triangle = new ArrayList<>();
		triangle.add(0, Arrays.asList(2));
		triangle.add(1, Arrays.asList(3,4));
		triangle.add(2, Arrays.asList(6,5,7));
		triangle.add(3, Arrays.asList(3,4,1,8));
		
		Triangle tri = new Triangle();
		int result = tri.minimumTotal(triangle);
		System.out.println("Sum is " + result);
	}
}
