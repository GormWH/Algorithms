package org.suhong.programmers.level0;

public class BinaryAdd {

    public static void main(String[] args) {
        BinaryAdd s = new BinaryAdd();
        System.out.println(s.solution("11", "10"));
    }
    public String solution(String bin1, String bin2) {
        StringBuilder answer = new StringBuilder();

        int ptr1 = bin1.length() - 1;
        int ptr2 = bin2.length() - 1;
        int prevSum = 0;
        while (ptr1 >= 0 || ptr2 >= 0) {
            // 현재 보고 있는 자릿수의 합을 계산 (0,1,2,3 중 하나)
            int sum = prevSum;
            if (ptr1 >= 0) sum += Integer.valueOf(bin1.charAt(ptr1--) - 48);
            if (ptr2 >= 0) sum += Integer.valueOf(bin2.charAt(ptr2--) - 48);

            // sum = 0,2면 현재 자릿수는 0, sum = 1,3면 현재 자릿수는 1
            if (sum % 2 == 0) {
                answer.append(0);
            } else {
                answer.append(1);
            }

            // sum = 0,1면 다음 자릿수에 +0, sum = 2,3이면 다음 자릿수에 +1
            if (sum < 2) {
                prevSum = 0;
            } else {
                prevSum = 1;
            }
        }
        if (prevSum != 0) {
            answer.append(1);
        }

        return answer.reverse().toString();
    }
}
