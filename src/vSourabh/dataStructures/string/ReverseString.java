package vSourabh.dataStructures.string;

import vSourabh.dataStructures.utils.ArrayUtills;

/**
 * @author Sourabh
 * 
 * LeetCode:
 */
public class ReverseString {
	
	
	/** Write a function that takes a string 
	 * as input and returns the string reversed.
	 * 
	 * Example:
	 * Given s = "hello"
	 * return "olleh".
	 */
	/**
	 * LeetCode: 344
	 * Time Complexity : O(n)
	 * Space Complexity: O(n)
	 */
	public String reverseString(String s) {
		char[] word = s.toCharArray();
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			char temp = word[i];
			word[i] = word[j];
			word[j] = temp;
			i++;
			j--;
		}
		return new String(word);
	}

	/**
	 * LeetCode: 344
	 * Swapping Using Two Pointers
	 * Time Complexity : O(n)
	 * Space Complexity: O(n)
	 */
	public String reverseStringBySwapping(String s) {
        byte[] bytes = s.getBytes();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            byte temp = bytes[i];
            bytes[i] = bytes[j];
            bytes[j] = temp;
            i++;
            j--;
        }
        return new String(bytes);
    }
	
	/**
	 * LeetCode: 344
	 * Time Complexity : O(n)
	 * Space Complexity: O(n)
	 */
	public String reverseStringUsingBuilder(String s) {
        return new StringBuilder(s).reverse().toString();
    }
	
	/**
	 * LeetCode: 344
	 * Divide and Conquer (Recursive) 
	 * Time Complexity : O(nLog(n))
	 * Space Complexity: O(h); h height of tree	
	 */
	public String reverseStringUsingTree(String s) {
        int length = s.length();
        if (length <= 1) return s;
        String leftStr = s.substring(0, length / 2);
        String rightStr = s.substring(length / 2, length);
        return reverseString(rightStr) + reverseString(leftStr);
    }
	
	/**
	 * LeetCode: 541
	 * 
	 * Given a string and an integer k, you need to reverse the first k characters 
	 * for every 2k characters counting from the start of the string. If there are 
	 * less than k characters left, reverse all of them. If there are less than 2k 
	 * but greater than or equal to k characters, then reverse the first k characters 
	 * and left the other as original.
	 * 
	 * Example:
	 * Input: s = "abcdefg", k = 2
	 * Output: "bacdfeg"
	 * Restrictions:
	 * The string consists of lower English letters only.
	 * Length of the given string and k will in the range [1, 10000]
	 */
	public String reverseStrII(String s, int k) {
		 char[] arr = s.toCharArray();
	        int n = arr.length;
	        int i = 0;
	        while(i < n) {
	            int j = Math.min(i + k - 1, n - 1);
	            ArrayUtills.swap(arr, i, j);
	            i += 2 * k;
	        }
	        return String.valueOf(arr);
	}
	
	public static void main(String[] args) {
		ReverseString obj = new ReverseString();
		String result = obj.reverseString("Reverse");
		System.out.println("Reverse String is " + result);
		
		result = obj.reverseStringBySwapping("ReverseS");
		System.out.println("Reverse String is " + result);
		
		result = obj.reverseStringUsingBuilder("RotATE");
		System.out.println("Reverse String is " + result);
		
		result = obj.reverseStringUsingTree("RoTate");
		System.out.println("Reverse String is " + result);
		
		result = obj.reverseStrII("ThisIsElephantInTheJungle", 3);
		System.out.println("Reverse String II is " + result);
		
		result = obj.reverseStrII("ThisIsElephantInTheJungle", 2);
		System.out.println("Reverse String II is " + result);
	}
}
