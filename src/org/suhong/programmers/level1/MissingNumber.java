package org.suhong.programmers.level1;

public class MissingNumber {
    public int solution(int[] nums) {
        int answer = 45;

        for (int num : nums)
            answer -= num;

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        System.out.println(new MissingNumber().solution(nums));
    }
}
