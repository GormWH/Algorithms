package org.suhong.leetcode.Problems.p20;

import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/valid-parentheses/
class Solution {
  public boolean isValid(String s) {
    Stack<Character> parenthesisStack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (isOpening(c)) {
        parenthesisStack.push(c);
      } else {
        if (parenthesisStack.size() == 0) {
          return false;
        }
        if (isPair(parenthesisStack.peek(), c)) {
          parenthesisStack.pop();
        } else {
          return false;
        }
      }
    }
    return parenthesisStack.size() == 0;
  }

  private boolean isOpening(char c) {
    if (c == '(' || c == '{' || c == '[') {
      return true;
    }
    return false;
  }

  private boolean isPair(char opening, char closing) {
    if (Math.abs(closing - opening) < 3) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    String str = "{{(([)))}}";
    System.out.println(s.isValid(str));
  }
}
