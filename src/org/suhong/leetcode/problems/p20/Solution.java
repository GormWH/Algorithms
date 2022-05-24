package org.suhong.leetcode.problems.p20;

import java.util.Stack;

// https://leetcode.com/problems/valid-parentheses/
class Solution {
  public boolean isValid(String s) {
    Stack<Character> parenthesisStack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(' || c == '{' || c == '[') {
        parenthesisStack.push(c);
      } else {
        if (parenthesisStack.empty() || Math.abs(parenthesisStack.peek() - c) >= 3) {
          return false;
        }
        parenthesisStack.pop();
      }
    }
    return parenthesisStack.empty();
  }

  private boolean isOpening(char c) {
    return c == '(' || c == '{' || c == '[';
  }

  private boolean isPair(char opening, char closing) {
    return Math.abs(closing - opening) < 3;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    String str = "{{(([)))}}";
    System.out.println(s.isValid(str));
  }
}