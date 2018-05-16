package sourabhs.datastructures.math;

/**
 * @author Sourabh
 * 
 * LeetCode
 */
public class ExcelSheetColumnTitle {


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

	public String convertToTitle2(int n) {
		
		StringBuilder res = new StringBuilder();
		 
		while(n > 0) {
			n -= 1;
			char temp = (char) ('A' + (n % 26));
			res.insert(0, temp);
			n =  n / 26;
		}
		return res.toString();
			
	}

	

	public static void main(String[] args) {
		ExcelSheetColumnTitle excel = new ExcelSheetColumnTitle();
		String result = excel.convertToTitle(731);
		System.out.println("The excel title " + result);

		result = excel.convertToTitle2(731);
		System.out.println("The excel title " + result);
	}

}
