package org.suhong.leetcode.problems.p69;

class Solution {
    // brute force
    public int mySqrt(int x) {
        int max = Integer.MAX_VALUE / 2;
        int answer = 0;
        while (true) {
            if (answer * answer > x || answer > max) {
                return answer - 1;
            }
            answer++;
        }
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
