package sourabhs.datastructures.math;

import java.util.Arrays;

public class RotateArray {

	

	public static void rotate(int n[], int k) {
		k %= n.length;
		reverse(n, 0, n.length - 1);
		reverse(n, 0, k - 1);
		reverse(n, k, n.length - 1);
	}

	private static void reverse(int n[], int l, int r){
		while(l < r) {
			int temp = n[r];
			n[r] = n[l];
			n[l] = temp;
			l++;
			r--;
		}
	}

	public static void rotate2(int[] nums, int k) {
		if(nums.length <= 1)
			return;

		//step each time to move
		k= k % nums.length;
		int[] tmp = new int[k];
		for(int i = 0; i < k; i++)
			tmp[i] = nums[nums.length - k + i];

		for(int i = nums.length - k - 1; i >= 0; i--)
			nums[i + k] = nums[i];

		for(int i = 0; i < k; i++)
			nums[i] = tmp[i];
	}
	
	
	public static void rotate3(int[] nums, int k) {
		if(nums.length <= 1)
			return;
		
		k = k % nums.length; //Each time to move steps

		int gcd = findGcd(nums.length, k); // GCD of lenth and move steps
		int position, count;

		//gcd path to finish move
		for(int i = 0; i < gcd; i++){
			//beginning position of each path
			position = i;
			//count is the number we need swap each path
			count = nums.length / gcd - 1;
			for(int j = 0; j < count; j++){
				position = (position + k) % nums.length;
				//swap index value in index i and position
				nums[i] ^= nums[position];
				nums[position] ^= nums[i];
				nums[i] ^= nums[position];
			}
		}
	}

	private static int findGcd(int a, int b){
		return (a == 0 || b == 0) ? a + b : findGcd(b, a % b);
	}
	public static void main(String[] args) {
		int num[] = {1,2,3,4,5,6,7};
		rotate(num, 3);
		System.out.println(Arrays.toString(num));
		
		num = new int[] {1,2,3,4,5,6,7};
		rotate2(num, 3);
		System.out.println(Arrays.toString(num));
		
		num = new int[] {1,2,3,4,5,6,7};
		rotate3(num, 3);
		System.out.println(Arrays.toString(num));

	}

}
