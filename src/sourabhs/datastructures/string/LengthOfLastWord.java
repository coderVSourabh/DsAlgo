package sourabhs.datastructures.string;

/**
 * @author Sourabh
 * 
 * LeetCode:
 * Given a string s consists of upper/lower-case alphabets and 
 * empty space characters ' ', return the length of last word 
 * in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * For example, 
 * Given s = "Hello World",
 * return 5.
 *
 */
public class LengthOfLastWord {
	
	public int lengthOfLstWord(String str) {
		int len = 0;
		char[] arr = str != null? str.toCharArray() : new char[] {};
        for(char ch : arr) {
            if (ch != ' ')
                ++len;
            else if (ch == ' ')
                len = 0;
        }
        return len;
	}
	
	public int lengthOfLastWordUsingTrim(String s) {
	    return s.trim().length()-s.trim().lastIndexOf(" ") - 1;
	}
	
	public int lengthOfLastWord2(String s) {
		if(s == null)
			return 0;
		char ch[] = s.toCharArray();
		int res = 0, len = ch.length - 1;
		while(len >= 0 && ch[len] == ' ') len--;
		while(len >= 0 && ch[len] != ' ') {
			++res;
			len--;
		}
		return res;
	}
	
	public static void main(String[] args) {
		LengthOfLastWord obj = new LengthOfLastWord();
		int result = obj.lengthOfLastWordUsingTrim("Hello World");
		System.out.println("Length of Last word is " + result);
		
		result = obj.lengthOfLstWord("Hello World");
		System.out.println("Length of Last word is " + result);
		
		result = obj.lengthOfLstWord(null);
		System.out.println("Length of Last word is " + result);
		
		result = obj.lengthOfLastWord2("Hello World   ");
		System.out.println("Length of Last word is " + result);
	}
}
