package vsourabh.datastructures.array;

public class TwoSum2 {

	
	public static int[] twoSum(int[] num, int target) {
		int[] indexes = new int[2];
		if(num == null || num.length < 2) return indexes;
		
		int left = 0, right = num.length - 1;
		while(left < right) {
			int sum = num[left] + num[right];
			if(sum == target) {
				indexes[0] = left + 1;
				indexes[1] = right + 1;
				break;
			} else if(target > sum)
				left +=1;
			else
				right -= 1;
		}
		return indexes;
	}

	public static void main(String[] args) {
		int[] res = twoSum(new int[]{2, 5,7,11,13,15,17}, 9);
		System.out.println(res[0] + "  -  " + res[1]);
	}

}
