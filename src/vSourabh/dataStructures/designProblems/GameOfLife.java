package vSourabh.dataStructures.designProblems;

import vSourabh.dataStructures.utils.ArrayUtills;

/**
 * @author Sourabh
 * 
 * LeetCode
 * Rules of Game
 * a) Any live cell with fewer than two live neighbours dies, as if caused by under-population.
 * b) Any live cell with two or three live neighbours lives on to the next generation.
 * c) Any live cell with more than three live neighbours dies, as if by over-population.
 * d) Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
 * 
 * Solution:
 * 	[2nd bit, 1st bit] = [next state, current state]
 * 	  00  dead (next) <- dead (current)
 *    01  dead (next) <- live (current)  
 *    10  live (next) <- dead (current)  
 *    11  live (next) <- live (current) 
 *    
 * 
 * 
 */
public class GameOfLife {

	public void gameOfLife(int[][] board) {
	    if (board == null || board.length == 0) return;
	    int m = board.length, n = board[0].length;

	    for (int i = 0; i < m; i++) {
	        for (int j = 0; j < n; j++) {
	            int lives = liveNeighbors(board, m, n, i, j);

	            // In the beginning, every 2nd bit is 0;
	            // So we only need to care about when will the 2nd bit become 1.
	            if (board[i][j] == 1 && lives >= 2 && lives <= 3) {  
	                board[i][j] = 3; // Make the 2nd bit 1: 01 ---> 11
	            }
	            if (board[i][j] == 0 && lives == 3) {
	                board[i][j] = 2; // Make the 2nd bit 1: 00 ---> 10
	            }
	        }
	    }

	    for (int i = 0; i < m; i++) {
	        for (int j = 0; j < n; j++) {
	            board[i][j] >>= 1;  // Get the 2nd state.
	        }
	    }
	}

	public int liveNeighbors(int[][] board, int m, int n, int i, int j) {
	    int lives = 0;
	    for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
	        for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
	            lives += board[x][y] & 1;
	        }
	    }
	    lives -= board[i][j] & 1;
	    return lives;
	}
	
	public static void main(String[] args) {
		
		System.out.println("Board Game");
		GameOfLife obj = new GameOfLife();
		int[][] board = new int[][] {{1}};
		ArrayUtills.printArray(board[0]);
		obj.gameOfLife(board);
		ArrayUtills.printArray(board[0]);
	}

}
