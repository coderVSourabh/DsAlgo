package sourabhs.datastructures.math;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Sourabh
 * 
 * LeetCode
 * Write a program to find the nth super ugly number.
 * Super ugly numbers are positive numbers whose all 
 * prime factors are in the given prime list primes 
 * of size k. 
 * 
 * For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32]
 * is the sequence of the first 12 super ugly numbers 
 * given primes = [2, 7, 13, 19] of size 4.
 * 
 * Note:
 * (1) 1 is a super ugly number for any given primes.
 * (2) The given numbers in primes are in ascending order.
 * (3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
 * (4) The nth super ugly number is guaranteed to fit in a 32-bit signed integer.
 */
public class SuperUglyNumber {

	/**
	 * 36 ms, Theoretically O(kN)
	 */
	public int nthSuperUglyNumberI(int n, int[] primes) {
	    int[] ugly = new int[n];
	    int[] idx = new int[primes.length];

	    ugly[0] = 1;
	    for (int i = 1; i < n; i++) {
	        //find next
	        ugly[i] = Integer.MAX_VALUE;
	        for (int j = 0; j < primes.length; j++)
	            ugly[i] = Math.min(ugly[i], primes[j] * ugly[idx[j]]);
	        
	        //slip duplicate
	        for (int j = 0; j < primes.length; j++) {
	            while (primes[j] * ugly[idx[j]] <= ugly[i]) idx[j]++;
	        }
	    }

	    return ugly[n - 1];
	}
	
	/**
	 * 	Trade-off space for speed. 23 ms, Theoretically O(kN)
	 */
	public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] idx = new int[primes.length];
        int[] val = new int[primes.length];
        Arrays.fill(val, 1);

        int next = 1;
        for (int i = 0; i < n; i++) {
            ugly[i] = next;
            
            next = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                //skip duplicate and avoid extra multiplication
                if (val[j] == ugly[i]) val[j] = ugly[idx[j]++] * primes[j];
                //find next ugly number
                next = Math.min(next, val[j]);
            }
        }

        return ugly[n - 1];
    }
	
	/**
	 *  theoretical bound to O( log(k)N ), but in reality it's 58 ms
	 */
	public int nthSuperUglyNumberHeap(int n, int[] primes) {
	    int[] ugly = new int[n];

	    Queue<Num> pq = new PriorityQueue<>();
	    for (int i = 0; i < primes.length; i++) pq.add(new Num(primes[i], 1, primes[i]));
	    ugly[0] = 1;

	    for (int i = 1; i < n; i++) {
	        ugly[i] = pq.peek().val;
	        while (pq.peek().val == ugly[i]) {
	            Num nxt = pq.poll();
	            pq.add(new Num(nxt.p * ugly[nxt.idx], nxt.idx + 1, nxt.p));
	        }
	    }

	    return ugly[n - 1];
	}
	
	private class Num implements Comparable<Num> {
	    int val;
	    int idx;
	    int p;

	    public Num(int val, int idx, int p) {
	        this.val = val;
	        this.idx = idx;
	        this.p = p;
	    }
	    
	    @Override
	    public int compareTo(Num that) {
	        return this.val - that.val;
	    }
	}


	public static void main(String[] args) {
		SuperUglyNumber obj = new SuperUglyNumber();
		int[] primes = {2, 7, 13, 19};
		int result = obj.nthSuperUglyNumber(5, primes);
		System.out.println("The Ugly Number is " + result);
		
		result = obj.nthSuperUglyNumberHeap(5, primes);
		System.out.println("The Ugly Number is " + result);
	
		result = obj.nthSuperUglyNumberI(5, primes);
		System.out.println("The Ugly Number is " + result);
	}

}
