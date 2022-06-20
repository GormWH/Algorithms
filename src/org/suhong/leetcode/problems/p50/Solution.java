package org.suhong.leetcode.problems.p50;

// https://leetcode.com/problems/powx-n/
public class Solution {

    public double myPow(double x, int n) {
        if (x == 0.0) return 0;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        double result = customPow(x, n);


        return result;
    }

    private double customPow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        }
        double num = customPow(x, n / 2);
        if (n % 2 == 0) {
            return num * num;
        } else {
            return num * num * x;
        }
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
