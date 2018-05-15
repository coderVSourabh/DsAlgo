package vsourabh.datastructures.math;

public class ExcelSheetColumnNumber {
	
	
	/**
	 * LeetCode
	 * Excel Sheet Column Number
	 * Given a column title as appear in an Excel sheet, 
	 * return its corresponding column number.
	 * 
	 * For example:
	 * A -> 1 B -> 2 C -> 3  ... Z -> 26  AA -> 27  AB -> 28 
	 */
	public int titleToNumber(String s) {
		int result = 0;
		for (int i = 0; i < s.length(); result = result * 26 + (s.charAt(i) - 'A' + 1), i++);
		return result;
    }
	
	public static void main(String[] args) {
		ExcelSheetColumnNumber excel = new ExcelSheetColumnNumber();
		int num = excel.titleToNumber("ABC");
		System.out.println(num);
	}

}
