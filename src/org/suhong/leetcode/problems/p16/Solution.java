package org.suhong.leetcode.problems.p16;

import java.util.*;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        int closestGap = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if( i > 0 && nums[i] == nums[i-1]) continue;
//            int first = nums[i];
            for (int j = i + 1, k = nums.length - 1; j < k;) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < target) {
                    j++;
                    while (j < k && nums[j-1] == nums[j]) {
                        j++;
                    }
                } else if (sum > target) {
                    k--;
                    while (j < k && nums[k] == nums[k+1]) {
                        k--;
                    }
                } else {
                    return sum;
                }
                if (closestGap > Math.abs(sum - target)) {
                    closest = sum;
                    closestGap = Math.abs(sum - target);
                }
            }
        }
        return closest;
    }

    private int binarySearchClosest(int[] nums, int from, int to, int target) {
        int mid = from + (to - from) / 2;
        int closestGap = Math.abs(nums[mid] - target);
        int closestIdx = mid;
        while (from < to) {
            int currentGap = nums[mid] - target;
            if (currentGap == 0) return mid;
            if (Math.abs(currentGap) < closestGap) {
                closestIdx = mid;
                closestGap = Math.abs(currentGap);
            }
            if (currentGap > 0) {
                to = mid;
            } else {
                from = mid + 1;
            }
            mid = from + (to - from) / 2;
        }
        return closestIdx;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums1 = {-1,2,1,-4};
        int[] nums2 = {0,0,0};
        int[] nums3 = {1,1,1,0};
        int[] nums4 = {-55,-24,-18,-11,-7,-3,4,5,6,9,11,23,33};

        System.out.println(s.threeSumClosest(nums1, 1)); // 2
        System.out.println(s.threeSumClosest(nums2, 1)); // 0
        System.out.println(s.threeSumClosest(nums3, 100)); // 3
        System.out.println(s.threeSumClosest(nums4, 0)); // 0
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
//        System.out.println(s.binarySearchClosest(nums1, 0, nums1.length, 0));
//        System.out.println(s.binarySearchClosest(nums2, 0, nums2.length, -3));
    }
}
