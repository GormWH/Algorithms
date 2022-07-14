package org.suhong.leetcode.problems.p70;

class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int nMinus2 = 1;
        int nMinus1 = 2;
        int temp;
        do {
            temp = nMinus2 + nMinus1;
            nMinus2 = nMinus1;
            nMinus1 = temp;
            n--;
        } while (n > 2);
        return temp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.climbStairs(2)); // 2
        System.out.println(s.climbStairs(3)); // 3
        System.out.println(s.climbStairs(4)); // 5
        System.out.println(s.climbStairs(5)); // 8
    }
}
