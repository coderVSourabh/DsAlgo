package sourabhs.datastructures.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Sourabh
 * LeetCode: 22
 * 
 * Given n pairs of parentheses, write a function to 
 * generate all combinations of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 */
public class GenerateParentheses {

  public List<String> generateParenthesis(int n) {
    List<String> list = new ArrayList<>();
    backtrack(list, "", 0, 0, n);
    return list;
  }

  private void backtrack(List<String> list, String str, int open, int close, int max){

    if(str.length() == max*2){
      list.add(str);
      return;
    }

    if(open < max)
      backtrack(list, str+"(", open+1, close, max);
    if(close < open)
      backtrack(list, str+")", open, close+1, max);
  }
  
  public List<String> generateParenthesisIterative(int n) {
    List<List<String>> lists = new ArrayList<>();
    lists.add(Collections.singletonList(""));

    for (int i = 1; i <= n; ++i) {
      final List<String> list = new ArrayList<>();

      for (int j = 0; j < i; ++j) {
        for (final String first : lists.get(j)) {
          for (final String second : lists.get(i - 1 - j)) {
            list.add("(" + first + ")" + second);
          }
        }
      }
      lists.add(list);
    }
    return lists.get(lists.size() - 1);
  }

  public static void main(String[] args) {
    GenerateParentheses obj = new GenerateParentheses();
    List<String> results = obj.generateParenthesis(3);
    results.forEach(p-> System.out.println(p));
    System.out.println("New Input");
    results = obj.generateParenthesisIterative(3);
    results.forEach(p-> System.out.println(p));
  }
}
