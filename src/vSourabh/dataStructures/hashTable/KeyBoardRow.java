package vSourabh.dataStructures.hashTable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import vSourabh.dataStructures.utils.ArrayUtills;

/**
 * @author Sourabh
 * 
 * LeetCode:
 * Given a List of words, return the words that can be typed 
 * using letters of alphabet on only one row's of American keyboard.
 *
 * Example:
 * Input: ["Hello", "Alaska", "Dad", "Peace"] Output: ["Alaska", "Dad"]
 * 
 * Note:
 * You may use one character in the keyboard more than once.
 * You may assume the input string will only contain letters of alphabet.
 */
public class KeyBoardRow {

	/**
	 * Using RegEx and Stream
	 */
	public String[] findWordsUsingRegEx(String[] words) {
	    return Stream.of(words).filter(
	    		s -> s.toLowerCase().matches("[qwertyuiop]*"
	    				+ "|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new);
	}
	
	public String[] findWords(String[] words) {
		String[] strs = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i<strs.length; i++){
			for(char c: strs[i].toCharArray()){
				map.put(c, i);//put <char, rowIndex> pair into the map
			}
		}
		List<String> res = new LinkedList<>();
		for(String w: words){
			if(w.equals("")) continue;
			int index = map.get(w.toUpperCase().charAt(0));
			for(char c: w.toUpperCase().toCharArray()){
				if(map.get(c)!=index){
					index = -1; //don't need a boolean flag. 
					break;
				}
			}
			if(index!=-1) res.add(w);//if index != -1, this is a valid string
		}
		return res.toArray(new String[0]);
	}
	
	public static void main(String[] args) {
		KeyBoardRow obj = new KeyBoardRow();
		String[] words = {"Hello", "Alaska", "Dad", "Peace"};
		String[] result = obj.findWords(words);
		System.out.print("The Resulting words are: ");
		ArrayUtills.printArray(result);
		
		result = obj.findWordsUsingRegEx(words);
		System.out.print("The Resulting words are: ");
		ArrayUtills.printArray(result);

	}

}
