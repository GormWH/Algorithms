package org.suhong.leetcode.problems.p12;

import java.util.HashMap;
import java.util.Map;

class Solution {
  private Map<Integer, Character> romanMap = new HashMap<>();

  public Solution() {
    romanMap.put(1, 'I');
    romanMap.put(5, 'V');
    romanMap.put(10, 'X');
    romanMap.put(50, 'L');
    romanMap.put(100, 'C');
    romanMap.put(500, 'D');
    romanMap.put(1000, 'M');
    romanMap.put(5000, ' ');
    romanMap.put(10000, ' ');
  }

  public String intToRoman(int num) {
    StringBuilder builder = new StringBuilder();
    int one = 1;
    int five = 5;
    int ten = 10;
    while (num != 0) {
      int digit = num % 10;
      num /= 10;
      buildString(digit, romanMap.get(one), romanMap.get(five), romanMap.get(ten), builder);
      one *= 10;
      five *= 10;
      ten *= 10;
    }

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