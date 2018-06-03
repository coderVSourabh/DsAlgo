package sourabhs.datastructures.hashtable;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

	public static boolean wordPattern(String pattern, String str) {
		String words[] = str.split(" ");
		if(words.length != pattern.length())
			return false;

		Map<String, Integer> map = new HashMap<>();
		for(int i = 0; i < words.length; i++) {
			if(map.put(pattern.charAt(i) + "", i) != map.put(words[i], i))
				return false;
		}
		return true;
	}

	public static boolean wordPattern2(String pattern, String str) {
		String words[] = str.split(" ");
		if(words.length != pattern.length())
			return false;

		Map<Character, String> map = new HashMap<>();
		for(int i = 0; i < words.length; i++) {
			map.putIfAbsent(pattern.charAt(i), words[i]);
			if(!map.get(pattern.charAt(i)).equals(words[i]))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		boolean res = wordPattern("abba", "dog cat cat dog");
		System.out.println(res);

		res = wordPattern2("abba", "dog cat cat dog");
		System.out.println(res);
		
		res = wordPattern("abba", "dog cat cat fish");
		System.out.println(res);

		res = wordPattern2("abba", "dog cat cat fish");
		System.out.println(res);
		
		res = wordPattern("aaaa", "dog cat cat dog");
		System.out.println(res);

		res = wordPattern2("aaaa", "dog cat cat dog");
		System.out.println(res);
		
		res = wordPattern("aaaa", "dog dog dog dog");
		System.out.println(res);
		
		res = wordPattern2("aaaa", "dog dog dog dog");
		System.out.println(res);
	}

}
