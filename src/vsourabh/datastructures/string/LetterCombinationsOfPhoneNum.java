package vsourabh.datastructures.string;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Sourabh
 * LeetCode:
 * 
 * Given a digit string, return all possible letter 
 * combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons).
 * e.g: 
 * 1:     ;  2: abc ; 3: def
 * 4: ghi ;  5: jkl ; 6: mno
 * 7: pqrs;  8: tuv ; 9: wxyz
 * 
 * Example:
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class LetterCombinationsOfPhoneNum {

	public List<String> letterCombinations(String digits) {
		LinkedList<String> ans = new LinkedList<>();
		String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		ans.add("");
		for(int i =0; i < digits.length(); i++){
			int x = Character.getNumericValue(digits.charAt(i));
			while(ans.peek().length()== i){
				String t = ans.remove();
				for(char s : mapping[x].toCharArray())
					ans.add(t+s);
			}
		}
		return ans;
	}
	
	private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    
	public List<String> letterCombinationsRecursive(String digits) {
		List<String> ret = new LinkedList<String>();
		combination("", digits, 0, ret);
		return ret;
	}

	private void combination(String prefix, String digits, int offset, List<String> ret) {
		if (offset >= digits.length()) {
			ret.add(prefix);
			return;
		}
		String letters = KEYS[(digits.charAt(offset) - '0')];
		for (int i = 0; i < letters.length(); i++) {
			combination(prefix + letters.charAt(i), digits, offset + 1, ret);
		}
	}
	public static void main(String[] args) {
		LetterCombinationsOfPhoneNum obj = new LetterCombinationsOfPhoneNum();
		List<String> result = obj.letterCombinations("789");
		result.forEach( p -> System.out.print(p + " "));
		
		System.out.println("\n");
		result = obj.letterCombinationsRecursive("78");
		result.forEach( p -> System.out.print(p + " "));

	}

}
