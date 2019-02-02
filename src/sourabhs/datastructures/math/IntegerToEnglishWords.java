package sourabhs.datastructures.math;

/**
 * @author Sourabh
 *
 * LeetCode:
 * Convert a non-negative integer to its english
 * words representation. Given input is guaranteed
 * to be less than 2^31 - 1.
 * 
 * For example,
 * 123 -> "One Hundred Twenty Three"
 * 12345 -> "Twelve Thousand Three Hundred Forty Five"
 * 1234567 -> "One Million Two Hundred Thirty Four 
 *             Thousand Five Hundred Sixty Seven"
 * Hint:
 * Did you see a pattern in dividing the number into 
 * chunk of words? For example, 123 and 123000
 */
public class IntegerToEnglishWords {
	
	private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", 
			"Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", 
			"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", 
			"Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	
	private final String[] TENS = {"", "Ten", "Twenty", "Thirty", 
			"Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	
	private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

	/**
	 * Time Complexity: O(n), where n ir the number of digits in the given integer.
	 */
	public String numberToWords(int num) {
	    if (num == 0) return "Zero";

	    int i = 0;
	    String words = "";
	    
	    while (num > 0) {
	        if (num % 1000 != 0)
	    	    words = helper(num % 1000) + THOUSANDS[i] + " " + words;
	    	num /= 1000;
	    	i++;
	    }
	    
	    return words.trim();
	}

	private String helper(int num) {
	    if (num == 0)
	        return "";
	    else if (num < 20)
	        return LESS_THAN_20[num] + " ";
	    else if (num < 100)
	        return TENS[num / 10] + " " + helper(num % 10);
	    else
	        return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
	}

	public static void main(String[] args) {
		IntegerToEnglishWords obj = new IntegerToEnglishWords();
		String result = obj.numberToWords(123);
		System.out.println("123: " + result);
		System.out.println("=====================");
		result = obj.numberToWords(123000);
		System.out.println("123000: " + result);
		System.out.println("=====================");
		result = obj.numberToWords(1000);
		System.out.println("1000: " + result);
	}
}
