package sourabhs.datastructures.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sourabh
 * 
 * LeetCode:
 * Given an array of strings, group anagrams together.
 * 
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
 * Return:
 * [ ["ate", "eat","tea"], 
 *   ["nat","tan"],
 *   ["bat"] ]
 * 
 * Note: All inputs will be in lower-case
 */
public class GroupAnagrams {

	/**
	 * Remember how we do multiplication?
	 * 
	 * Start from right to left, perform multiplication on every pair of digits, 
	 * and add them together. Let's draw the process! From the following draft, 
	 * we can immediately conclude:
	 * `num1[i] * num2[j]` will be placed at indices `[i + j`, `i + j + 1]` 
	 */
	public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) 
        	return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
	
	public static void main(String[] args) {
		GroupAnagrams obj = new GroupAnagrams();
		List<List<String>> result = obj.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"});
		
		result.forEach(p -> {
				p.forEach(str -> System.out.print(str + " "));
				System.out.println("");
		});
	}
}
