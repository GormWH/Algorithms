package org.suhong.leetcode.problems.p15;

import java.util.*;
import java.util.stream.Collectors;

// https://leetcode.com/problems/3sum/
class Solution {
    // almost brute force
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums); // first, sort array(to avoid duplicates)
        Integer firstPrev = null;
        for (int i = 0; i < nums.length - 2; i ++) {
            Integer firstNum = nums[i];
            if (firstNum.equals(firstPrev)) continue;
            else firstPrev = firstNum;
            Integer secondPrev = null;
            for (int j = i + 1; j < nums.length - 1; j++) {
                Integer secondNum = nums[j];
                if (secondNum.equals(secondPrev)) continue;
                else secondPrev = secondNum;
                int thirdIdx = Arrays.binarySearch(nums, j+1, nums.length, -firstNum - secondNum);
                if (thirdIdx >= 0) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(firstNum);
                    triplet.add(secondNum);
                    triplet.add(nums[thirdIdx]);
                    result.add(triplet);
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = {-1,0,1,2,-1,-4};
        int[] nums2 = {};
        int[] nums3 = {0};
        System.out.println("nums1=====================");
        s.threeSum(nums1).forEach(list -> {
            System.out.println(list.toString());
        });
        System.out.println("nums2=====================");
        s.threeSum(nums2).forEach(list -> {
            System.out.println(list.toString());
        });
        System.out.println("nums3=====================");
        s.threeSum(nums3).forEach(list -> {
            System.out.println(list.toString());
        });
    }
}
