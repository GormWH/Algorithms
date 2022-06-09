package org.suhong.leetcode.problems.p455;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/assign-cookies/
public class Solution {

    public int findContentChildren(int[] g, int[] s) {
        if (s.length == 0) return 0;
        int result = 0;

        Arrays.sort(s);
        Arrays.sort(g);
        int cookiePointer = 0;
        outer:
        for (int greed : g) {
            while (true) {
                if (cookiePointer == s.length) break outer;
                if (greed <= s[cookiePointer++]) {
                    result++;
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] gs1 = {{1,2,3},{1,1}};
        int[][] gs2 = {{1,2},{1,2,3}};

        System.out.println(s.findContentChildren(gs1[0], gs1[1])); // 1
        System.out.println(s.findContentChildren(gs2[0], gs2[1])); // 2
    }
}
