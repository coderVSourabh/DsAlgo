package sourabhs.datastructures.math;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

	public static boolean isIsomorphic(String s1, String s2) {
		int[] m = new int[512];
		for(int i = 0; i < s1.length(); i++) {
			if(m[s1.charAt(i)] != m[s2.charAt(i) + 256]) return false;
			m[s1.charAt(i)] = m[s2.charAt(i) + 256] = i+1;
		}
		return true;
	}

	public static boolean isIsomorphicMap(String s, String t) {
		if(s == null || s.length() <= 1) return true;
		Map<Character, Character> map = new HashMap<>();
		for(int i = 0 ; i< s.length(); i++) {

			char a = s.charAt(i), b = t.charAt(i);
			if(map.containsKey(a)) {
				if(map.get(a).equals(b)) continue;
				else return false;
			} else {
				if(!map.containsValue(b)) map.put(a,b);
				else return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		boolean res = isIsomorphic("egg", "add");
		System.out.println(res);

		res = isIsomorphicMap("egg", "add");
		System.out.println(res);
		
		res = isIsomorphic("aab", "xxy");
		System.out.println(res);

		res = isIsomorphicMap("aab", "xxy");
		System.out.println(res);
		
		res = isIsomorphic("abc", "xxy");
		System.out.println(res);

		res = isIsomorphicMap("abc", "zzy");
		System.out.println(res);
	}
}
