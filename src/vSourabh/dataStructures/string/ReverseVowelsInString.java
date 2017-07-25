package vsourabh.datastructures.string;

import java.util.HashSet;
import java.util.Set;

import vsourabh.datastructures.utils.ArrayUtills;

/**
 * @author Sourabh
 * 
 * LeetCode:
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * 
 * Example: 
 * Given s = "hello", return "holle".
 * Given s = "leetcode", return "leotcede".
 * 
 * Note:
 * The vowels does not include the letter "y".
 */
public class ReverseVowelsInString {
	
	public String reverseVowels(String word) {
		if(word == null || word.length()==0)
			return word;
		String vowels = "aeiouAEIOU";
		char[] chars = word.toCharArray();
		int start = 0;
		int end = word.length()-1;
		while(start<end){

			while(start<end && !vowels.contains(chars[start]+"")){
				start++;
			}

			while(start<end && !vowels.contains(chars[end]+"")){
				end--;
			}

			ArrayUtills.swap(chars, start, end);
			start++;
			end--;
		}
		return new String(chars);
	}
	
	
	/**
	 * Set to reduce the search time to O(1)
	 */
	public String reverseVowelsUsingSet(String word) {
		char[] chars = word.toCharArray();
		Set<Character> set=new HashSet<>();
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		set.add('A');
		set.add('E');
		set.add('I');
		set.add('O');
		set.add('U');
		int start=0, end=chars.length-1;
		while(start<end){
			if(!set.contains(chars[start])){
				start++;
				continue;
			}
			if(!set.contains(chars[end])){
				end--;
				continue;
			}
			
			ArrayUtills.swap(chars, start, end);
			start++;
			end--;
		}
		
		return new String(chars);
	}

	public static void main(String[] args) {
		ReverseVowelsInString obj = new ReverseVowelsInString();
		String result = obj.reverseVowels("Sourabh");
		System.out.println("The Reverse vowel String is " + result);
		
		result = obj.reverseVowelsUsingSet("ThisIsAVowel");
		System.out.println("The Reverse vowel String is " + result);
	}

}
