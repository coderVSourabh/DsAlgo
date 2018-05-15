package vsourabh.datastructures.bitmanipulation;

public class NumberOf1Bits {

	 public static int hammingWeight(int n) {
		 int numOfOnes = 0;
		 while(n!=0) { // 32 bit checks max
			 numOfOnes += (n&1); // Check if last digit is 1 or not
			 n >>>= 1; // Shift one right
		 }
		 return numOfOnes;
	}
	public static void main(String[] args) {
		int res = hammingWeight(15);
		System.out.println(res);
	}

}
