package sourabhs.datastructures.dynamicprogramming;

public class PaintHouse {

	public static int minCost(int[][] costs) {
		if(costs == null || costs.length == 0) return 0;

		for(int i = 1; i<costs.length; i++) {
			costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
			costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
			costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
		}
		int n = costs.length - 1;
		return Math.min(Math.min(costs[n][0], costs[n][1]), costs[n][2]);
	}

	public static int minCost2(int[][] costs) {
		if(costs.length==0) return 0;
		int lastR = costs[0][0];
		int lastG = costs[0][1];
		int lastB = costs[0][2];
		for(int i=1; i<costs.length; i++) {
			int curR = Math.min(lastG,lastB)+costs[i][0];
			int curG = Math.min(lastR,lastB)+costs[i][1];
			int curB = Math.min(lastR,lastG)+costs[i][2];
			lastR = curR;
			lastG = curG;
			lastB = curB;
		}
		return Math.min(Math.min(lastR,lastG),lastB);
	}
	public static void main(String[] args) {
		int res = minCost(new int[][] {{1,2,1}, {2,3,5}, {5,2,4}, {2,6,3}});
		System.out.println(res);

		res = minCost2(new int[][] {{1,2,1}, {2,3,5}, {5,2,4}, {2,6,3}});
		System.out.println(res);
	}
}
