package sourabhs.datastructures.graph.depth_first_search;

import java.util.*;

public class RemoveInvalidParentheses {

  private Set<String> validExp = new HashSet<>();
  private int minRemoved;

  private void init() {
    this.validExp.clear();
    this.minRemoved = Integer.MAX_VALUE;
  }

  private void recurse(String s, int index, int lCount, int rCount, StringBuilder exp, int removedCount) {
    if(index == s.length()) { // end of string
      if(lCount == rCount) { // current experssion is valid
        if(removedCount <= this.minRemoved) { // convert stringBuilder to string. so perform when needed
          String probableAnswer = exp.toString();
          if(removedCount < this.minRemoved) {
            this.validExp.clear();
            this.minRemoved = removedCount;
          }
          this.validExp.add(probableAnswer);
        }
      }
    } else {
      char currChar = s.charAt(index);
      int len = exp.length();
      if(currChar != '(' && currChar != ')') {
        // current expression is neither open or close brace, then add it string builder
        exp.append(currChar);
        this.recurse(s, index + 1, lCount, rCount, exp, removedCount);
        exp.deleteCharAt(len);
      } else { //recursion where we delete the current character and move forward.
        this.recurse(s, index + 1, lCount, rCount, exp, removedCount + 1);
        exp.append(currChar);
        if(currChar == '(') { // if its an open parenthesis, consider it and recurse
          this.recurse(s, index + 1, lCount + 1, rCount, exp, removedCount);
        } else if(rCount < lCount) {
          this.recurse(s, index + 1, lCount, rCount + 1, exp, removedCount);
        }
        exp.deleteCharAt(len); //undo the append for other recurse.
      }
    }
  }

  /**
   * Time Complexity : O(2^N)
   */
  public List<String> removeInvalidParenthesis(String s) {
    this.init();
    this.recurse(s, 0, 0, 0, new StringBuilder(), 0);
    return new ArrayList<>(this.validExp);
  }

  /**
   * Time Complexity : O(2^N)
   */
  public List<String> removeInvalidParenthesisUsingLoop(String s) {
    List<String> res = new ArrayList<>();

    if(s == null) return res;

    Set<String> visited = new HashSet<>();
    Queue<String> queue = new LinkedList<>();

    //initialize
    visited.add(s);
    queue.offer(s);

    boolean found = false;

    while(!queue.isEmpty()) {
      s = queue.poll();
      if(isValid(s)) {
        res.add(s);
        found = true;
      }

      if(found)
        continue;

      for(int i= 0; i < s.length(); i++) {
        if(s.charAt(i) != '(' && s.charAt(i) != ')')
          continue;
        String t = s.substring(0, i).concat(s.substring(i + 1));
        if(!visited.contains(t)) { // add each string which are not visited
          visited.add(t);
          queue.offer(t);
        }
      }
    }
    return res;
  }

  private boolean isValid(String s) {
    int count = 0;

    for(int i = 0; i <s.length(); i++) {
      if(s.charAt(i) == '(')
        count++;
      else if(s.charAt(i) == ')' && count-- == 0)
        return false;
    }
    return count == 0;
  }

  public static void main(String[] args) {
    RemoveInvalidParentheses obj = new RemoveInvalidParentheses();
    List<String> res = obj.removeInvalidParenthesis("(()))");
    res.forEach(System.out::println);
    System.out.println("=====================");
    res = obj.removeInvalidParenthesis("()())()");
    res.forEach(System.out::println);
    System.out.println("=====================");
    res = obj.removeInvalidParenthesisUsingLoop("()())()");
    res.forEach(System.out::println);
    System.out.println("=====================");
    res = obj.removeInvalidParenthesis(")(");
    res.forEach(System.out::println);
    System.out.println("=====================");
    res = obj.removeInvalidParenthesisUsingLoop(")(");
    res.forEach(System.out::println);
  }
}
