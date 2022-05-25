package org.suhong.leetcode.problems.p12;

import java.util.HashMap;
import java.util.Map;

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

  public String intToRoman(int num) {

  }

  public static void main(String[] args) {

  }
}