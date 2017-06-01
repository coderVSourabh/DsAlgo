package vSourabh.dataStructures.hashTable;

/**
 * @author Sourabh
 * LeetCode :
 * You are given a map in form of a two-dimensional integer 
 * grid where 1 represents land and 0 represents water. Grid 
 * cells are connected horizontally/vertically (not diagonally).
 * The grid is completely surrounded by water, and there is exactly
 * one island (i.e., one or more connected land cells). The island
 * doesn't have "lakes" (water inside that isn't connected to the
 * water around the island). One cell is a square with side length 1.
 * The grid is rectangular, width and height don't exceed 100. 
 * Determine the perimeter of the island.
 */

public class IslandPerimeter {


	/**
	 * [[0,1,0,0], [1,1,1,0], [0,1,0,0], [1,1,0,0]]
	 * Answer: 16
	 * 
	 * loop over the matrix and count the number of islands;
	 * if the current dot is an island, count if it has any right neighbour or down neighbour;
	 * the result is islands * 4 - neighbours * 2
	 */
	public int islandPerimeter(int[][] grid) {
		int islands = 0, neighbours = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					islands++; // Count islands
					if (i < grid.length - 1 && grid[i + 1][j] == 1) 
						neighbours++; // Count down neighbours
					if (j < grid[i].length - 1 && grid[i][j + 1] == 1)
						neighbours++; // Count right neighbours
				}
			}
		}
		return islands * 4 - neighbours * 2;
	}

	
	public static void main(String[] args) {
		int[][] island = {{0,1,0,0}, {1,1,1,0}, {0,1,0,0}, {1,1,0,0}};
		IslandPerimeter obj = new IslandPerimeter();
		int result = obj.islandPerimeter(island);
		System.out.println("The perimeter of the island is " + result);
	}
}
