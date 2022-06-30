package org.suhong.leetcode.problems.p415;

// https://leetcode.com/problems/add-strings/
class Solution {

    public String addStrings(String num1, String num2) {
        StringBuilder longer;
        StringBuilder shorter;
        if (num1.length() < num2.length()) {
            longer = new StringBuilder(num2);
            shorter = new StringBuilder(num1);
        } else {
            longer = new StringBuilder(num1);
            shorter = new StringBuilder(num2);
        }

        for (int lng = longer.length() - 1, shr = shorter.length() - 1; lng >= 0; lng--, shr--) {
            char lngDigit = longer.charAt(lng);
            int digitSum;
            if (shr < 0) {
                digitSum = lngDigit - 48;
            } else {
                char shrDigit = shorter.charAt(shr);
                digitSum = lngDigit + shrDigit - 96;
            }

            if (digitSum > 9) {
                longer.setCharAt(lng, (char)(digitSum - 10 + 48));
                if (lng != 0) {
                    longer.setCharAt(lng - 1 , (char) (longer.charAt(lng - 1) + 1));
                } else {
                    longer.insert(0, '1');
                }
            } else {
                longer.setCharAt(lng, (char)(digitSum + 48));
            }
        }
        return longer.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        String[] nums1 = {"11", "123"};
        String[] nums2 = {"456", "77"};
        String[] nums3 = {"0", "0"};
        String[] nums4 = {"1", "9"};

        System.out.println(s.addStrings(nums1[0], nums1[1])); // 134
        System.out.println(s.addStrings(nums2[0], nums2[1])); // 533
        System.out.println(s.addStrings(nums3[0], nums3[1])); // 0
        System.out.println(s.addStrings(nums4[0], nums4[1])); // 10


    }
}
