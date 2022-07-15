package org.suhong.leetcode.problems.p1672;

import java.util.Arrays;

// https://leetcode.com/problems/richest-customer-wealth/
class Solution {
    public int maximumWealth1(int[][] accounts) {
        int max = 0;

        for (int[] customer : accounts) {
            int wealth = 0;
            for (int amount : customer) {
                wealth += amount;
            }
            max = Math.max(max, wealth);
        }

        return max;
    }

    public int maximumWealth(int[][] accounts) {
        int max = 0;

        for (int i = 0; i < accounts.length; i++) {
            int wealth = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                wealth += accounts[i][j];
            }
            if (wealth > max) max = wealth;
        }

        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.maximumWealth(new int[][]{{1,2,3},{3,2,1}})); // 6
        System.out.println(s.maximumWealth(new int[][]{{1,5},{7,3},{3,5}})); // 10
        System.out.println(s.maximumWealth(new int[][]{{2,8,7},{7,1,3},{1,9,5}})); // 17
    }
}
