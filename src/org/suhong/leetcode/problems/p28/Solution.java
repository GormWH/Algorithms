package org.suhong.leetcode.problems.p28;

class Solution {
    public int strStr(String haystack, String needle) {
        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();
        int n_len = n.length;
        int h_limit = h.length - n_len + 1;

        outer:
        for (int i = 0; i < h_limit; i++) {
            for (int j = 0; j < n_len; j++) {
                if (h[i+j] != n[j]) continue outer;
            }
            return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        String haystack1 = "hello";
        String needle1 = "ll";

        String haystack2 = "aaaaa";
        String needle2 = "bba";

        String haystack3 = "string";
        String needle3 = "";

        String haystack4 = "aaa";
        String needle4 = "aaaa";

        System.out.println(s.strStr(haystack1, needle1)); // 2
        System.out.println(s.strStr(haystack2, needle2)); // -1
        System.out.println(s.strStr(haystack3, needle3)); // 0
        System.out.println(s.strStr(haystack4, needle4)); // -1

    }
}
