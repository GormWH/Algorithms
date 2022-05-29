package org.suhong.leetcode.problems.p3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
class Solution {
  // brute force
  public int lengthOfLongestSubstring1(String s) {
    int result = 0;
    outer:
    for (int i = 0; i < s.length(); i++) {
      Set<Character> characterSet = new HashSet<>();
      characterSet.add(s.charAt(i));
      result = Math.max(result, characterSet.size());
      for (int j = i + 1; j < s.length(); j++) {
        char current = s.charAt(j);
        if (characterSet.contains(current)) {
          continue outer;
        } else {
          characterSet.add(current);
          result = Math.max(result, characterSet.size());
        }
      }
    }

    return result;
  }

  public int lengthOfLongestSubstring2(String s) {
    Map<Character, Integer> substringMap = new HashMap<>();
    int result = 0;
    int start = -1;
    int end = 0;
    for (int i = 0; i < s.length(); i++) {
      char curr = s.charAt(i);
      Integer prevIdx = substringMap.get(curr);
      if (prevIdx == null) {
        substringMap.put(curr, i);
      } else {
        if (prevIdx > start) {
          start = prevIdx ;
        }
        substringMap.put(curr, i);
      }
      end = i;
      result = Math.max(result, end - start);
    }
    return result;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    String str1 = "abcabcbb";
    String str2 = "bbbbb";
    String str3 = "pwwkew";
    String str4 = "abcdefaghi";
    String str5 = "abba";
    String str6 = "";

    System.out.println(s.lengthOfLongestSubstring2(str1)); // 3
    System.out.println(s.lengthOfLongestSubstring2(str2)); // 1
    System.out.println(s.lengthOfLongestSubstring2(str3)); // 3
    System.out.println(s.lengthOfLongestSubstring2(str4)); // 9
    System.out.println(s.lengthOfLongestSubstring2(str5)); // 2
    System.out.println(s.lengthOfLongestSubstring2(str6)); // 0

  }
}