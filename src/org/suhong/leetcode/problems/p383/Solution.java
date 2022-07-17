package org.suhong.leetcode.problems.p383;

// https://leetcode.com/problems/ransom-note/
class Solution {
    // brute force
    public boolean canConstruct(String ransomNote, String magazine) {
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

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.canConstruct("a","b")); // false
        System.out.println(s.canConstruct("aa","ab")); // false
        System.out.println(s.canConstruct("aa","aab")); // true
    }
}
