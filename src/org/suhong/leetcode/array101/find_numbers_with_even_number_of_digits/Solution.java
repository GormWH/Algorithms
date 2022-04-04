package org.suhong.leetcode.array101.find_numbers_with_even_number_of_digits;

class Solution {
    public int findNumbers(int[] nums) {
        int result = 0;
        for (int num : nums) {
            if (isEvenDigits(num)) result++;
        }
        return result;
    }

    public int findNumbers2(int[] nums) {
        int result = 0;
        for (int num : nums) {
            if (Integer.toString(num).length() % 2 == 0) result++;
        }
        return result;
    }

    private boolean isEvenDigits(int num) {
        int numOfDivision = 0;
        while (num != 0) {
            num = num / 10;
            numOfDivision++;
        }
        return numOfDivision % 2 == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1234, 123, 123, 1234};
        int[] nums2 = {123, 123, 123, 4444};
        System.out.println(solution.findNumbers2(nums1));
        System.out.println(solution.findNumbers2(nums2));

    }
}
