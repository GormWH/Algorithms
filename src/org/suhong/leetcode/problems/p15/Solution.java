package org.suhong.leetcode.problems.p15;

import java.util.*;
import java.util.stream.Collectors;

// https://leetcode.com/problems/3sum/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            result.addAll(twoSum(nums, i));
        }
        return result;
    }

    private List<List<Integer>> twoSum(int[] nums, int fistIdx) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int target = -nums[fistIdx];
        for (int i = 0; i < nums.length; i++) {
            if (i == fistIdx) continue;
            map.put(target - nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            Integer current = nums[i];
            Integer search = map.get(current);
            if (search != null && search != i && search != fistIdx) {
                List<Integer> answer = new ArrayList<>();
                answer.add(-target);
                answer.add(target - current);
                answer.add(current);
                result.add(answer);
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
        s.threeSum(nums2).forEach(list -> {
            System.out.println(list.toString());
        });
    }
}
