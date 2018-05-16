package sourabhs.datastructures.array;

/**
 * @author Sourabh
 * 
 * LeetCode:
 * Search a 2D Matrix
 * 
 * Write an efficient algorithm that searches for a value 
 * in an m x n matrix. This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 * Consider the following matrix:
 * 
 * [[1,   3,  5,  7],
 *  [10, 11, 16, 20],
 *  [23, 30, 34, 50]
 *  ]
 *  
 *  Given target = 3, return true.
 *
 */
public class SearchMatrix {
	
	public  boolean searchMatrix(int[][] matrix, int target) {

		int n = matrix.length;
        int m = matrix[0].length;
        int left = 0, right = m * n - 1;

        while (left != right) {
            int mid = (left + right - 1) >> 1;
            
            if (matrix[mid / m][mid % m] < target)
                left = mid + 1;
            else 
                right = mid;
        }
        
        return matrix[right / m][right % m] == target;
    }
	
	public  boolean searchMatrixBinarySearch(int[][] matrix, int target) {

		int row_num = matrix.length;
		int col_num = matrix[0].length;
		
		int begin = 0, end = row_num * col_num - 1;
		
		while(begin <= end) {
			int mid = (end - begin) / 2 + begin;
			int mid_value = matrix[mid/col_num][mid%col_num];
			
			if( mid_value == target)
				return true;
			else if(mid_value < target)
				begin = mid+1;
			else
				end = mid-1;	
		}
		return false;
    }

	public static void main(String[] args) {
		
		SearchMatrix obj = new SearchMatrix();
		int matrix[][] = {{1,2,4,5},{6,7,8,9},{11,13,17,19},{21,22,24,25}};
		boolean result = obj.searchMatrix(matrix, 3);
		System.out.println("Is Number found: " + result);
		
		result = obj.searchMatrix(matrix, 17);
		System.out.println("Is Number found: " + result);
	
		result = obj.searchMatrixBinarySearch(matrix, 3);
		System.out.println("Is Number found: " + result);
		
		result = obj.searchMatrixBinarySearch(matrix, 17);
		System.out.println("Is Number found: " + result);
	}
}