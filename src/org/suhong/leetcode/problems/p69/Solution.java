package org.suhong.leetcode.problems.p69;

class Solution {
    // brute force
    public int mySqrt(int x) {
        int start = 0;
        int end = x;
        int result = 0;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (mid * mid <= x) {
                result = (int) mid;
                start = (int) mid + 1;
            } else {
                end = (int) mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.mySqrt(4)); // 2
        System.out.println(s.mySqrt(8)); // 2
        System.out.println(s.mySqrt(18)); // 4
        System.out.println(s.mySqrt(35)); // 5
        System.out.println(s.mySqrt(1600)); // 40
        System.out.println(s.mySqrt(2147395600)); // 46340
    }
}
