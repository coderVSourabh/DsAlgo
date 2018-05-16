package sourabhs.datastructures.array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate2 {

	public static boolean containsNearByDuplicate(int[] num, int k) {
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i< num.length - 1; i++) {
			if(i > k) set.remove(num[i-k-1]);
			if(!set.add(num[i])) return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		boolean res = containsNearByDuplicate(new int[] {1,2,5,2,1,3,2}, 3);
		System.out.println(res);
	}
}
