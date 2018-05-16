package sourabhs.datastructures.string;

/**
 * @author Sourabh
 * 
 * LeetCode:
 * Given a string, determine if it is a palindrome, 
 * considering only alphanumeric characters and ignoring cases.
 * 
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * 
 * Note:
 * Have you consider that the string might be empty? 
 * This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome. 
 */
public class ValidPalindrome {

	public boolean isPalindrome(String s) {
		if (s.isEmpty()) {
			return true;
		}
		int head = 0, tail = s.length() - 1;
		char cHead, cTail;
		while(head <= tail) {
			cHead = s.charAt(head);
			cTail = s.charAt(tail);
			if (!Character.isLetterOrDigit(cHead)) {
				head++;
			} else if(!Character.isLetterOrDigit(cTail)) {
				tail--;
			} else {
				if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
					return false;
				}
				head++;
				tail--;
			}
		}
		return true;
	}
	
	public boolean isPalindrome2(String s) {
		if (s == null || s.isEmpty()) 
			return true;
		
		char in[] = s.toCharArray();
		int head = 0, tail = in.length - 1;

		while(head <= tail) {
			if (in[head] != in[tail]) 
				return false;
			head++;
			tail--;			
		}
		return true;
	}
	
	public static void main(String[] args) {
		ValidPalindrome obj = new ValidPalindrome();
		boolean result;
		
		result = obj.isPalindrome("abc cba");
		System.out.println("Palindrome1 : " + result);
		
		result = obj.isPalindrome("abcba");
		System.out.println("Palindrome1A : " + result);
		
		result = obj.isPalindrome("A man, a plan, a canal: Panama");
		System.out.println("Palindrome2 : " + result);
		
		result = obj.isPalindrome("racing F1");
		System.out.println("Palindrome3 : " + result);
		
		result = obj.isPalindrome2(null);
		System.out.println("Palindrome4 : " + result);
		
		result = obj.isPalindrome2("aabbbcccccbbbaa");
		System.out.println("Palindrome5 : " + result);
		
		result = obj.isPalindrome2("A man, a pl, a canal: Panama");
		System.out.println("Palindrome6 : " + result);
	}

}
