package sourabhs.datastructures.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sourabh
 * 
 * LeetCode:
 * 
 * Given an arbitrary ransom note string and another string containing 
 * letters from all the magazines, write a function that will return true 
 * if the ransom note can be constructed from the magazines ; otherwise, 
 * it will return false.
 * 
 * Each letter in the magazine string can only be used once in your ransom note.
 * 
 * Note:
 * You may assume that both strings contain only lowercase letters.
 * 
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 *
 */
public class RansomNote {
	
	public boolean canConstruct(String ransomNote, String magazine) {
		int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < ransomNote.length(); i++) {
            if(--arr[ransomNote.charAt(i)-'a'] < 0) {
                return false;
            }
        }
        return true;
	}
	
	public boolean canConstructUsingMap(String ransomNote, String magazine) {
        Map<Character, Integer> magM = new HashMap<>();
        for (char c:magazine.toCharArray()){
            int newCount = magM.getOrDefault(c, 0)+1;
            magM.put(c, newCount);
        }
        for (char c:ransomNote.toCharArray()){
            int newCount = magM.getOrDefault(c,0)-1;
            if (newCount<0)
                return false;
            magM.put(c, newCount);
        }
        return true;
    }

	public static void main(String[] args) {
		RansomNote obj = new RansomNote();
		boolean result = obj.canConstruct("aa", "aab");
		System.out.println("RansomNote can be constructed : " + result);

		result = obj.canConstruct("ab", "aab");
		System.out.println("RansomNote can be constructed : " + result);

		result = obj.canConstruct("aa", "abb");
		System.out.println("RansomNote can be constructed : " + result);
		
		result = obj.canConstructUsingMap("aa", "aab");
		System.out.println("RansomNote can be constructed : " + result);

		result = obj.canConstructUsingMap("ab", "aab");
		System.out.println("RansomNote can be constructed : " + result);

		result = obj.canConstructUsingMap("aa", "abb");
		System.out.println("RansomNote can be constructed : " + result);
	}

}
