package vSourabh.dataStructures.math;

/**
 * @author Sourabh
 * 
 * LeetCode
 */
public class ExcelSheetColumn {


	/**
	 * LeetCode
	 * Excel Sheet Column Title
	 * 
	 * Given a positive integer, return its 
	 * corresponding column title as appear in an Excel sheet.
	 * 
	 * For example:
	 * A -> 1 B -> 2 C -> 3  ... Z -> 26  AA -> 27  AB -> 28
	 */
	public String convertToTitle(int n) {
		return n == 0 ? "" : convertToTitle(--n / 26) + (char)('A' + (n % 26));
	}


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
		ExcelSheetColumn excel = new ExcelSheetColumn();
		int num = excel.titleToNumber("ABC");
		String result = excel.convertToTitle(num);
		num = excel.titleToNumber(result);
		System.out.println("The excel title " + result + " is at number " + num);

	}

}
