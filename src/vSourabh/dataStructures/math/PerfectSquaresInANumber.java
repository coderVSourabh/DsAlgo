package vSourabh.dataStructures.math;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Vector;

/**
 * @author Sourabh
 * 
 * LeetCode:
 * Given a positive integer n, find the least number of 
 * perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * For example, 
 * given n = 12, return 3 because 12 = 4 + 4 + 4; 
 * given n = 13, return 2 because 13 = 4 + 9.
 */
public class PerfectSquaresInANumber {

	/**
	 * dp[0] = 0 
	 * dp[1] = dp[0]+1 = 1
	 * dp[2] = dp[1]+1 = 2
	 * dp[3] = dp[2]+1 = 3
	 * dp[4] = Min{ dp[4-1*1]+1, dp[4-2*2]+1 } 
	 * 		 = Min{ dp[3]+1, dp[0]+1 }
	 * 		 = 1				
	 * dp[5] = Min{ dp[5-1*1]+1, dp[5-2*2]+1 } 
	 *		 = Min{ dp[4]+1, dp[1]+1 } 
	 * 		 = 2
	 *					.
	 *					.
	 *					.
	 * dp[13] = Min{ dp[13-1*1]+1, dp[13-2*2]+1, dp[13-3*3]+1 } 
	 * 		  = Min{ dp[12]+1, dp[9]+1, dp[4]+1 } 
	 * 		  	= 2
	 * 
	 * dp[n] = Min{ dp[n - i*i] + 1 },  n - i*i >=0 && i >= 1
	 */
	public int numSquaresUsingDynamicProg(int n)  {
        int[] dp = new int[n + 1];
    	Arrays.fill(dp, Integer.MAX_VALUE);
    	dp[0] = 0;
    	for(int i = 1; i <= n; ++i) {
    		int min = Integer.MAX_VALUE;
    		int j = 1;
    		while(i - j*j >= 0) {
    			min = Math.min(min, dp[i - j*j] + 1);
    			++j;
    		}
    		dp[i] = min;
    	}		
    	return dp[n];
    }
	
	  /*
	   *  Mathematical Solution
	   *  	Based on Lagrange's Four Square theorem, there
	   *  	are only 4 possible results: 1, 2, 3, 4.
	   */
    public int numSquaresByMathmetatics(int n)  {  
        // If n is a perfect square, return 1.
        if(isSquare(n)) 
             return 1;  
        
        // The result is 4 if and only if n can be written in the 
        // form of 4^k*(8*m + 7). Please refer to 
        // Legendre's three-square theorem.
          
        while ((n & 3) == 0) // n%4 == 0
            n >>= 2;  

        if ((n & 7) == 7) // n%8 == 7
            return 4;
        
        // Check whether 2 is the result.
        int sqrootN = (int)(Math.sqrt(n)); 
        for(int i = 1; i <= sqrootN; i++)
            if (isSquare(n - i*i)) 
                return 2;  
        
        return 3;  
    }  
    
    private boolean isSquare(int n) {  
        int sqRootN= (int) (Math.sqrt(n));  
        return (sqRootN * sqRootN ==  n);  
    } 
	
    //TODO Not Working
    public int numSquaresUsingBFS(int n)  {
        if (n <= 0)
           return 0;
        
        // perfectSquares contain all perfect square numbers which 
        // are smaller than or equal to n.
        Vector<Integer> perfectSquares = new Vector<>();
        
        // cntPerfectSquares[i - 1] = the least number of perfect 
        // square numbers which sum to i.
        Vector<Integer> cntPerfectSquares = new Vector<>(n);
        for(int i = 0; i < n; i++)
        	cntPerfectSquares.add(0);
        
        // Get all the perfect square numbers which are smaller than 
        // or equal to n.
        for (int i = 1; i*i <= n; i++) {
            perfectSquares.add(i*i);
            cntPerfectSquares.add(0, i*i - 1);
        }
        
        // If n is a perfect square number, return 1 immediately.
        if (perfectSquares.get(perfectSquares.size() - 1) == n)
            return 1;
        
        // Consider a graph which consists of number 0, 1,...,n as
        // its nodes. Node j is connected to node i via an edge if  
        // and only if either j = i + (a perfect square number) or 
        // i = j + (a perfect square number). Starting from node 0, 
        // do the breadth-first search. If we reach node n at step 
        // m, then the least number of perfect square numbers which 
        // sum to n is m. Here since we have already obtained the 
        // perfect square numbers, we have actually finished the 
        // search at step 1.
        Deque<Integer> searchQ = new ArrayDeque<>();
        for (Integer i : perfectSquares)
            searchQ.push(i);
        
        int currCntPerfectSquares = 1;
        
        while (!searchQ.isEmpty()) {
            currCntPerfectSquares++;
            
            int searchQSize = searchQ.size();
            for (int i = 0; i < searchQSize; i++) {
                int tmp = searchQ.getFirst();
                // Check the neighbors of node tmp which are the sum 
                // of tmp and a perfect square number.
                for (Integer j : perfectSquares) {
                    if (tmp + j == n) {
                    	
                    	// We have reached node n.
                        return currCntPerfectSquares;
                    } else if ((tmp + j < n) && (cntPerfectSquares.get(tmp + j - 1) == 0)) {
                        
                    	// If cntPerfectSquares[tmp + j - 1] > 0, this is not 
                        // the first time that we visit this node and we should 
                        // skip the node (tmp + j).
                        cntPerfectSquares.add(tmp + j - 1, currCntPerfectSquares);
                        searchQ.push(tmp + j);
                    } else if (tmp + j > n) {
                    	
                        // We don't need to consider the nodes which are greater ]
                        // than n.
                        break;
                    }
                }
                
                searchQ.pop();
            }
        }
        return 0;
    }
    
    public static void main(String[] args) {
    	PerfectSquaresInANumber obj = new PerfectSquaresInANumber();
    	int result = obj.numSquaresByMathmetatics(21);
		System.out.println("Number of square in 21 are " + result);
		
		result = obj.numSquaresUsingDynamicProg(21);
		System.out.println("Number of square in 21 are " + result);
		
		result = obj.numSquaresUsingBFS(21);
		System.out.println("Number of square in 21 are " + result);
	}

}
