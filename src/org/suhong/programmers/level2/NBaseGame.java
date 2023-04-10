package org.suhong.programmers.level2;

public class NBaseGame {

    public static void main(String[] args) {
        NBaseGame s = new NBaseGame();
        System.out.println((int)'a');

        System.out.println(s.solution(2,4,2,1)); // "0111"
        System.out.println(s.solution(16,16,2,1)); // "02468ACE11111111"
        System.out.println(s.solution(16,16,2,2)); // "13579BDF01234567"
    }
    public String solution(int n, int t, int m, int p) {
        --p; // 총 3명이 있을 경우 순서를 1,2,3이 아닌 0,1,2로 변경
        StringBuilder builder = new StringBuilder();
        int num = 0;
        int turn = 0;
        while (t > 0) {
            String strNum = Integer.toString(num,n); // n 진수
            //System.out.println(strNum);
            for (char c: strNum.toCharArray()) {
                if (turn % m == p) {
                    if (c >= 97) c -= 32; // 소문자 -> 대문자 변경
                    builder.append(c);
                    --t; // 플레이어가 말한 횟수 카운트 다운
                    if (t == 0) break;
                }
                ++turn;
            }
            ++num;
        }
        return builder.toString();
    }
}
