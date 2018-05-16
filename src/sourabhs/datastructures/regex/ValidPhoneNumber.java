package sourabhs.datastructures.regex;

public class ValidPhoneNumber {
	
	public static boolean validPhoneNumber(String phoneNum) {
		return phoneNum.matches("\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}");
		// \d{10} : 1234567890
		// (?:\\d{3}-){2}\\d{4} 123-456-7890
		// \\(\\d{3}\\)\\d{3}-?\\d{4} (123)4567890 or (123)456-7890
	}

	public static void main(String[] args) {
		boolean res = validPhoneNumber("9876543210");
		System.out.println(res);
		
		res = validPhoneNumber("987-654-3210");
		System.out.println(res);
		
		res = validPhoneNumber("(987)6543210");
		System.out.println(res);
		
		res = validPhoneNumber("(987)654-3210");
		System.out.println(res);
		
		res = validPhoneNumber("987654-3210");
		System.out.println(res);
	}

}
