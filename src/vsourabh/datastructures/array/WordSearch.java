package vsourabh.datastructures.array;

/**
 * @author Sourabh
 * 
 * LeetCode:
 * 
 * Word Search
 * 
 * Given a 2D board and a word, 
 * find if the word exists in the grid. 
 * 
 * The word can be constructed from letters of 
 * sequentially adjacent cell, where "adjacent" 
 * cells are those horizontally or vertically 
 * neighboring. The same letter cell may not be 
 * used more than once. 
 * 
 * For example,
 * Given board = 
 * [ ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E'] ]
 *   
 * word = "ABCCED", -> returns true, (i.e. 0-1-2-6-10-9)
 * word = "SEE", -> returns true, (i.e. 7-11-10)
 * word = "ABCB", -> returns false. (i.e. 0-1-2-?)
 *
 */
public class WordSearch {

	/**
	 * Solution 1 : No additional Space
	 */
	public boolean exist(char[][] board, String word) {
		char[] w = word.toCharArray();
		for (int y=0; y<board.length; y++) {
			for (int x=0; x<board[y].length; x++) {
				if (exist(board, y, x, w, 0)) return true;
			}
		}
		return false;
	}

	private boolean exist(char[][] board, int y, int x, char[] word, int i) {
		if (i == word.length) 
			return true;
		if (y<0 || x<0 || y == board.length || x == board[y].length) 
			return false;
		if (board[y][x] != word[i]) 
			return false;
		board[y][x] ^= 256;
		
		boolean exist = exist(board, y, x+1, word, i+1)
				|| exist(board, y, x-1, word, i+1)
				|| exist(board, y+1, x, word, i+1)
				|| exist(board, y-1, x, word, i+1);
		
		board[y][x] ^= 256;
		return exist;
	}
	
	/**
	 * Solution 2 : O(n) extra space
	 */
	
	static boolean[][] visited;
	public boolean exist2(char[][] board, String word) {
		visited = new boolean[board.length][board[0].length];

		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				if((word.charAt(0) == board[i][j]) && search(board, word, i, j, 0)){
					return true;
				}
			}
		}

		return false;
	}

	private boolean search(char[][]board, String word, int i, int j, int index){
		if(index == word.length()){
			return true;
		}

		if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j]){
			return false;
		}

		visited[i][j] = true;
		if(search(board, word, i-1, j, index+1) || 
				search(board, word, i+1, j, index+1) ||
				search(board, word, i, j-1, index+1) || 
				search(board, word, i, j+1, index+1)){
			return true;
		}

		visited[i][j] = false;
		return false;
	}
	
	
	public static void main(String[] args) {
		char[][] board = {{'A','B','C','E'}, 
				{'S','F','C','S'}, {'A','D','E','E'}};
		WordSearch obj = new WordSearch();
		System.out.println(obj.exist(board, "ABCCED"));
		System.out.println(obj.exist(board, "ABFCSE"));
		System.out.println(obj.exist(board, "SEE"));
		System.out.println(obj.exist(board, "ASAA"));
		
		System.out.println(obj.exist2(board, "ABCCED"));
		System.out.println(obj.exist2(board, "ABFCSE"));
		System.out.println(obj.exist2(board, "SEE"));
		System.out.println(obj.exist2(board, "ASAA"));
	}

}
