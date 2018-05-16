package sourabhs.datastructures.array;

/**
 * 
 * @author Sourabh
 * 
 * Code to find the frequent (or most repeated)
 * Character in the given character array
 *
 */
public class FindFrequentChar {
	
	public char findFrequentChar(char[] str) {
		
		// To store the ASCII value of characters like A = 65, Z = 90 a = 97, z =  122
		int count[] = new int[256]; 
		
		for (int i = 0; i < str.length; i++) {
			count[str[i]]++;
		}

		int max = 0;
		char frequentChar = 0;

		for (int i = 0; i < count.length; i++) {
			if (count[i] > max) {
				max = count[i];
				frequentChar = (char) i;
			}
		}
		return frequentChar;
	}

	public static void main(String[] args) {
		String str = new String("FrequencyMatcher");
		System.out.println(" The character  is " + new FindFrequentChar().findFrequentChar(str.toCharArray()) + " in String " + str );

	}

}
