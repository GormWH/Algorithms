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

    // using two pointer
    // https://www.code-recipe.com/post/three-sum
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums); // first, sort array(to avoid duplicates)
        for (int i = 0; i < nums.length - 2; i ++) {
            if( i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = i + 1, k = nums.length - 1; j < k;) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                    while (j < k && nums[j-1] == nums[j]) {
                        j++;
                    }
                } else if (sum > 0) {
                    k--;
                    while (j < k && nums[k] == nums[k+1]) {
                        k--;
                    }
                } else {
                    result.add(List.of(nums[i], nums[j], nums[k]));
                    k--;
                    while (j < k && nums[k] == nums[k+1]) {
                        k--;
                    }
                }
            }

        }

        return result;
    }

    // using hash map
    public List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums); // first, sort array(to avoid duplicates)
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            int target = - nums[i]; // a + b + c = 0 => b + c = -a = target
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i + 2; j < nums.length; j++) {
                map.put(target - nums[j], j); // c = target - b
            }

            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j > i + 1 && nums[j - 1] == nums[j]) continue;
                Integer searchResult = map.get(nums[j]);
                if (searchResult != null && j < searchResult) {
                    result.add(List.of(nums[i], nums[j], nums[searchResult]));
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
        s.threeSum3(nums1).forEach(list -> {
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
