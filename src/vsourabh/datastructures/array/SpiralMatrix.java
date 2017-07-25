package vsourabh.datastructures.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sourabh
 * LeetCode:
 *   Spiral Matrix
 *   Spiral Matrix II
 */
public class SpiralMatrix {

	/**
	 * Spiral Matrix I
	 * 
	 * Given a matrix of m x n elements (m rows, n columns), 
	 * return all elements of the matrix in spiral order.
	 * 
	 * For example,
	 * Given the following matrix:
	 * [
	 *   [ 1, 2, 3 ],
	 *   [ 4, 5, 6 ],
	 *   [ 7, 8, 9 ]
	 * ]
	 * You should return [1,2,3,6,9,8,7,4,5].
	 */
	/*
	 * This is a very simple and easy to understand solution. 
	 * I traverse right and increment rowBegin, then traverse down 
	 * and decrement colEnd, then I traverse left and decrement 
	 * rowEnd, and finally I traverse up and increment colBegin.
	 * 
	 * The only tricky part is that when I traverse left or up I have
	 * to check whether the row or col still exists to prevent 
	 * duplicates.
	 */
	public List<Integer> spiralOrder(int[][] matrix) {

		List<Integer> res = new ArrayList<>();

		if (matrix.length == 0) 
			return res;

		int rowBegin = 0;
		int rowEnd = matrix.length-1;
		int colBegin = 0;
		int colEnd = matrix[0].length - 1;

		while (rowBegin <= rowEnd && colBegin <= colEnd) {
			// Traverse Right
			for (int j = colBegin; j <= colEnd; j ++) {
				res.add(matrix[rowBegin][j]);
			}
			rowBegin++;

			// Traverse Down
			for (int j = rowBegin; j <= rowEnd; j ++) {
				res.add(matrix[j][colEnd]);
			}
			colEnd--;

			if (rowBegin <= rowEnd) {
				// Traverse Left
				for (int j = colEnd; j >= colBegin; j --) {
					res.add(matrix[rowEnd][j]);
				}
			}
			rowEnd--;

			if (colBegin <= colEnd) {
				// Traver Up
				for (int j = rowEnd; j >= rowBegin; j --) {
					res.add(matrix[j][colBegin]);
				}
			}
			colBegin ++;
		}
		return res;
	}
	
	
	/**
	 * Spiral Matrix II
	 * 
	 * Given an integer n, generate a square matrix filled with 
	 * elements from 1 to n^2 in spiral order.
	 * For example,
	 * 
	 * Given n = 3, 
	 * Return the following matrix:
	 * [ [ 1, 2, 3 ],
	 *   [ 8, 9, 4 ],
	 *   [ 7, 6, 5 ]
	 * ]
	 */
	public int[][] generateMatrix(int n) {
		// Declaration
		int[][] matrix = new int[n][n];

		// Edge Case
		if (n == 0) {
			return matrix;
		}

		// Normal Case
		int rowStart = 0;
		int rowEnd = n-1;
		int colStart = 0;
		int colEnd = n-1;
		int num = 1; //change

		while (rowStart <= rowEnd && colStart <= colEnd) {
			for (int i = colStart; i <= colEnd; i ++) {
				matrix[rowStart][i] = num ++; //change
			}
			rowStart ++;

			for (int i = rowStart; i <= rowEnd; i ++) {
				matrix[i][colEnd] = num ++; //change
			}
			colEnd --;

			for (int i = colEnd; i >= colStart; i --) {
				if (rowStart <= rowEnd)
					matrix[rowEnd][i] = num ++; //change
			}
			rowEnd --;

			for (int i = rowEnd; i >= rowStart; i --) {
				if (colStart <= colEnd)
					matrix[i][colStart] = num ++; //change
			}
			colStart ++;
		}

		return matrix;
	}
	
	
	public static void main(String[] args) {

		SpiralMatrix obj = new SpiralMatrix();
		int[] mat[] = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		List<Integer> order = obj.spiralOrder(mat);
		order.forEach(System.out::print);
		
		System.out.println("\n");
		int result[][] = obj.generateMatrix(4);
		for(int[] row : result)
			System.out.print(Arrays.toString(row));
	}
}
