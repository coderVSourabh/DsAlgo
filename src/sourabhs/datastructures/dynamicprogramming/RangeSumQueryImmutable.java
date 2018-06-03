package sourabhs.datastructures.dynamicprogramming;

public class RangeSumQueryImmutable {
	
	int numArray[];
	public RangeSumQueryImmutable(int nums[]) {
		for(int i = 1; i < nums.length; i++)
			nums[i] += nums[i-1];
		this.numArray = nums;
	}
	public int sumRange(int i, int j) {
		if(i == 0) return numArray[j];
		return numArray[j] - numArray[i-1];
	}
	public static void main(String[] args) {
		RangeSumQueryImmutable obj = new RangeSumQueryImmutable(new int[]{-2,0,3,-5,2,-1});
		int val = obj.sumRange(0, 2);
		System.out.println(val);
		
		val = obj.sumRange(2, 5);
		System.out.println(val);
		
		val = obj.sumRange(0, 5);
		System.out.println(val);
	}

}
