package sourabhs.datastructures.string;

/**
 * @author Sourabh
 * 
 * LeetCode
 */
public class ReverseWords {

	/**
	 * 
	 * LeetCode: 557
	 * Given a string, you need to reverse the order of characters in each 
	 * word within a sentence while still preserving whitespace and initial
	 * word order.
	 * 
	 * Example:
	 * Input: "Let's take LeetCode contest"
	 * Output: "s'teL ekat edoCteeL tsetnoc"
	 * 
	 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
	 */
	public String reverseWords(String str) {
        char[] arr = str.toCharArray();
		for (int i = 0; i < arr.length; i++) {
            if (arr[i] != ' ') {
                int j = i;
                for (; j < arr.length && arr[j] != ' '; j++) { }
                reverse(arr, i, j - 1);
                i = j - 1;	
            }
        }
        return String.valueOf(arr);
    }
	
	private void reverse(char[] arr, int i, int j) {
		char temp;
		for(; i < j ; i++, j--) {
			temp = arr[j];
			arr[j] = arr[i];
			arr[i] = temp;
		}
	}
	
	/**
	 * LeetCode: 557
	 */
	public String reverseWordsUsingStringBuilder(String s) {
        StringBuilder sb = new StringBuilder();
        
        int i = 0, j = 0;
        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                sb.append(" ");
                i++;
            }
            else {
                j = i + 1;
                while (j < s.length() && s.charAt(j) != ' ') j++;
                sb.append((new StringBuilder(s.substring(i, j))).reverse());
                i = j;
            }
        }
        
        return sb.toString();
    }
	
	public static void main(String[] args) {
		ReverseWords obj = new ReverseWords();
		String result = obj.reverseWords("This is a very big String to reverse");
		System.out.println("Reverse String is : " + result);

		result = obj.reverseWordsUsingStringBuilder("This is a very big String to reverse");
		System.out.println("Reverse String is : " + result);
	}

}
