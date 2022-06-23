package org.suhong.leetcode.problems.p11;

// https://leetcode.com/problems/container-with-most-water/
class Solution {

    // brute force
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = height.length - 1; i < j; j--) {
                int area = (j - i) * Math.min(height[i], height[j]);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    // improved solution
    public int maxArea2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = (height.length - 1) * Math.min(height[left], height[right]);

        outer:
        while (left < right) {
            System.out.printf("left: %d-%d, right: %d-%d, area: %d\n", left, height[left], right, height[right], (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                System.out.println("right is bigger");
                for (int i = left + 1; i < right; i++) {
                    if (height[i] > height[left]) {
                        int area = (right - i) * Math.min(height[i], height[right]);
                        if (maxArea < area) {
                            maxArea = area;
                            left = i;
                            System.out.println("타냐 안타냐");
                            continue outer;
                        }
                    }
                }
                break;
            } else if (height[left] > height[right]) {
                System.out.println("left is bigger");
                for (int i = right - 1; left < i; i--) {
                    if (height[i] > height[right]) {
                        int area = (i - left) * Math.min(height[left], height[i]);
                        if (maxArea < area) {
                            maxArea = area;
                            right = i;
                            continue outer;
                        }
                    }
                }
                break;
            } else {
                System.out.println("left and right is same");
                for (int i = left + 1; i < right; i++) {
                    if (height[i] > height[left]) {
                        if (right - i > i - left) {
                            int area = (right - i) * Math.min(height[i], height[right]);
                            if (maxArea < area) {
                                maxArea = area;
                                left = i;
                                continue outer;
                            }
                        } else {
                            int area = (i - left) * Math.min(height[left], height[i]);
                            if (maxArea < area) {
                                maxArea = area;
                                right = i;
                                continue outer;
                            }
                        }
                    }
                }
                break;
            }
        }
        System.out.printf("left: %d-%d, right: %d-%d, area: %d\n", left, height[left], right, height[right], (right - left) * Math.min(height[left], height[right]));
        return maxArea;
    }

    // https://www.code-recipe.com/post/container-with-most-water
    public int maxArea3(int[] height) {

        int maxArea = 0;
        for (int i = 0, j = height.length - 1; i < j;) {
            int left = height[i];
            int right = height[j];
            int area = (j - i) * Math.min(left, right);
            if (area > maxArea) maxArea = area;
            if (left < right) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums1 = {1,8,6,2,5,4,8,3,7};
        int[] nums2 = {1,1};
        int[] nums3 = {2,3,4,5,18,17,6};

        System.out.println(s.maxArea3(nums1)); // 49
        System.out.println(s.maxArea3(nums2)); // 1
        System.out.println(s.maxArea3(nums3)); // 17
    }
}
