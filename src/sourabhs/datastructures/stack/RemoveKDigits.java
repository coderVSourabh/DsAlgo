package sourabhs.datastructures.stack;

import java.util.Stack;

public class RemoveKDigits {

  public String removeKdigits(String num, int k) {
    if(num == null || num.length() == k)
      return "0";

    Stack<Character> stack = new Stack<>();
    int i = 0;
    while(i < num.length()) {
      while(k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
        stack.pop();
        k--;
      }
      stack.push(num.charAt(i));
      i++;
    }

    // corner case
    while(k>0) {
      stack.pop();
      k--;
    }
    StringBuilder res = new StringBuilder();
    while(!stack.isEmpty())
      res.append(stack.pop());

    res.reverse();

    while(res.length() > 0 && res.charAt(0) == '0')
      res.deleteCharAt(0);

    return res.toString();

  }

  public static void main(String[] args) {

    RemoveKDigits obj = new RemoveKDigits();
    String res = obj.removeKdigits("10200", 1);
    System.out.println(res);
    System.out.println("=====================");
    res = obj.removeKdigits("1432219", 3);
    System.out.println(res);
    System.out.println("=====================");
  }
}
