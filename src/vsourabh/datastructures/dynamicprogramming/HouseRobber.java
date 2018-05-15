package vsourabh.datastructures.dynamicprogramming;

public class HouseRobber {

	public static int rob(int[] n) {
		int[][] dp = new int[n.length + 1][2];
		
		for(int i = 1; i <= n.length; i++) {
			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
			dp[i][1] = n[i-1] + dp[i-1][0];
		}
		return Math.max(dp[n.length][0], dp[n.length][1]);
	}
	
	public static int rob1(int[] n) {
		int prevNo  = 0;
		int prevYes = 0;
		
		for(int i : n) {
			int temp = prevNo;
			prevNo = Math.max(prevNo, prevYes);
			prevYes = i + temp;
		}
		return Math.max(prevNo, prevYes);
	}

	public static void main(String[] args) {
		int res = rob(new int[]{1,4,2,5,7,1,3});
		System.out.println(res);
		
		res = rob1(new int[]{1,4,2,5,7,1,3});
		System.out.println(res);
	}
}
