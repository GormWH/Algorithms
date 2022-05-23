package org.suhong.leetcode.Problems.p474;

// https://leetcode.com/problems/ones-and-zeroes/
class Solution {
  public int findMaxForm(String[] strs, int m, int n) {
    int result = 0;
    outer:
    for (String str : strs) {
      int zeros = 0;
      int ones = 0;
      for (char c : str.toCharArray()) {
        if (c == '0') {
          zeros++;
          if (zeros > m) continue outer;
        }
        else {
          ones++;
          if (ones > n) continue outer;
        }
      }
      result++;
    }
    return result;
  }

  public static void main(String[] args) {
    Solution s = new Solution();

    String[] strs1 = {"10","0001","111001","1","0"};
    String[] strs2 = {"10","0","1"};

    System.out.println(s.findMaxForm(strs1, 5, 3)); // expects 4
    System.out.println(s.findMaxForm(strs2, 1, 1)); // expects 2
  }
}
