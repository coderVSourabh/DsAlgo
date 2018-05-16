package sourabhs.datastructures.hashtable;

public class ValidAnagram {

	public static boolean isAnagram(String s, String t) {
		if(s == null || t == null) return s == null  && t == null;
		int[] alphabets = new int[26];
		for(int i = 0; i < s.length(); i++) alphabets[s.charAt(i) - 'a']++;
		for(int i = 0; i < t.length(); i++) alphabets[t.charAt(i) - 'a']--;
		for(int i : alphabets) if(i != 0) return false;
		return true;
	}
	public static void main(String[] args) {
		boolean res = isAnagram("anagram", "nagaram");
		System.out.println(res);
		
		res = isAnagram("add", "dad");
		System.out.println(res);
		
		res = isAnagram("rat", "ate");
		System.out.println(res);
	}

}
