package org.suhong.leetcode.problems.p1217;

// https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/
class Solution {
    public int minCostToMoveChips(int[] position) {
        int even = 0;
        int odd = 0;
        for (int num : position) {
            if (num % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return Math.min(even, odd);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] position1 = {1,2,3};
        int[] position2 = {2,2,2,3,3};
        int[] position3 = {1,1000000000};

        System.out.println(s.minCostToMoveChips(position1)); // 1
        System.out.println(s.minCostToMoveChips(position2)); // 2
        System.out.println(s.minCostToMoveChips(position3)); // 1
    }
}