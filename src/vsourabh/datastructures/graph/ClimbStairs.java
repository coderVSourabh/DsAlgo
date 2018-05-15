package vsourabh.datastructures.graph;

public class ClimbStairs {

	public static int climbStairs(int n) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		if (n == 2) return 2;
		int oneStepBefore = 2, twoStepBefore = 1;
		int i = 2;
		while(i <= n) {
			int temp = oneStepBefore;
			oneStepBefore += twoStepBefore;
			twoStepBefore = temp;
			i++;
		}
		return oneStepBefore;
	}
	
	public static void main(String[] args) {
		int res = climbStairs(2);
		System.out.println(res);

		res = climbStairs(3);
		System.out.println(res);

		res = climbStairs(5);
		System.out.println(res);
	}

}
