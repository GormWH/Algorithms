package org.suhong.leetcode.problems.p58;

// https://leetcode.com/problems/length-of-last-word/
class Solution {
    public int lengthOfLastWord(String s) {
        char[] charArray = s.toCharArray();

        // get the last index of character
        int lastCharIdx = -1;
        for (int i = charArray.length-1; i >= 0; i--) {
            if (charArray[i] != ' ') {
                lastCharIdx = i;
                break;
            }
        }
        if (lastCharIdx == -1) return 0; // if no characters found, return 0

        // get the last index of space(which is before the last word)
        int lastSpaceIdx = -1;
        for (int i = lastCharIdx-1; i >= 0; i--) {
            if (charArray[i] == ' ') {
                lastSpaceIdx = i;
                break;
            }
        }
        return lastCharIdx - lastSpaceIdx;

    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.lengthOfLastWord("Hello World")); // 5
        System.out.println(s.lengthOfLastWord("   fly me   to   the moon  ")); // 4
        System.out.println(s.lengthOfLastWord("luffy is still joyboy")); // 6
        System.out.println(s.lengthOfLastWord("    ")); // 0
    }
}
