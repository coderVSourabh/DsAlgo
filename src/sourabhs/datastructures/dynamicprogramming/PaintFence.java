package sourabhs.datastructures.dynamicprogramming;

public class PaintFence {

	public static int numWays(int n, int k) {
		if(n == 0 || k == 0) return 0;
		if(n == 1) return k;
		int[] same = new int[n], diff = new int[n]; // i and  i-1 same or diff
		same[0] = same[1] = k;
		diff[0] = k;
		diff[1] = k * (k - 1);
		for(int i = 2; i < n; i++) {
			same[i] = diff[i-1];
			diff[i] = (k-1)*same[i-1] + (k-1)*diff[i-1];
		}
		return same[n-1]+diff[n-1];
	}

	public static void main(String[] args) {
		int res = numWays(3, 2);
		System.out.println(res);
	}	
}
