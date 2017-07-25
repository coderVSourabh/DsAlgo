package vsourabh.datastructures.array;

import java.util.Arrays;

/**
 * @author Sourabh
 * 
 * LeetCode:
 * Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right which minimizes 
 * the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 */
public class MinPathSum {
	
	public int minPathSumExtraSpace(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length; 
		int[][] sum = new int[m][n];
		for(int[] row : grid)
			Arrays.fill(row, grid[0][0]);
		for (int i = 1; i < m; i++)
			sum[i][0] = sum[i - 1][0] + grid[i][0];
		for (int j = 1; j < n; j++)
			sum[0][j] = sum[0][j - 1] + grid[0][j];
		for (int i = 1; i < m; i++)
			for (int j = 1; j < n; j++)
				sum[i][j]  = Integer.min(sum[i - 1][j], sum[i][j - 1]) + grid[i][j];
		return sum[m - 1][n - 1];
	}
	
	public int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length; 
		int[] cur = new int[m];
		Arrays.fill(cur, grid[0][0]);
		for (int i = 1; i < m; i++)
			cur[i] = cur[i - 1] + grid[i][0]; 
		for (int j = 1; j < n; j++) {
			cur[0] += grid[0][j]; 
			for (int i = 1; i < m; i++)
				cur[i] = Integer.min(cur[i - 1], cur[i]) + grid[i][j];
		}
		return cur[m - 1];
	}
	
	public int minPathSumNoExtraSpace(int[][] grid) {
		int m = grid.length;// row
		int n = grid[0].length; // column
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j != 0) {
					grid[i][j] = grid[i][j] + grid[i][j - 1];
				} else if (i != 0 && j == 0) {
					grid[i][j] = grid[i][j] + grid[i - 1][j];
				} else if (i == 0 && j == 0) {
					grid[i][j] = grid[i][j];
				} else {
					grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j])
							+ grid[i][j];
				}
			}
		}

		return grid[m - 1][n - 1];
	}
	 
	public static void main(String[] args) {
		int[][] grid = {{1,2,1,1}, {2,4,1,1}, {2,1,4,3}, {5,1,1,3}};
		MinPathSum obj = new MinPathSum();
		
		int result = obj.minPathSumExtraSpace(grid);
		System.out.println("Shortest Path is " + result);
		
		result = obj.minPathSum(grid);
		System.out.println("Shortest Path is " + result);
		
		result = obj.minPathSumNoExtraSpace(grid);
		System.out.println("Shortest Path is " + result);
	}

}
