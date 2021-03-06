package sourabhs.datastructures.string;

import java.util.Stack;

/**
 * @author Sourabh
 * 
 * LeetCode:
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid. The brackets must close in the correct 
 * order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		ValidParentheses obj = new ValidParentheses();
		boolean result = obj.isValid("{([])}");
		System.out.println("The string is " + result);

		result = obj.isValid("{(()]}");
		System.out.println("The string is " + result);
	}

}
