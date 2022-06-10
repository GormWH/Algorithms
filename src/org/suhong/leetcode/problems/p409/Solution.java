package org.suhong.leetcode.problems.p409;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-palindrome/
class Solution {

    public int longestPalindrome(String s) {
        Map<Character, Integer> letterCountMap = new HashMap<>();
        for (Character c : s.toCharArray()) {
            Integer count = letterCountMap.get(c);
            if (count == null) {
                letterCountMap.put(c, 1);
            } else {
                letterCountMap.put(c,count + 1);
            }
        }

        int numOfOdds = 0;
        for (int count : letterCountMap.values()) {
            if (count % 2 != 0) {
                numOfOdds++;
            }
        }
        return s.length() - (numOfOdds > 0 ? numOfOdds - 1 : 0);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        String str1 = "abccccdd";
        String str2 = "a";
        String str3 = "bb";

        System.out.println(s.longestPalindrome(str1)); // 7
        System.out.println(s.longestPalindrome(str2)); // 1
        System.out.println(s.longestPalindrome(str3)); // 2

    }

}
