package sourabhs.datastructures.array;

/**
 * @author Sourabh
 * 
 * LeetCode:
 * JumpGame
 * JumpGame II
 *
 */
public class JumpGame {
	
	/**
	 * LeetCode:
	 * Jump Game II
	 * Given an array of non-negative integers, you are initially 
	 * positioned at the first index of the array.
	 * 
	 * Each element in the array represents your maximum jump length at that position.
	 * 
	 * Your goal is to reach the last index in the minimum number of jumps.
	 * 
	 * For example: Given array A = [2,3,1,1,4]
	 * 
	 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 
	 *  1, then 3 steps to the last index.)
	 * 
	 * Note: You can assume that you can always reach the last index.
	 */

	 public int jump(int A[], int n) {
		 if(n<2)
			 return 0;
		 int level=0,currentMax=0,i=0,nextMax=0;

		 while(currentMax-i+1>0) {		//nodes count of current level>0
			 level++;
			 for(;i<=currentMax;i++) {	//traverse current level , and update the max reach of next level
				nextMax=Integer.max(nextMax,A[i]+i);
				if(nextMax>=n-1)return level;   // if last element is in level+1,  then the min jump=level 
			 }
			 currentMax=nextMax;
		 }
		 return 0;
	 }
	 
	 public int jump(int[] A) {
		 int jumps = 0, curEnd = 0, curFarthest = 0;
		 for (int i = 0; i < A.length - 1; i++) {
			 curFarthest = Math.max(curFarthest, i + A[i]);
			 if (i == curEnd) {
				 jumps++;
				 curEnd = curFarthest;
			 }
		 }
		 return jumps;
	 }

	 /**
	  * Given an array of non-negative integers, you are initially positioned at 
	  * the first index of the array.
	  * 
	  * Each element in the array represents your maximum jump length at that position.
	  * Determine if you are able to reach the last index.
	  * For example: 
	  * A = [2,3,1,1,4], return true.
	  * A = [3,2,1,0,4], return false.
	  */
	 public boolean canJump(int[] A) {
		 int max = 0;
		 for(int i=0;i<A.length;i++) {
			 if(i>max) return false;
			 max = Math.max(A[i]+i,max);
		 }
		 return true;
	 }

	public static void main(String[] args) {
		JumpGame obj = new JumpGame();
		int []A = new int[] {2,3,1,1,4};
		int jumps = obj.jump(A, A.length);
		System.out.println("Number of jumps: " + jumps);
		
		jumps = obj.jump(new int[]{2,3,4,5,1,1,1,1,5}, 9);
		System.out.println("Number of jumps: " + jumps);
		
		jumps = obj.jump(new int[]{2,3,4,5,1,1,1,1,5});
		System.out.println("Number of jumps: " + jumps);
		
		boolean jumper = obj.canJump(new int[]{2,2,3,4,1,1,1,0,5});
		System.out.println("Can jumps: " + jumper);
	
		jumper = obj.canJump(new int[]{2,2,3,4,1,1,1,1,5});
		System.out.println("Can jumps: " + jumper);
	
	}

}