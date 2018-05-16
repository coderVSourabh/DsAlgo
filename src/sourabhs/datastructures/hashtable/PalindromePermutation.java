package sourabhs.datastructures.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PalindromePermutation {

	// O(n) Time, O(n) Space
	public static boolean canPermutePalindrome(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < s.length(); i++)
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		int count = 0;
		for(char key : map.keySet())
			count += map.get(key) % 2;
		return count <= 1;
	}

	// O(n) Time, O(128) Space
	public static boolean canPermutePalindromeArray(String s) {
		int[] map = new int[128];
		int count = 0;
		for(int i = 0; i < s.length(); i++) {
			map[s.charAt(i)]++;
			if(map[s.charAt(i)] % 2  == 0)
				count--;
			else
				count++;
		}
		return count <= 1;
	}
	public static boolean canPermutePalindromeSet(String s) {
		Set <Character> set = new HashSet <> ();
		for (int i = 0; i < s.length(); i++) {
			if (!set.add(s.charAt(i))) // If adds returns true
				set.remove(s.charAt(i));
		}
		return set.size() <= 1;
	}
	public static void main(String[] args) {
		boolean result = canPermutePalindrome("aab");
		System.out.println(result);
		
		result = canPermutePalindromeArray("aab");
		System.out.println(result);
		
		result = canPermutePalindromeSet("aab");
		System.out.println(result);
		
		result = canPermutePalindrome("code");
		System.out.println(result);
		
		result = canPermutePalindromeArray("code");
		System.out.println(result);
		
		result = canPermutePalindromeSet("code");
		System.out.println(result);
	}

}
