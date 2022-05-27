package org.suhong.leetcode.problems.p6;

// https://leetcode.com/problems/zigzag-conversion/
class Solution {
  public String convert(String s, int numRows) {
    if (numRows == 1) {
      return s;
    }
    StringBuilder builder = new StringBuilder();
    int length = s.length();
    int cycleLength = numRows * 2 - 2;
    int numCycle = length / cycleLength + 1;
    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < numCycle; j++) {
        int index1 = i + j * cycleLength;
        if (index1 >= length) continue;
        builder.append(s.charAt(index1));
        int index2 = (j + 1) * cycleLength - i;
        if (i != 0 && i != numRows - 1 && index2 < length) {
          builder.append(s.charAt(index2));
        }
      }
    }
    return builder.toString();
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    String str = "PAYPALISHIRING";
    System.out.println(s.convert(str, 3)); // PAHNAPLSIIGYIR
    /*
    P   A   H   N
    A P L S I I G
    Y   I   R
     */
    System.out.println(s.convert(str, 4)); // PINALSIGYAHRPI
    /*
    P     I    N
    A   L S  I G
    Y A   H R
    P     I
     */
  }
}
