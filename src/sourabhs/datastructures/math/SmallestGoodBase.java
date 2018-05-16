package sourabhs.datastructures.math;

/**
 * @author Sourabh
 * 
 * LeetCode:
 * For an integer n, we call k>=2 a good base 
 * of n, if all digits of n base k are 1.
 * 
 * Now given a string representing n, you should 
 * return the smallest good base of n in string format. 
 * 
 * Example:
 * Input: "13" Output: "3" Explanation: 13 base 3 is 111.
 * 
 * Input: "4681" Output: "8" Explanation: 4681 base 8 is 11111.
 * 
 * Input: "1000000000000000000" Output: "999999999999999999"
 * Explanation: 1000000000000000000 base 999999999999999999 is 11.
 * 
 * Note:
 * The range of n is [3, 10^18].
 * The string representing n is always valid and will not have leading zeros.
 */
public class SmallestGoodBase {
	
	public String smallestGoodBase(String n) {
		long tn=Long.parseLong(n);
		long x=1;
		for (int i=62;i>=1;i--) {
			if ((x<<i)<tn) {
				long cur=mysolve(tn,i);
				if (cur!=0) 
					return Long.toString(cur);
			}
		}
		return Long.toString(tn-1);
	}
		    
	long mysolve(long n, int d) {
		double tn= (double) n;
		long right=(long) (Math.pow(tn,1.0/d)+1);
		long left=1;
		while (left<=right){
			long mid=left+(right-left)/2;
			long sum=1,cur=1;
			for (int i=1;i<=d;i++) {
				cur*=mid;
				sum+=cur;
			}
			if (sum==n) return mid;
			if (sum>n) right=mid-1;
			else left=mid+1;
		}
		return 0;
	}

	public static void main(String[] args) {
		SmallestGoodBase obj = new SmallestGoodBase();
		String result = obj.smallestGoodBase("13");
		System.out.println("The Smallest Base is " + result);
		
		result = obj.smallestGoodBase("4681");
		System.out.println("The Smallest Base is " + result);
		
		result = obj.smallestGoodBase("1000000000000000000");
		System.out.println("The Smallest Base is " + result);
	}

}
