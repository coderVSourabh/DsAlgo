package sourabhs.datastructures.math;

/**
 * @author Sourabh
 * 
 * LeetCode
 * Count the number of prime numbers 
 * less than a non-negative number, n.
 */
public class CountPrimes {

	/**
	 * leetCode
	 */
	public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        return count;
    }
	
	public static void main(String[] args) {
		CountPrimes obj = new CountPrimes();
		int count = obj.countPrimes(99);
		System.out.println("CountPrimes of 99 is " + count);
	}

}
