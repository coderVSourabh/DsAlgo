package sourabhs.datastructures.string;

/**
 * @author Sourabh
 * 
 * LeetCode: 
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * 
 * Example: Input: "babad" Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * Input: "cbbd" Output: "bb"
 */
public class LongestPalindromeSubString {

	private int lo, maxLen;

	public String longestPalindrome(String s) {
		int len = s.length();
		lo = maxLen = 0;
		if (len < 2)
			return s;

		for (int i = 0; i < len-1; i++) {
			extendPalindrome(s, i, i);  //assume odd length Palindrome, try to extend Palindrome as possible
			extendPalindrome(s, i, i+1); //assume even length Palindrome.
		}
		return s.substring(lo, lo + maxLen);
	}

	private void extendPalindrome(String s, int j, int k) {
		while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
			j--;
			k++;
		}
		if (maxLen < k - j - 1) {
			lo = j + 1;
			maxLen = k - j - 1;
		}
	}
	
	
	public String longestPalindromeUsingArray(String s) {
		if (s.isEmpty()) return "";
		if (s.length() == 1) return s;
		int min_start = 0, max_len = 1;
		char[] ch = s.toCharArray();
		for (int i = 0; i < ch.length;) {
			
			if (ch.length - i <= max_len / 2) 
				break;
			int j = i, k = i;
			
			while (k < ch.length - 1 && ch[k+1] == ch[k]) 
				++k; // Skip duplicate characters.
			
			i = k+1;
			while (k < s.length() - 1 && j > 0 && ch[k + 1] == ch[j - 1]) { 
				// Expand.
				++k; 
				--j;	
			} 
			
			int new_len = k - j + 1;
			if (new_len > max_len) { 
				min_start = j; 
				max_len = new_len; 	
			}
		}
		return String.copyValueOf(ch, min_start, max_len);
	}
	
	public static void main(String[] args) {
		LongestPalindromeSubString obj = new LongestPalindromeSubString();
		String result = obj.longestPalindrome("ababc");
		System.out.println("The longest Substring Palindrome is " + result);
		
		result = obj.longestPalindrome("abbacd");
		System.out.println("The longest Substring Palindrome is " + result);
		
		result = obj.longestPalindromeUsingArray("abbacd");
		System.out.println("The longest Substring Palindrome is " + result);
	}

}
