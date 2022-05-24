package org.suhong.leetcode.problems.p13;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/roman-to-integer/
class Solution {
  private Map<Character, Integer> romanMap = new HashMap<>();

  public Solution() {
    romanMap.put('I', 1);
    romanMap.put('V', 5);
    romanMap.put('X', 10);
    romanMap.put('L', 50);
    romanMap.put('C', 100);
    romanMap.put('D', 500);
    romanMap.put('M', 1000);
  }

  public int romanToInt(String s) {
    int result = romanMap.get(s.charAt(s.length()-1));
    int prev = result;
    for (int i = s.length() - 2; i >= 0; i--) {
      int current = romanMap.get(s.charAt(i));
      if (current < prev) {
        result -= current;
      } else {
        result += current;
      }
      prev = current;
    }

    return result;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    String str1 = "III";
    String str2 = "LVIII";
    String str3 = "MCMXCIV";

    System.out.println(s.romanToInt(str1));
    System.out.println(s.romanToInt(str2));
    System.out.println(s.romanToInt(str3));
  }
}

/*
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
*/
