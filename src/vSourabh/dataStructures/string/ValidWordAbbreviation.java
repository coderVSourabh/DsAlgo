package vsourabh.datastructures.string;

/**
 * @author Sourabh
 *
 * LeetCode:
 * 
 * Given a non-empty string s and an abbreviation abbr, 
 * return whether the string matches with the given abbreviation.
 * 
 * A string such as "word" contains only the following valid abbreviations:
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", 
 * "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 * Notice that only the above abbreviations are valid abbreviations of the 
 * string "word". Any other string is not a valid abbreviation of "word".
 * 
 * Note:
 * Assume s contains only lowercase letters and abbr contains only 
 * lowercase letters and digits.
 * 
 * Example:
 * Given s = "internationalization", abbr = "i12iz4n":
 * Return true.
 * 
 * Given s = "apple", abbr = "a2e":
 * Return false.
 */
public class ValidWordAbbreviation {

	public boolean validWordAbbreviation(String word, String abbr) {
		int i = 0, j = 0;
		while (i < word.length() && j < abbr.length()) {
			if (word.charAt(i) == abbr.charAt(j)) {
				++i;++j;
				continue;
			}
			if (abbr.charAt(j) <= '0' || abbr.charAt(j) > '9') {
				return false;
			}
			int start = j;
			while (j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
				++j;
			}
			int num = Integer.valueOf(abbr.substring(start, j));
			i += num;
		}
		return i == word.length() && j == abbr.length();
	}
	public static void main(String[] args) {
		ValidWordAbbreviation obj = new ValidWordAbbreviation();
		boolean result = obj.validWordAbbreviation("windows", "wind1ws");
		System.out.println("The WordAbbreviation is " + result);

		result = obj.validWordAbbreviation("apple", "a3e");
		System.out.println("The WordAbbreviation is " + result);
		
		result = obj.validWordAbbreviation("apple", "a5e");
		System.out.println("The WordAbbreviation is " + result);
	}

}
