package org.suhong.leetcode.problems.p67;

// https://leetcode.com/problems/add-binary/
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();

        int idxA = a.length() - 1;
        int idxB = b.length() - 1;
        boolean prev = false;
        while (idxA >= 0 || idxB >= 0) {
            int sum = 0;
            if (idxA >= 0) {
                sum += a.charAt(idxA--) == '1' ? 1 : 0;
            }
            if (idxB >= 0) {
                sum += b.charAt(idxB--) == '1' ? 1 : 0;
            }
            if (prev) {
                sum += 1;
            }
            if (sum > 1) {
                builder.append(sum - 2);
                prev = true;
            } else {
                builder.append(sum);
                prev = false;
            }
        }
        if (prev) {
            builder.append(1);
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        String a1 = "11", b1 = "1";
        String a2 = "1010", b2 = "1011";
        String a3 = "1111", b3 = "1111";

        System.out.println(s.addBinary(a1, b1)); // 100
        System.out.println(s.addBinary(a2, b2)); // 10011
        System.out.println(s.addBinary(a3, b3)); // 11110
    }
}