package org.suhong.leetcode.problems.p1006;

// https://leetcode.com/problems/clumsy-factorial/
class Solution {
    public int clumsy(int n) {
        int result = 0;

        if (n >= 4) {
            result += n * (n-1) / (n-2) + (n-3);
            n -= 4;
        } else {
            return -smallerThanFour(n);
        }
        while (n >= 4) {
            result += - n * (n-1) / (n-2) + (n-3);
            n -= 4;
        }
        result += smallerThanFour(n);
        return result;
    }

    private int smallerThanFour(int n) {
        int result = 0;
        switch (n) {
            case 3:
                result += - n * (n-1) / (n-2);
                break;
            case 2:
                result += - n * (n-1);
                break;
            case 1:
                result += - n;
                break;
            default:
                break;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.clumsy(4)); // 7
        System.out.println(s.clumsy(10)); // 12
        System.out.println(s.clumsy(1)); // 1
    }
}
