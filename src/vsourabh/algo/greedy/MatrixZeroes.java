package vsourabh.algo.greedy;

import java.util.Arrays;

/**
 * @author Sourabh
 * 
 * LeetCode: 
 * Given a m x n matrix, if an element is 0, 
 * set its entire row and column to 0. Do it in place.
 * 
 * Follow up :
 * Did you use extra space?
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 */
public class MatrixZeroes {
	
	public void setZeroes(int[][] matrix) {
		 boolean colFirst = false;
		 int rows = matrix.length, cols = matrix[0].length;

		    for (int i = 0; i < rows; i++) {
		        if (matrix[i][0] == 0) colFirst = true;
		        for (int j = 1; j < cols; j++)
		            if (matrix[i][j] == 0)
		                matrix[i][0] = matrix[0][j] = 0;
		    }

		    for (int i = rows - 1; i >= 0; i--) {
		        for (int j = cols - 1; j >= 1; j--)
		            if (matrix[i][0] == 0 || matrix[0][j] == 0)
		                matrix[i][j] = 0;
		        if (colFirst) matrix[i][0] = 0;
		    }
	}

	public static void main(String[] args) {
		int mat[][] = {{1,2,1,1,3},{2,1,0,1,3},{2,1,4,5,6},{2,9,1,3,0}};
		MatrixZeroes obj = new MatrixZeroes();
		obj.setZeroes(mat);
		for(int[] row : mat)
			System.out.println( Arrays.toString(row));
		
		System.out.println("******************************************");
		mat = new int[][] {{1,2,0,1,3},{2,1,6,1,3},{0,1,4,5,6},{2,9,1,3,0}};
		obj.setZeroes(mat);
		for(int[] row : mat)
			System.out.println( Arrays.toString(row));
	}

}
