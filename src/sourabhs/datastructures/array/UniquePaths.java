package sourabhs.datastructures.array;

import java.util.Arrays;

/**
 * @author Sourabh
 * 
 * LeetCode
 *  UniquePaths I
 *  UniquePaths II
 *
 */
public class UniquePaths {

	/**
	 * UniquePaths I
	 * 
	 * A robot is located at the top-left corner of a m x n grid 
	 * (marked 'Start' in the diagram below).
	 * 
	 * The robot can only move either down or right at any point in time. 
	 * The robot is trying to reach the bottom-right corner of the grid 
	 * (marked 'Finish' in the diagram below).
	 * 
	 * How many possible unique paths are there?
	 * Note: m and n will be at most 100.
	 */
	public int uniquePathsExtraSpace(int m, int n) {
		int path[][] = new int[m][n];
		for(int[] row : path)
			Arrays.fill(row, 1);
		for (int i = 1; i < m; i++)
			for (int j = 1; j < n; j++)
				path[i][j] = path[i - 1][j] + path[i][j - 1];
		return path[m - 1][n - 1];
	}
	
	public int uniquePaths(int m, int n) {
		if (m > n) return uniquePaths(n, m);
		int cur[] = new int[m];
		Arrays.fill(cur, 1);
		
		for (int j = 1; j < n; j++)
			for (int i = 1; i < m; i++)
				cur[i] += cur[i - 1]; 
		return cur[m - 1];
	}
	
	
	/**
	 * 
	 * UniquePaths II
	 * 
	 * Follow up for "Unique Paths":
	 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
	 * 
	 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
	 * For example,
	 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
	 * [ [0,0,0],
	 *   [0,1,0],
	 *   [0,0,0]]
	 *   
	 * The total number of unique paths is 2.
	 * Note: m and n will be at most 100.
	 */
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int width = obstacleGrid[0].length;
		int[] dp = new int[width];
		dp[0] = 1;
		for (int[] row : obstacleGrid) {
			for (int j = 0; j < width; j++) {
				if (row[j] == 1)
					dp[j] = 0;
				else if (j > 0)
					dp[j] += dp[j - 1];
			}
		}
		return dp[width - 1];
	}

	public int uniquePathsWithObstaclesDP(int[][] obstacleGrid) {

		//Empty case
		if(obstacleGrid.length == 0) return 0;

		int rows = obstacleGrid.length;
		int cols = obstacleGrid[0].length;

		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				if(obstacleGrid[i][j] == 1)
					obstacleGrid[i][j] = 0;
				else if(i == 0 && j == 0)
					obstacleGrid[i][j] = 1;
				else if(i == 0)
					obstacleGrid[i][j] = obstacleGrid[i][j - 1] * 1;// For row 0, if there are no paths to left cell, then its 0,else 1
				else if(j == 0)
					obstacleGrid[i][j] = obstacleGrid[i - 1][j] * 1;// For col 0, if there are no paths to upper cell, then its 0,else 1
				else
					obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
			}
		}
		return obstacleGrid[rows - 1][cols - 1];
	}

	public static void main(String[] args) {
		UniquePaths paths = new UniquePaths();
		int numOfPaths = paths.uniquePathsExtraSpace(3, 7);
		System.out.println("Number of Paths are " + numOfPaths);
		
		numOfPaths = paths.uniquePaths(3, 7);
		System.out.println("Number of Paths are " + numOfPaths);
		
		
		int[][] grid = new int[][] {{0,0,0},{0,1,0},{0,0,0}};
		numOfPaths = paths.uniquePathsWithObstacles(grid);
		System.out.println("Number of Paths without Obstacles are " + numOfPaths);

		numOfPaths = paths.uniquePathsWithObstaclesDP(grid);
		System.out.println("Number of Paths without Obstacles are " + numOfPaths);
	}

}
