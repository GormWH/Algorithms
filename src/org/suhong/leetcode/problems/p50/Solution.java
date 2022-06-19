package org.suhong.leetcode.problems.p50;

public class Solution {

    public double myPow(double x, int n) {
        if (x == 0.0) return 0;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        double result = 1;
        while (n > 0) {
            result *= x;
            n--;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        double x1 = 2.0;
        int n1 = 10;

        double x2 = 2.1;
        int n2 = 3;

        double x3 = 2.0;
        int n3 = -2;

        System.out.println(s.myPow(x1, n1));
        System.out.println(s.myPow(x2, n2));
        System.out.println(s.myPow(x3, n3));

    }
}
