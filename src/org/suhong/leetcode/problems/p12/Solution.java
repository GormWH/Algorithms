package org.suhong.leetcode.problems.p12;

import java.util.HashMap;
import java.util.Map;

class Solution {
  private Map<Integer, Character> romanMap = new HashMap<>();

  public Solution() {
    romanMap.put(0, ' ');
    romanMap.put(1, 'I');
    romanMap.put(5, 'V');
    romanMap.put(10, 'X');
    romanMap.put(50, 'L');
    romanMap.put(100, 'C');
    romanMap.put(500, 'D');
    romanMap.put(1000, 'M');
  }

  public String intToRoman(int num) {
    StringBuilder builder = new StringBuilder();
    int digit = num % 10;
    num = num  / 10;
    buildString(digit, romanMap.get(1), romanMap.get(5), romanMap.get(10), builder);
    digit = num % 10;
    num = num  / 10;
    buildString(digit, romanMap.get(10), romanMap.get(50), romanMap.get(100), builder);
    digit = num % 10;
    num = num  / 10;
    buildString(digit, romanMap.get(100), romanMap.get(500), romanMap.get(1000), builder);
    digit = num % 10;
    num = num  / 10;
    buildString(digit, romanMap.get(1000), romanMap.get(0), romanMap.get(0), builder);
    return builder.reverse().toString();
  }

  private void buildString(int digit, char one, char five, char ten, StringBuilder builder) {
    if (digit == 9) {
      builder.append(ten);
      builder.append(one);
    } else if (digit >= 5) {
      for (int i = 0; i < digit - 5; i++) {
        builder.append(one);
      }
      builder.append(five);
    } else if (digit == 4) {
      builder.append(five);
      builder.append(one);
    } else {
      for (int i = 0; i < digit; i++) {
        builder.append(one);
      }
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.intToRoman(3));
    System.out.println(s.intToRoman(58));
    System.out.println(s.intToRoman(1994));
  }
}