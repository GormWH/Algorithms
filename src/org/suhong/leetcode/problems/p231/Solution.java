package org.suhong.leetcode.problems.p231;

import java.util.HashSet;
import java.util.Set;

class Solution {

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return isPowerOfTwoRecursive(n);
    }

    private boolean isPowerOfTwoRecursive(int n) {
        if (n % 2 == 0) {
            return isPowerOfTwo(n / 2);
        }
        return n == 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.isPowerOfTwo(16)); // true
        System.out.println(s.isPowerOfTwo(28)); // false
        System.out.println(s.isPowerOfTwo(Integer.MAX_VALUE / 2 + 1)); // true
        System.out.println(s.isPowerOfTwo(17)); // false
        System.out.println(s.isPowerOfTwo(-1)); // false
    }
}
