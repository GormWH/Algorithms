package org.suhong.leetcode.problems.p383;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/ransom-note/
class Solution {
    // brute force
    public boolean canConstruct1(String ransomNote, String magazine) {
        StringBuilder magazineManager = new StringBuilder(magazine);
        outer:
        for (char chr: ransomNote.toCharArray()) {
            for (int i = 0; i < magazineManager.length(); i++) {
                if (chr == magazineManager.charAt(i)) {
                    magazineManager.deleteCharAt(i);
                    continue outer;
                }
            }
            return false;
        }
        return true;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        int[] alphabetCounts = new int[26];
        for (char alphabet: magazine.toCharArray()) {
            alphabetCounts[alphabet - 'a']++;
        }
        for (char alphabet: ransomNote.toCharArray()) {
            if (alphabetCounts[alphabet - 'a'] == 0) return false;
            alphabetCounts[alphabet - 'a']--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.canConstruct("a","b")); // false
        System.out.println(s.canConstruct("aa","ab")); // false
        System.out.println(s.canConstruct("aa","aab")); // true
    }
}
