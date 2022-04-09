package org.suhong.programmers.level1;

// 음양 더하기
// https://programmers.co.kr/learn/courses/30/lessons/76501
public class RealSum {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        int length = signs.length;
        for (int i = 0; i <length; i++) {
            answer += signs[i] ? absolutes[i] : - absolutes[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        RealSum realSum = new RealSum();
        int[] absolutes = {4,7,12};
        boolean[] signs = {true,false,true};
        System.out.println(realSum.solution(absolutes, signs));
    }
}
