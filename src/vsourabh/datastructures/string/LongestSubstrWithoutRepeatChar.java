package vsourabh.datastructures.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sourabh
 * 
 * LeetCode:
 * Given a string, find the length of the longest 
 * substring without repeating characters.
 * 
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. 
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 */
public class LongestSubstrWithoutRepeatChar {

	/**
	 * the basic idea is, keep a hashmap which stores the characters in string as keys 
	 * and their positions as values, and keep two pointers which define the max substring. 
	 * move the right pointer to scan through the string , and meanwhile update the hashmap. 
	 * If the character is already in the hashmap, then move the left pointer to the right 
	 * of the same character last found. Note that the two pointers can only move forward.
	 */
	public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        Map<Character, Integer> map = new HashMap<>();	
        int max=0;
        // j is for the length of substring
        for (int i=0, j=0; i<s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j,map.get(s.charAt(i))+1); // If repeat character is less than the substring 
                										//adbccb in this case second b will reduce the j, hence Math.max
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }
	
	public static void main(String[] args) {
		LongestSubstrWithoutRepeatChar obj = new LongestSubstrWithoutRepeatChar();
		int result = obj.lengthOfLongestSubstring("ababcdefba");
		System.out.println("The length of Substring is " + result);
		
		result = obj.lengthOfLongestSubstring("pwwkews");
		System.out.println("The length of Substring is " + result);
		
		result = obj.lengthOfLongestSubstring("adbccba");
		System.out.println("The length of Substring is " + result);
	}
}
