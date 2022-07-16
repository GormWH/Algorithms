package org.suhong.leetcode.problems.p1342;

// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
class Solution {
    public int numberOfSteps(int num) {
        int count = 0;
        while (num > 1) {
            if (num % 2 == 0) {
                count += 1;
            } else {
                count += 2;
            }
            num = num / 2;
        }
        return count + num;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.numberOfSteps(14)); // 6
        System.out.println(s.numberOfSteps(8)); // 4
        System.out.println(s.numberOfSteps(123)); // 12
    }
}
