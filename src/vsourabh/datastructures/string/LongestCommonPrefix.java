package vsourabh.datastructures.string;

import java.util.Arrays;

/**
 * @author Sourabh
 * 
 * LeetCode:
 * Write a function to find the longest common 
 * prefix string amongst an array of strings.
 * 
 * Example:
 * Input  : {“geeksforgeeks”, “geeks”, “geek”, “geezer”}
 * Output : "gee"
 * 
 * Input  : {"apple", "ape", "april"}
 * Output : "ap"
 */
public class LongestCommonPrefix {
	
	public String longestCommonPrefix(String[] strs) {
	    if(strs == null || strs.length == 0)    return "";
	    String pre = strs[0];
	    int i = 1;
	    while(i < strs.length){
	        while(strs[i].indexOf(pre) != 0)
	            pre = pre.substring(0,pre.length()-1);
	        i++;
	    }
	    return pre;
	}
	
	public String longestCommonPrefixRevised(String[] strs) {
	    if (strs.length == 0) 
	    	return "";
	    String pre = strs[0];
	    for (int i = 1; i < strs.length; i++)
	        while(strs[i].indexOf(pre) != 0)
	            pre = pre.substring(0,pre.length()-1);
	    return pre;
	}
	
	public String longestCommonPrefixUsingSort(String[] strs) {
		StringBuilder result = new StringBuilder();

		if (strs == null || strs.length <= 0) 
			return "";

		Arrays.sort(strs);

		char [] a = strs[0].toCharArray();
		char [] b = strs[strs.length-1].toCharArray();

		for (int i = 0; i < a.length; i ++){
			if (b.length > i && b[i] == a[i]){
				result.append(b[i]);
			}
			else {
				return result.toString();
			}
		}
		return result.toString();
	}
	
	public static void main(String[] args) {
		LongestCommonPrefix obj = new LongestCommonPrefix();
		String result = obj.longestCommonPrefix(new String[] {"geeksforgeeks", "geeks", "geek", "geezer"});
		System.out.println("Common Prefix " + result);
	}

}
