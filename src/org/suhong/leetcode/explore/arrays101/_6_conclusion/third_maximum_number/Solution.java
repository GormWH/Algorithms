package org.suhong.leetcode.explore.arrays101._6_conclusion.third_maximum_number;

class Solution {
    public int thirdMax(int[] nums) {
        ThirdMax tool = new ThirdMax();
        for (int num: nums) {
            tool.add(num);
        }
        return tool.getThirdMaxOrMax();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums1 = {3,2,1};
        int[] nums2 = {2,1};
        int[] nums3 = {1,3,2,1};

        System.out.println(s.thirdMax(nums1)); // 1
        System.out.println(s.thirdMax(nums2)); // 2
        System.out.println(s.thirdMax(nums3)); // 1
    }
}

class ThirdMax {
    private final Integer[] maxes = new Integer[3];

    public void add(int num) {
        if (maxes[0] == null) { // no elements
            maxes[0] = num;
        } else if (maxes[1] == null){ // only one element
            if (num > maxes[0]) {
                maxes[1] = maxes[0];
                maxes[0] = num;
            } else if (num < maxes[0]) {
                maxes[1] = num;
            }
        } else if (maxes[2] == null) { // two elements
            if (num > maxes[0]) {
                maxes[2] = maxes[1];
                maxes[1] = maxes[0];
                maxes[0] = num;
            } else if (maxes[0] > num && num > maxes[1]) {
                maxes[2] = maxes[1];
                maxes[1] = num;
            } else if (maxes[1] > num) {
                maxes[2] = num;
            }
        } else { // all elements filled
            if (num > maxes[0]) {
                maxes[2] = maxes[1];
                maxes[1] = maxes[0];
                maxes[0] = num;
            } else if (maxes[0] > num && num > maxes[1]) {
                maxes[2] = maxes[1];
                maxes[1] = num;
            } else if (maxes[1] > num && num > maxes[2]) {
                maxes[2] = num;
            }
        }
    }

    public int getThirdMaxOrMax() {
        return maxes[2] == null ? maxes[0] : maxes[2];
    }

}
