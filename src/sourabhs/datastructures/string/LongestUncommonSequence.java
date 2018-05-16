package sourabhs.datastructures.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Sourabh
 *
 */
public class LongestUncommonSequence {

	/**
	 * LeetCode: 521
	 * 
	 * Given a group of two strings, you need to find the longest uncommon subsequence 
	 * of this group of two strings. The longest uncommon subsequence is defined as the 
	 * longest subsequence of one of these strings and this subsequence should not be 
	 * any subsequence of the other strings.
	 * 
	 * A subsequence is a sequence that can be derived from one sequence by deleting 
	 * some characters without changing the order of the remaining elements. Trivially, 
	 * any string is a subsequence of itself and an empty string is a subsequence of any string.
	 * 
	 * The input will be two strings, and the output needs to be the length of the longest 
	 * uncommon subsequence. If the longest uncommon subsequence doesn't exist, return -1.
	 * 
	 * Example:
	 * Input: "aba", "cdc"
	 * Output: 3
	 * Explanation: The longest uncommon subsequence is "aba" (or "cdc"), because "aba" is a 
	 * subsequence of "aba",  but not a subsequence of any other strings in the group of two strings. 
	 * 
	 * Note: Both strings' lengths will not exceed 100. Only letters from a ~ z will appear in input strings.
	 */
	public int findLUSlength(String a, String b) {
	    return a.equals(b) ? -1 : Math.max(a.length(), b.length());
	}
	
	/**
	 * LeetCode: 522
	 * 
	 * Given a list of strings, you need to find the longest uncommon subsequence among them. 
	 * The longest uncommon subsequence is defined as the longest subsequence of one of these 
	 * strings and this subsequence should not be any subsequence of the other strings.
	 * 
	 * A subsequence is a sequence that can be derived from one sequence by deleting some characters
	 * without changing the order of the remaining elements. Trivially, any string is a subsequence 
	 * of itself and an empty string is a subsequence of any string.
	 *  
	 * The input will be a list of strings, and the output needs to be the length of the longest 
	 * uncommon subsequence. If the longest uncommon subsequence doesn't exist, return -1.
	 * 
	 * Example:
	 * Input: "aba", "cdc", "eae" Output: 3
	 * 
	 * Note:
	 * All the given strings' lengths will not exceed 10.
	 * The length of the given list will be in the range of [2, 50].
	 */
	public int findLUSlength(String[] strs) {
		Map<String, Integer> subseqFreq = new HashMap<>();
		for (String s : strs) 
			for (String subSeq : getSubseqs(s))
				subseqFreq.put(subSeq, subseqFreq.getOrDefault(subSeq, 0) + 1);
		int longest = -1;
		for (Map.Entry<String, Integer> entry : subseqFreq.entrySet()) 
			if (entry.getValue() == 1) longest = Math.max(longest, entry.getKey().length());
		return longest;
	}

	public static Set<String> getSubseqs(String s) {
		Set<String> res = new HashSet<>();
		if (s.length() == 0) {
			res.add("");
			return res;
		}
		Set<String> subRes = getSubseqs(s.substring(1));
		res.addAll(subRes);
		for (String seq : subRes) res.add(s.charAt(0) + seq);
		return res;
	}
	
	public static void main(String[] args) {
		LongestUncommonSequence obj = new LongestUncommonSequence();
		int result = obj.findLUSlength("abba", "cddc");
		System.out.println("The result is " + result);
		
		

	}

}
