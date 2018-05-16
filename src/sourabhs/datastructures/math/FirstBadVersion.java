package sourabhs.datastructures.math;

public class FirstBadVersion {
	
	public static int firstBadVersion(int n) {
		int start = 1, end = n;
		while(start < end) {
			int mid = start + (end-start)/2;
			if(!isBadVersion(mid)) start = mid +1;
			else end = mid;
		}
		return start;
	}
	
	private static boolean isBadVersion(int m) {
		return m == 21;
	}

	public static void main(String[] args) {
		int res = firstBadVersion(45);
		System.out.println(res);
	}
}
