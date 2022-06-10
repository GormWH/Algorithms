package org.suhong.nadong.c4;

public class Solution {

    public int operationCountUntilOne(int N, int K) {
        int count = 0;
        while (N != 0) {
            int remainder = N % K;
            if (remainder == 0) {
                N /= K;
                count++;
            } else {
                N -= remainder;
                count += remainder;
            }
        }
        return count - 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.operationCountUntilOne(25, 7)); // 7
        System.out.println(s.operationCountUntilOne(25, 5)); // 2
    }
}
