package sourabhs.datastructures.string;

/**
 * @author Sourabh
 *
 * LeetCode:
 * Count the number of segments in a string, where a segment 
 * is defined to be a contiguous sequence of non-space characters.
 * Please note that the string does not contain any non-printable characters.
 * 
 * Example: 
 * Input: "Hello, my name is John"
 * Output: 5
 */
public class CountStringSegments {

	/**
	 * Time Complexity :O(n)
	 * Space Complexity:O(1)
	 */
	public int countSegments(String s) {
	    int res=0;
	    for(int i=0; i<s.length(); i++)
	        if(s.charAt(i)!=' ' && (i==0 || s.charAt(i-1)==' '))
	            res++;        
	    return res;
	}


	public static void main(String[] args) {
		CountStringSegments obj = new CountStringSegments();
		int result;
		result = obj.countSegments("");
		System.out.println("Segments are " + result);
		
		result = obj.countSegments("Hey there what's up?");
		System.out.println("Segments are " + result);
	}

}
