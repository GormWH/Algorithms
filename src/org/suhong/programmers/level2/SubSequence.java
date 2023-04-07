package org.suhong.programmers.level2;

import java.util.ArrayList;
import java.util.List;

// 프로그래머스 [연속된 부분 수열의 합]
public class SubSequence {
    public int[] solution(int[] sequence, int k) {
        int length = sequence.length;
        int[] answer = {0,length-1};
        int start = 0, end = 0;
        int sum = sequence[0];
        while (start <= end && end < length) {
            if (sum < k) {
                sum += sequence[++end];
            } else if (sum > k) {
                sum -= sequence[start++];
            } else {
                if (answer[1] - answer[0] > end - start) {
                    answer[0] = start;
                    answer[1] = end;
                }
                sum += sequence[++end] - sequence[start++];
            }
        }

        return answer;
    }


}
