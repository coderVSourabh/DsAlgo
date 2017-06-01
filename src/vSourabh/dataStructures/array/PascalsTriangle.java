package vSourabh.dataStructures.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author Sourabh
 * LeetCode 
 * 
 */
public class PascalsTriangle {

	/**
	 * 
	 * LeetCode: 
	 * Given numRows, generate the first numRows of Pascal's triangle.
	 * if numRows = 5
	 * Result is 
	 *   [ 
	 *       [1],
	 *      [1,1],
	 *     [1,2,1],
	 *    [1,3,3,1],
	 *   [1,4,6,4,1]
	 *   ]
	 */
	public List<List<Integer>> generate(int numRows)
	{
		List<List<Integer>> allrows = new ArrayList<>();
		List<Integer> row = new ArrayList<>();
		for(int i=0;i<numRows;i++) {
			row.add(0, 1);
			for(int j=1;j<row.size()-1;j++)
				row.set(j, row.get(j)+row.get(j+1));
			allrows.add(new ArrayList<Integer>(row));
		}
		return allrows;
		
	}
	
	public List<List<Integer>> generateTrianlge(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        if (numRows <=0)
            return triangle;

        for (int i=0; i<numRows; i++){
            List<Integer> row =  new ArrayList<Integer>();
            for (int j=0; j<i+1; j++){
                if (j==0 || j==i)
                    row.add(1);
                else
                    row.add(triangle.get(i-1).get(j-1)+triangle.get(i-1).get(j));
            }
            triangle.add(row);
        }
        return triangle;
    }
	
	/**
	 * 
	 * LeetCode: 
	 * 
	 * Given an index k, return the kth row of the Pascal's triangle.
	 * For example, given k = 3,
	 * Return [1,3,3,1]
	 * 
	 * Vector is almost same as ArrayList
	 * Vector grows by doubling the size of Array
	 * ArrayList grows only by 50% of Array Size
	 * Vector is synchronized
	 */
	public Vector<Integer> getRow(int rowIndex) {
        
		Vector<Integer> vector = new Vector<>();
		if(rowIndex < 0)
        	return vector;
		
		for(int i=1; i<rowIndex+1; i++) {
        	vector.add(0, 1);
        	for(int j = 1; j < vector.size() - 1; j++) {
            	int tmp = vector.get(j) + vector.get(j + 1);
    			vector.set(j, tmp);	
            }
        }
        return vector;
    }
	
	
	public static void main(String[] args) {
		PascalsTriangle pTriangle = new PascalsTriangle();
		List<List<Integer>> result =  pTriangle.generate(6);
		
		/*for(List<Integer> row : result) {
			for(Integer item : row)
				System.out.print(item + " ");
			System.out.print("\n");
			
		}*/
		// Same as above in lambda expression
		result.forEach(p -> {
			p.forEach(q -> System.out.print(q + " "));
			System.out.print("\n"); 
		});
		
		result =  pTriangle.generateTrianlge(4);
		result.forEach(p -> {
			p.forEach(q -> System.out.print(q + " "));
			System.out.print("\n"); 
		});
		
		System.out.println("\nGet the row data 4");
		Vector<Integer> rowResult =  pTriangle.getRow(4);
		rowResult.stream().forEach(myData -> System.out.print(myData + " "));
	}

}
