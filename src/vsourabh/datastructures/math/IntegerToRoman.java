package vsourabh.datastructures.math;

/**
 * @author Sourabh
 *
 * LeetCode:
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class IntegerToRoman {
	
	public String intToRoman(int num) {
	    String M[] = {"", "M", "MM", "MMM"};
	    String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
	    String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
	    String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
	    return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
	}
	
	public String intToRomanUsingLoop(int num) {

	    int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
	    String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
	    
	    StringBuilder sb = new StringBuilder();
	    
	    for(int i=0;i<values.length;i++) {
	        while(num >= values[i]) {
	            num -= values[i];
	            sb.append(strs[i]);
	        }
	    }
	    return sb.toString();
	}

	public static void main(String[] args) {
		IntegerToRoman obj = new IntegerToRoman();
		String result = obj.intToRoman(121);
		System.out.println("The Roman Number is " + result);

		 result = obj.intToRoman(7);
		 System.out.println("The Roman Number is " + result);

		 result = obj.intToRomanUsingLoop(2);
		 System.out.println("The Roman Number is " + result);
	}

}
