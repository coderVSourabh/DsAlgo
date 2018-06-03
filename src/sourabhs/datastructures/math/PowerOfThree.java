package sourabhs.datastructures.math;

public class PowerOfThree {

	public static boolean isPowerOfThree(int n) {
		if (n < 3)
			return false;
		while (n % 3 == 0)
			n /= 3;
		return n == 1;
	}

	public static boolean isPowerOfThree2(int n) {
		return Integer.toString(n, 3).matches("^10*$"); // Convert base of 3 and it should be 10000... format e.g. 4 base 2 is 100 
	}

	public static boolean isPowerOfThreeFastest(int n) {
		return n > 0 && 1162261467 % n == 0;   //1162261467 max possible power of 3 integer
	}

	public static void main(String[] args) {
		boolean res = isPowerOfThree(31);
		System.out.println(res);

		res = isPowerOfThree(27);
		System.out.println(res);

		res = isPowerOfThree2(31);
		System.out.println(res);

		res = isPowerOfThree2(27);
		System.out.println(res);

		res = isPowerOfThreeFastest(31);
		System.out.println(res);

		res = isPowerOfThreeFastest(27);
		System.out.println(res);
	}

}
