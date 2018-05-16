package sourabhs.datastructures.string;

/**
 * @author Sourabh
 * 
 * LeetCode:
 * Implement strStr().
 * Returns the index of the first occurrence of 
 * needle in haystack, or -1 if needle is not part
 * of haystack.
 */
public class ImplementStrStr {

	public int strStr(String haystack, String needle) {
		for (int i = 0; ; i++) {
			for (int j = 0; ; j++) {
				if (j == needle.length()) return i;
				if (i + j == haystack.length()) return -1;
				if (needle.charAt(j) != haystack.charAt(i + j)) break;
			}
		}
	}
	
	public int StrImpl(String hay, String search) {
		int j = 0;
		char ch[] = search.toCharArray();
		
		for(int i = 0; ; i++) {
			
			if(ch[j] == hay.charAt(i)){
				if (j == ch.length - 1)
					return i - 1;
				j++;
				continue;
			}
			j = 0;
			if (i + ch.length == hay.length()) return -1;
				
		}
		
	}

	public static void main(String[] args) {
		
		ImplementStrStr obj = new ImplementStrStr();
		
		int index = obj.strStr("This is a very big String", "big");
		System.out.println("The index is : " + index);

		index = obj.strStr("This is a very big String", "Strinnnng");
		System.out.println("The index is : " + index);
		

		index = obj.StrImpl("This is a very big String", "big");
		System.out.println("The index is : " + index);
	}
}
