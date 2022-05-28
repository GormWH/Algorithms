package org.suhong.leetcode.problems.p3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
class Solution {
  // brute force
  public int lengthOfLongestSubstring(String s) {
    //Map<Character, Integer> substringMap = new HashMap<>();
    int result = 0;
    outer:
    for (int i = 0; i < s.length(); i++) {
      Set<Character> characterSet = new HashSet<>();
      characterSet.add(s.charAt(i));
      for (int j = i + 1; j < s.length(); j++) {
        char current = s.charAt(j);
        if (characterSet.contains(current)) {
          result = Math.max(result, characterSet.size());
          continue outer;
        } else {
          characterSet.add(current);
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    String str1 = "abcabcbb";
    String str2 = "bbbbb";
    String str3 = "pwwkew";
    String str4 = "abcdefaghi";

    System.out.println(s.lengthOfLongestSubstring(str1)); // 3
    System.out.println(s.lengthOfLongestSubstring(str2)); // 1
    System.out.println(s.lengthOfLongestSubstring(str3)); // 3
    System.out.println(s.lengthOfLongestSubstring(str4)); // 9

  }
}