package org.suhong.leetcode.problems.p9;

// https://leetcode.com/problems/palindrome-number/
class Solution {

  // with string
  public boolean isPalindrome1(int x) {
    if (x < 0) {
      return false;
    }
    String intStr = String.valueOf(x);
    for (int i = 0, j = intStr.length() - 1; i < j; i++, j--) {
      if (intStr.charAt(i) != intStr.charAt(j)) {
        return false;
      }
    }
    return true;
  }

  // with arithmetic method1
  public boolean isPalindrome2(int x) {
    if (x < 0) {
      return false;
    }

    int original = x;
    int reversed = 0;
    while (original > 0) {
      reversed = reversed * 10 + original % 10;
      original = original / 10;
    }

    return x == reversed;
  }

  // with arithmetic method2
  // referenced: (https://www.code-recipe.com/post/palindrome-number)
  public boolean isPalindrome3(int x) {
    if (x < 0 || (x != 0 && x % 10 == 0)) {
      return false;
    }

    int reverse = 0;
    while (x > reverse) {
      reverse = reverse * 10 + x % 10;
      x /= 10;
    }
    return x == reverse || x == reverse / 10;
  }

  public static void main(String[] args) {
    Solution s = new Solution();

    int num1 = 121;
    int num2 = -121;
    int num3 = 10;

    System.out.println(s.isPalindrome3(num1));
    System.out.println(s.isPalindrome3(num2));
    System.out.println(s.isPalindrome3(num3));
  }
}
