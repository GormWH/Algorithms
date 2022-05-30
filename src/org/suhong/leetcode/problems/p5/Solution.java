package org.suhong.leetcode.problems.p5;

// https://leetcode.com/problems/longest-palindromic-substring/submissions/
class Solution {
  public String longestPalindrome(String s) {
    if (s.length() == 1) {
      return s;
    }
    String result = null;
    if (s.charAt(0) == s.charAt(1)) {
      result = s.substring(0,2);
    } else {
      result = s.substring(0,1);
    }
    for (int center = 1; center < s.length(); center++) {
      // case1: odd number of elements
      for (int i = center - 1, j = center + 1;
            i >= 0 && j < s.length();
            i--, j++) {
        if (s.charAt(i) == s.charAt(j)) {
          if (j - i + 1 > result.length()) {
            result = s.substring(i, j+1);
          }
        } else {
          break;
        }
      }

      // case2: even number of elements
      if (center + 1 < s.length() && s.charAt(center) == s.charAt(center + 1)) {
        if (result.length() < 2) {
          result = s.substring(center, center + 2);
        }
        for (int i = center - 1, j = center + 2;
             i >= 0 && j < s.length();
             i--, j++) {
          if (s.charAt(i) == s.charAt(j)) {
            if (j - i + 1 > result.length()) {
              result = s.substring(i, j+1);
            }
          } else {
            break;
          }
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    String str1 = "babad";
    String str2 = "cbbd";
    String str3 = "abcde";
    String str4 = "qabcdcbae";
    String str5 = "eabcdcbae";
    String str6 = "aacabdkacaa";
    System.out.println(s.longestPalindrome(str1));
    System.out.println(s.longestPalindrome(str2));
    System.out.println(s.longestPalindrome(str3));
    System.out.println(s.longestPalindrome(str4));
    System.out.println(s.longestPalindrome(str5));
    System.out.println(s.longestPalindrome(str6));
  }
}
